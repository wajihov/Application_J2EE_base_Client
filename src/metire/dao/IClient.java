package metire.dao;

import java.util.List;

import metire.entities.Client;



public interface IClient {

	public void addClient(Client c);

	public List<Client> clientParmc(String mc);

	public List<Client> allClient();

	public Client getClient(String ref);

	public void updateClient(Client c);

	public void supprimerClient(String ref);
}