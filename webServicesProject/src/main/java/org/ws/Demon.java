package org.ws;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.mb.MyMb;

@WebService
public class Demon {

	private MyMb mb;
	@WebMethod
	public String hello(String req)
	{
		mb.setName(req);
		
		return req+mb.show();
	}
	public MyMb getMb() {
		return mb;
	}
	public void setMb(MyMb mb) {
		this.mb = mb;
	}
	
}
