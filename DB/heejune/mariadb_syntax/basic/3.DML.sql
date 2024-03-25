UPDATE author set email='abc@naver.com', name='abc' where id=4
delete from post where author_id=3;
delete from author where id=2
insert into author (id, name, email) values(2,'han','hay@gmail.com')


select * from author where id=1;
select name, email from author;
select name, email from author where id=1;
select * from author where id>1;
select * from author where id>1 AND name=’kim’;

-- 이름 중복 제거하고 조회 
SELECT DISTINCT NAME FROM author;

-- ORDER BY
SELECT * FROM author ORDER BY NAME asc  
-- (asc: 오름차순 desc: 내림차순) 

-- ORDER BY 멀치: 먼저 쓴 칼럼 우선 정렬, asc/desc  생략시 asc 적용 
SELECT * FROM author ORDER BY name desc, email desc;

-- limit number: 특정 숫자로 결과값 개수 제한 (2개로 개수 제한)
select * FROM author ORDER BY id desc limit 2; 

-- ALIAS 를 이용한  select 문
select name as 이름 from author; 
-- as는 생략 가능 
select name, email from author as a;


