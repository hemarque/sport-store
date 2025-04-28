import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { CartProvider } from "./context/CartContext";
import Home from "./pages/Home";
import Catalog from "./pages/Catalog";
import ProductDetail from "./pages/ProductDetail";
import Cart from "./pages/Cart";
import Checkout from "./pages/Checkout";
import Confirmation from "./pages/Confirmation";
import Backoffice from "./pages/Backoffice";
import CreatePart from "./pages/CreatePart";
import CreateProduct from "./pages/CreateProduct";

const App: React.FC = () => {
  return (
    <CartProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/catalog" element={<Catalog />} />
          <Route path="/product/:id" element={<ProductDetail />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/checkout" element={<Checkout />} />
          <Route path="/confirmation" element={<Confirmation />} />
          
          <Route path="/backoffice" element={<Backoffice />} />
          <Route path="/part" element={<CreatePart />} />
          <Route path="/product" element={<CreateProduct />} />
        </Routes>
      </Router>
    </CartProvider>
  );
};

export default App;
