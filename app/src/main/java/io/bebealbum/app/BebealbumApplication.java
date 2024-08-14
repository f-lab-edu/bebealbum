package io.bebealbum.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BebealbumApplication {

    private static final Logger logger = LoggerFactory.getLogger(BebealbumApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(BebealbumApplication.class, args);
        logger.info("asdfasdfasdfasdfasdfasdf");
    }
}
