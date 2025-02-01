create table delivery (
delivery_id bigserial primary key,
delivery_date date,
delivery_type varchar,
delivery_cost bigint,
address varchar,
order_id bigserial
)