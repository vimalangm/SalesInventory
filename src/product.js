import React, { useState } from 'react'
import NewWindow from 'react-new-window'
import 'bootstrap/dist/css/bootstrap.min.css';
const Product =props=> {
    const [details, setDetails] = useState({
        pname: "",
        price: "",
        discount: "",
    });
    const handleChange = (e) => {
        const { name, value } = e.target;
        setDetails((prev) => {
            return { ...prev, [name]: value };
        });
    };
    const handleClick = () => {
        fetch("http://localhost:8080/sales/inventory/system/save/" + details.pname + "/" + details.price + "/" + details.discount)
        .then((response) => {
            if(!response.ok) throw new Error(response.status);
            else return response.data;
          })
          .then((data) => {
            alert("Record Added Successfully!!!");
          })
          .catch((error) => {
            console.log('error: ' + error);
          });
    };
    const [searchText, setSearchText] = useState({
        searchid: "",
    });
    const handleSearchValue = (e) => {
        const { name, value } = e.target;
        setSearchText((prev) => {
            return { ...prev, [name]: value };
        });
    };
    const[btnFalse,setButtonFalse]=useState(true);
    const handlSearch = () => {
        fetch("http://localhost:8080/sales/inventory/system/get/" + searchText.searchid)
            .then(response => response.json())
            .then((jsonData) => {
                setDetails({
                    pname: jsonData.productName,
                    price: jsonData.price,
                    discount: jsonData.discount
                });
                setButtonFalse(false);
            })
            .catch((error) => {
                console.error(error);
                setButtonFalse(true);
            })

    };
    const handleClear = () => {
        setDetails({
            pname: '',
            price: '',
            discount: ''
        });
        setButtonFalse(true);
    }
    const handlUpdate = () => {
        fetch("http://localhost:8080/sales/inventory/system/update/" + searchText.searchid + "/" + details.pname + "/" + details.price + "/" + details.discount);
        
    };

    return (
        <NewWindow  features={{ width: 400, height: 450 }} title="product registration" center="parent" >
            <>
                <div align="center">
                    <h3><font color="red">Product Registration</font></h3>

                </div>
                <form>
                    <div class="form-floating mb-3">
                        <input type="text" value={details.pname} class="form-control" name="pname" onChange={handleChange} />
                        <label>Product Name</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" value={details.price} class="form-control" name="price" onChange={handleChange} />
                        <label>Price</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" value={details.discount} class="form-control" name="discount" onChange={handleChange} />
                        <label>Discount</label>
                    </div><br></br>
                    <div class="text-center">
                        {btnFalse && <button class="btn btn-primary me-1" type="button" onClick={handleClick}>Save</button>}
                      <button type="button" class="btn btn-primary me-1" onClick={handleClear}>clear</button> 
                       <button type="button" class="btn btn-primary" onClick={props.handleClose}>Close</button>
                        </div>
                </form>
                <br></br>
                <div class="text-center">
                    <div class="search">
                        <i class="fa fa-search"></i>
                        <input type="text" class="form-control" placeholder="search with product id" name='searchid' onChange={handleSearchValue} />
                        <br></br>
                        <button class="btn btn-primary me-1" onClick={handlSearch}>Search</button>
                        <button class="btn btn-primary" onClick={handlUpdate}>Update</button>
                    </div>

                </div>
                
            </>
        </NewWindow>
    )
}

export default Product;