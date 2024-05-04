CREATE VIEW [dbo].[pizza_order_summary] AS
SELECT porder.id_order AS idOrder, customer.name AS customerName, porder.created_date AS createdDate, porder.total_price AS total, STRING_AGG(pizza.name, ',') AS pizzaNames
FROM pizza_order porder
    INNER JOIN pizza_customer customer ON customer.id_customer = porder.id_customer
    INNER JOIN pizza_order_item item ON item.id_order = porder.id_order
    INNER JOIN pizza ON pizza.id_pizza = item.id_pizza
GROUP BY porder.id_order, customer.name, porder.created_date, porder.total_price
GO
