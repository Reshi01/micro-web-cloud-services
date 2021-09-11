package co.edu.javeriana.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.util.HttpStatus;

@Path("paseos/")
public class Controllers {
	
	@Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Paseo> getAllPaseos() {
		Repository repository= new Repository();
    	List<Paseo> paseos=repository.getAllPaseo();
        return paseos;
    }
	
	@Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public HttpStatus addPaseo(Paseo paseo) {
		Repository repository= new Repository();
		if(repository.addPaseo(paseo)) {
			return HttpStatus.CREATED_201;
		}
		return HttpStatus.CONFLICT_409;
    }
	
	@Path("modify")
    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Paseo modifyPaseo(@QueryParam("id") String id,
    		@QueryParam("name") String name,
    		@QueryParam("startLocation") String startLocation,
    		@QueryParam("endLocation") String endLocation) {
		Repository repository= new Repository();
		Paseo paseo=repository.modifyPaseo(id, name, startLocation, endLocation);
		if(paseo!=null) {
			return paseo;
		}
		return null;
    }
    
    @Path("delete")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public HttpStatus deletePaseo(@QueryParam("id") String id) {
    	Repository repository= new Repository();
    	if(repository.deletPaseo(id)) {
    		return HttpStatus.OK_200;
    	}
        return HttpStatus.INTERNAL_SERVER_ERROR_500;
    }
}
