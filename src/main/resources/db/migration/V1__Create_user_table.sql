create table USER
(
    ID           INTEGER auto_increment primary KEY NOT NULL,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        VARCHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT
);