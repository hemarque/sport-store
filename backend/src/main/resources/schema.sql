CREATE TABLE products (
    id BIGINT PRIMARY KEY,
    type VARCHAR(255),
    name VARCHAR(255),
    price FLOAT
);

CREATE TABLE parts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    option_name VARCHAR(255),
    price FLOAT,
    product_id BIGINT,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products(id)
);
