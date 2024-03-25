-- item table
create table item(id bigint,product_name varchar(255) not null unique, product_count BIGINT default 0, price int default 0, expiration_date datetime DEFAULT CURRENT_TIMESTAMP, user_id varchar(255) not null, foreign key(user_id) references members(id) on delete cascade);
-- members table
create table members(id bigint, user_id varchar(255) not null unique, password varchar(255) not null, type enum('user', 'admin','seller') not null );
-- order table 