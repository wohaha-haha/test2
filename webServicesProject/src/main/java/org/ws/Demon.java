package org.ws;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Demon {

	@WebMethod
	public String hello(String req)
	{
		return req+"=";
	}
}
