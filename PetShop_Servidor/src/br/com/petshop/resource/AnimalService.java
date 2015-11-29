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
			List<Animal> animais = trazerAnimais();
			for (Animal animal : animais) {
				if (animal.getId() == id) {
					return animal;
				}
			}
			return null;
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response criarAnimal(String data) {
			try {
				Animal animal = new Animal();
				animal = new Gson().fromJson(data, Animal.class);

				if (animal == null)
					throw new Exception();
				
				AnimalDao.saveAnimal(animal);
			} catch (Exception e) {
				String result = "Error: " + e.getMessage();
				return Response.status(500).entity(result).build();
			}

			String result = "Animal Criado : ";
			return Response.status(200).entity(result).build();
			
		}
		
		@DELETE
		@Path("/{id}")
		@Consumes("application/json")
		public Response deletarAnimal(Animal animal) {
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
	
