import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { Product } from "../model/Product";
import { Part } from "../model/Part";
import { useCart } from "../context/CartContext";

const ProductDetail: React.FC = () => {
    const { id } = useParams();
    const [product, setProduct] = useState<Product | null>(null);
    const { cart, addToCart } = useCart();
    const navigate = useNavigate();

    useEffect(() => {
        if (id) {
            fetch(`http://localhost:8080/api/products/${id}`)
                .then(response => response.json())
                .then(data => {
                    const parts = data.parts.map((part: any) => new Part(
                        part.id,
                        part.type,
                        part.option,
                        part.price
                    ));
                    const loadedProduct = new Product(
                        data.id,
                        data.type,
                        data.name,
                        data.price,
                        parts
                    );
                    setProduct(loadedProduct);
                })
                .catch(error => console.error("Error fetching product:", error));
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
