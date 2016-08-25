package com.killyz.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class ApiInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String LOCATION = "C:\\killdb\\warehouse\\temp";
    private static final long MAX_FILE_SIZE = 5242880;
    private static final long MAX_REQUEST_SIZE = 20971520;
    private static final int FILE_SIZE_THRESHOLD = 0;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ApiConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new ApiCORSFilter()};
    }

    private MultipartConfigElement getMultipartConfigElement() {
        return new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }

}
