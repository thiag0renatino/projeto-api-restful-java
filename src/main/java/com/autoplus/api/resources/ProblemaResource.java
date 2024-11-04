package com.autoplus.api.resources;

import java.sql.SQLException;

import com.autoplus.api.model.bo.ProblemaBO;
import com.autoplus.api.model.vo.Problema;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/problemas")
public class ProblemaResource {
	
	private ProblemaBO problemaBO = new ProblemaBO();
	
	@POST
	@Path("/problema")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Problema problema, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		problemaBO.inserirBO(problema);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(problema.getIdProbl());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/problema/{idProbl}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Problema problema, @PathParam("idProbl") String idProbl) throws ClassNotFoundException, SQLException {
		problemaBO.atualizarBO(problema);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/problema/{idProbl}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idProbl") String idProbl) throws ClassNotFoundException, SQLException {
		problemaBO.deletarBO(idProbl);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idProbl}")
	@Produces(MediaType.APPLICATION_JSON)
	public Problema selecionarRs(@PathParam("idProbl") String idProbl) throws ClassNotFoundException, SQLException{
		return problemaBO.buscarBO(idProbl);
	}
	

}
