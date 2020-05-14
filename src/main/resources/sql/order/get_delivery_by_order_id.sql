SELECT d.*
FROM
    order_system.deliveries AS d,
    order_system.orders AS o,
    order_system.order_delivery AS od
WHERE d.id = od.delivery_id
    AND od.order_id = o.id
    AND o.id = ?;