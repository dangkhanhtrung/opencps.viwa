package org.duongthuy.tichhop.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.duongthuy.tichhop.util.RESTfulUtils;

@Path("/dossier")
public class DuongThuyAPI {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String urlAPI) {
		
		String url = "dictitem/get-dictitems-by-parentId/parent-item-id/0";
		String output = RESTfulUtils.responseGETAPI(url);
 
		return Response.status(200).entity(output).build();
 
	}
}
