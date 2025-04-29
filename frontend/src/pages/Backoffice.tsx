import React from "react";
import { Link } from "react-router-dom";

const Admin: React.FC = () => {
  return (
    <div>
      <div className="flex items-start space-x-2">
        <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
        <h1>Marcus Shop</h1>       
      </div>
      <h2>Backoffice</h2>
      <Link to="/part">Create part</Link> | <Link to="/product">Create product</Link>
    </div>
  );
};

export default Admin;
