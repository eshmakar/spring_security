package ru.eshmakar.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity // эта аннотация уже содержить аннотацию @Configuration, поэтому написать еще раз нет смысла
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {//перезаписываем только этот метод
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();// UserBuilder - Создает добавляемого пользователя. withDefaultPasswordEncoder() - Создает пользователя и автоматически кодирует предоставленный пароль с помощью PasswordEncoderFactories.createDelegatingPasswordEncoder()

        auth.inMemoryAuthentication()//данные юзеров и паролей будут хранятся в памяти
                .withUser(userBuilder.username("zaur").password("zaur").roles("EMPLOYEE"))
                .withUser(userBuilder.username("elena").password("elena").roles("HR"))
                .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER", "HR"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//ограничиваем доступ
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER") // ссылку по умолчанию / могут видеть все
                .antMatchers("/hr_info").hasRole("HR") // эту ссылку /hr_info могут видеть только юзеры типа HR
                .antMatchers("/manager_info").hasRole("MANAGER")//а эту только MANAGER
                .and().formLogin().permitAll();//заканчиваем настройку прав доступа
    }
}
