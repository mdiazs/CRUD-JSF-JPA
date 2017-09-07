package com.aula114.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import com.aula114.model.Usuario;
import com.aula114.bean.ImplJPA;

@ManagedBean
@RequestScoped
public class ViewManager {

	// Propiedades

	@ManagedProperty("#{implJpa}")
	private ImplJPA jpa;

	@ManagedProperty("#{user}")
	private Usuario u;

	private List<Usuario> listaUsuarios;
	private List<String> listaDni;

	// Getters y Setters

	public ImplJPA getJpa() {
		return jpa;
	}

	public void setJpa(ImplJPA jpa) {
		this.jpa = jpa;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<String> getListaDni() {
		return listaDni;
	}

	public void setListaDni(List<String> listaDni) {
		this.listaDni = listaDni;
	}

	// Métodos

	public String addUser() {
		jpa.addUser(u);
		listaUsuarios = jpa.listUsers();
		listaDni = jpa.listDni();
		u = new Usuario();
		return null;
	}

	public String deleteUser() {
		jpa.deleteUser(u.getDni());
		listaUsuarios = jpa.listUsers();
		listaDni = jpa.listDni();
		u = new Usuario();
		return null;
	}

	public String updateUser() {
		jpa.updateUser(u);
		listaUsuarios = jpa.listUsers();
		listaDni = jpa.listDni();
		u = new Usuario();
		return null;
	}

	@PostConstruct
	public void init() {
		listaUsuarios = jpa.listUsers();
		listaDni = jpa.listDni();
	}

	public void onTabChange(TabChangeEvent event) {
		FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onTabClose(TabCloseEvent event) {
		FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
