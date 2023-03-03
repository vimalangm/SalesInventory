import './App.css';
import Product from './product';
import Sales from './sales';
import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  const [isShownProduct, setIsShownProduct] = useState(false);
  const [isShownSales, setIsShownSales] = useState(false);
  const handleClickProduct = event => {
    setIsShownProduct(!isShownProduct);
  };
  const handleClickSales = event => {
    setIsShownSales(!isShownSales);
  };
  return (
    <div className="App">
      <h1><font color="red">Sales Inventory Management System</font></h1>
    <br></br><br></br>
      <button type="button" class="btn btn-primary btn-lg btn-block me-1" onClick={handleClickProduct}>Product</button>
      <button type="button" class="btn btn-primary btn-lg btn-block" onClick={handleClickSales}>Sales</button>
      {isShownProduct && (
        <div>
          <Product handleClose={handleClickProduct} />
        </div>
      )}
        {isShownSales && (
        <div>
          <Sales  handleClose={handleClickSales} />
        </div>
      )}
    </div>
  );
}

export default App;
