create table buyer (
buyerId bigserial primary key,
first_name varchar,
last_name varchar,
phone_number bigint,
email varchar,
orderHistoryId bigint references buyer(buyerId)
)