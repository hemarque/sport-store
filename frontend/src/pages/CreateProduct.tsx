import React, { useState, useEffect } from "react";
import { Part } from "../model/Part";
import { Product } from "../model/Product";
import { Link } from "react-router-dom";


const CreateProduct: React.FC = () => {
    const [type, setType] = useState("");
    const [name, setName] = useState("");
    const [price, setPrice] = useState(0);
    const [availableParts, setAvailableParts] = useState<Part[]>([]);
    const [selectedParts, setSelectedParts] = useState<number[]>([]);
    const [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        fetchParts();
        fetchProducts();
    }, []);

    const fetchParts = () => {
        fetch("http://localhost:8080/api/parts")
            .then(response => response.json())
            .then(data => setAvailableParts(data))
            .catch(error => console.error("Error fetching parts:", error));
    };

    const fetchProducts = () => {
        fetch("http://localhost:8080/api/products")
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error("Error fetching products:", error));
    };

    const togglePartSelection = (partId: number) => {
        setSelectedParts((prevSelected) =>
            prevSelected.includes(partId)
                ? prevSelected.filter(id => id !== partId)
                : [...prevSelected, partId]
        );
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        const selectedPartsObjects = availableParts.filter(part => selectedParts.includes(part.id));

        const newProduct = {
            type,
            name,
            price,
            parts: selectedPartsObjects
        };

        try {
            const response = await fetch("http://localhost:8080/api/products", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(newProduct),
            });

            if (response.ok) {
                setType("");
                setName("");
                setPrice(0);
                setSelectedParts([]);
                fetchProducts();
            } else {
                alert("Failed to create product.");
            }
        } catch (error) {
            console.error("Error creating product:", error);
        }
    };

    return (
        <div>
            <div className="flex items-start space-x-2">
                <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
                <h1>Marcus Shop</h1>
            </div>
            <h2>Create New Product</h2>
            <Link to="/">Home</Link> | <Link to="/backoffice">Backoffice</Link> | <Link to="/part">Create part</Link>
            <br /><br /><hr /><br />
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Product Type (e.g., Bicycle)"
                    value={type}
                    onChange={(e) => setType(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Product Name (e.g., Mountain Bike)"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Base Price"
                    value={price}
                    onChange={(e) => setPrice(Number(e.target.value))}
                    required
                    min="0"
                />
                <h3>Select Parts:</h3>
                <div>
                    {availableParts.map((part) => (
                        <label key={part.id}>
                            <input
                                type="checkbox"
                                checked={selectedParts.includes(part.id)}
                                onChange={() => togglePartSelection(part.id)}
                                className="w-4 h-4"
                            />
                            <span>{part.type} - {part.option} (${part.price})<br /></span>
                        </label>
                    ))}
                </div>

                <button type="submit">Create Product</button>
            </form>

            <div>
                <h2>Existing Products</h2>
                <div>
                    {products.map(product => (
                        <div key={product.id}>
                            <h3>{product.name}</h3>
                            <p>Type: {product.type}</p>
                            <p>Base Price: ${product.price}</p>
                            <ul>
                                {product.parts.map(part => (
                                    <li key={part.id}>
                                        {part.type} - {part.option} (${part.price})
                                    </li>
                                ))}
                            </ul>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default CreateProduct;
