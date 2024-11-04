package com.autoplus.api.resources;

import java.sql.SQLException;

import com.autoplus.api.model.bo.VeiculoBO;
import com.autoplus.api.model.vo.Veiculo;

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

@Path("/veiculos")
public class VeiculoResource {
	
	private VeiculoBO veiculoBO = new VeiculoBO();
	
	@POST
	@Path("/veiculo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Veiculo veiculo, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		veiculoBO.inserirBO(veiculo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(veiculo.getIdPlaca());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/veiculo/{idPlaca}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Veiculo veiculo, @PathParam("idPlaca") String idPlaca) throws ClassNotFoundException, SQLException {
		veiculoBO.atualizarBO(veiculo);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/veiculo/{idPlaca}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idPlaca") String idPlaca) throws ClassNotFoundException, SQLException {
		veiculoBO.deletarBO(idPlaca);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idPlaca}")
	@Produces(MediaType.APPLICATION_JSON)
	public Veiculo selecionarRs(@PathParam("idPlaca") String idplaca) throws ClassNotFoundException, SQLException{
		return veiculoBO.buscarBO(idplaca);		
	}
	
}
