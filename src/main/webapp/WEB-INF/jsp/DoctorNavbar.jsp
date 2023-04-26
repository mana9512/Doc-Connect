<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head><jsp:include page="Header.jsp" />
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" >Doc-Connect</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/doc-connect/doctor/dashboard.htm">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/doc-connect/doctor/appointments.htm">Appointments</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/doc-connect/doctor/cancelled-appointments.htm">Cancelled Appointments</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/doc-connect/doctor/add/availability.htm">Add Availability</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/doc-connect/doctor/availabilities.htm">View Availabilities</a>
					</li>
				</ul>
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link" href="/doc-connect/logout.htm">Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>