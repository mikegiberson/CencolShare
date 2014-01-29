package com.cencolshare.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component("CORSFilter")
@Profile("web")
public class CorsFilter extends OncePerRequestFilter {
  public CorsFilter() {
    // empty
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    //log.debug("Processing CORS request for {}", request.getRequestURI());
    response.addHeader("Access-Control-Allow-Origin", "*");

    if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
      // CORS "pre-flight" request
      //log.debug("Procerssing CORS pre-flight request.");
      response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
      response.addHeader("Access-Control-Allow-Headers", "Content-Type, x-unifyi-session-id");
      response.addHeader("Access-Control-Max-Age", "604800");
    }
    filterChain.doFilter(request, response);
  }
}
