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

import br.com.petshop.dao.PessoaDao;
import br.com.petshop.model.Adocao;
import br.com.petshop.model.Pessoa;
@Path("/pessoas")
public class PessoaService {

		@GET
		@Path("/todos")
		@Produces("application/json")
		public List<Pessoa> trazerpessoas() {
			return PessoaDao.getPessoas();
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Pessoa trazerPessoa(@PathParam("id") int id) {
			return PessoaDao.getById(id);
		}

		@POST
		@Consumes("application/json")
		public Response criarPessoa(Pessoa pessoa) {
			try {
				PessoaDao.savePessoa(pessoa);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Pessoa Criada : " + pessoa.getNomeSocial();
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deletarPessoa(@PathParam("id") int id) {
			Pessoa Pessoa = PessoaDao.getById(id);
			try {				
				PessoaDao.deletePessoa(Pessoa);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Pessoa Deletado : " + Pessoa;
			return Response.status(200).entity(result).build();
			
		}


	

}
	
