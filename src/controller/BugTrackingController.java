package controller;

import java.sql.SQLException;
import java.util.List;

import dao.BugDAO;
import dao.CategoryDAO;
import dao.DeveloperDAO;
import model.Bugs;
import model.Category;
import model.Developer;

public class BugTrackingController {
	
	private final CategoryDAO categoryDAO;
	private final DeveloperDAO developerDAO;
	private final BugDAO bugDAO;
	
	public BugTrackingController()
	{
		this.categoryDAO = new CategoryDAO();
		this.developerDAO = new DeveloperDAO();
		this.bugDAO = new BugDAO();
	}
	
	public void addCategory(Category category) throws SQLException
	{
		categoryDAO.addCategory(category);
	}
	
	public void updateCategory(Category category) throws SQLException
	{
		categoryDAO.updateCategory(category);
	}
	
	public List<Category> getAllCategories() throws SQLException
	{
		return categoryDAO.getAllCategories();
	}
	
	public void deleteCategory(int categoryId) throws SQLException
	{
		categoryDAO.deleteCategory(categoryId);
	}
	
	public void addDeveloper(Developer developer) throws SQLException
	{
		developerDAO.addDeveloper(developer);
	}
	
	public void updateDeveloper(Developer developer) throws SQLException
	{
		developerDAO.updateDeveloper(developer);
	}
	
	public List<Developer> getAllDevelopers() throws SQLException
	{
		return developerDAO.getAllDevelopers();
	}
	
	public void deleteDeveloper(int developerId) throws SQLException
	{
		developerDAO.deleteDeveloper(developerId);
	}
	public void addBug(Bugs bugs) throws SQLException
	{
		bugDAO.addBug(bugs);
	}
	public void updateBug(Bugs bugs) throws SQLException
	{
		bugDAO.updateBug(bugs);
	}
	public List<Bugs> getAllBugs() throws SQLException
	{
		return bugDAO.getAllBugs();
	}
	public void deleteBug(int BugId) throws SQLException
	{
		bugDAO.deleteBug(BugId);
	}

	public List<Bugs> getAllBugswithCatName()throws SQLException {
		
		return bugDAO.getAllBugswithCatName();
	}
	public List<Bugs> getAllBugswithDevName()throws SQLException {
		
		return bugDAO.getAllBugswithDevName();
	}

	public List<Bugs> getAllBugsbycat() throws SQLException {
		
		return bugDAO.getAllBugsbyCat();
	}

	public List<Bugs> getBugassigned(String devName) throws SQLException {
		
		return bugDAO.getBugassigned(devName);
	}

	public int getMaxBug() throws SQLException {
		
		return bugDAO.getMaxBug();
	}
}