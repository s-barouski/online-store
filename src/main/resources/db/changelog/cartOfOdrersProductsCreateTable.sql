create table cart_of_orders_products (
id bigserial,
cart_of_order_id bigserial references product(product_id),
product_id bigserial references cart_of_order(cart_of_order_id)
)