package br.edu.univas.si8.ta.trab.rest.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.edu.univas.si8.ta.trab.rest.api.ClientService;
import br.edu.univas.si8.ta.trab.rest.ejb.interfaces.Client;


@RequestScoped
public class ClientServiceImpl implements ClientService {
	
	@EJB(mappedName = "java:app/trab-rest-ejb-0.1-SNAPSHOT/ClientBean!br.edu.univas.si8.ta.trab.ejb.interfaces.ClientRemote")
	private Client client;
	
	public String[] listClientesNomes() {
		return client.listClientNames();
	}
	
	public String saveNewClientes(String name, String email) {
		client.createNewClient(name, email);
		return "{\"message\": \"Success\"}";
	}

}
