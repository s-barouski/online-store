create table ordering (
order_id bigserial primary key,
order_date date,
total_cost FLOAT,
order_history_id bigint,
delivery_id bigint REFERENCES delivery(delivery_id)
)
