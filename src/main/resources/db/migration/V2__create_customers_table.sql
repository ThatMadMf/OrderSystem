CREATE TABLE IF NOT EXISTS customers (
    id              SERIAL PRIMARY KEY,
    name            VARCHAR (32) NOT NULL,
    address         VARCHAR (128) NOT NULL,
    phone           INTEGER (16) NOT NULL,
    contact_person  VARCHAR (32) NOT NULL
)