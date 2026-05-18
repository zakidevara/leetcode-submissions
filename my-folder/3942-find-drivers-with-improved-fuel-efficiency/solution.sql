WITH agg AS (
    SELECT
        d.driver_id,
        d.driver_name,
        ROUND(AVG(CASE WHEN EXTRACT(MONTH FROM t.trip_date) <= 6 
            THEN t.distance_km / t.fuel_consumed END), 2) AS first_half_avg,
        ROUND(AVG(CASE WHEN EXTRACT(MONTH FROM t.trip_date) > 6 
            THEN t.distance_km / t.fuel_consumed END), 2) AS second_half_avg,
        ROUND(
            COALESCE(AVG(CASE WHEN EXTRACT(MONTH FROM t.trip_date) > 6 
                THEN t.distance_km / t.fuel_consumed END), 0)
            - COALESCE(AVG(CASE WHEN EXTRACT(MONTH FROM t.trip_date) <= 6 
                THEN t.distance_km / t.fuel_consumed END), 0)
        , 2) AS efficiency_improvement
    FROM drivers AS d
    LEFT JOIN trips AS t ON t.driver_id = d.driver_id
    GROUP BY d.driver_id, d.driver_name
)
SELECT *
FROM agg
WHERE
    first_half_avg IS NOT NULL AND
    second_half_avg IS NOT NULL AND
    efficiency_improvement > 0.0
ORDER BY efficiency_improvement DESC, driver_name ASC;
