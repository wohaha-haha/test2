package cxf.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {
	public static void main(String args[]) {

		String url = "http://172.27.18.92:8080";
		Map<String, String> headerInfoMap = new HashMap<String, String>();
		headerInfoMap.put("SAT-Appkey", "RevenueEngine");
		headerInfoMap.put("SAT-Action", "bdp.im.chl.carr");
		headerInfoMap.put("SAT-Timestamp", "2000-01-01 00:00:00");
		headerInfoMap.put("SAT-Appkey", "RevenueEngine");
		headerInfoMap.put("Authorization", "Basic cmVhZG1pbjpwYXNzdzByZA==");
		headerInfoMap.put("Content-Type", "application/json");
		String rqStr = "{\"BDPRQ\": {\"-Version\": \"1.0\",\"Query\": {\"dpt_dt\": \"20170704\",\"carr_cd\": \"CA\",\"seg_type\": \"D\",\"chl_cd\": \"I\",\"ofc_cd\": \"PEK112\",\"chl_type\": \"T\"}} }";
		String rs = "";

		try {
//			CredentialsProvider credsProvider = new BasicCredentialsProvider();
//			credsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("readmin", "passw0rd"));
//			
//			
//			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
//			 httpClientBuilder.setDefaultCredentialsProvider(credsProvider);  
//			 CloseableHttpClient httpclient = httpClientBuilder.build();  
			CloseableHttpClient httpclient = HttpClients.createDefault();
//			 CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
			HttpPost httpPost = new HttpPost(url);
//			RequestConfig config =RequestConfig.custom().setAuthenticationEnabled(true).build();
//			httpPost.setConfig(config);
			HttpEntity entity = new StringEntity(rqStr, Consts.UTF_8);
			httpPost.setEntity(entity);
			for (Map.Entry<String, String> entry : headerInfoMap.entrySet()) {
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				rs = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
				HttpEntity responseEntity = response.getEntity();
				EntityUtils.consume(responseEntity);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
				httpclient.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rs);
	}

	public static String sendPost(String url, Map<String, String> headerInfoMap, String rqStr) {

		String rs = "";

		try {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("readmin", "passw0rd"));
			CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig config =RequestConfig.custom().setAuthenticationEnabled(true).build();
			httpPost.setConfig(config);
			HttpEntity entity = new StringEntity(rqStr, Consts.UTF_8);
			httpPost.setEntity(entity);
			for (Map.Entry<String, String> entry : headerInfoMap.entrySet()) {
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				rs = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
				HttpEntity responseEntity = response.getEntity();
				EntityUtils.consume(responseEntity);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
				httpclient.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	private static void initRequest(HttpRequestBase httpRequest, Map<String, String> headerInfoMap) {
		// 初始化header信息
		// if (!CommonUtils.isNull(headerInfoMap)) {
		for (Map.Entry<String, String> entry : headerInfoMap.entrySet()) {
			httpRequest.addHeader(entry.getKey(), entry.getValue());
			// }
		}
//		RequestConfig config =RequestConfig.custom().setAuthenticationEnabled(true).build();
//		httpRequest.setConfig(config);
		// 是否使用代理
		// if (useProxy) {
		// HttpHost proxy = new HttpHost(Proxy_HostName, Proxy_Port, "http");
		// RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		// httpRequest.setConfig(config);
		// }
	
	}

}
