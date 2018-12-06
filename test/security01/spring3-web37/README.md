spring3-web37
=============

- information
```
sample
```
- 한글처리
```
# vi /etc/mysql/my.ini
	.....
	[mysqld]
		.....
		character-set-client-handshake = FALSE
		init_connect = "SET collation_connection = utf8_general_ci"
		init_connect = "SET NAMES utf8"
		character-set-server = utf8
	[client]
		default-character-set = utf8
	[mysql]
		default-character-set = utf8
	[mysqldump]
		default-character-set = utf8
	.....

# service mysql restart
	.....
	
# mysql -u XXX -pXXX

	mysql> show variables like 'c%';
		+--------------------------+----------------------------+
		| Variable_name            | Value                      |
		+--------------------------+----------------------------+
		| character_set_client     | utf8                       |
		| character_set_connection | utf8                       |
		| character_set_database   | utf8                       |
		| character_set_filesystem | binary                     |
		| character_set_results    | utf8                       |
		| character_set_server     | utf8                       |
		| character_set_system     | utf8                       |
		| character_sets_dir       | /usr/share/mysql/charsets/ |
		| collation_connection     | utf8_general_ci            |
		| collation_database       | utf8_general_ci            |
		| collation_server         | utf8_general_ci            |
		| completion_type          | NO_CHAIN                   |
		| concurrent_insert        | AUTO                       |
		| connect_timeout          | 10                         |
		+--------------------------+----------------------------+
		14 rows in set (0.00 sec)

	mysql> use spring
	
	mysql> DROP TABLE IF EXISTS ITEM;

	mysql> CREATE TABLE IF NOT EXISTS ITEM (
		->   ITEM_ID        INTEGER(5) AUTO_INCREMENT,
		->   ITEM_NAME      VARCHAR(20),
		->   PRICE          INTEGER(6),
		->   DESCRIPTION    VARCHAR(50),
		->   PICTURE_URL    VARCHAR(20),
		->   PRIMARY KEY (ITEM_ID)
		-> ) default charset=utf8 collate utf8_general_ci;

	mysql> quit

[END]

```



References
----------
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):

.....


