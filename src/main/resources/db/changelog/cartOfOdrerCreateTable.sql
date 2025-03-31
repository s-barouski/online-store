create table cart_of_order (
cart_of_order_id bigserial primary key,
quantity_of_goods integer,
total_cost float,
buyer_id bigint references buyer(buyer_id)
)