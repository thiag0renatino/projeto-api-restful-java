package com.autoplus.api.resources;

import java.sql.SQLException;

import com.autoplus.api.model.bo.ServicoBO;
import com.autoplus.api.model.vo.Servico;

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

@Path("/servicos")
public class ServicoResource {

	private ServicoBO servicoBO = new ServicoBO();
	
	@POST
	@Path("/servico")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Servico servico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		servicoBO.inserirBO(servico);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(servico.getIdServico());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/servico/{idServico}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Servico servico, @PathParam("idServico") String idServico) throws ClassNotFoundException, SQLException {
		servicoBO.atualizarBO(servico);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/servico/{idServico}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idServico") String idServico) throws ClassNotFoundException, SQLException {
		servicoBO.deletarBO(idServico);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idServico}")
	@Produces(MediaType.APPLICATION_JSON)
	public Servico selecionarRs(@PathParam("idServico") String idServico) throws ClassNotFoundException, SQLException{
		return servicoBO.buscarBO(idServico);
	}
	
}
