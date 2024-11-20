package net.consulbit.academy.config;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Configura AppConfig.class come RootConfirationClasses, il quale
     * diventerà l'ApplicationContext genitore che contiene le definizioni dei beans
     * condivise da tutti i contesti figli (DispatcherServlet).
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    /**
     * Configura WebMvcConfig.class come ServletConfigClasses, ovvero
     * lApplicationContext figlio che contiene le definizioni di beans WebMvc.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    /**
     * Configura / come ServletMapping, il che significa che tutte le richieste
     * saranno gestite da DispatcherServlet.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * Registra OpenEntityManagerInViewFilter come filtro servlet, in questo modo
     * è possibile eseguire il caricamento lazy delle collections lazt dell'entità JPA durante il rendering
     * della vista.
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{ new OpenEntityManagerInViewFilter() };
    }
}
