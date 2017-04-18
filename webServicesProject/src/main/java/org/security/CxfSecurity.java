package org.security;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback; 


public class CxfSecurity  implements CallbackHandler {     
	public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {  
	        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];  
	        String identifier = pc.getIdentifier();  
	        String password = pc.getPassword();  
	        System.out.println("identifier = " + identifier);  
            System.out.println("password = " + password);  
	        if ("admin".equals(identifier)) {  
	        	pc.setPassword("88888888");
	            System.out.println("验证通过！");  
	            System.out.println("identifier = " + identifier);  
	            System.out.println("password = " + password);  
	        } else {  
	            throw new SecurityException("验证失败");  
	        }  
	    }  
	}  