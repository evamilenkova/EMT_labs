import React from "react";


const author =(props)=>{

return (

    <div className='container mm-4 mt-5'>
            <div className="row">
                <div className="row">
                    <table className='table table-striped'>
                        <thead><th>Name</th><th>Surname</th></thead>
                        <tbody>
                            {props.authors.map((term) => {
                                return (
                                    <tr key={term}>
                                        <td>{term.name}</td>
                                        <td>{term.surname}</td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

)


}

export default author;