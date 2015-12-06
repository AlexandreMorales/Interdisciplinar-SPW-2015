package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.petshop.model.Pessoa;
import br.com.petshop.util.HibernateUtil;


public class PessoaDao {

	private static Session session;
	
	public static void savePessoa(Pessoa Pessoa){
		
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        session.save(Pessoa);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
	}
	
	public static Pessoa getById(int id){
		Pessoa result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result =  (Pessoa) session.get(Pessoa.class, id);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}

	public static Pessoa getByUsuario(int id){
		Pessoa result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result = (Pessoa)
    		    session.createQuery("select u from Pessoa u where u.usuario.id = :id")
    		           .setInteger("id", id)
    		           .uniqueResult();
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Pessoa> getPessoas(){
		
		List<Pessoa> result = new ArrayList<>();
		
		try{
			
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		result =  session.createCriteria(Pessoa.class).list();
		
		session.getTransaction().commit();
				
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		
		return result;
	}
	
	public static void deletePessoa(Pessoa Pessoa){
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();			
			
			session.beginTransaction();			
			
			session.delete(Pessoa);
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

