create table ordering (
orderId bigserial primary key,
order_date date,
totalCost bigint,
orderHistoryId bigint,
deliveryId bigint references ordering(orderId)
)