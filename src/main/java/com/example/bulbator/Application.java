package com.example.bulbator;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
//@EnableAutoConfiguration(exclude={WebMvcAutoConfiguration.class, DispatcherServletAutoConfiguration.class })
@EnableAutoConfiguration
@ComponentScan
public class Application implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
                new ConfigureListener());
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }

//    @Bean
//    public ServletContextInitializer servletContextInitializer() {
//
//        return sc -> {
//            sc.addListener(com.sun.faces.config.ConfigureListener.class);
//            sc.setInitParameter("com.sun.faces.expressionFactory", "com.sun.el.ExpressionFactoryImpl");
//            sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
//            sc.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString());
//            sc.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
//            sc.setInitParameter("javax.faces.FACELETS_LIBRARIES", "springsecurity.taglib.xml");
//            sc.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
//            sc.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
//            sc.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString());
//            sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
//            sc.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
//            sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
//            sc.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
//            sc.setInitParameter("primefaces.THEME", "Omega");
//        };
//    }
}