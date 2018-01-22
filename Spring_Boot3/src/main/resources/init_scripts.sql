DROP TABLE IF EXISTS ACCOUNT;
create TABLE IF NOT EXISTS ACCOUNT(
      ACCOUNT_NAME VARCHAR (255) NOT NULL,
      PASSWORD VARCHAR (255) NOT NULL,
      ID SERIAL,
      ENABLED BOOL DEFAULT TRUE 
);
DROP TABLE IF EXISTS ENTRY;
CREATE TABLE ENTRY (
       ID BIGSERIAL PRIMARY KEY,
       CREATED TIMESTAMP DEFAULT NULL,
       SUMMARY VARCHAR (255) DEFAULT NULL,
       TITLE VARCHAR (255) DEFAULT NULL
       

);

-- USERS IN JOURNAL

INSERT INTO ACCOUNT(account_name, password) VALUES('springboot','isawesome');
INSERT INTO ACCOUNT(account_name, password) VALUES('springsecurity','isawesometoo');

-- JOURNAL DATA
INSERT INTO ENTRY(title,summary,created) VALUES('Get to know Spring Boot','Today I will
learn Spring Boot','2016-01-02 00:00:00.00');
INSERT INTO ENTRY(title,summary,created) VALUES('Simple Spring Boot Project','I will do my
first Spring Boot project','2016-01-03 00:00:00.00');
INSERT INTO ENTRY(title,summary,created) VALUES('Spring Boot Reading','Read more about
Spring Boot','2016-02-02 00:00:00.00');
INSERT INTO ENTRY(title,summary,created) VALUES('Spring Boot in the Cloud','Learn Spring
Boot using Cloud Foundry','2016-02-05 00:00:00.00');