package com.cencolshare.init;

import javax.annotation.PreDestroy;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextCleanupListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.cencolshare.security.SecurityConfig;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	private AnnotationConfigWebApplicationContext ctx = null;

	public void onStartup(ServletContext servletContext)
			throws ServletException {
	    
		SLF4JBridgeHandler.removeHandlersForRootLogger();
	    SLF4JBridgeHandler.install();
	    
		ctx = new AnnotationConfigWebApplicationContext();
		//ctx.register(StandaloneEnvConfig.class);
		//ctx.register(StandaloneTestEnvConfig.class);
		ctx.register(WebAppConfig.class);
		ctx.register(SecurityConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(ctx));
		servletContext.addListener(new ContextCleanupListener());

		ctx.setServletContext(servletContext);		
		//configureSpringSecurity(servletContext, ctx);

		log.debug("application starting up");
		System.setProperty("spring.profiles.active", "web");

		Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
				new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true);
		
		servletContext.addFilter("CORSFilter", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, true, "/*");
		
		log.debug("application started");
	}

    private void configureSpringSecurity(ServletContext servletContext, WebApplicationContext rootContext) {
        FilterRegistration.Dynamic springSecurity = servletContext.addFilter("springSecurityFilterChain",
            new DelegatingFilterProxy("springSecurityFilterChain", rootContext));
        springSecurity.addMappingForUrlPatterns(null, true, "/*");
      }
    
	  @PreDestroy
	  protected final void cleanup() {
	    if (ctx != null) {
	      ctx.close();
	    }
	  }
}
