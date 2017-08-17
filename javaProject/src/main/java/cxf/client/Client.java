package cxf.client;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //服务的地址
        URL wsUrl = new URL("http://rams.travelsky.com/bdservice-analysis/services/analysis/futAraeIncomeWsService?app_key=nrise&from_airline=SC");
        
        HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();
        
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        
        OutputStream os = conn.getOutputStream();
        
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
       // If you are parsing the date using SimpleDateFormat, you might want to set the time zone to UTC (Zulu time).
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String created = formatter.format(currentTime);
        String id = String.valueOf(System.currentTimeMillis());
        String passwd="Des?Eg+7eb2d";
        String nonce=calculateNonce();
        //请求体
        String soap = "<soapenv:Envelope xmlns:api=\"http://api.analysis.bdservice.re.adap.travelsky.com/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
        		"   <soapenv:Header>"
        		+ "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"
        		+ "<wsse:UsernameToken wsu:Id=\"UsernameToken-"+id+"\">"
        		+ "<wsse:Username>SCuserqwmn</wsse:Username>"
        		+ "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Des?Eg+7eb2d</wsse:Password>"
        		+ "<wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+nonce+"</wsse:Nonce>"
        		+ "<wsu:Created>"+created+"</wsu:Created>"
        		+ "</wsse:UsernameToken>"
        		+ "</wsse:Security>"
        		+ "</soapenv:Header>\r\n" + 
        		"   <soapenv:Body>\r\n" + 
        		"      <api:queryFutAreaIncome>\r\n" + 
        		"         <!--Optional:-->\r\n" + 
        		"         <arg0>{\"area\":\"0AS\",\"dpt_tm_rang\":\"0023\",\"fltEndDate\":\"201708010\",\"fltStartDate\":\"201708010\",\"oi_type\":\"A\" }</arg0>\r\n" + 
        		"      </api:queryFutAreaIncome>\r\n" + 
        		"   </soapenv:Body>\r\n" + 
        		"</soapenv:Envelope>";
        System.out.println(soap);
        os.write(soap.getBytes());
        
        InputStream is = conn.getInputStream();
        
        byte[] b = new byte[1024];
        int len = 0;
        String s = "";
        while((len = is.read(b)) != -1){
            String ss = new String(b,0,len,"UTF-8");
            s += ss;
        }
        System.out.println(s);
        
        is.close();
        os.close();
        conn.disconnect();
	}

	private static String calculateNonce() throws Exception {
		  UUID uuid = UUID.randomUUID();  
	        String str = uuid.toString();  
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] digest = md.digest((str ).getBytes());// 对接后的字符串进行sha1加密
        byte[] b = Base64.encodeBase64(digest);
       return new String(b);
    }
	private static String calculatePasswordDigest(String nonce ,String created, String password) throws Exception {
		//org.apache.wss4j.dom.message.token.UsernameToken.doPasswordDigest(String, String, byte[])
		String passwdDigest = null;
        try {
            byte[] b1 = nonce != null ?Base64.encodeBase64(nonce.getBytes()) : new byte[0];
            byte[] b2 = created != null ? created.getBytes("UTF-8") : new byte[0];
            byte[] b3 = password.getBytes();
            byte[] b4 = new byte[b1.length + b2.length + b3.length];
            int offset = 0;
            System.arraycopy(b1, 0, b4, offset, b1.length);
            offset += b1.length;
            
            System.arraycopy(b2, 0, b4, offset, b2.length);
            offset += b2.length;

            System.arraycopy(b3, 0, b4, offset, b3.length);
            MessageDigest md = MessageDigest.getInstance("SHA-1");
    		byte[] digestBytes = md.digest(b4);// 对接后的字符串进行sha1加密
//            byte[] digestBytes = WSSecurityUtil.generateDigest(b4);
            passwdDigest = new String(Base64.encodeBase64(digestBytes));
        } catch (Exception e) {
//            if (DO_DEBUG) {
//                LOG.debug(e.getMessage(), e);
//            }
        }
        return passwdDigest;
    }
}
