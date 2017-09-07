package com.aula114.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.aula114.model.Usuario;

@ManagedBean(name = "implJpa")
@ApplicationScoped

public class ImplJPA {

	public void addUser(Usuario u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadUsuarios");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteUser(String dni) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadUsuarios");
		EntityManager em = emf.createEntityManager();
		Usuario u = em.find(Usuario.class, dni);
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}

	public void updateUser(Usuario u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadUsuarios");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}

	public List<Usuario> listUsers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadUsuarios");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u", Usuario.class);
		List<Usuario> listUsers = consulta.getResultList();
		em.getTransaction().commit();
		em.close();
		return listUsers;
	}

	@SuppressWarnings("unchecked")
	public List<String> listDni() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadUsuarios");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query consulta = em.createQuery("select u.dni from Usuario u");
		List<String> listDni = consulta.getResultList();
		em.getTransaction().commit();
		em.close();
		return listDni;
	}

}
