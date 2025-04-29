# sport-store : frontend

# Marcus Shop - E-Commerce Application

Marcus Shop is an e-commerce application built with React. It allows users to browse, purchase products, and manage their shopping cart. Administrators can create new products and parts in the backoffice. The application also includes a checkout process and a confirmation page for completed purchases.

## Features

- **User Features**:
  - Browse products and view product details.
  - Add products to the shopping cart.
  - View and manage items in the shopping cart.
  - Checkout process and payment integration (pending).
  - Order confirmation page.

- **Admin Features**:
  - Admin login (protected route, needs authentication).
  - Create and manage products and parts in the backoffice.
  - View and manage the catalog of products.

## Installation

1. Clone the repository:

   `git clone https://github.com/hemarque/sport-store.git`

2. Install dependencies:

    `cd frontend`

    `npm install`

3. Run the application:

    `npm start`

The app will be available at http://localhost:3000.

## Technologies Used
- React
- React Router
- Context API for global state (shopping cart)
- Fetch API for backend communication

## Not implemented yet
Here's a concise list of the features that are partially or not fully implemented:

### Partially:
- Product page UI for available options and price calculation
- Add to cart action and data persistence
- Administrative workflows for managing the store

### Not fully implemented:
- Prohibited combinations (e.g., specific frame options with wheels)
- "Temporarily out of stock" functionality for parts
- Dynamic pricing based on part combinations (e.g., frame finish affecting price)
- Dynamic price setting for parts and combinations

## Other features to Implement
- Authentication for admin users.
- Payment gateway integration (Stripe, PayPal).
- Inventory management and stock updates.
- Enhanced user interface (UX improvements).
- SEO and accessibility optimizations.

## Future Improvements
- Implement product search and filters.
- Add user reviews and ratings for products.
- Multi-language support.
- Mobile responsiveness enhancements.

---

## UI Structure

### 1. Customer UI
1. [Home](http://localhost:3000/)
2. [Catalog](http://localhost:3000/catalog)
    1. calls /api/products to get the products
    2. (click on product)
3. [Product Details](http://localhost:3000/product/1)
    1. calls /api/products/{product id}
    2. (click on Add to Cart updates the Cart)
    3. You can
        1. (click on Go to Cart to review the Cart)
        2. (click on Continue Shopping to go Home)
4. [Cart](http://localhost:3000/cart)
    1. (click on Proceed to Checkout)
    2. (click on Continue Shopping to go Home)
5. [Checkout](http://localhost:3000/checkout)
    1. (click on Confirm Order)
6. [Order Confirmation](http://localhost:3000/confirmation)
    1. The shopping cart is emptied
    2. (click on Go to Home to go to the main page)


### 2. Admin UI

1. [Home](http://localhost:3000/)
2. [Backoffice](http://localhost:3000/backoffice)
    1. (click on Create part)
    2. (click on Create product)
3. [Create New Part](http://localhost:3000/part)
    1. (click on Home)
    2. (click on Backoffice)
    3. (click on Create product)
4. [Create New Product](http://localhost:3000/product)
    1. (click on Home)
    2. (click on Backoffice)
    3. (click on Create part)
