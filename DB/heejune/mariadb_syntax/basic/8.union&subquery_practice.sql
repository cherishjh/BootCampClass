-- author table 에서 name, email,
-- post table 에서 title, contents

select name, email from author union select title, contents from post;

-- union recursive
-- 재귀문으로서 자기 자신을 참조해서 반복적으로 데이터를 생성하고 하나의 테이블을 만드는 용으로 사용
union 과 함께 사용되며 데이터행을 더해나가는 방식
with recursive 재귀문에서 where 절은 재귀적으로 생성되는 각각의 행에 대해 평가되며,
조건이 거짓이 되는 순간 더 이상 새로운 행을 생성하지 않고, 전체 재귀문이 stop 

프로그래머스 입양 시각 구하기(2)
WITH RECURSIVE number_sequence(HOUR) AS 
(SELECT 0
UNION ALL
SELECT HOUR + 1 FROM number_sequence WHERE HOUR < 23
)
select hour, 0 as count from number_sequence
where hour not in (select hour(datetime) from animal_outs)

union
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
ORDER BY HOUR;