<!doctype html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.hiber.modal.Task"%>
<%@page import="java.util.List" isELIgnored="false"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Note Taker</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background: linear-gradient(to left, #ffafbd, #ffc3a0);
}

html {
	font-size: 16px;
	font-family: cursive;
}

.mycls {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

::-webkit-scrollbar {
	display: none;
}
</style>
<script type="text/javascript">
		function getdata(id,name,desc,date,time) {
			alert(id+" "+name+" "+desc+" "+date+" "+time)
			document.getElementById('myid').value=id;
			document.getElementById('myname').value=name;
			document.getElementById('mydate').value=date;
			document.getElementById('mytime').value=time;
			document.getElementById('mydec').value=desc;
			
		}
	</script>
</head>

<body>
<c:if test="${addtask!=null}">
	<script type="text/javascript">
		alert("Task added");
	</script>
</c:if>
	<div class="container my-3">
		<div class="row my-5 p-3">
			<div class="col-8 m-auto px-5 text-center mycls"
				style="background-color: white;">
				<h1 class="text-dark mt-5 mb-0">Note Taker</h1>
				<p class="mt-0">
					<i>"Be sure to review your to-do list daily"</i>
				</p>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a href="tasklist"
						class="nav-link active" id="profile-tab" data-bs-target="#profile"
						role="tab" aria-controls="profile" aria-selected="false">List
							of your tasks</a></li>
					<li class="nav-item" role="presentation">
						<button class="nav-link " id="home-tab" data-bs-toggle="tab"
							data-bs-target="#home-tab-pane" type="button" role="tab"
							aria-controls="home-tab-pane" aria-selected="true">Add
							New task</button>
					</li>
				</ul>

				<div class="tab-content" id="myTabContent">

					<div class="tab-pane fade show active" id="profile" role="tabpanel" style="height: 20.5rem; overflow:auto; "
						aria-labelledby="profile-tab">

						<c:choose>
							<c:when test="${tasks!=null}">
								<c:forEach var="task" items="${tasks}">
									<div class="container list-group">
										<div class="row list-group-item mx-auto w-100">
											<div class="d-flex justify-content-between">

												<h5>
													<c:out value="${task.taskno}" />
													).
													<c:out value="${task.taskName}" />
												</h5>
												<div>
													<a href="" data-bs-target="#update" 
														onclick="getdata(<c:out value="${task.taskid}" />,
																		'<c:out value="${task.taskName}" />',
																		'<c:out value="${task.description}" />',
																		'<c:out value="${task.conplitionDate}" />',
																		'<c:out value="${task.complitionTime}" />')" 
														data-bs-toggle="modal">
														<i class='bx bx-edit' style="font-size: 1.5rem;"></i>
													</a> <a href="deltask?id=<c:out value='${task.taskid}' />"> <i
														class='bx bx-trash text-danger' style="font-size: 1.5rem;"></i></a>
												</div>
											</div>
											<div class="col">
												<p>
													<c:out value="${task.description}" />
												</p>
												<p class="d-flex justify-content-between mb-1">
													<small> <c:out value="${task.conplitionDate}" /> |
														<c:out value="${task.complitionTime}" />
													</small> <small><c:out value="${task.lastuupdated}" /> </small>
												</p>

											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="container p-5">
									<div class="row p-5">
										<div class="col p-5">
											<a href="tasklist" class="btn btn-success">Click to show
												your todays tasks >></a>
										</div>

									</div>
								</div>

							</c:otherwise>
						</c:choose>

					</div>

					<div class="tab-pane fade" id="home-tab-pane" role="tabpanel"
						aria-labelledby="home-tab" tabindex="0">
						<form action="addtask" method="post">
							<div class="m-3 row">
								<label for="title" class="col-sm-4 col-form-label">Task's
									Title</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="title" name="title"
										required placeholder="Add the title of your task">
								</div>
							</div>
							<div class="mx-3 mb-3 row">
								<label for="completiondate" class="col-sm-4 col-form-label">Complition
									Date</label>
								<div class="col-sm-8">
									<input type="date" class="form-control" id="inputPassword"
										name="cdate" required>
								</div>
							</div>
							<div class="mx-3 mb-3 row">
								<label for="complitiontime" class="col-sm-4 col-form-label">Complition
									Time</label>
								<div class="col-sm-8">
									<input type="time" class="form-control" id="inputPassword"
										name="ctime" required>
								</div>
							</div>
							<div class="mx-3 mb-3 row">
								<label for="desc" class="col-sm-4 col-form-label">Description</label>

								<div class="col-sm-8">
									<textarea rows="3" cols="20" class="form-control" id="desc"
										name="desc" placeholder="describe your task" required></textarea>
								</div>
							</div>
							<div class="mx-3 mb-3 row">
								<div class="col-sm-6">
									<button class="btn btn-danger" type="submit">Add new
										task now</button>
								</div>
								<div class="col-sm-6">
									<button class="btn btn-outline-secondary" type="reset">Clear</button>
								</div>
							</div>

						</form>
					</div>


				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" tabindex="-1" id="update">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h4 class="text-center">Update your tasks here</h4>
					<form action="updatetask">
						<div class="mb-3">
							<label for="taskid" class="form-label">Task ID</label> 
							<input type="text" class="form-control" id="myid" name="tid" readonly>
						</div>
						<div class="mb-3">
							<label for="name" class="form-label">Title</label>
							 <input	type="text" class="form-control" name="titl" id="myname">
						</div>
						<div class="mb-3">
							<label for="date" class="form-label">Complition date</label> <input
								type="date" class="form-control" id="mydate" name="cdate">
						</div>
						<div class="mb-3">
							<label for="time" class="form-label">Complition time</label> <input
								type="time" class="form-control" id="mytime" name="ctime">
						</div>
						<div class="mb-3">
							<label for="dec" class="form-label">Description</label>
							<textarea rows="3" cols="20" class="form-control" id="mydec" name="desc"
								placeholder="describe your task" required></textarea>
						</div>
						<button type="submit" class="btn btn-outline-success">Update
							task</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Links to bootstrap and jquery -->
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js">
		
	</script>
</body>

</html>