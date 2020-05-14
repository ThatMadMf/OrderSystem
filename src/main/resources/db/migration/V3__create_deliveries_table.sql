CREATE TABLE IF NOT EXISTS deliveries (
    id              SERIAL PRIMARY KEY,
    delivery_name    VARCHAR (32),
    price           DOUBLE NOT NULL
)