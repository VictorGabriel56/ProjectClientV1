package br.com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.connection.ConnectionFactory;
import br.com.model.Client;

public class ClientRepository {
	
	// C R U D
	
	Connection con;
	
	public ClientRepository () {
		this.con = ConnectionFactory.getConnection();
	}
	
	public boolean save(Client client)	throws SQLException{
		
		this.con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO client (name,email) VALUES (?,?)";
		
		PreparedStatement stmt = this.con.prepareStatement(sql);
		
		stmt.setString(1, client.getName());
		stmt.setString(2, client.getEmail());
		
		boolean save = stmt.executeUpdate() > 0;
		
		ConnectionFactory.closeConnection(con);
		stmt.close();
		
		return save;
	}
	
	public List<Client> list()	throws SQLException{
		
		List<Client> clients = new ArrayList<>();
		
		this.con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM client";
		
		Statement stmt = this.con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Client client = new Client();
			
			client.setId(rs.getLong("id"));
			client.setName(rs.getString("name"));
			client.setEmail(rs.getString("email"));
			
			clients.add(client);
			
		}
		
		ConnectionFactory.closeConnection(con, stmt, rs);
		
		return clients;		
	}
	
	
	public boolean update(Client client)	throws SQLException{
		this.con = ConnectionFactory.getConnection();
		String sql = "UPDATE client SET name = ?, email = ?";
		sql += " WHERE id = ?";
		
		PreparedStatement stmt = this.con.prepareStatement(sql);
		
		stmt.setString(1, client.getName());
		stmt.setString(2, client.getEmail());
		stmt.setLong(3, client.getId());
		
		boolean updated = stmt.executeUpdate() > 0;
		ConnectionFactory.closeConnection(con, stmt);
		
		return updated;		
	}
	
	public boolean delete(Long idClient)	throws SQLException{
		this.con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM client WHERE id = ?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		
		stmt.setLong(1, idClient);
		
		boolean deleted = stmt.executeUpdate() > 0;
		ConnectionFactory.closeConnection(con, stmt);
		
		return deleted;
		
	}
	
	public Client searchClient(Long id)	throws SQLException{
		this.con = ConnectionFactory.getConnection();
		Client client = new Client();
		String sql = "SELECT * FROM client WHERE id = ?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			client.setId(rs.getLong("id"));
			client.setName(rs.getString("name"));
			client.setEmail(rs.getString("email"));
			
		}
		
		ConnectionFactory.closeConnection(con, stmt, rs);
		
		return client;
	}
	
	
}
