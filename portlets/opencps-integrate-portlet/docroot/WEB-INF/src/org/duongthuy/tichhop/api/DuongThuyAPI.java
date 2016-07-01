package org.duongthuy.tichhop.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.duongthuy.tichhop.util.RESTfulUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;

@Path("/dossier")
public class DuongThuyAPI {

	final static String dossier_by_oid = PortletProps.get("DOSSIER_BY_OID_URL");
	
	@GET
	@Path("/declaration/messagefunction/{messagefunction}/messageid/{messageid}")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response getNewDossier(@NotNull @PathParam("messagefunction") String messagefunction,
			 @PathParam("messageid") String messageid) {
		
		_log.info("************** messagefunction: "+messagefunction);
		_log.info("************** messageid: "+messageid);
		//(\\w+)
		String url = dossier_by_oid.replaceAll("PARAM_OID", messageid);
		_log.info("************** url: "+url);
		String output = RESTfulUtils.responseGETAPI(url);
 
		return Response.status(200).entity(output).build();
 
	}
	
	private static Log _log = LogFactoryUtil.getLog(DuongThuyAPI.class);
}
