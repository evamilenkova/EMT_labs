import React from 'react'

const categories = (props) => {
    return(
        <div className='container mm-4 mt-5'>
            <div className="row">
            <div className="row">
                <table className='table table-info table-striped'>
                        <thead><th>Category Name</th></thead>
                        <tbody>
                            {props.categories.map((term)=>{
                                return(
                                <tr key={term}>
                                    <td>{term}</td>
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

export default categories;