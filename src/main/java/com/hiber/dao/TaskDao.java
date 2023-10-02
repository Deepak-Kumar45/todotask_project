package com.hiber.dao;

import java.util.List;

import com.hiber.dao.impl.TaskDaoImpl;
import com.hiber.modal.Task;

public interface TaskDao {
	
	public static TaskDao getRef() {
		return new TaskDaoImpl();
	}
	
	public int addTask(Task task);
	
	public Task getTask(int taskId);
	
	public List<Task> addAllTasks();
	
	public void updateTask(Task task);
	
	public void deleteTask(int id);
	
}
