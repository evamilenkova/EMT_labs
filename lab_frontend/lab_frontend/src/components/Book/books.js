import React from 'react';
import { Link } from 'react-router-dom';
import ReactPaginate from 'react-paginate';


class Book extends React.Component{

    constructor(props){
        super(props)
    
    this.state={
        page:0,
        size:2
    }
}

    render () {

        const offset= this.state.size * this.state.page
        const nextPageOffset=offset+this.state.size
        const pageCount= Math.ceil(this.props.books.length / this.state.size)
        const books=this.getBooksPage(offset,nextPageOffset);

        return  (

            <div className='container mm-4 mt-5'>
            <div className="row">
                <div className="row">
                    <table className='table table-striped'>
                        <thead><th>Name</th><th>Author</th><th>AvilableCopies</th><th>Category</th></thead>
                        <tbody>
                {books}
                        </tbody>
                    </table>
                </div>
                <ReactPaginate
            previousLabel={"back"}
            nextLabel={"next"}
            nextClassName='page-link'
            previousClassName='page-link'
            breakLabel={<a href="/#">...</a>}
            breakClassName='break-me'
            pageClassName='ml-1 page-link'
            pageCount={3}
            marginPagesDisplayed={2}
            pageRangeDisplayed={5}
            onPageChange={this.handleChange}
            containerClassName='pagination m-4 justify-content-center'
            activeClassName='active'
                />
            </div>
            <Link className=" btn btn-dark w-100 " to={"/books/add"} ><span className='h5'>Add Book</span></Link>
        </div>

        );
    }

    handleChange=(data)=>{
        let selected=data.selected;
        this.setState({
            page:selected
        })
        

    }


    getBooksPage=(offset, nextPageOffset)=>{
       return  this.props.books.map((term) => {
                                return (
                                    <tr key={term}><td>{term.name}</td>
                                        <td>{term.author.name} {term.author.surname}</td>
                                        <td>{term.availableCopies}</td>
                                        <td>{term.category}</td>
                                        <td className='text-right'>
                                        <Link title="Edit"  onClick={()=>this.props.getProduct(term.id)} to={`/books/edit/${term.id}`} className='btn btn-primary mx-2'> Edit</Link>
                                        <a title="Delete" className='btn btn-danger mx-2'
                                                onClick={() => this.props.onDelete(term.id)}> Delete</a>
                                        </td>
                                    </tr>
                                );
                            }).filter((book,index)=> {
                                return index>=offset && index < nextPageOffset
                            })

    }

}

export default Book;

