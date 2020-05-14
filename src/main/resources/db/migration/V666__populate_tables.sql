INSERT INTO products (price, description)
VALUES  (990, 'Product #1'),
        (530, 'Product #2'),
        (200, 'Product #3'),
        (100, 'Product #4'),
        (320, 'Product #5');

INSERT INTO customers (name, address, phone, contact_person)
VALUES  ('Company #1', 'Address #1', 123456, 'Some dude'),
        ('Company #2', 'Address #2', 123456, 'Some dude'),
        ('Company #3', 'Address #3', 123456, 'Some dude'),
        ('Company #4', 'Address #4', 123456, 'Some dude'),
        ('Company #5', 'Address #5', 123456, 'Some dude');

INSERT INTO orders (customer_id, product_id, amount, order_date)
VALUES  (1 , 2, 20, current_timestamp),
        (2 , 4, 34, current_timestamp);

INSERT INTO deliveries (delivery_name, price)
VALUES  ('Pickup from shop', 20),
        ('Pickup from postal office', 60),
        ('Courier', 100),
        ('Courier quickly', 150);

INSERT INTO order_delivery (order_id, delivery_id)
VALUES  (1, 1),
        (2, 4);