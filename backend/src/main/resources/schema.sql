CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    name VARCHAR(255),
    price FLOAT
);

CREATE TABLE parts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    option_name VARCHAR(255),
    price FLOAT
);

CREATE TABLE product_parts (
    product_id BIGINT,
    part_id BIGINT,
    PRIMARY KEY (product_id, part_id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT fk_part FOREIGN KEY (part_id) REFERENCES parts(id)
);
