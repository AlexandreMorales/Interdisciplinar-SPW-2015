package br.com.petshop.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.petshop.dao.AdocaoDao;
import br.com.petshop.model.Adocao;
@Path("/adocoes")
public class AdocaoService {

		@GET
		@Path("/todos")
		@Produces("application/json")
		public List<Adocao> trazeradocoes() {
			return AdocaoDao.getAdocoes();
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Adocao trazerAdocao(@PathParam("id") int id) {
			return AdocaoDao.getById(id);
		}

		@POST
		@Consumes("application/json")
		public Response criarAdocao(Adocao Adocao) {
			try {
				AdocaoDao.saveAdocao(Adocao);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Adocao Criada :" + Adocao.getId();
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deletarAdocao(@PathParam("id") int id) {
			Adocao Adocao = AdocaoDao.getById(id);
			try {				
				AdocaoDao.deleteAdocao(Adocao);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Adocao Deletado : " + Adocao;
			return Response.status(200).entity(result).build();
			
		}


	

}
	
