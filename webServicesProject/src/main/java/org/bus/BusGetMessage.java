package org.bus;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class BusGetMessage extends AbstractSoapInterceptor {

    public BusGetMessage() {
        super(Phase.INVOKE);
    }

    public void handleMessage(SoapMessage message) throws Fault {
    	
    	MessageContentsList list = MessageContentsList.getContentsList ( message );
    	 System.out.println("+++++++++++++++++++++++++++++++++++++");
    	for(Object o:list)
    		System.out.println(o);
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        HttpServletRequest httprequest = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);  
        System.out.println(httprequest.getRemoteAddr());  
        System.out.println();
        list.set(0, "3");
        message.setContent(MessageContentsList.class, list);
    }
	

}
