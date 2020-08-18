package cool.lytton.doc;

import cool.lytton.doc.config.CorsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableAutoConfiguration(exclude = {CorsConfig.class})
@SpringBootApplication
@MapperScan("cool.lytton.doc.mapper")
public class DocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocApplication.class, args);
    }

}
