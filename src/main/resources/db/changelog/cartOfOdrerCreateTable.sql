create table cart_of_order (
cart_id bigserial primary key,
quantityOfGoods integer,
totalCost float,
buyerId bigint references cart_of_order(cart_id)
)