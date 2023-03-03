import React,{useState} from 'react'
import NewWindow from 'react-new-window'
import 'bootstrap/dist/css/bootstrap.min.css';

const Sales=props=> {
    const [details, setDetails] = useState({
        pname: "",
        price: "",
        discount: "",
    });
    //const[id,setId]=useState();
    const handleSearch = (e) => {
        
        fetch("http://localhost:8080/sales/inventory/system/getSalesItem/" + e)
            .then(response => response.json())
            .then((jsonData) => {
                setDetails({
                    pname: jsonData.productName,
                    price: jsonData.price,
                    discount: jsonData.discount
                });
               // setId(e);
            })
            .catch((error) => {
                console.error(error)
            })

            console.log(details);
    };
    const handleSale=()=>{
        fetch("http://localhost:8080/sales/inventory/system/sale/" + details.pname + "/" + details.price + "/" + details.discount)
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
    return (
        <NewWindow features={{ width: 400, height: 450 }} title="product registration" center="parent" >

            <>
                <div align="center">
                    <h3><font color="red">Product Sales</font></h3>

                </div>
                <br></br>
                <div class="text-center">
                    <div class="search">
                        <i class="fa fa-search"></i>
                        <input type="text" class="form-control" placeholder="search with product id" name='searchid' onChange={event => handleSearch(event.target.value)} />

                    </div>

                </div>
                <br></br>
                <form>
                    <div class="form-floating mb-3">
                        <input type="text" value={details.pname} class="form-control" name="pname" />
                        <label>Product Name</label>
                    </div>
                    <div class="form-floating">
                        <input type="text"  value={details.price} class="form-control" name="price" />
                        <label>Price</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" value={details.discount} class="form-control" name="discount" />
                        <label>Discount</label>
                    </div><br></br>
                    <div class="text-center">
                        <button class="btn btn-primary me-1" type="button" onClick={handleSale}>Sale</button>
                        <button type="button" class="btn btn-primary" onClick={props.handleClose}>Close</button>
                    </div>
                </form>


            </>
        </NewWindow>
    )
}
export default Sales;