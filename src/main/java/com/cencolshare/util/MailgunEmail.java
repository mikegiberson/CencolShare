package com.cencolshare.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.cencolshare.model.Email;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Slf4j
@Component
public class MailgunEmail {

	InputStream in;
	private Properties configProp = new Properties();
	
	private static String API_KEY = null;
	private static String URL = null;
	private static String ADMIN_EMAIL = null;
	
	public MailgunEmail() throws IOException {
		// load data from email properties file:
		log.debug("Reading email properties and loading email class");
		in = this.getClass().getClassLoader().getResourceAsStream("email.properties");
		configProp.load(in);
		
		API_KEY = configProp.getProperty("apikey");
		URL = configProp.getProperty("url");
		ADMIN_EMAIL = configProp.getProperty("adminemail");
	
	}

	public ClientResponse sendEmail(final Email email) {
		
		log.debug("In email class");
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", API_KEY));
		WebResource webResource = client.resource(URL);
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		
		formData.add("from", ADMIN_EMAIL);
	    formData.add("to", email.getTo());
	    formData.add("subject", email.getSubject());
	    formData.add("html", email.getContent());
	    log.debug("sending email {} to {}" + email.getSubject(), email.getTo());
	    
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
		
	}	
	


}
