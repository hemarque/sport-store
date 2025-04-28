import React from "react";
import { Link } from "react-router-dom";

const Admin: React.FC = () => {
  return (
    <div className="p-4">
      <div className="flex items-center space-x-4">
        <img className="align-top" width="40" src="/img/logo.png" alt="logo" />
        <h1 className="text-2xl font-bold">Admin</h1>
      </div>
      <Link to="/part">Create part</Link>
      <br/>
      <Link to="/product">Create product</Link>
    </div>
  );
};

export default Admin;
