##社区

##资料
[Spring 文档](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[es 社区](https://elasticsearch.cn/explore)
[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
[GitHub OAuth](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)
[h2](https://h2database.com/html/main.html)

##工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[flyway](https://flywaydb.org/documentation/usage/maven/)



##脚本
```sql
create table USER
(
    ID           INTEGER auto_increment primary KEY NOT NULL,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT
);

```
```bash
mvn flyway:migrate
```

git init
