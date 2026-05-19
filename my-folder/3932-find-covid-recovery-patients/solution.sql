WITH positives AS (
    -- Step 1: get first positive date per patient
    SELECT
        p.patient_id, 
        p.patient_name, 
        p.age,
        MIN(t.test_date) AS first_positive_date
    FROM patients p
    JOIN covid_tests t ON t.patient_id = p.patient_id
    WHERE t.result = 'Positive'
    GROUP BY p.patient_id, p.patient_name, p.age
),
negatives AS (
    -- Step 2: get first negative date after first_positive_date
    SELECT
        t.patient_id,
        MIN(t.test_date) AS first_negative_after_positive
    FROM covid_tests t
    JOIN positives pos ON pos.patient_id = t.patient_id
    WHERE t.result = 'Negative'
        AND t.test_date > pos.first_positive_date
    GROUP BY t.patient_id
)

SELECT
    pos.patient_id,
    pos.patient_name,
    pos.age,
    neg.first_negative_after_positive - pos.first_positive_date AS recovery_time
FROM positives pos
JOIN negatives neg ON neg.patient_id = pos.patient_id
ORDER BY recovery_time ASC, patient_name ASC
