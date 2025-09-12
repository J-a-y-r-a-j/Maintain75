package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Spring {
    public static void main(String[] args) throws SQLException {
        Main m1 = new Main();

        SpringApplication.run(Spring.class, args);
    }
}
