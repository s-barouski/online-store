CREATE TABLE image (
    id UUID PRIMARY KEY,
    path_to_file VARCHAR(255) NOT NULL,
    original_file_name VARCHAR(255) NOT NULL,
    content_type VARCHAR(100) NOT NULL,
    description TEXT,
    product_id BIGINT REFERENCES product(product_id)
);