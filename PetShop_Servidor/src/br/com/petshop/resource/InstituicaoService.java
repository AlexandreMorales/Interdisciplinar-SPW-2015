package br.com.petshop.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.petshop.dao.InstituicaoDao;
import br.com.petshop.model.Adocao;
import br.com.petshop.model.Instituicao;
import br.com.petshop.model.Usuario;
@Path("/instituicoes")
public class InstituicaoService {

		@GET
		@Path("/todos")
		@Produces("application/json")
		public List<Instituicao> trazerInstituicoes() {
			return InstituicaoDao.getInstituicoes();
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Instituicao trazerInstituicao(@PathParam("id") int id) {
			return InstituicaoDao.getById(id);
		}
		
		@GET
		@Path("/usuario/{id}")
		@Produces("application/json")
		public Instituicao trazerInstituicaoPorUsuario(@PathParam("id") int id) {
			return InstituicaoDao.getByUsuario(id);
		}

		@POST
		@Consumes("application/json")
		public Response criarInstituicao(Instituicao Instituicao) {
			try {
				InstituicaoDao.saveInstituicao(Instituicao);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Instituicao Criada : " + Instituicao.getNome();
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deletarInstituicao(@PathParam("id") int id) {
			Instituicao Instituicao = InstituicaoDao.getById(id);
			try {				
				InstituicaoDao.deleteInstituicao(Instituicao);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Instituicao Deletado : " + Instituicao;
			return Response.status(200).entity(result).build();
			
		}


	

}
	
