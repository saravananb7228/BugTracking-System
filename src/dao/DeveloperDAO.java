package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Developer;
import utility.DBConnection;

public class DeveloperDAO {
	public void addDeveloper(Developer developer) throws SQLException
	{
		String query = "INSERT INTO developers"
				+ "(developer_name,email)VALUES(?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, developer.getName());
			ps.setString(2, developer.getEmail());
			ps.executeUpdate();
		}
				
	}
	
	public void updateDeveloper(Developer developer) throws SQLException
	{
		String query = "UPDATE developers "
				+ "SET developer_name=?,email=? WHERE developer_id=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, developer.getName());
			ps.setString(2, developer.getEmail());
			ps.setInt(3, developer.getDeveloperId());
			ps.executeUpdate();
		}
		
	}
	
	public List<Developer> getAllDevelopers() throws SQLException
	{
		List<Developer> developers = new ArrayList<>();
		String query = "SELECT * FROM developers";
		try(Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
				ResultSet result = s.executeQuery(query))
		{
			while(result.next())
			{
				Developer obj= new Developer();
				obj.setDeveloperId(result.getInt("developer_id"));
				obj.setName(result.getString("developer_name"));
				obj.setEmail(result.getString("email"));
				developers.add(obj);
			}
		}
		return developers;
	}
	
	public void deleteDeveloper(int developerId) throws SQLException
	{
		String query = "DELETE FROM developers "
				+ "WHERE developer_id=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, developerId);
			ps.executeUpdate();
		}
				
	}
}