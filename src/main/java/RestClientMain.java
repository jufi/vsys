import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by jufi on 07.01.14.
 */
@Path("resources")
public class RestClientMain {

	private static HashMap<String, String> resourcesById = new HashMap<String, String>();

	public RestClientMain() {
		resourcesById.put("Test1", "Testiusadfh1");
		resourcesById.put("Test2", "Testsldacnsaonasdkc2");
		resourcesById.put("otherTest", "Testsldacnsaonasdkc2");
		for (Map.Entry<String, String> entry : resourcesById.entrySet()) {
			addResource(entry.getKey(), entry.getValue());
		}
	}

	@GET
	public String getResources() {
		List<String> resourcesIds = new ArrayList<String>();
		resourcesIds.addAll(resourcesById.keySet());
		StringBuilder sb = new StringBuilder();
		for (String string : resourcesIds) {
			sb.append("ID: " + string);
			sb.append("\n");
		}
		return sb.toString();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@PathParam("{id}") String id) {
		return resourcesById.get(id);
	}

	@POST
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response addResource(@PathParam("{id}") String id, String text) {
		String msg = "ID: " + id + "Text : " + text;
		return Response.status(200).entity(msg).build();
	}
//	@PUT
//	@Path("{text}")
//	@Consumes(MediaType.TEXT_PLAIN)
//	@Produces(MediaType.TEXT_PLAIN)
//	public static String put() {
//	}
}
