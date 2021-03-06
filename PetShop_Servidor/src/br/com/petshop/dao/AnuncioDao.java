package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.petshop.model.Animal;
import br.com.petshop.model.Anuncio;
import br.com.petshop.model.Usuario;
import br.com.petshop.util.HibernateUtil;


public class AnuncioDao {

	private static Session session;
	
	public static void saveAnuncio(Anuncio Anuncio){
		
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        session.save(Anuncio);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
	}
	
	public static Anuncio getById(int id){
		Anuncio result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result =  (Anuncio) session.get(Anuncio.class, id);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Anuncio> getAnuncios(){
		
		List<Anuncio> result = new ArrayList<>();
		
		try{
			
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		result =  session.createCriteria(Anuncio.class).list();
		
		session.getTransaction().commit();
				
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		
		return result;
	}
	
	public static void deleteAnuncio(Anuncio Anuncio){
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();			
			
			session.beginTransaction();			
			
			session.delete(Anuncio);
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	public static void deletePorAnimal(Animal animal){
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();			
			
			session.beginTransaction();			
			
			
			Query query = session.createQuery("delete Anuncio where animal_id = :id");
			query.setParameter("id", animal.getId());
			query.executeUpdate();
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Anuncio> getPorAnimal(int id){
		List<Anuncio> result = new ArrayList<>();		
		try{			
			session = HibernateUtil.getSessionFactory().openSession();				
			session.beginTransaction();						
			Query query = session.createQuery("from Anuncio where animal_id = :id");
			query.setParameter("id", id);
			result = query.list();			
			session.getTransaction().commit();			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return result;
	}
	
}

