import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductList from './components/ProductList';
import Cart from './components/Cart';
import CartSummary from './components/CartSummary';
import {Link, BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import ProductList2 from './components/ProductList2';

//items, totalAmount:0, errorMsg
function App() {
  return (
    <Router>
    <div className="App">
      <Link to="products">제품 리스트 (카드형)</Link> &nbsp;|&nbsp;
      <Link to="products2">제품 리스트 (테이블형)</Link> &nbsp;|&nbsp;
      <Link to="cart">장바구니</Link>
      <Routes>
        <Route path="products" element={<ProductList2/>}/>
        <Route path="products2" element={<ProductList/>}/>
        <Route path="cart" element={<Cart/>}/>
        <Route path="payment" element={<CartSummary/>}/>
      </Routes>
    </div>
    </Router>
  );
}

export default App;
