set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;
create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;
create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	master_flg boolean,
	user_address1 varchar(50),
	user_address2 varchar(50),
	user_sex varchar(16),
	user_phone_number varchar(16),
	insert_date datetime,
	updated_date datetime
);

drop table if exists item_info_transaction;
create table item_info_transaction(
	id int not null primary key auto_increment,
	item_name varchar(30),
	item_price int,
	item_stock int,
	insert_date datetime,
	update_date datetime
);

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);

insert into item_info_transaction(item_name,item_price,item_stock) values
("雑誌",900,50),
("漫画",400,30),
("技術書",2500,10),
("ラノベ",600,100),
("ビジネス書",1500,60);

insert into login_user_transaction(login_id,login_pass,user_name,master_flg) values("internous","internous01","admin",1);