-- Inserir categorias
INSERT INTO categories (name, code, status) VALUES
('Electronics', 'ELEC', 1),
('Clothing', 'CLOTH', 1),
('Books', 'BOOK', 1),
('Toys', 'TOY', 1),
('Home Decor', 'DECOR', 1),
('Sports', 'SPORT', 1),
('Beauty', 'BEAUTY', 1),
('Food', 'FOOD', 1),
('Health', 'HEALTH', 1),
('Automotive', 'AUTO', 1),
('Tools', 'TOOLS', 1),
('Garden', 'GARDEN', 1),
('Pets', 'PETS', 1),
('Jewelry', 'JEWELRY', 1),
('Movies', 'MOVIES', 1),
('Music', 'MUSIC', 1),
('Games', 'GAMES', 1),
('Furniture', 'FURN', 1),
('Crafts', 'CRAFTS', 1),
('Office', 'OFFICE', 1);


-- Inserir produtos
INSERT INTO products (name, code, price, quantity, ean, category_id, manufacturer, status) VALUES
('Smartphone', 'SPH1', 599.99, 100, '1234567890123', 1, 'Samsung', 1),
('Laptop', 'LT1', 899.99, 50, '1234567890124', 1, 'Dell', 1),
('T-shirt', 'TS1', 19.99, 200, NULL, 2, NULL, 1),
('Jeans', 'JN1', 39.99, 150, NULL, 2, NULL, 1),
('Harry Potter', 'HP1', 12.99, 300, '1234567890125', 3, 'Scholastic', 1),
('LEGO Set', 'LG1', 49.99, 100, '1234567890126', 4, 'LEGO', 1),
('Throw Pillow', 'TP1', 9.99, 250, NULL, 5, NULL, 1),
('Yoga Mat', 'YM1', 29.99, 150, '1234567890127', 6, 'Gaiam', 1),
('Lipstick', 'LP1', 14.99, 200, NULL, 7, NULL, 1),
('Granola Bars', 'GB1', 4.99, 500, '1234567890128', 8, 'Nature Valley', 1),
('Multivitamin', 'MV1', 9.99, 300, '1234567890129', 9, 'Nature Made', 1),
('Motor Oil', 'MO1', 24.99, 100, '1234567890130', 10, 'Valvoline', 1),
('Hammer', 'HM1', 12.99, 150, NULL, 11, NULL, 1),
('Gardening Gloves', 'GG1', 7.99, 200, NULL, 12, NULL, 1),
('Dog Collar', 'DC1', 8.99, 300, NULL, 13, NULL, 1),
('DVD', 'DVD1', 7.99, 400, '1234567890131', 14, 'Universal Pictures', 1),
('CD', 'CD1', 5.99, 500, '1234567890132', 15, 'Sony Music', 1),
('Board Game', 'BG1', 24.99, 100, '1234567890133', 16, 'Hasbro', 1),
('Coffee Table', 'CT1', 99.99, 50, NULL, 17, NULL, 1),
('Knitting Needles', 'KN1', 3.99, 400, NULL, 18, NULL, 1),
('Printer Paper', 'PP1', 14.99, 200, NULL, 19, NULL, 1);

