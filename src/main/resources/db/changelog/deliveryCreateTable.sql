create table delivery (
deliveryId bigserial primary key,
delivery_date date,
deliveryType varchar,
deliveryCost bigint,
address varchar,
orderId bigint references delivery(deliveryId)
)