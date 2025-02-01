create table order_history (
order_history_id bigserial primary key,
buyer_id bigserial references buyer(buyer_id)
)