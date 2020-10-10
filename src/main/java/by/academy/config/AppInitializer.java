package by.academy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class AppInitializer implements ServletContainerInitializer {
    private static final Logger logger = LoggerFactory.getLogger(AppInitializer.class);

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) {

        logger.info("Call onStartup");
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();

        logger.info("----------------------5----------------------");

        context.register(ApplicationConfiguration.class);

        logger.info("----------------------4----------------------");

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        logger.info("----------------------3----------------------");

        final ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.addMapping("/");

        logger.info("----------------------2----------------------");

        dispatcher.setLoadOnStartup(1);

        logger.info("----------------------1----------------------");
    }


}
