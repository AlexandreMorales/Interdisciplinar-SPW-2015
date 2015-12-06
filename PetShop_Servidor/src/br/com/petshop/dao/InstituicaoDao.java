package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.petshop.model.Instituicao;
import br.com.petshop.util.HibernateUtil;


public class InstituicaoDao {

	private static Session session;
	
	public static void saveInstituicao(Instituicao Instituicao){
		
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        session.save(Instituicao);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
	}
	
	public static Instituicao getById(int id){
		Instituicao result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result =  (Instituicao) session.get(Instituicao.class, id);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}
	
	public static Instituicao getByUsuario(int id){
		Instituicao result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result = (Instituicao)
    		    session.createQuery("select u from Instituicao u where u.usuario.id = :id")
    		           .setInteger("id", id)
    		           .uniqueResult();
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Instituicao> getInstituicoes(){
		
		List<Instituicao> result = new ArrayList<>();
		
		try{
			
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		result =  session.createCriteria(Instituicao.class).list();
		
		session.getTransaction().commit();
				
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		
		return result;
	}
	
	public static void deleteInstituicao(Instituicao Instituicao){
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();			
			
			session.beginTransaction();			
			
			session.delete(Instituicao);
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

