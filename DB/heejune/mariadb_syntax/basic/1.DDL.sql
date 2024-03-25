-- 데이터베이스 생성 
CREATE DATABASE board;
-- 데이터베이스 선택
USE board;
-- author 테이블 신규 생성
CREATE TABLE author(id INT, name VARCHAR(255), 
email VARCHAR(255),password VARCHAR(255),test1 VARCHAR(255), PRIMARY KEY (id));
-- 테이블 목록 조회
SHOW TABLES;
-- 테이블 컬럼 조회
DESCRIBE author; 
-- post table 신규 생성
CREATE TABLE posts(id INT PRIMARY KEY, title VARCHAR(255), content VARCHAR(255), author_id INT, FOREIGN KEY (author_id) REFERENCES author(id))

-- 테이블 컬럼상세조회
SHOW FULL COLUMNS FROM author;

--테이블 생성문 조회
SHOW CREATE TABLE posts;

-- 테이블 제약조건 조회 
SELECT *FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'posts';

use INFORMATION_SCHEMA;

--테이블 INDEX 조회
SHOW INDEX FROM 테이블명
--예) SHOW INDEX FROM posts;

--테이블 이름 변경
ALTER TABLE 테이블명 ADD COULMN 컬럼명 자료형 [NULL 또는 NOT NULL]

--ALTER 문
--테이블 이름 변경
ALTER TABLE posts RENAME post;
-- 테이블 컬럼 추가 
ALTER TABLE author ADD COLUMN role VARCHAR(50);
-- 테이블 컬럼 변경
ALTER TABLE author MODIFY COLUMN name VARCHAR(100) NOT NULL;
-- 칼럼 이름 변경 
ALTER TABLE 테이블명 CHANGE COLUMN 기존칼럼명 새로운칼럼명 VARCHAR(255);
-- 칼럼 삭제
ALTER TABLE author DROP COLUMN test1;

-- 데이터베이스 삭제
DROP database 
-- 테이블 삭제 : 스키마 자체가 없어짐
DROP TABLE 테이블명

-- 테이블의 데이터만을 지우고 싶을때 
DELETE FROM 테이블명 WHERE 필드 이름=데이터값
TRUNCATE TABLE 테이블명 WHERE 필드 이름= 데이터값

-- IF EXISTS
DROP DATABASE IF EXISTS abc;

-






