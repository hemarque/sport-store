import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCart } from "../context/CartContext";

const Checkout: React.FC = () => {
    const { clearCart } = useCart();
    const [customerData, setCustomerData] = useState({ name: "", email: "", address: "" });
    const navigate = useNavigate();

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setCustomerData({ ...customerData, [name]: value });
    };

    const handleCheckout = () => {
        clearCart();
        navigate("/confirmation");
    };

    return (
        <div>
            <div className="flex items-start space-x-2">
                <img className="align-top" width="30px" src="/img/logo.png" alt="logo" />
                <h1>Marcus Shop</h1>
            </div>
            <h1>Checkout</h1>
            <form>
                <input
                    type="text"
                    name="name"
                    placeholder="Your Name"
                    value={customerData.name}
                    onChange={handleInputChange}
                />
                <input
                    type="email"
                    name="email"
                    placeholder="Your Email"
                    value={customerData.email}
                    onChange={handleInputChange}
                />
                <input
                    type="text"
                    name="address"
                    placeholder="Your Address"
                    value={customerData.address}
                    onChange={handleInputChange}
                />
            </form>
            <button onClick={handleCheckout} style={{ marginTop: "16px" }}>
                Confirm Order
            </button>    </div>
    );
};

export default Checkout;
