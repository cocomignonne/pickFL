CREATE TABLE MEMBER(
MEMBER_NO NUMBER NOT NULL PRIMARY KEY,
MEMBER_ID VARCHAR2(15) NOT NULL UNIQUE,
MEMBER_PWD VARCHAR2(30) NOT NULL,
MEMBER_NAME VARCHAR2(20) NOT NULL,
MEMBER_EMAIL VARCHAR2(30) NOT NULL,
MEMBER_BIRTH  VARCHAR2(20) NOT NULL,
MEMBER_JOIN_DATE TIMESTAMP,
MEMBER_ROLE CHAR(1) DEFAULT 'C' CHECK(MEMBER_ROLE IN ('C','A')),
MEMBER_QUIT_YN CHAR(1) DEFAULT 'N' CHECK(MEMBER_QUIT_YN IN ('Y','N'))
);

CREATE TABLE PRODUCT (
    PRODUCT_NO     NUMBER PRIMARY KEY,
    PRODUCT_NAME   VARCHAR2(50) NOT NULL UNIQUE,
    PRODUCT_PRICE  NUMBER NOT NULL,
    PRODUCT_STOCK  NUMBER NOT NULL,
    PRODUCT_IMAGE  VARCHAR2(200) NOT NULL,
    PRODUCT_COLOR  VARCHAR2(50),
    FLOWER_LANG    VARCHAR2(50),
    PRODUCT_SIMPLE VARCHAR2(50),
    PRODUCT_DETAIL VARCHAR2(200),
    PRODUCT_SIZE   CHAR(1) DEFAULT 'M' CHECK ( PRODUCT_SIZE IN ( 'S', 'M', 'L' ) ),
    DISCOUNT_RATE  NUMBER,
    SALE_STATUS    CHAR(1) DEFAULT 'Y' CHECK ( SALE_STATUS IN ( 'Y', 'N' ) )
);

CREATE TABLE QUESTION (
    Q_NO     NUMBER PRIMARY KEY UNIQUE,
    MEMBER_NO NUMBER NOT NULL UNIQUE,
    Q_TITLE  VARCHAR2(200) NOT NULL,
    Q_CONTENT   VARCHAR2(3000) NOT NULL,
    Q_CREAT  TIMESTAMP,
    Q_RESPONSE CHAR(1) DEFAULT 'N' CHECK(Q_RESPONSE IN ('Y','N')),
    Q_DELETED  CHAR(1) DEFAULT 'N' CHECK(Q_DELETED IN ('Y','N'))
);

CREATE TABLE QUESTION_RESPONSE(
    R_NO    NUMBER PRIMARY KEY  UNIQUE,
    Q_NO    NUMBER NOT NULL UNIQUE,
    MEMBER_NO NUMBER NOT NULL,
    ADMIN_NO    NUMBER NOT NULL,
    R_CONTENT   VARCHAR2(3000) NOT NULL,
    R_CREATE    TIMESTAMP,
    R_DELETED CHAR(1) DEFAULT 'N' CHECK(R_DELETED IN ('Y','N'))
);


CREATE SEQUENCE SEQ_MEMBER NOCYCLE NOCACHE;

CREATE SEQUENCE SEQ_PRODUCT NOCYCLE NOCACHE;

CREATE SEQUENCE SEQ_QUESTION NOCYCLE NOCACHE;

CREATE SEQUENCE SEQ_QUESTION_RESPONSE NOCYCLE NOCACHE;

SELECT * FROM MEMBER;

DROP TABLE MEMBER;

DROP SEQUENCE SEQ_MEMBER;

DELETE FROM MEMBER WHERE MEMBER_ID = 'admin1';

DROP TABLE PRODUCT CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_PRODUCT;

DROP TABLE QUESTION CASCADE CONSTRAINTS;

DROP TABLE QUESTION_RESPONSE CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_QUESTION;

DROP SEQUENCE SEQ_QUESTION_RESPONSE;



insert into member values(1, 'os2864', 'ws2864', '황인준', 'os2864@naver.com', '970514', sysdate, 'A', 'N');
insert into member values(2, 'ws2864', 'os2864', '황인준2', 'os2864@naver.com', '970514', sysdate, 'A', 'N');

