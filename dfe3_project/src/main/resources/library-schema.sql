drop table if exists 'library' CASCADE;
create table
	'library'
	(
		id bigint AUTO_INCREMENT,
		title varchar(128),
		author varchar(128),
		genre varchar(128)
		primary key (id)
	);