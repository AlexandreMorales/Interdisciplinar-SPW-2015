package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.petshop.model.Usuario;
import br.com.petshop.util.HibernateUtil;


public class UsuarioDao {

	private static Session session;
	
	public static void saveUsuario(Usuario Usuario){
		
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        session.save(Usuario);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
	}
	
	public static Usuario getById(int id){
		Usuario result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result =  (Usuario) session.get(Usuario.class, id);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}

	public static Usuario getUsuario(Usuario usuario){
		Usuario result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result = (Usuario)
    		    session.createQuery("select u from Usuario u where u.Email = :email AND u.Senha = :senha")
    		           .setString("email", usuario.getEmail()).setString("senha", usuario.getSenha())
    		           .uniqueResult();
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Usuario> getUsuarios(){
		
		List<Usuario> result = new ArrayList<>();
		
		try{
			
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		result =  session.createCriteria(Usuario.class).list();
		
		session.getTransaction().commit();
				
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		
		return result;
	}
	
	public static void deleteUsuario(Usuario Usuario){
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();			
			
			session.beginTransaction();			
			
			session.delete(Usuario);
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

