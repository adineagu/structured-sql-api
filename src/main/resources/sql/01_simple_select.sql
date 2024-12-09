SELECT DISTINCT
    T1.COLUMN1 || 'ABC' as COLUMN1, 
    T2.COLUMN2
FROM
    SCHEMA1.TABLE1 T1
    @properties(name="Join_1")
    LEFT JOIN SCHEMA2.TABLE2 T2
        ON  T1.COLUMN1 = T2.COLUMN1
        AND T1.COLUMN2 = T2.COLUMN2
    @properties(name="Join_2")
    INNER JOIN (
        SELECT
            T3.COLUMN1,
            T3.COLUMN2
        FROM
            SCHEMA3.TABLE3 T3
        WHERE
            T3.COLUMN1 = 'value1'
            AND T3.COLUMN2 = 'value2'
        UNION ALL
        SELECT DISTINCT
            T4.COLUMN1,
            T4.COLUMN2
        FROM
            SCHEMA3.TABLE4 T4
        WHERE
            T4.COLUMN1 = 'value1'
            AND T4.COLUMN2 = 'value2'
    ) T5
        ON  T1.COLUMN1 = T5.COLUMN1
        AND T1.COLUMN2 = T5.COLUMN2
WHERE
    T5.COLUMN1 = 'value1'
    AND T2.COLUMN2 = 'value2'