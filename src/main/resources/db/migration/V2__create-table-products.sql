CREATE TABLE products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    code VARCHAR(20) NOT NULL UNIQUE,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    ean VARCHAR(13),
    category_id BIGINT,
    manufacturer VARCHAR(30),
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
