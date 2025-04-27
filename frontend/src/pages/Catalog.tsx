import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import { Product } from "../model/Product";

const Catalog: React.FC = () => {

  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/products") // ← API endpoint
      .then(response => response.json())
      .then(data => setProducts(data))
      .catch(error => console.error("Error fetching products:", error));
  }, []);

  return (
    <div>
      <div className="flex items-start space-x-2">
        <img className="align-top" width="30px" src="/img/logo.png" alt="logo" />
        <h1>Marcus Shop</h1>
      </div>
      <h1>Catalog</h1>
      {products.map((product) => (
        <div key={product.id}>
          <h2>{product.name}</h2>
          <p>${product.price}</p>
          <Link to={`/product/${product.id}`}>See Details</Link>
        </div>
      ))}
    </div>
  );
};

export default Catalog;
