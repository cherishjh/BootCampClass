-- 과제 내용 기입: 


insert into author(id,name,email) value(1, 'Jaine', 'ja@gmail.com');
insert into author(id,name,email)  value(2, 'Charile', 'ha@gmail.com');
insert into author(id,name,email)  value(3,'Sophie', 'sophie@gmail.com');
insert into author(id,name,email)  value(4,'Jessica','han@gmail.com');
insert into author(id,name,email) value(5,'Chuck','jas@gmail.com');
 
insert into post(id,title,author_id) value(1, 'hello', 1 );
insert into post(id,title,author_id) value(2, 'Charile', 2);
insert into post(id,title,author_id) value(3,'Sophie',2);
insert into post(id,title) value(4,'Jessica');
insert into post(id,title) value(5,'Chuck');

update post set author_id= null where author_id is not null;
delete from author; 

select * from post order by title asc, contents desc limit 3;