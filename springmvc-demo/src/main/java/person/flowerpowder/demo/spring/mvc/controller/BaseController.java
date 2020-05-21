package person.flowerpowder.demo.spring.mvc.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * Basic controller for all the actions
 * 
 *
 *
 */
@Controller
public class BaseController implements Serializable {


	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	
	/**
	 * Return a generic variable from the session
	 * 
	 * @param httpRequest
	 * @param key
	 * @return
	 */
	public Object getVarFromSession(HttpServletRequest httpRequest, String key) {
		//Check if session is up
		return (httpRequest != null && httpRequest.getSession() != null)
			? httpRequest.getSession().getAttribute(key) : null;
	}
	
	/**
	 * Set a generic variable in the session
	 * 
	 * @param httpRequest
	 * @param key
	 * @param value
	 * @return
	 */
	public Boolean setVarInSession(HttpServletRequest httpRequest, String key, Object value) {
		if(httpRequest != null) {
			try {
				httpRequest.getSession().setAttribute(key, value);
				return true;
			} catch(Exception e) {
				logger.error("Error registering " + key + " in session " + value);
				return false;
			}
		} else {
			logger.error("Error registering " + key + " in session: session is null");
			return false;
		}
	}
	
}