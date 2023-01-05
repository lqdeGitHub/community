##社区

##资料
[Spring 文档](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[es 社区](https://elasticsearch.cn/explore)
[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
[GitHub OAuth](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)
[h2](https://h2database.com/html/main.html)
[Mybatis](https://mybatis.org/generator/index.html)
[](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-error-handling)
##工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[flyway](https://flywaydb.org/documentation/usage/maven/)
[lombok](https://www.projectlombok.org)
[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)

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
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

git init
