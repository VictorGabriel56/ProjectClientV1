package br.com.service;

import java.sql.SQLException;
import java.util.List;
import br.com.model.Client;
import br.com.repository.ClientRepository;

public class ClientService {
	
	public ClientRepository repository;
	
	public ClientService() {
		this.repository = new ClientRepository();
	}
	
	public void save(Client client)	throws SQLException{
		this.repository.save(client);
	}
	
	public List<Client> list()	throws SQLException{
		return this.repository.list();
	}
	
	public void update(Client client)	throws SQLException{
		this.repository.update(client);
	}
	
	public void delete(Long idClient)	throws SQLException{
		this.repository.delete(idClient);
	}
	
	public Client search(Long id)	throws SQLException{
		return this.repository.searchClient(id);
	}	

}
