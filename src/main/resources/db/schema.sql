DROP TABLE IF EXISTS user;
create table user
(
	id bigint auto_increment,
	account_id bigint,
	name varchar(50),
	avatar_url varchar(100),
	gmt_creator bigint,
	gmt_modify bigint,
	money integer default 30,
	constraint user_pk
		primary key (id)
);
DROP TABLE IF EXISTS trouble;
create table trouble
(
	id bigint auto_increment,
	title varchar(50),
	content text,
	tag_id bigint,
	creator bigint,
	gmt_create bigint,
	gmt_modify bigint,
	constraint trouble_pk
		primary key (id)
);
DROP TABLE IF EXISTS comment;
create table comment
(
	id int auto_increment,
	title varchar(50),
	content text,
	recipient bigint,
	creator bigint,
	trouble_id bigint,
	is_share bit,
	gmt_create bigint,
	gmt_modify bigint,
	constraint comment_pk
		primary key (id)
);

DROP TABLE IF EXISTS information;
create table information
(
	id bigint auto_increment,
	recipient bigint,
	sender bigint,
	status bit default 0,
	comment_id bigint,
	gmt_create bigint,
	gmt_modify bigint,
	constraint information_pk
		primary key (id)
);







