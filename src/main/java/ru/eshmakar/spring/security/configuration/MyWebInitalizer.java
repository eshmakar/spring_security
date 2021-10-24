package ru.eshmakar.spring.security.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer { //для регистрации DispatcherServlet и использования конфигурации Spring на основе Java
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};//будет использоваться наш класс
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
