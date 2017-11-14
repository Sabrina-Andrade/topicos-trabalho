package br.edu.univas.si8.ta.trab.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/data")
public interface ClientService {

	@GET
	@Path("/clientes/nomes")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listClientesNomes();

	@POST
	@Path("/cliente/{name}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	String saveNewClientes(@PathParam("name") String name, @PathParam("email") String email);
}
