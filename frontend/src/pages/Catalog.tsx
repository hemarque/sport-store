import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import { Product } from "../model/Product";

const Catalog: React.FC = () => {

  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/products") 
      .then(response => response.json())
      .then(data => setProducts(data))
      .catch(error => console.error("Error fetching products:", error));
  }, []);

  return (
    <div>
      <div className="flex items-start space-x-2">
        <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
        <h1>Marcus Shop</h1>
      </div>
      <h2>Catalog</h2>
      {products.map((product) => (
        <div key={product.id}>
          <h3>{product.name}</h3>
          <p>${product.price}</p>
          <Link to={`/product/${product.id}`}>See Details</Link>
          <hr/>
        </div>
      ))}
    </div>
  );
};

export default Catalog;
