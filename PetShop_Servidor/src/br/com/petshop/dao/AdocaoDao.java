package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.petshop.model.Adocao;
import br.com.petshop.util.HibernateUtil;


public class AdocaoDao {

	private static Session session;
	
	public static void saveAdocao(Adocao Adocao){
		
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        session.save(Adocao);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
	}
	
	public static Adocao getById(int id){
		Adocao result = null;
		try {
		
		session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();

        result =  (Adocao) session.get(Adocao.class, id);
        
        session.getTransaction().commit();
        
		}catch(Exception e){
			System.err.println(e.getMessage());		
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Adocao> getAdocoes(){
		
		List<Adocao> result = new ArrayList<>();
		
		try{
			
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		result =  session.createCriteria(Adocao.class).list();
		
		session.getTransaction().commit();
				
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		
		return result;
	}
	
	public static void deleteAdocao(Adocao Adocao){
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();			
			
			session.beginTransaction();			
			
			session.delete(Adocao);
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

