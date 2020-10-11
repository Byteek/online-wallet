package by.academy.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
@ComponentScan("by.academy")
@EnableAspectJAutoProxy
@EnableJpaRepositories("by.academy.repository")
@EnableTransactionManagement
@EnableWebSecurity
@EnableWebMvc
public class ApplicationConfiguration implements WebMvcConfigurer {


    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://ec2-54-195-247-108.eu-west-1.compute.amazonaws.com:5432/df75ag0ful563i?sslmode=require");
        dataSource.setUsername("uiqkovfbpcfoid");
        dataSource.setPassword("4b19ae0042ce2a63957335ca8e36ab95973b37564ffaa50b02c6dc66fea4993b");
        dataSource.setDriverClassName("com.post.cj.jdbc.Driver");
        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("show_sql", "true");
        properties.setProperty("generate-ddl", "false");
        properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");
        properties.setProperty("hibernate.naming.implicit-strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
        properties.setProperty("hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");

        return properties;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setPackagesToScan("by.academy.entity");
        entityManagerFactory.setDataSource(dataSource());
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws URISyntaxException {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setDataSource(dataSource());
        txManager.setJpaProperties(getHibernateProperties());
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}






