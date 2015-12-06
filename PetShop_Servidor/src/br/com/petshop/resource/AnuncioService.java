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

import br.com.petshop.dao.AnuncioDao;
import br.com.petshop.model.Anuncio;
@Path("/anuncios")
public class AnuncioService {

		@GET
		@Path("/todos")
		@Produces("application/json")
		public List<Anuncio> trazerAnuncios() {
			return AnuncioDao.getAnuncios();
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Anuncio trazerAnuncio(@PathParam("id") int id) {
			return AnuncioDao.getById(id);
		}

		@POST
		@Consumes("application/json")
		public Response criarAnuncio(Anuncio Anuncio) {
			try {
				AnuncioDao.saveAnuncio(Anuncio);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Anuncio Criada :" + Anuncio.getId();
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deletarAnuncio(@PathParam("id") int id) {
			Anuncio Anuncio = AnuncioDao.getById(id);
			try {				
				AnuncioDao.deleteAnuncio(Anuncio);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Anuncio Deletado : " + Anuncio;
			return Response.status(200).entity(result).build();
			
		}


	

}
	
