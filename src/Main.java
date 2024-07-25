import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import controller.BugTrackingController;
import model.Category;
import model.Developer;
import model.Bugs;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		BugTrackingController controller = new
				BugTrackingController();
		
		while(true)
		{
			System.out.println("Bug Tracking System");
			System.out.println("1.Add Category");
			System.out.println("2.Update Category");
			System.out.println("3.List All Categories");
			System.out.println("4.Delete Category");
			System.out.println("5.Add Developer");
			System.out.println("6.Update Developer");
			System.out.println("7.List All Developer");
			System.out.println("8.Delete Developer");
			System.out.println("9.Add Bug");
			System.out.println("10.Update Bug");
			System.out.println("11.List All Bug");
			System.out.println("12.Delete Bug");
			System.out.println("13. List bugs with category names");
			System.out.println("14. List bugs with developer names");
			System.out.println("15. List bugs by category");
			System.out.println("16. List bugs by developer name");
			System.out.println("17. Max bugs assigned to the developer");
			System.out.println("18.Exit");
			
			
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1:System.out.println("Enter category name: ");
					String name = br.readLine();
					controller.addCategory(new Category(0,name));
					break;
					
			case 2:System.out.println("Enter Category ID");
					int updateCategoryId = Integer.parseInt(br.readLine());
					System.out.println("Enter New Category Name");
					String Updatename = br.readLine();
					controller.updateCategory(new Category(updateCategoryId,Updatename));
					break;
					
			case 3: List<Category> categories = controller.getAllCategories();
					for(Category category: categories)
					{
						System.out.println
						("ID: "+category.getCategoryId()+" Name: "
						+category.getCategoryName());
					}
					break;
					
			case 4:System.out.println("Enter Category ID to be Deleted");
					int deleteCategoryId = Integer.parseInt(br.readLine());
					controller.deleteCategory(deleteCategoryId);
					break;
			
			case 5:System.out.println("Enter developer name: ");
				   String developerName = br.readLine();
				   System.out.println("Enter developer email: ");
				   String email = br.readLine();
				   controller.addDeveloper(new Developer(0,developerName,email));
			break;
			
			case 6:System.out.println("Enter Developer ID");
				int updateDeveloperId = Integer.parseInt(br.readLine());
				System.out.println("Enter New Developer Name");
				String UpdateDevelopername = br.readLine();
				System.out.println("Enter New Developer Email");
				String UpdateDeveloperEmail = br.readLine();
				controller.updateDeveloper(new Developer(updateDeveloperId,UpdateDevelopername,UpdateDeveloperEmail));
				break;
			
			case 7: List<Developer> developers = controller.getAllDevelopers();
					for(Developer Developer: developers)
					{
						System.out.println
						("ID: "+Developer.getDeveloperId()+" Name: "
						+Developer.getName() +
						"Email: "+Developer.getEmail());
					}
					break;
			
			case 8:System.out.println("Enter Developer ID to be Deleted");
					int deleteDeveloperId = Integer.parseInt(br.readLine());
					controller.deleteDeveloper(deleteDeveloperId);
					break;
			case 9:System.out.println("Enter bug description: ");
			   		String description = br.readLine();
			   		System.out.println("Enter category Id: ");
			   		int categoryId = Integer.parseInt(br.readLine());
			   		System.out.println("Enter the developer assigned to: ");
			   		int assignedTo = Integer.parseInt(br.readLine());
			   		controller.addBug(new Bugs(0,description,categoryId,assignedTo,"Open",new Date(),null));
		break;
		
			case 10:System.out.println("Enter the Bug Id:");
			int updateBugId = Integer.parseInt(br.readLine());
			System.out.println("Enter the New Description:");
			String UpdateDesc = br.readLine();
			System.out.println("Enter the New category ID:");
			int updateCatId = Integer.parseInt(br.readLine());
			System.out.println("Enter the New Developer ID:");
			int updateDevId = Integer.parseInt(br.readLine());
			System.out.println("Enter the Status Update:");
			String UpdateStatus = br.readLine();
			System.out.println("Enter the Resolved Date (yyyy-mm-dd hh:mm:ss):");
			String resolvedDate = br.readLine();
			Timestamp resDate =resolvedDate.isEmpty()? null: Timestamp.valueOf(resolvedDate);
			controller.updateBug(new Bugs(updateBugId,UpdateDesc,updateCatId,updateDevId,UpdateStatus,null,resDate));
			break;
			case 11:List<Bugs> bug = controller.getAllBugs();
			for(Bugs b: bug)
			{
				System.out.println("ID: "+b.getBugId()+" Description: "+b.getDescription()+" Category: "+b.getCategory_id()+" Assigned To: "+b.getAssigned_to()+" Created on : "+b.getCreated_date()+" Status: "+b.getStatus()+" Resolved on: "+b.getResolved_date());
			}
			break;

			case 12: System.out.println("Enter Bug Id to deleted");
			int deleteBugId=Integer.parseInt(br.readLine());
			controller.deleteBug(deleteBugId);
			break;
			
			case 13:List<Bugs> bugwithCatName = controller.getAllBugswithCatName();
			for(Bugs b: bugwithCatName)
			{
				System.out.println(b.getDescription());
			}
			break;
			case 14:List<Bugs> bugwithDevName = controller.getAllBugswithDevName();
			for(Bugs b: bugwithDevName)
			{
				System.out.println(b.getDescription());
			}
			break;
			case 15:List<Bugs> bugbyCat = controller.getAllBugsbycat();
			for(Bugs b: bugbyCat)
			{
				System.out.println(b.getDescription());
			}
			break;
			case 16:System.out.println("Enter Developer Name");
			String devName=br.readLine();
				List<Bugs> MaxBug = controller.getBugassigned(devName);
			for(Bugs b: MaxBug)
			{
				System.out.println(b.getDescription());
			}
			break;
			case 17:List<Bugs> Maxbug = controller.getMaxBug();
			for(Bugs b: Maxbug)
			{
				System.out.println(b.getDescription());
			}
			break;
			case 18: System.out.println("Exiting.....");
					return;
					
			}
			
		}
		
		

	}

}