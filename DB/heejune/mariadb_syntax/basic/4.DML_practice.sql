insert into author (id, name, email) values(...)
insert into author (id, name, email) values(...)
insert into author (id, name, email) values(...)
insert into author (id, name, email) values(...)
insert into author (id, name, email) values(...)

insert into post(id, title, contents, author_id) value(1, 'apple' , null, 1);
insert into post(id, title, contents, author_id) value(2,'pear' ,'happy'  , 2);
insert into post(id, title, contents, author_id) value(3,'warewolf', 'freak', null);
insert into post(id, title, contents, author_id) value(4,'sun' , null, null);
insert into post(id, title, contents, author_id) value(5,'good' , 'good', 9);
-- crtl+'shift'+enter 
----------------------------------------------------------------------------------

UPDATE author set email='abc@naver.com', name='abc' where id=4
delete from post where author_id=2;
delete from author where id=2;
-- post에 글쓴적이 있는 author 데이터 1개 삭제 ->에러 -> 조치 후 삭제
-- 방법1. 글쓴이를 찾아서 삭제
delete from post where author_id=2;
delete from author where id=2;
-- 방법2. 글쓴이를 찾아 author_id를 null로 만들고, 삭제
update post set author_id = null where author_id=2;
delete from author where id=2;

