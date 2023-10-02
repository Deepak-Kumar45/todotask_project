package com.hiber.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_task100")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskid;
	
	private int taskno;
	private String taskName;
	
	private String description;
	@Temporal(TemporalType.DATE)
	private Date conplitionDate;
	
	@Temporal(TemporalType.TIME)
	private Date complitionTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastuupdated;

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public int getTaskno() {
		return taskno;
	}

	public void setTaskno(int taskno) {
		this.taskno = taskno;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getConplitionDate() {
		return conplitionDate;
	}

	public void setConplitionDate(Date conplitionDate) {
		this.conplitionDate = conplitionDate;
	}

	public Date getComplitionTime() {
		return complitionTime;
	}

	public void setComplitionTime(Date complitionTime) {
		this.complitionTime = complitionTime;
	}

	public Date getLastuupdated() {
		return lastuupdated;
	}

	public void setLastuupdated(Date lastuupdated) {
		this.lastuupdated = lastuupdated;
	}

	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", taskno=" + taskno + ", taskName=" + taskName + ", description="
				+ description + ", conplitionDate=" + conplitionDate + ", complitionTime=" + complitionTime
				+ ", lastuupdated=" + lastuupdated + "]";
	}

	

	public Task(int taskno, String taskName, String description, Date conplitionDate, Date complitionTime,
			Date lastuupdated) {
		super();
		this.taskno = taskno;
		this.taskName = taskName;
		this.description = description;
		this.conplitionDate = conplitionDate;
		this.complitionTime = complitionTime;
		this.lastuupdated = lastuupdated;
	}

	public Task() {
		super();
	}
	
	
	
}
