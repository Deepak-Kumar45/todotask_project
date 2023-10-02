package com.hiber.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hiber.dao.TaskDao;
import com.hiber.modal.Task;

public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TaskController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Front controller is called");
		String path = request.getServletPath();
		System.out.println("Path:" + path);

		String url = request.getServletPath();
		System.out.println("current path:" + url);
		try {

			switch (url) {
			case "/addtask":
				addTask(request, response);
				break;
			case "/deltask":
				deltask(request, response);
				break;
			case "/updatetask":
				updateTask(request, response);
				break;
			case "/tasklist":
				showallTasks(request, response);
				break;
			default:
				showallTasks(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void showallTasks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Task> tasks = TaskDao.getRef().addAllTasks();
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void updateTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("tid"));
		String title=request.getParameter("titl");
		String desc=request.getParameter("desc");
		String d=request.getParameter("cdate");
		String t=request.getParameter("ctime");
		Date comDate=null;
		Date comtime=null;
		try {
			comDate=new SimpleDateFormat("y-M-d").parse(d);
			comtime=new SimpleDateFormat("HH:mm").parse(t);
		}catch (Exception e) {
			e.printStackTrace();
		}
		Task task=TaskDao.getRef().getTask(id);
		
		task.setComplitionTime(comtime);
		task.setConplitionDate(comDate);
		task.setDescription(desc);
		task.setLastuupdated(new Date());
		task.setTaskName(title);
		TaskDao.getRef().updateTask(task);
		request.setAttribute("updTask", "task is added with id "+id);
		request.getRequestDispatcher("index.jsp").forward(request, response);	}

	private void deltask(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		TaskDao.getRef().deleteTask(id);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void addTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String d=request.getParameter("cdate");
		String t=request.getParameter("ctime");
		Date comDate=null;
		Date comtime=null;
		try {
			comDate=new SimpleDateFormat("y-M-d").parse(d);
			comtime=new SimpleDateFormat("HH:mm").parse(t);
		}catch (Exception e) {
			e.printStackTrace();
		}
		Task task=new Task();
		task.setComplitionTime(comtime);
		task.setConplitionDate(comDate);
		task.setDescription(desc);
		task.setLastuupdated(new Date());
		task.setTaskName(title);
		int id=TaskDao.getRef().addTask(task);
		request.setAttribute("addtask", "task is added with id "+id);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
