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

import br.com.petshop.dao.UsuarioDao;
import br.com.petshop.model.Adocao;
import br.com.petshop.model.Usuario;
@Path("/usuarios")
public class UsuarioService {

		@GET
		@Path("/todos")
		@Produces("application/json")
		public List<Usuario> trazerUsuarios() {
			return UsuarioDao.getUsuarios();
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Usuario trazerUsuario(@PathParam("id") int id) {
			return UsuarioDao.getById(id);
		}

		@POST
		@Consumes("application/json")
		public Response criarUsuario(Usuario Usuario) {
			try {
				UsuarioDao.saveUsuario(Usuario);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			int result = Usuario.getId();
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deletarUsuario(@PathParam("id") int id) {
			Usuario Usuario = UsuarioDao.getById(id);
			try {				
				UsuarioDao.deleteUsuario(Usuario);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Usuario Deletado : " + Usuario;
			return Response.status(200).entity(result).build();
			
		}


	

}
	
