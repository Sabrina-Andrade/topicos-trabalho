package br.edu.univas.si8.ta.trab.rest.ejb.interfaces;

public interface Client {
	
	void createNewClient(String name, String email);
	
	String[] listClientNames();

}
