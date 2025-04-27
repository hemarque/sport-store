import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { Product } from "../model/Product";
import { Part } from "../model/Part";
import { useCart } from "../context/CartContext";

const products: Record<string, Product> = {
    "1": new Product(
        "bicycle",
        "Mountain Bike",
        [
            new Part("Frame Type", "Full-suspension", 130),
            new Part("Frame Finish", "Shiny", 30),
            new Part("Wheels", "Mountain wheels", 80),
            new Part("Rim Color", "Black", 20),
            new Part("Chain", "Single-speed chain", 43)
        ]
    ),
    "2": new Product(
        "bicycle",
        "Road Bike",
        [
            new Part("Frame Type", "Diamond", 120),
            new Part("Frame Finish", "Matte", 25),
            new Part("Wheels", "Road wheels", 70),
            new Part("Rim Color", "Blue", 20),
            new Part("Chain", "8-speed chain", 50)
        ]
    ),
    "3": new Product(
        "bicycle",
        "Fat Bike",
        [
            new Part("Frame Type", "Full-suspension", 130),
            new Part("Frame Finish", "Matte", 25),
            new Part("Wheels", "Fat bike wheels", 100),
            new Part("Rim Color", "Black", 20),
            new Part("Chain", "Single-speed chain", 43)
        ]
    )
};

const ProductDetail: React.FC = () => {
    const { id } = useParams();
    const [product, setProduct] = useState<Product | null>(null);
    const { cart, addToCart } = useCart(); // global shopping cart

    const navigate = useNavigate();

    useEffect(() => {
        if (id) {
            setProduct(products[id]);
        }
    }, [id]);

    if (!product) return <div>Loading...</div>;

    const handleCart = () => {
        navigate("/cart");
    };
    const handleContinueShopping = () => {
        navigate("/");
    };

    return (
        <div>
            <div className="flex items-start space-x-2">
                <img className="align-top" width="30px" src="/img/logo.png" alt="logo" />
                <h1>Marcus Shop</h1>
            </div>
            <h1>{product.name}</h1>
            <p>Type: {product.type}</p>
            <p>Total Price: ${product.getTotalPrice()}</p>
            <h2>Parts:</h2>
            <ul>
                {product.parts.map((part, index) => (
                    <li key={index}>
                        {part.type} - {part.option} (${part.price})
                    </li>
                ))}
            </ul>
            <button onClick={() => addToCart(product)}>Add to Cart</button>

            <div>
                <h3>Shopping Cart</h3>
                {cart.length > 0 ? (
                    <ul>
                        {cart.map((cartItem, index) => (
                            <li key={index}>{cartItem.name} - ${cartItem.getTotalPrice()}</li>
                        ))}
                    </ul>
                ) : (
                    <p>Your cart is empty.</p>
                )}
            </div>

            <div className="flex gap-4 mt-6">
                <button onClick={handleCart}>Go to Cart</button>
                <button onClick={handleContinueShopping}>Continue Shopping</button>
            </div>
        </div>
    );
};

export default ProductDetail;
