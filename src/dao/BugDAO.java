package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Bugs;
import model.Developer;
import utility.DBConnection;

public class BugDAO {

	public static void addBug(Bugs bugs) throws SQLException
	{
		String query = "INSERT INTO bugs"
				+ "(bug_description,category_id,assigned_to,bug_status,created_date)"+"VALUES(?,?,?,?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, bugs.getDescription());
			ps.setInt(2, bugs.getCategory_id());
			ps.setInt(3,bugs.getAssigned_to());
			ps.setString(4, bugs.getStatus());
			ps.setTimestamp(5,new Timestamp(bugs.getCreated_date().getTime()));
			ps.executeUpdate();
		}
				
	}

	public static void updateBug(Bugs bugs) throws SQLException {
		String query = "update bugs"+"set bug_description = ?, category_id=?,"+"assigned_to=?,status=?,resolved_date=?"+" where bug_id = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, bugs.getDescription());
			ps.setInt(2, bugs.getCategory_id());
			ps.setInt(3,bugs.getAssigned_to());
			ps.setString(4, bugs.getStatus());
			ps.setTimestamp(5, new Timestamp(bugs.getResolved_date().getTime()));
			ps.setInt(6,bugs.getBugId());
			ps.executeUpdate();
		}
		
	}

	public List<Bugs> getAllBugs() throws SQLException {
		List<Bugs> bugs = new ArrayList<>();
		String query = "SELECT * FROM bugs";
		try(Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
				ResultSet result = s.executeQuery(query))
		{
			while(result.next())
			{
				Bugs obj= new Bugs();
				obj.setBugId(result.getInt("bug_id"));
				obj.setDescription(result.getString("bug_description"));
				obj.setCategory_id(result.getInt("category_id"));
				obj.setAssigned_to(result.getInt("assigned_to"));
				obj.setStatus(result.getString("bug_status"));
				obj.setCreated_date(result.getTimestamp("created_date"));
				obj.setResolved_date(result.getTimestamp("resolved_date"));
				bugs.add(obj);
			}
		}
		return bugs;
	}

	public void deleteBug(int deleteBugId) {
		String query = "delete from bugs where bug_id =?;";
		try {
			Connection co = DBConnection.getConnection();
			PreparedStatement p = co.prepareStatement(query);
			p.setInt(1, deleteBugId);
			p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Bugs> getAllBugswithCatName() throws SQLException {
		List<Bugs> bugs = new ArrayList<>();
		String query = "SELECT b.*,c.category_name FROM bugs b join categories c on b.category_id=c.category_id";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
					ResultSet result = ps.executeQuery(query))
			{
				while(result.next())
				{
					Bugs obj= new Bugs();
					obj.setBugId(result.getInt("bug_id"));
					obj.setDescription(result.getString("bug_description")+"(Category:" +result.getString("category_name")+")");
					obj.setCategory_id(result.getInt("category_id"));
					obj.setAssigned_to(result.getInt("assigned_to"));
					obj.setStatus(result.getString("bug_status"));
					obj.setCreated_date(result.getTimestamp("created_date"));
					obj.setResolved_date(result.getTimestamp("resolved_date"));
					bugs.add(obj);
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bugs;
	}

	public List<Bugs> getAllBugswithDevName() throws SQLException {
		List<Bugs> bugs = new ArrayList<>();
		String query = "SELECT b.*,d.developer_name FROM bugs b join developers d on b.assigned_to=d.developer_id";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
					ResultSet result = ps.executeQuery(query))
			{
				while(result.next())
				{
					Bugs obj= new Bugs();
					obj.setBugId(result.getInt("bug_id"));
					obj.setDescription(result.getString("bug_description")+"(Developer Name:" +result.getString("developer_name")+")");
					obj.setCategory_id(result.getInt("category_id"));
					obj.setAssigned_to(result.getInt("assigned_to"));
					obj.setStatus(result.getString("bug_status"));
					obj.setCreated_date(result.getTimestamp("created_date"));
					obj.setResolved_date(result.getTimestamp("resolved_date"));
					bugs.add(obj);
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bugs;
	}

	public List<Bugs> getAllBugsbyCat() throws SQLException {
		List<Bugs> bugs = new ArrayList<>();
		String query = "SELECT b.*,c.category_name from bugs b join categories c on b.category_id=c.category_id order by c.category_name";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
					ResultSet result = ps.executeQuery(query))
			{
				while(result.next())
				{
					Bugs obj= new Bugs();
					obj.setBugId(result.getInt("bug_id"));
					obj.setDescription(result.getString("bug_description")+"(Category Name:" +result.getString("category_name")+")");
					obj.setCategory_id(result.getInt("category_id"));
					obj.setAssigned_to(result.getInt("assigned_to"));
					obj.setStatus(result.getString("bug_status"));
					obj.setCreated_date(result.getTimestamp("created_date"));
					obj.setResolved_date(result.getTimestamp("resolved_date"));
					bugs.add(obj);
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bugs;
	}

	public List<Bugs> getBugassigned(String devName) throws SQLException {
		List<Bugs> bugs = new ArrayList<>();
		String query = "SELECT b.* from bugs b join developers d on b.assigned_to=d.developer_id where d.developer_name=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);)
			{
			 ps.setString(1, devName);
	            try (ResultSet resultSet = ps.executeQuery()) {
	                while (resultSet.next()) {
	                    Bugs bug = new Bugs();
	                    bug.setBugId(resultSet.getInt("bug_id"));
	                    bug.setDescription(resultSet.getString("bug_description"));
	                    bug.setCategory_id(resultSet.getInt("category_id"));
	                    bug.setAssigned_to(resultSet.getInt("assigned_to"));
	                    bug.setStatus(resultSet.getString("bug_status"));
	                    bug.setCreated_date(resultSet.getTimestamp("created_date"));
	                    bug.setResolved_date(resultSet.getTimestamp("resolved_date"));
	                    bugs.add(bug);
	                }
	            }
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bugs;
	}

	public int getMaxBug() throws SQLException {
		List<Bugs> bugs = new ArrayList<>();
		String query = "select max(bug_count) as max_bugs from (select count(*) as bug_count from bugs group by assigned_to) as bug_counts";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
					ResultSet result = ps.executeQuery(query))
			{
				if(result.next())
				{
					return result.getInt("max_bugs");
				}
			}
		return 0;
		
	}

}
