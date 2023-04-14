
import { Component } from 'react';
import { Route, Routes, Navigate } from 'react-router-dom';

import './App.css';
import Book from './components/Book/books';
import Category from './components/Category/categories'
import BookService from './repository/booksRepository';
import Header from './components/Header/header';
import AddBook from './components/Book/BookAdd/bookadd'
import Author from "./components/Author/author";
import BookEdit from './components/Book/BookEdit/bookedit';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      books: [],
      categories: [],
      authors: [],
      selectedProduct: {}
    }
  }

  render() {
    return (
      <div>
        <Header></Header>

        <Routes>
          <Route path="/books/add" element={<AddBook categories={this.state.categories} authors={this.state.authors} onAdd={this.addProduct} />}> </Route>
          <Route path="/books/edit/:id" element={<BookEdit categories={this.state.categories} authors={this.state.authors}  product={this.state.selectedProduct} editBook={this.editBook} />}> </Route>
          <Route path="/books" element={<Book books={this.state.books} onDelete={this.deleteBook} getProduct={this.getProductById} />}> </Route>
          <Route path="" element={<Book books={this.state.books} onDelete={this.deleteBook} getProduct={this.getProductById} />}> </Route>
          <Route path="/categories" element={<Category categories={this.state.categories} />}></Route>
          <Route path="/authors" element={<Author authors={this.state.authors} />}></Route>
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>

      </div>
    );
  }


  componentDidMount() {

    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
  }

  loadBooks = () => {
    BookService.fetchBooks()
      .then((data) => {

        this.setState({
          books: data.data
        })

      })
  }

  loadAuthors = () => {
    BookService.fetchAuthors()
      .then((data) => {
        this.setState({
          authors: data.data
        })
      })
  }
  deleteBook = (id) => {
    BookService.deleteBook(id)
      .then(() => {
        this.loadBooks();
      })
  }

  addProduct = (name, authorId, availableCopies, category) => {
    BookService.addBook(name, authorId, availableCopies, category)
      .then(() => {
        this.loadBooks();
      })
  }


  loadCategories = () => {
    BookService.fetchCategories()
      .then((data) => {
        this.setState({
          categories: data.data
        })
      })
  }

  editBook = (id, name, authorId, availableCopies, category) => {
    BookService.editBook(id, name, authorId, availableCopies, category)
      .then(() => {
        this.loadBooks()
      })
  }

  getProductById = (id) => {
    BookService.getBookById(id)
      .then((data) => {
        this.setState({
          selectedProduct: data.data,
        })
      })
  }



}



export default App;
