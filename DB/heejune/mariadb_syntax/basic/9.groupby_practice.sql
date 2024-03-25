-- region의 행 개수
select count(*) from excel group by region;
-- region 이름과 그 개수
select region, count(*) from excel group by region;
-- 
select region, sum(price) from excel group by region;


select sum(price) from post group by author_id;

-- author id 별 count 값
select author_id, count(*) from post group by author_id;
-- author id 별 price sum
select author_id, sum(price) as income from post group by author_id;
-- author id 별 price avg
select author_id, avg(price) as 'average income' from post group by author_id;

-- 1. author_id 별로 price 평균값을 구하시오, 단 건별로 350 이상인 데이터만 평균 내서 출력하시오
select author_id, avg(price) from post where price>=350 group by author_id;
-- 2. author_id 별로 price 평균값을 구하되, 평균값이 200 이상 건만 출력하시오.
select author_id, avg(price) as 'avg' from post group by author_id having avg >=200;
-- 1번과 2번을 합친 조건
select author_id, avg(price) as 'avg' from post where price>=350 group by author_id having avg>=200;

-- 프로그래머스
1. 입양 시각 구하기(1)
SELECT hour(datetime) as 'HOUR', count(animal_id) as 'COUNT' from animal_outs 
where hour(datetime) between 9 and 19
group by hour(datetime)
order by hour(datetime); 
-> 이건 틀린것

-- 강사님 답안
    -- 시간대 출력
    date_format(변수명, '%H-%i') where '9:00' and '19:59'

SELECT date_format(datetime, '%H') as 'HOUR', count(animal_id) as 'COUNT' from animal_outs 
where date_format(datetime, '%H:%i') between '9:00' and '19:59'
group by 'HOUR'
order by 'HOUR'; 

SELECT CAST(date_format(datetime, '%H')) as 'HOUR', count(animal_id) as 'COUNT' from animal_outs 
where date_format(datetime, '%H:%i') between '9:00' and '19:59'
group by 'HOUR'
order by 'HOUR'; 

2.성분으로 구분한 아이스크림 총 주문량
SELECT ICECREAM_INFO.INGREDIENT_TYPE as INGREDIENT_TYPE, 
SUM(FIRST_HALF.TOTAL_ORDER) as TOTAL_ORDER 
FROM ICECREAM_INFO 
INNER JOIN FIRST_HALF 
ON ICECREAM_INFO.FLAVOR=FIRST_HALF.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC;
-- 이런 유형은 일반적으로 INNER JOIN

3. 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
SELECT CAR_TYPE, COUNT(*) AS COUNT FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%'
OR OPTIONS LIKE '%열선시트%'
OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;

4. 재구매가 일어난 상품과 회원 리스트 구하기
SELECT USER_ID, PRODUCT_ID, COUNT(*) FROM ONLINE_SALE 
GROUP BY USER_ID,
PRODUCT_ID HAVING COUNT(PRODUCT_ID)>1
ORDER BY USER_ID, PRODUCT_ID DESC;

SELECT * WHERE HOUR(DATETIME) NOT IN BETWEEN 0 AND 23 AS HOUR, 