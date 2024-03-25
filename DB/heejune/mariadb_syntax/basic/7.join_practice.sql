-- join 실습
-- 1. author 테이블(alias a ) 과 post(alias p) 테이블을 join하여 글을 작성한 모든 저자의 이름(name)과 해당 글의 제목 (title)을 조회하시오.
select a.name as name , p.title as title  from post p inner join author a on p.author_id=a.ID;
-- 2. author 테이블을 기준으로 post 테이블과 join 하여, 모든 저자의 이름과 해당 저자가 작성한 글의 제목을 조회하시오. 글을 작성하지 않은 저자의 경우, 글 제목은 NULL로 표시
select a.name, p.title from author a left join post p on a.ID=p.author_id;
-- 3. 2번과 동일하게 모든 저자의 이름과 해당 저자가 작성한 글의 제목을 조회.  단 저자의 나이가 25세 이상인 저자만 조회.
select a.name, p.title from author a left join post p on a.ID=p.author_id where a.age>=25;

-- 프로그래머스 SQL
1. 없어진 기록 찾기
-- 방법 1. left join, animal_ins에 null 만들어서 null 찾기
SELECT o.animal_id as ANIMAL_ID, o.name as NAME from animal_outs as o left join animal_ins as i
on o.animal_id=i.animal_id 
where i.datetime is null
order by o.animal_id asc;

-- 방법 2. NOT IN
SELECT from animal_outs where animal_id 
not in (select animal_id from animal_outs inner join animal_ins on animal_ins.animal_id=animal_outs.animal_id)
order by animal_id;


2. 조건에 맞는 도서와 저자 리스트 구하기
-- 방법 1: left join(내 생각)
SELECT b.book_id as BOOK_ID, a.author_name as AUTHOR_NAME, date_format(b.PUBLISHED_DATE,'20%y-%m-%d') as PUBLISHED_DATE from book as b 
left join author as a 
on b.author_id=a.author_id
where b.category like '경제'
order by b.published_Date asc;
-- 운이 좋았음, 그러니까 not null이 걸려 있었거나 데이터가 비어있지 않아서 결과가 같이 나왔음
-- (그러니까 이 문제는 author_Id가 not null 이 걸려 있어서?)

-- 방법 2: inner join
SELECT b.book_id as BOOK_ID, a.author_name as AUTHOR_NAME, date_format(b.PUBLISHED_DATE,'20%y-%m-%d') as PUBLISHED_DATE from book as b 
inner join author as a 
on b.author_id=a.author_id
where b.category like '경제'
order by b.published_Date asc;

