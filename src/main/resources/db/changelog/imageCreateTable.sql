Create Table image (
id varchar PRIMARY KEY unique,
             path_to_file varchar(255),
             original_file_name varchar,
             content_type varchar,
             description varchar,
             product_id bigint REFERENCES product(id)
             )