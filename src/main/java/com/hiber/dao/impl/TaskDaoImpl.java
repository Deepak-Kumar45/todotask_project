package com.hiber.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiber.dao.TaskDao;
import com.hiber.factory.Factory;
import com.hiber.modal.Task;

public class TaskDaoImpl implements TaskDao{

	private Session session=Factory.getSessionFactory().getCurrentSession();
	Transaction tx=null;
	
	@Override
	public int addTask(Task task) {
		try {
			tx=session.beginTransaction();
			int id=(Integer)session.save(task);
			tx.commit();
			return id;
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Task getTask(int taskId) {
		
		try{
			tx=session.beginTransaction();
			Task task=session.get(Task.class, taskId);
			tx.commit();
			return task;
		}catch (Exception e) {
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		return null;
	}

	@Override
	public List<Task> addAllTasks() {
		try {
			tx=session.beginTransaction();
			List<Task> tasks=session.createQuery("from com.hiber.modal.Task").list();
			tx.commit();
			return tasks;
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateTask(Task task) {
		try {
			tx=session.beginTransaction();
			session.update(task);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTask(int id) {
		try {
			tx=session.beginTransaction();
			Task task=session.get(Task.class, id);
			if(task!=null) {
				session.delete(task);
			}
			tx.commit();
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
}
