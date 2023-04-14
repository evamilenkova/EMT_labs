import React from "react";
import { Link } from "react-router-dom";

const header = () => {

    return (

        <nav className="navbar  navbar-expand-lg navbar-dark navbar-fixed bg-dark">
             <div class="container">
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <Link className=" nav-link medium " to={"/books"}><span class="mb-0 h4">Books</span></Link>
                    </li>
                    <li className="nav-item">
                        <Link class="nav-link xx-large" to={"/categories"} ><span class="mb-0 h4">Categories</span></Link>
                    </li>
                    <li className="nav-item">
                        <Link class="nav-link xx-large" to={"/authors"} ><span class="mb-0 h4">Authors</span></Link>
                    </li>
                </ul>
            </div>
            </div>
        </nav>

    )
}

export default header;