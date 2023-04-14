package com.ukim.finki.emtlabs.web;

import com.ukim.finki.emtlabs.model.Book;
import com.ukim.finki.emtlabs.model.dtos.BookDto;
import com.ukim.finki.emtlabs.model.exceptions.AuthorNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.BookNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.NoMoreAvailableCopiesException;
import com.ukim.finki.emtlabs.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {


    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks(){
        return  this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws BookNotFoundException {
     return this.bookService.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return this.bookService.saveBook(book)
                .map(b->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
    @PostMapping("/add/dto")
    public ResponseEntity<BookDto> addBookDto(@RequestBody BookDto book) throws AuthorNotFoundException {
        return this.bookService.saveBookDto(book)
                .map(b->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isPresent()) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok().build();
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<BookDto> editBook(@PathVariable Long id, @RequestBody BookDto book) throws AuthorNotFoundException, BookNotFoundException {
        return this.bookService.update(id,book.getName(),book.getAuthorId(),
                        book.getAvailableCopies(),book.getCategory())
                .map(i->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Book book) throws AuthorNotFoundException, BookNotFoundException {
//        return this.bookService.update(id,book.getName(),book.getAuthor().getId(),
//                        book.getAvailableCopies(),book.getCategory().name())
//                .map(i->ResponseEntity.ok().body(book))
//                .orElseGet(()->ResponseEntity.badRequest().build());
//    }

    @PostMapping("/borrow/{id}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long id) throws NoMoreAvailableCopiesException, BookNotFoundException {
        return this.bookService.markAsBorrowed(id).map(b->ResponseEntity.ok().body(b))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

}
