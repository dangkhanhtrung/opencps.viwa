package org.duongthuy.tichhop.util;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

public class RESTfulUtils {

	final static String portalURL = PortletProps.get("PORTAL_URL");
	public static String responseGETAPI(String urlAPI){
		String result = StringPool.BLANK;
		
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin.qa@fds.vn", "fds@2016");
		 
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );

		client.register(feature);
		 
		WebTarget webTarget = client.target(portalURL + urlAPI);
		
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		
		result = response.readEntity(String.class);
		
		return Validator.isNotNull(result)?result:"{}";
	}
	
	public static String responsePOSTAPI(String urlAPI, String input){
		String result = StringPool.BLANK;
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		
		WebTarget webTarget = client.target(portalURL + urlAPI);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(input, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		result = response.readEntity(String.class);
		
		return Validator.isNotNull(result)?result:"{}";
	}
	
	private static Log _log = LogFactoryUtil.getLog(RESTfulUtils.class);
}
