-- Write your PostgreSQL query statement below
SELECT a.year, a.price, b.product_name
FROM Sales AS a
LEFT JOIN Product AS b ON b.product_id=a.product_id
