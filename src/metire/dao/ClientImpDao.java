package metire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.connection.SingletonConnetion;
import metire.entities.Client;

public class ClientImpDao implements IClient {

	@Override
	public void addClient(Client c) {
		Connection connection = SingletonConnetion.getConnecxion();
		try {			
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO `client`(`REF_Prod`, `Designation`, `Prix`, `Quantite`) VALUES (?,?,?,?)");
			ps.setString(1, c.getRef_prod());
			ps.setString(2, c.getDesignation());
			ps.setDouble(3, c.getPrix());
			ps.setInt(4, c.getQuantite());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
		}
	}

	@Override
	public List<Client> clientParmc(String mc) {
		Connection connection = SingletonConnetion.getConnecxion();
		List<Client> clients = new ArrayList<Client>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from client where designation like ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client c = new Client();
				c.setRef_prod(rs.getString(1));
				c.setDesignation(rs.getString(2));
				c.setPrix(rs.getDouble("prix"));
				c.setQuantite(rs.getInt("quantite"));
				clients.add(c);
			}
			ps.close();
		} catch (Exception e) {
		}
		return clients;
	}

	@Override
	public List<Client> allClient() {
		Connection connection = SingletonConnetion.getConnecxion();
		List<Client> clients = new ArrayList<Client>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from client");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client c = new Client();
				c.setRef_prod(rs.getString(1));
				c.setDesignation(rs.getString(2));
				c.setPrix(rs.getDouble("prix"));
				c.setQuantite(rs.getInt("quantite"));
				clients.add(c);
			}
			ps.close();
		} catch (Exception e) {
		}
		return clients;
	}

	@Override
	public Client getClient(String ref) {
		Connection connection = SingletonConnetion.getConnecxion();
		Client client = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from client where ref_prod like ?");
			ps.setString(1, ref);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				client = new Client();
				client.setRef_prod(rs.getString("ref_prod"));
				client.setDesignation(rs.getString("designation"));
				client.setPrix(rs.getDouble("prix"));
				client.setQuantite(rs.getInt("quantite"));
			}
			ps.close();
		} catch (Exception e) {
		}
		if (client == null)
			throw new RuntimeException("le client : " + ref + " n'existe pas");
		return client;
	}

	@Override
	public void updateClient(Client c) {
		Connection connection = SingletonConnetion.getConnecxion();
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE `client` SET `Designation`=?,`Prix`=?,`Quantite`=? WHERE `REF_Prod`=?");
			ps.setString(1, c.getDesignation());
			ps.setDouble(2, c.getPrix());
			ps.setInt(3, c.getQuantite());
			ps.setString(4, c.getRef_prod());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void supprimerClient(String ref) {
		Connection connection = SingletonConnetion.getConnecxion();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `client` WHERE `REF_Prod` = ?");
			ps.setString(1, ref);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

}