-- Write your PostgreSQL query statement below
-- Get product purchased by the same users
SELECT DISTINCT p1.product_id product1_id, p2.product_id product2_id, pi1.category product1_category, pi2.category product2_category, COUNT(p1.user_id) AS customer_count
FROM ProductPurchases p1
JOIN ProductPurchases p2 ON p1.user_id=p2.user_id
JOIN ProductInfo pi1 ON pi1.product_id=p1.product_id
JOIN ProductInfo pi2 ON pi2.product_id=p2.product_id
WHERE p1.product_id < p2.product_id
GROUP BY product1_id, product2_id, product1_category, product2_category
HAVING COUNT(p1.user_id) >=3
ORDER BY customer_count DESC, product1_id, product2_id

