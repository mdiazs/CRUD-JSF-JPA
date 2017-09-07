# CRUD-JSF-JPA

Aplicación JSF tipo CRUD que se apoya en JPA para interactuar con una base de datos MySQL.

Incluye:

	JPA funciones:

		- persist().
		- merge().
		- remove().
		- createQuery().

	JSF componentes:

		- h:datatable.
		- p:growl.
		- p:accordionPanel.
		- h:form.
		- h:selectOneMenu.
		- h:inputText.
		- p:commandButton.
		- ...

	Inyección de dependencias.
	
	Ajax.

Crear base de datos y tabla:

	create database usuarios_db;

	use usuarios_db;

	create table usuario(dni varchar(9) primary key, nombre varchar(20), apellidos varchar(40), edad int(3));

Desplegar la aplicación:

	mvn clean install tomee:run

	localhost:8080/crud
