CREATE TABLE IF NOT EXISTS orders (
    id              SERIAL PRIMARY KEY,
    customer_id     INTEGER NOT NULL REFERENCES customers(id) ON DELETE CASCADE,
    product_id      VARCHAR NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    amount          INTEGER NOT NULL,
    order_date      TIMESTAMP NOT NULL
)