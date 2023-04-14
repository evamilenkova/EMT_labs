import React from "react";
import {  useNavigate,useParams } from "react-router-dom";


const BookEdit = (props) => {


    const navigate=useNavigate();
    const params = useParams();
    const [formData, updateData] = React.useState({
        name:"",
        authorId: 0,
        availableCopies: 0,
        category: ""
    })

    const handleChange=(e)=>{
        updateData({
            name: props.product.name,
            authorId: props.product.author.id,
            availableCopies: props.product.availableCopies,
            category: props.product.category,
            [e.target.name]: e.target.value,
        })
    }
    const onFormSubmit=(e)=>{
        e.preventDefault();
        const name=formData.name
        const authorId=formData.authorId;
        const availableCopies=formData.availableCopies;
        const category=formData.category;
        props.editBook(params.id,name,authorId,availableCopies,category)
        navigate("/books", { replace: true })
    }


    return (

        <div className="col mt-5">
            <div className="container">
            <form onSubmit={onFormSubmit}>
                <div className="form-group m-auto mt-3 w-75" >
                    <label htmlFor="name" className="h5">Book Name</label>
                    <input type="text"
                        className="form-control"
                        id="name"
                        name="name"
                        placeholder={props.product.name}
                        onChange={handleChange} />
                </div>
                <div className="form-group m-auto mt-3 w-75">
                    <label className="h5">Author</label>
                    <select name="authorId" onChange={handleChange} className="form-control">
                        {props.authors.map((term)=>{
                        if(props.product.author!==undefined && props.product.author.id===term.id)  return  <option value={term.id} selected={term.id}>{term.name} {term.surname}</option>
                        else return  <option value={term.id}>{term.name} {term.surname}</option>
                        })}

                    </select>
                </div>

                <div className="form-group m-auto mt-3 w-75">
                    <label className="h5"  htmlFor="copies">Available Copies</label>
                    <input type="text"
                        className="form-control"
                        id="availableCopies"
                        name="availableCopies"
                        placeholder={props.product.availableCopies}
                        onChange={handleChange}/>
                </div>
                <div className="form-group m-auto mt-3 w-75">
                    <label className="h5">Category</label>
                    <select name="category"  onChange={handleChange} className="form-control">
                    {props.categories.map((term)=>{
                        if(props.product!==undefined && props.product.category==term)
                        return <option value={term} selected={term}>{term}</option>
                        else return  <option value={term}>{term}</option> 
                    })}
                    </select>
                
                </div>
                <div className="form-group m-auto mt-3 w-75 float-right" >
                <button className=" btn btn-success w-100 float-right" type="submit" ><span className='h5'>Submit</span></button>
                </div>
            </form>
        </div>
        </div>
    
    
   

)
}

export default BookEdit;