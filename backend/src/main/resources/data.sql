INSERT INTO products (id, type, name, price) VALUES
(1, 'bicycle', 'Mountain Bike', 303),
(2, 'bicycle', 'Road Bike', 285),
(3, 'bicycle', 'Fat Bike', 318);

INSERT INTO parts (type, option_name, price, product_id) VALUES
('Frame Type', 'Full-suspension', 130, 1),
('Frame Finish', 'Shiny', 30, 1),
('Wheels', 'Mountain wheels', 80, 1),
('Rim Color', 'Black', 20, 1),
('Chain', 'Single-speed chain', 43, 1),

('Frame Type', 'Diamond', 120, 2),
('Frame Finish', 'Matte', 25, 2),
('Wheels', 'Road wheels', 70, 2),
('Rim Color', 'Blue', 20, 2),
('Chain', '8-speed chain', 50, 2),

('Frame Type', 'Full-suspension', 130, 3),
('Frame Finish', 'Matte', 25, 3),
('Wheels', 'Fat bike wheels', 100, 3),
('Rim Color', 'Black', 20, 3),
('Chain', 'Single-speed chain', 43, 3);
