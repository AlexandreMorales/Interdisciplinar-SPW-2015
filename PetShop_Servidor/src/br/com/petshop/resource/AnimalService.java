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

import br.com.petshop.dao.AnimalDao;
import br.com.petshop.model.Adocao;
import br.com.petshop.model.Animal;
@Path("/animais")
public class AnimalService {

		@GET
		@Path("/todos")
		@Produces("application/json")
		public List<Animal> trazerAnimais() {
			return AnimalDao.getAnimais();
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Animal trazerAnimal(@PathParam("id") int id) {
			return AnimalDao.getById(id);
		}

		@POST
		@Consumes("application/json")
		public Response criarAnimal(Animal animal) {
			try {
				AnimalDao.saveAnimal(animal);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Animal Criado : " + animal.getNomeAdotivo();
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deletarAnimal(@PathParam("id") int id) {
			Animal animal = AnimalDao.getById(id);
			try {				
				AnimalDao.deleteAnimal(animal);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Animal Deletado : " + animal;
			return Response.status(200).entity(result).build();
			
		}


	

}
	
