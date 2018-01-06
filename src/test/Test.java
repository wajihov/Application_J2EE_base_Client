package test;

import java.util.List;

import metire.dao.ClientImpDao;
import metire.dao.IClient;
import metire.entities.Client;

public class Test {

	public static void main(String[] args) {
		System.out.println("hello");
		IClient metier = new ClientImpDao();
		/*
		 * metier.addClient(new Client("PROD3", "TV samsung", 1500, 10));
		 * metier.addClient(new Client("PROD4", "TV LG", 700, 10));
		 * metier.addClient(new Client("PROD5", "TV HLI", 600, 10));
		 * metier.addClient(new Client("PROD6", "TV VISIO", 500, 10));
		 */
		System.out.println("---------- List client ------------");
		List<Client> clients = metier.allClient();
		for (Client c : clients) {
			System.out.println("le client : " + c.getRef_prod() + " à le designation :" + c.getDesignation() + "");
		}
		System.out.println("---------- List client par mCef ------------");
		List<Client> clients2 = metier.clientParmc("u");
		for (Client c : clients2) {
			System.out.println("le client : " + c.getRef_prod() + " à le designation :" + c.getDesignation() + "");
		}
		System.out.println("---------- List client par get client ------------");
		try {
			Client client = metier.getClient("pr2");
			System.out.println("le designation est : " + client.getDesignation() + " prix : " + client.getPrix()
					+ " qte : " + client.getQuantite());
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		System.out.println("---------- List client Modifier ------------");
		try {
			Client client = metier.getClient("pro2");
			System.out.println("After le designation est : " + client.getDesignation() + " prix : " + client.getPrix()
			+ " qte : " + client.getQuantite());
			client.setPrix(900);
			client.setQuantite(150);
			client.setDesignation("Ecron LCD");
			metier.updateClient(client);
			System.out.println("Before le designation est : " + client.getDesignation() + " prix : " + client.getPrix()
			+ " qte : " + client.getQuantite());
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		System.out.println("---------- List client Supprimer ------------");
		
		metier.supprimerClient("PROD3");
	}

}
