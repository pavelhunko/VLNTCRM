DROP TABLE "DBUSERS"."USERS";
DROP TABLE "DBUSERS"."CONTACTS";
DROP SCHEMA "DBUSERS" RESTRICT;

create schema dbusers;

CREATE TABLE IF NOT EXISTS "DBUSERS"."USERS" (
user_id int(11) NOT NULL AUTO_INCREMENT(1409300, 1) primary key,
email CHAR(40),
    firstName CHAR(40),
    lastName CHAR(40),
password CHAR(40)
);

CREATE TABLE IF NOT EXISTS "DBUSERS"."CONTACTS" (
    id int(11) NOT NULL AUTO_INCREMENT,
    user_id int(11) NOT NULL,
    firstName CHAR(40),
    lastName CHAR(40),
EMAIL CHAR(40),
PHONE CHAR(40),
STREETADDRESS CHAR(40),
COMPANYNAME CHAR(40),
       FOREIGN KEY (USER_ID) REFERENCES "DBUSERS"."USERS"(USER_ID)
);

INSERT INTO "DBUSERS"."USERS" (email, firstname, lastname, password) VALUES ('nicolatesla@nt.com', 'Nicola','Tesla', 'nicolatesla');
INSERT INTO "DBUSERS"."USERS" (email, firstname, lastname, password) VALUES ('adalovelace@al.com', 'Ada','Lovelace', 'adalovelace');