import axios from '../custom-axios/axios';


const BookService = {

    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    editBook: (id) => {
        return axios.post(`/books/edit/${id}`);
    },
    addBook: (name, authorId, availableCopies, category) => {
        return axios.post("/books/add/dto", {
            "name": name,
            "authorId": authorId,
            "availableCopies": availableCopies,
            "category": category

        });
    },

    editBook: (id, name, authorId, availableCopies, category) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "authorId": authorId,
            "availableCopies": availableCopies,
            "category": category
        })
    },
    getBookById:(id)=>{
        return axios.get(`/books/${id}`);
    }



}
export default BookService;