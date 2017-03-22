package com.charlieaffs.rest.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.tradeit.dao.ApiKeyDao;
import com.charlieaffs.data.tradeit.model.ApiKey;
import com.charlieaffs.ifs.logging.TILogger;

@Component
public class AuthenticationFilter implements Filter {

	public final static String HEADER_AUTHORIZATION = "Authorization";

	@Autowired
	private ApiKeyDao apiKeyDao;
	
	public void init(FilterConfig filterConfig) throws ServletException { }

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if(req instanceof HttpServletRequest) {
			HttpServletRequest httpReq = (HttpServletRequest) req;	
			String key = httpReq.getHeader(HEADER_AUTHORIZATION);
			TILogger.getLog().info("Authenticating request with key(" + key + ") for ip: " + httpReq.getRemoteAddr());
			
			boolean error = true;
			if(key != null) {
				ApiKey apiKey = apiKeyDao.authenticate(key);
				if(apiKey != null) {
					error = false;
					TILogger.getLog().debug("Succesfully authenticated " + apiKey.getDescription());
				}
			}
			
			if(error) {
				HttpServletResponse httpResp = (HttpServletResponse) resp;
				TILogger.getLog().warn("Aborting request, authentication key is either wrong or does not exist");
				httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication key is either wrong or does not exist...");
				return;
			}
		}
		
		chain.doFilter(req, resp);
	}

	public void destroy() {	}
	
}
