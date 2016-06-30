package org.duongthuy.tichhop.util;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTfulUtils {

	private static String responseGETAPI(String urlAPI){
		String result = StringPool.BLANK;
		
		Client client = Client.create();

		WebResource webResource = client.resource(urlAPI);
		
		ClientResponse response = webResource.accept("application/json")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		result = response.getEntity(String.class);
		
		_log.info("responseGETAPI "+ result);
		
		return Validator.isNotNull(result)?result:"{}";
	}
	
	private static String responsePOSTAPI(String urlAPI, String input){
		String result = StringPool.BLANK;
		
		Client client = Client.create();

		WebResource webResource = client.resource(urlAPI);
		
		ClientResponse response = webResource.type("application/json")
				.post(ClientResponse.class, input);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		result = response.getEntity(String.class);
		
		_log.info("responsePOSTAPI "+ result);
		
		return Validator.isNotNull(result)?result:"{}";
	}
	
	private static Log _log = LogFactoryUtil.getLog(RESTfulUtils.class);
}
