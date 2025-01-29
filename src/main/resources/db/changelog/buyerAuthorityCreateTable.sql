create table buyer_authority (
buyer_id bigserial references buyer(buyer_id),
authority_id bigserial references authority(authority_id),
primary key(buyer_id,authority_id)
)