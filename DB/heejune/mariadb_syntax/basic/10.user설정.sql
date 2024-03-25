create user 'newuser'@'localhost' identified by 'newuser' #pw   
-- insert 권한 주기 
grant insert on board.author to 'newuser'@'localhost' ;
-- select 권한 주기 
grant select on board.author to 'newuser'@'localhost';
-- 권한 뺴기
revoke insert on board.author to 'newuser'@'localhost';

flush privileges;
-- 특정 사용자 권한 조회 
show grants for 'newuser'@'localhost';

