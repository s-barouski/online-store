create table cart_of_order_products (
id bigserial,
cart_id bigserial references product(product_id),
product_id bigserial references cart_of_order(cart_id)
)