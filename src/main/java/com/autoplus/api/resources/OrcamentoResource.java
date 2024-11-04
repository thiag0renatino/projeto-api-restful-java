package com.autoplus.api.resources;

import java.sql.SQLException;

import com.autoplus.api.model.bo.OrcamentoBO;
import com.autoplus.api.model.vo.Orcamento;

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

@Path("/orcamentos")
public class OrcamentoResource {
	
	private OrcamentoBO orcamentoBO = new OrcamentoBO();
	
	@POST
	@Path("/orcamento")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Orcamento orcamento, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		orcamentoBO.inserirBO(orcamento);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(orcamento.getIdOrcamento());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/orcamento/{idOrcamento}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Orcamento orcamento, @PathParam("idOrcamento") String idOrcamento) throws ClassNotFoundException, SQLException {
		orcamentoBO.atualizarBO(orcamento);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/orcamento/{idOrcamento}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idOrcamento") String idOrcamento) throws ClassNotFoundException, SQLException {
		orcamentoBO.deletarBO(idOrcamento);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idOrcamento}")
	@Produces(MediaType.APPLICATION_JSON)
	public Orcamento selecionarRs(@PathParam("idOrcamento") String idOrcamento) throws ClassNotFoundException, SQLException {
		return orcamentoBO.buscarBO(idOrcamento);
	}

}
