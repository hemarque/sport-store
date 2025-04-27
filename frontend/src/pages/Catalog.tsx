import { Link } from "react-router-dom";

const products = [
  { id: "1", name: "Mountain Bike", price: 303 },
  { id: "2", name: "Road Bike", price: 285 },
  { id: "3", name: "Fat Bike", price: 318 }
];


const Catalog: React.FC = () => {
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
