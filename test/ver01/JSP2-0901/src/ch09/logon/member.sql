
use tain

/* http://bstar36.tistory.com/307 */

drop table member;

create table if not exists member (
	id       varchar(128)  character set utf8,
	passwd   varchar(128)  character set utf8,
	name     varchar(128)  character set utf8,
	jumin1   varchar(128)  character set utf8,
	jumin2   varchar(128)  character set utf8,
	email    varchar(128)  character set utf8,
	blog     varchar(128)  character set utf8,
	reg_date timestamp,
	primary key (id)
);
/* ) default charset = utf8; */

