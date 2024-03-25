-- 1. author_address table 생성, author_id가 FK, author 테이블 reference
CREATE TABLE author_address
(author_id int, state_city VARCHAR(255), 
details VARCHAR(255), zip_code VARCHAR(255), phonenumber int, 
foreign key (author_id) references author(id) on delete cascade);

-- bigint로 설정해야 함 


-- (foreign key 추가하는 방법)

-- 2. author table과 1:1 관계 형성
select * from author_address as aa
inner join author as a
on aa.author_id=a.id

-- 3. author table 과 post table의 n:m 관계 형성 
create table author_post
(Num int, post_author_id int, post_id int, 
primary key(Num),
foreign key(post_author_id) references author(id) on delete cascade,
foreign key(post_id) references post(id) on delete cascade);

-- 4. join and join

select * from author_address as aa
inner join author as a
on aa.author_id=a.id
left join author_post 
on a.id = author_post.post_author_id