import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
//        addResource("1", "Testiusadfh1");
//        addResource("2", "Testsldacnsaonasdkc2");
//        addResource("3");
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
    public String get(@PathParam("id") String id) {
        System.out.println("");
        return resourcesById.get(id);
    }

    @POST
    @Path("{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addResource(@PathParam("id") String id) {
        System.out.println("AddResource");
        String msg = "ID: " + id + " Text : " ;
        resourcesById.put(id, id);
        return Response.status(200).entity(msg).build();
    }

}