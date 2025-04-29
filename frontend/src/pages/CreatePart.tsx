import React, { useState, useEffect } from "react";
import { Part } from "../model/Part";
import { Link } from "react-router-dom";

const CreatePart: React.FC = () => {
    const [type, setType] = useState("");
    const [option, setOption] = useState("");
    const [price, setPrice] = useState(0);
    const [parts, setParts] = useState<Part[]>([]);

    const fetchParts = async () => {
        try {
            const response = await fetch("http://localhost:8080/api/parts");
            if (response.ok) {
                const data = await response.json();
                setParts(data);
            } else {
                console.error("Failed to fetch parts.");
            }
        } catch (error) {
            console.error("Error fetching parts:", error);
        }
    };

    useEffect(() => {
        fetchParts();
    }, []);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const newPart = { type, option, price };

        try {
            const response = await fetch("http://localhost:8080/api/parts", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(newPart),
            });

            if (response.ok) {
                setType("");
                setOption("");
                setPrice(0);
                await fetchParts();
            } else {
                alert("Failed to create part.");
            }
        } catch (error) {
            console.error("Error creating part:", error);
        }
    };

    return (
        <div>
            <div className="flex items-start space-x-2">
                <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
                <h1>Marcus Shop</h1>
            </div>
            <h2>Create New Part</h2>
            <Link to="/">Home</Link> | <Link to="/backoffice">Backoffice</Link> | <Link to="/product">Create product</Link>
            <br/><br/><hr/><br/>
            <form onSubmit={handleSubmit} className="flex flex-col gap-4 max-w-md">
                <input
                    type="text"
                    placeholder="Type (e.g., Frame Type)"
                    value={type}
                    onChange={(e) => setType(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Option (e.g., Full-suspension)"
                    value={option}
                    onChange={(e) => setOption(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Price"
                    value={price}
                    onChange={(e) => setPrice(Number(e.target.value))}
                    required
                    min="0"
                />
                <button type="submit" className="bg-blue-500 text-white py-2 px-4 rounded">Create Part</button>
            </form>

            <div className="mt-8">
                <h3 className="text-lg font-bold mb-2">Existing Parts</h3>
                {parts.length === 0 ? (
                    <p>No parts found.</p>
                ) : (
                    <ul className="space-y-2">
                        {parts.map((part) => (
                            <li key={part.id} className="border p-2 rounded">
                                <strong>Type:</strong> {part.type} | <strong>Option:</strong> {part.option} | <strong>Price:</strong> ${part.price}
                            </li>
                        ))}
                    </ul>
                )}
            </div>
        </div>
    );
};

export default CreatePart;
