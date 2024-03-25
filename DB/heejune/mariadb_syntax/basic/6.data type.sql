-- author 테이블에 age 데이터 tinyint unsigned로 추가 
-- 255이하로 insert,, 255초과로 insert test
-- post에 price라는 원고료컬럼을 추가, 원고료 칼럼은 총 10자리 및 소수점 단위는 3자리까지 가능 
    -- 칼럼 추가 후 비어있는 칼럼에 숫자 update test(소수점3이하 test, 소수점 3초과 test)
  

  alter table post add column price decimal(10,3);



-- BLOB(longblob)
다양한 크기의 바이너리 데이터를 저장할 수 있는 타입 
  create table table_blob(id int, myimg blob);
  insert into table_blob(id, myimg) values(1, LOAD_FILE('C:\\image_sea.jpg'));
  select HEX(myimg) from table_blob where id=1;
--    HEX는 16진수로 변환

-- 실습 과제: 
-- role 타입 enum타입 변경하고
-- ‘user’, ‘admin’으로 enum 타입지정, not null로 설정하되,
-- 입력이 없을 시에는 ‘user’로 셋팅되도록 default 설정
update author set role='user';  
-- user로 모두 바꿈
alter table author modify column role enum('user','admin') not null default 'user';


--날짜와 시간
DATE
날짜를 저장할 수 있는 타입
YYYY-MM-DD

DATETIME(m)
날짜와 함께 시간까지 저장, m지정시 소수점 microseconds
YYYY-MM-DD HH:MM:SS
가장 많이 사용
java의 localdatetime과 sync
DATETIME DEFAULT CURRENT_TIMESTAMP

현재 시간을 default 로 삽입하는 형식
-- 실습과제 
-- post 테이블에 DATETIME으로 createdTIme 칼럼 추가 및 default 로 현재 시간 들어가도록 설정
-- datetime(6) default current_timestamp(6)
-- 칼럼 추가 후 insert test
alter table post add column createdTime DATETIME(6) default current_timestamp(6);
insert into post(id) value(12);


-- 비교연산자
=
! = <>
<  <=   >=
IS NULL, IS NOT NULL
BETWEEN min AND max : 피연산자값이 min값보다 크거나 max 보다 작으면 참을 반환함
-- 둘다 포함(이상, 이하)
IN(), NOT IN()
-- 특정컬럼 IN() 안에 넣어서 참이면 출력 

-- 프로그래머스 SQL문제 풀이 (비교연산자 (IS NULL)- 나이 정보가 없는 회원수 구하기)

-- 논리연산자 
AND &&도 가능
OR || 도 가능 
NOT ! 도 가능
-- 실습 문제 
-- author 테이블의 id가 1,2,4는 아닌 데이터 조회(NOT IN 사용)
-- post 테이블의 id가 2~4까지 데이터 조회
--   between 활용
--   and 조건 활용
--   or 조건 활용
select id from author where id not in(1,2,4);
select id from post where id between 2 and 4;
select id from post where id>=2 and id<=4;
select id from post where (id) not(id<2 or id>4); 

-- 검색패턴
LIKE 
-- 특정 패턴을 포함하는 데이터만을 검색하기 위한 와일드카드(wildcard) 문자
-- 일반적으로 %와 함께 사용됨
SELECT * FROM author WHERE name LIKE  '홍%'
SELECT * FROM author WHERE name LIKE  '%동'
SELECT * FROM author WHERE name LIKE  '%길%'

NOT LIKE 
SELECT * FROM author WHERE name NOT LIKE  '홍%'
--  ‘홍’으로 시작하지 않는 모든 이름을 가지고 오는 쿼리

REGEXP
정규표현식을 토대로 패턴 연산 수행
SELECT * FROM author WHERE name REGEXP '[a-z]';
SELECT * FROM author WHERE name REGEXP '[가-힣]';
-- 프로그래밍할때 많이 사용// 자바할때 좀 더 깊게 배울 예정 
-- 회원가입할때 특수문자, 이메일에 '알파벳@알파벳.com' 이 있는지 없는지
NOT REGEXP


-- 타입변환
CAST 
CAST (a AS type)
-- a값을 type으로 변환
-- 보통 정수 값을 DATE 타입으로 변환하는데 사용
SELECT CAST(20200101 AS DATE); ⇒2020-01-01

CONVERT
-- 문자열을 날짜/시간으로 변환하는데 사용
CONVERT('2020-01-01', DATE); ⇒2020-01-01

DATE_FORMAT *가장 많이 사용*
-- DATE_FORMAT 함수는 날짜/시간 타입의 데이터를 지정된 형식의 문자열로 변환
DATE_FORMAT(date,format)
ex. SELECT DATE_FORMAT(’2020-01-01 17:12:00’, ‘%Y-%m-%d’); ⇒ 2020-01-01

-- 프로그래머스 SQL 문제 풀이 (date 타입 변환 관련- 조건에 맞는 도서 리스트 출력하기)