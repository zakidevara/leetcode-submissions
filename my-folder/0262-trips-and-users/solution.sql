-- Write your PostgreSQL query statement below
SELECT 
    t.request_at as "Day",  
    ROUND((SUM(CASE WHEN status LIKE 'cancelled%' THEN 1.0 ELSE 0 END)/COUNT(t.id)), 2) as "Cancellation Rate"
FROM Trips t
JOIN Users driver ON driver.users_id=t.driver_id
JOIN Users client ON client.users_id=t.client_id
WHERE driver.banned != 'Yes' AND client.banned != 'Yes'
AND t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at
