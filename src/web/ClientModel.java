package web;

import java.util.ArrayList;
import java.util.List;

import metire.entities.Client;

public class ClientModel {
	private String motCle;
	private List<Client> clients = new ArrayList<Client>();
	private Client client = new Client();
	private String erreur;
	private String mode = "ajouter";

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}