package com.autoplus.api.resources;

import java.sql.SQLException;

import com.autoplus.api.model.bo.ProdutoBO;
import com.autoplus.api.model.vo.Produto;

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


@Path("/produtos")
public class ProdutoResource {
	
	private ProdutoBO produtoBO = new ProdutoBO();
	
	@POST
	@Path("/produto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Produto produto, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		produtoBO.inserirBO(produto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(produto.getIdProduto());
		return Response.created(builder.build()).build(); 
	}
	
	@PUT
	@Path("/produto/{idProduto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Produto produto, @PathParam("idProduto") String idProduto) throws ClassNotFoundException, SQLException {
		produtoBO.atualizarBO(produto);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/produto/{idProduto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idProduto") String idProduto) throws ClassNotFoundException, SQLException {
		produtoBO.deletarBO(idProduto);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{idProduto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto selecionarRs(@PathParam("idProduto") String idProduto) throws ClassNotFoundException, SQLException{
		return produtoBO.buscarBO(idProduto);
	}

}
