package ru.eshmakar.spring.security.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//вместо web.xml будем использовать конфигурацию из java класса
@Configuration
@ComponentScan(basePackages = "ru.eshmakar.spring.security")
@EnableWebMvc
public class MyConfig {

    @Bean
    public DataSource dataSource() {//Spring будет автоматический соединяться к базу данных
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public ViewResolver viewResolver(){//чтобы использовать jsp страницы для отображения
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");//установка начальной пути для отображения jsp файлов
        internalResourceViewResolver.setSuffix(".jsp");//расширение файла
        return internalResourceViewResolver;
    }

}
