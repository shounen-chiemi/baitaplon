package test.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import test.springweb.entity2.repository.*;
import test.springweb.entity2.*;
import test.springweb.entity2.thanhvien;
import test.springweb.service.thanhvienService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class SpringwebApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringwebApplication.class, args);
    }

}
