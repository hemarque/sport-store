INSERT INTO products (type, name, price) VALUES
('bicycle', 'Mountain Bike', 303),
('bicycle', 'Road Bike', 285),
('bicycle', 'Fat Bike', 318);

INSERT INTO parts (type, option_name, price) VALUES
('Frame Type', 'Diamond', 120),
('Frame Finish', 'Shiny', 30),
('Frame Finish', 'Matte', 25),
('Wheels', 'Mountain wheels', 80),
('Wheels', 'Road wheels', 70),
('Wheels', 'Fat bike wheels', 100),
('Rim Color', 'Black', 20),
('Rim Color', 'Blue', 20),
('Chain', 'Single-speed chain', 43),
('Chain', '8-speed chain', 50),
('Frame Type', 'Full-suspension', 130);


-- Mountain Bike (id=1)
INSERT INTO product_parts (product_id, part_id) VALUES
(1, 11), -- Full-suspension
(1, 2),  -- Shiny
(1, 4),  -- Mountain wheels
(1, 7),  -- Black rim
(1, 9);  -- Single-speed chain

-- Road Bike (id=2)
INSERT INTO product_parts (product_id, part_id) VALUES
(2, 1),  -- Diamond
(2, 3),  -- Matte
(2, 5),  -- Road wheels
(2, 8),  -- Blue rim
(2, 10); -- 8-speed chain

-- Fat Bike (id=3)
INSERT INTO product_parts (product_id, part_id) VALUES
(3, 11), -- Full-suspension
(3, 3),  -- Matte
(3, 6),  -- Fat bike wheels
(3, 7),  -- Black rim
(3, 9);  -- Single-speed chain
