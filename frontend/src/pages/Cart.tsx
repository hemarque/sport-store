import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Product } from "../model/Product";
import { Part } from "../model/Part";

const Cart: React.FC = () => {
  const [cart, setCart] = useState<Product[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    const savedCart = localStorage.getItem("cart");
    if (savedCart) {
      const cartItems: Product[] = JSON.parse(savedCart).map((item: Product) => {
        const parts = item.parts.map((part: Part) => new Part(part.id, part.type, part.option, part.price));
        return new Product(item.id, item.type, item.name, item.price, parts);
      });
      setCart(cartItems);
    }
  }, []);

  const handleCheckout = () => {
    navigate("/checkout");
  };

  const handleContinueShopping = () => {
    navigate("/");
  };

  return (
    <div>
      <div className="flex items-start space-x-2">
        <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
        <h1>Marcus Shop</h1>
      </div>

      <h1>Shopping Cart</h1>
      {cart.length > 0 ? (
        <>
          <ul>
            {cart.map((cartItem, index) => (
              <li key={index}>
                {cartItem.name} - ${cartItem.getTotalPrice()}
              </li>
            ))}
          </ul>
          <div className="flex gap-4 mt-6">
            <button onClick={handleCheckout}>Proceed to Checkout</button>
            <button onClick={handleContinueShopping}>Continue Shopping</button>
          </div>
        </>
      ) : (
        <p>Your cart is empty.</p>
      )}
    </div>
  );
};
export default Cart;
