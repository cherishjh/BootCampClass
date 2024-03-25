-- 프로시저 네임 : getUser(IN userId INT)
where id =userId 


DELIMITER //
CREATE PROCEDURE getUser(IN userId int)
begin
select * from author where id=userId;
end //
DELIMITER ;
show create procedure getUser;


-- post 테이블에서 쉽게 insert 할 수 있는 post 관련 프로시저 생성
-- 사용자에게 title, contents, author_id만 입력 받아 insert 하는 insert 문 생성
DELIMITER //
CREATE PROCEDURE easy_post(IN title varchar(255), contents varchar(3000),userID int) 
begin
insert into post(title, contents, author_id) value(title, contents, userID);
end // 
DELIMITER ;
show create procedure easy_post;

-- post 테이블에 if 문 활용하여 고액 원고료 작가 조회
"고액 원고료 작가입니다"
"고액 원고료 작가가 아닙니다"

DELIMITER //
CREATE PROCEDURE my_procedure(in author_id int)
select author_id, sum(price), salary into Sales from post
group by author_id;
begin
declare Sales, varhar(255)
if post(price)>=800 then
"고액 원고료 작가입니다"
else
"고액 원고료 작가가 아닙니다"
end if;
end // 
DELIMITER ;


-- 강사님 답
insert into post(title, contents, author_id) value(title, contents, userID);
end // 
DELIMITER ;
show create procedure easy_post;

delimiter
CREATE PROCEDURE post_price_check(in a_id int)
begin 
    declare avg_price int default 0;
    select avg(price) into avg_price from post where author_id=a_id; 
    if avg_price>10000 then
        select "고액 원고료 작가입니다" as message;
    else
        select "고액 원고료 작가가 아닙니다" as message;
    end if;
end//
delimiter


-- author 테이블에 while 문을 활용하여 데이터 대량 insert

-- while 문
declare calculator int default 0;
while calculator<100 Do
insert into post(contents) value("hi");
set calculator= calculator+1;
end while;

-- 프로시저문
delimiter //
CREATE PROCEDURE addPost()             
begin 
   declare calculator int default 0;
    while calculator<100 Do
        insert into post(contents) value("hi");
        set calculator= calculator+1;
    end while;
end //
delimiter ;
-- 이건 변수를 넣어서 확인하는 프로시저가 아닌 그냥 어떤 procedure 이므로 
-- () 안에 변수 명을 넣어줄 필요가 없음

-- 함수의 기본 꼴: 함수명();

delimiter //
CREATE PROCEDURE addPostt()             
begin 
   declare calculator int default 0;
    while calculator<20 Do
        insert into post(contents) value("hi");
        insert into post(title) value(concat("Hello ", calculator));
        set calculator = calculator+1;
    end while;
end //
delimiter ;