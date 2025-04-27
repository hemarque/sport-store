import React from "react";
import { useNavigate } from "react-router-dom";

const Confirmation: React.FC = () => {
  const navigate = useNavigate();

  const handleGoHome = () => {
    navigate("/");
  };

  return (
    <div>
      <div className="flex items-start space-x-2">
        <img className="align-top" width="40px" src="/img/logo.png" alt="logo" />
        <h1>Marcus Shop</h1>
      </div>

      <h1>Thank you for your order!</h1>
      <p>Your order has been confirmed. We will process it soon.</p>
      <button onClick={handleGoHome}>Go to Home</button> { }
    </div>
  );
};

export default Confirmation;
