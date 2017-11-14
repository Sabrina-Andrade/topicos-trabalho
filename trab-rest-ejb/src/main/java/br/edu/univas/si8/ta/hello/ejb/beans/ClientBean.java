package br.edu.univas.si8.ta.hello.ejb.beans;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.univas.si8.ta.trab.ejb.dao.ClientDAO;
import br.edu.univas.si8.ta.trab.ejb.entities.Client;
import br.edu.univas.si8.ta.trab.rest.ejb.interfaces.ClientLocal;
import br.edu.univas.si8.ta.trab.rest.ejb.interfaces.ClientRemote;

@Stateless
@Local(ClientLocal.class)
@Remote(ClientRemote.class)
public class ClientBean implements ClientLocal, ClientRemote {
	
	@EJB
	private ClientDAO dao;
	

	@Override
	public void createNewClient(String name, String email) {
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		dao.insert(client);
	}

	@Override
	public String[] listClientNames() {
		return dao.listAll()
				.stream()
				.map(Client::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

	
	
}
