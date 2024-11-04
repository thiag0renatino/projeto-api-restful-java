package com.autoplus.api.resources;


import java.sql.SQLException;
import java.util.ArrayList;

import com.autoplus.api.model.bo.OficinaBO;
import com.autoplus.api.model.vo.Oficina;

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

@Path("/oficinas")
public class OficinaResources {

	private OficinaBO oficinaBO = new OficinaBO();
	
	@POST
	@Path("/oficina")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Oficina oficina, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		oficinaBO.inserirBO(oficina);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(oficina.getIdCredencial());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/oficina/{idCredencial}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Oficina oficina, @PathParam("idCredencial") String idCredencial) throws ClassNotFoundException, SQLException {
		oficinaBO.atualizarBO(oficina);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/oficina/{idCredencial}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idCredencial") String idCredencial) throws ClassNotFoundException, SQLException {
		oficinaBO.deletarBO(idCredencial);
		return Response.ok().build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Oficina> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<Oficina>) oficinaBO.buscarBO();
	}
	
}
