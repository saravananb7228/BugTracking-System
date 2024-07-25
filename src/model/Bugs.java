package model;

import java.util.Date;

public class Bugs {
	private int bugId;
	private String description;
	private int category_id;
	private int assigned_to;
	private String status;
	private Date created_date;
	private Date resolved_date;
	public Bugs() {
		super();
	}
	public Bugs(int bugId, String description, int category_id, int assigned_to, String status, Date created_date,
			Date resolved_date) {
		super();
		this.bugId = bugId;
		this.description = description;
		this.category_id = category_id;
		this.assigned_to = assigned_to;
		this.status = status;
		this.created_date = created_date;
		this.resolved_date = resolved_date;
	}
	public int getBugId() {
		return bugId;
	}
	public void setBugId(int bugId) {
		this.bugId = bugId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(int assigned_to) {
		this.assigned_to = assigned_to;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getResolved_date() {
		return resolved_date;
	}
	public void setResolved_date(Date resolved_date) {
		this.resolved_date = resolved_date;
	}
	
	

}
