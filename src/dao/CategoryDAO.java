package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import utility.DBConnection;

public class CategoryDAO {
	
	public void addCategory(Category category) throws SQLException
	{
		String query = "INSERT INTO categories"
				+ "(category_name)VALUES(?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, category.getCategoryName());
			ps.executeUpdate();
		}
				
	}
	
	public void updateCategory(Category category) throws SQLException
	{
		String query = "UPDATE categories "
				+ "SET category_name=? WHERE category_id=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, category.getCategoryName());
			ps.setInt(2, category.getCategoryId());
			ps.executeUpdate();
		}
		
	}
	
	public List<Category> getAllCategories() throws SQLException
	{
		List<Category> categories = new ArrayList<>();
		String query = "SELECT * FROM categories";
		try(Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
				ResultSet result = s.executeQuery(query))
		{
			while(result.next())
			{
				Category obj= new Category();
				obj.setCategoryId(result.getInt("category_id"));
				obj.setCategoryName(result.getString("category_name"));
				categories.add(obj);
			}
		}
		return categories;
	}
	
	public void deleteCategory(int categoryId) throws SQLException
	{
		String query = "DELETE FROM categories "
				+ "WHERE category_id=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, categoryId);
			ps.executeUpdate();
		}
				
	}
	
}