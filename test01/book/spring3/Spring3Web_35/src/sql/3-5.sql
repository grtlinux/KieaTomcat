USE SPRING;

CREATE TABLE IF NOT EXISTS USER_ACCOUNT(
	USER_ID VARCHAR(20),
	USER_NAME VARCHAR(20) CHARACTER SET utf8,
	PASSWORD VARCHAR(20),
	POSTCODE VARCHAR(8),
	ADDRESS VARCHAR(50) CHARACTER SET utf8,
	EMAIL VARCHAR(50),
	JOB VARCHAR(30) CHARACTER SET utf8,
    BIRTHDAY DATE,
	PRIMARY KEY (USER_ID)
);

CREATE TABLE IF NOT EXISTS ITEM(
	ITEM_ID INTEGER(5) AUTO_INCREMENT,
	ITEM_NAME VARCHAR(20) CHARACTER SET utf8,
	PRICE INTEGER(6),
	DESCRIPTION VARCHAR(50) CHARACTER SET utf8,
	PICTURE_URL VARCHAR(20),
	PRIMARY KEY (ITEM_ID)
);

CREATE TABLE IF NOT EXISTS SALE(
	SALE_ID INTEGER(10),
	USER_ID VARCHAR(20),
	UPDATE_TIME TIMESTAMP,
	PRIMARY KEY (SALE_ID,USER_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER_ACCOUNT (USER_ID) 
);

CREATE TABLE IF NOT EXISTS SALE_LINE(
	SALE_ID INTEGER(10),
	SALE_LINE_ID INTEGER(3),
	ITEM_ID INTEGER(5),
	QUANTITY INTEGER(1),
	UPDATE_TIME TIMESTAMP,
	PRIMARY KEY (SALE_ID,SALE_LINE_ID),
	FOREIGN KEY (SALE_ID) REFERENCES SALE (SALE_ID),
	FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ITEM_ID)	
);

DELETE FROM ITEM;
LOAD DATA LOCAL INFILE 'item.csv' 
INTO TABLE ITEM 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

DELETE FROM USER_ACCOUNT;
LOAD DATA LOCAL INFILE 'user.csv' 
INTO TABLE USER_ACCOUNT 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';
QUIT
