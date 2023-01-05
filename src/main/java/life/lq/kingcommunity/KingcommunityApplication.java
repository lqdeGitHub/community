package life.lq.kingcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "life.lq.kingcommunity.mapper")
public class KingcommunityApplication {

    public static void main(String[] args) {

        SpringApplication.run(KingcommunityApplication.class, args);
    }

}
