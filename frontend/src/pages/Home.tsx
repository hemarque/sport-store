import React from "react";
import { Link } from "react-router-dom";

const Home: React.FC = () => {
  return (
    <div>
      <div className="flex items-start space-x-2">
        <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
        <h1>Marcus Shop</h1>
      </div>
      <Link to="/catalog">Browse Products</Link> | <Link to="/backoffice">Backoffice (for authorized personnel only)</Link>
    </div>
  );
};

export default Home;
