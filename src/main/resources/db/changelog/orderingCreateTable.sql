create table ordering (
order_id bigserial primary key,
order_date date,
total_cost bigint,
order_history_id bigint
)
