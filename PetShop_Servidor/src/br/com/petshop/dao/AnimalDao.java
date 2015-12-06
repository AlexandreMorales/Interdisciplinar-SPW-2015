package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.petshop.model.Animal;
import br.com.petshop.util.HibernateUtil;

public class AnimalDao {

	private static Session session;

	public static void saveAnimal(Animal Animal) {

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			session.save(Animal);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static Animal getById(int id) {
		Animal result = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = (Animal) session.get(Animal.class, id);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Animal> getByInstituicao(int id) {
		List<Animal> result = new ArrayList<>();
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = session.createQuery("select u from Animal u where u.instituicao.id = :id").setInteger("id", id)
					.list();

			session.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Animal> getDisponiveis() {
		List<Animal> result = new ArrayList<>();
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = session.createQuery("select u from Animal u where u.disponivel = true").list();

			session.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Animal> getAnimais() {

		List<Animal> result = new ArrayList<>();

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			result = session.createCriteria(Animal.class).list();

			session.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

		return result;
	}

	public static void deleteAnimal(Animal Animal) {

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			session.delete(Animal);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
