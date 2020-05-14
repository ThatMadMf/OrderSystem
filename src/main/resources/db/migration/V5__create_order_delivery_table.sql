CREATE TABLE IF NOT EXISTS order_delivery (
    order_id        INTEGER NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
    delivery_id     INTEGER REFERENCES deliveries(id),
    CONSTRAINT      order_delivery_pkey PRIMARY KEY (order_id, delivery_id)
);
