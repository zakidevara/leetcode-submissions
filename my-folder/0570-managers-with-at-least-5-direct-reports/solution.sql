-- Write your PostgreSQL query statement below
SELECT e2.name FROM Employee e1
JOIN Employee e2 ON e1.managerId=e2.id
GROUP BY e1.managerId, e2.name
HAVING
    COUNT(e1.managerId) >= 5

