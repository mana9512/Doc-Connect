<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="Header.jsp" />
</head>

<body>
    <jsp:include page="DoctorNavbar.jsp" />

    <div class="container my-4">
    <h1 class="text-center mb-4">Upcoming Appointments</h1>
    <div class="card">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Patient</th>
                            <th>Contact</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="appointment" items="${appointments}">
                        <tr>
                            <td>${appointment.appointmentDate}</td>
                            <td>${appointment.appointmentTime}</td>
                            <td>${appointment.patient.name}</td>
                            <td>${appointment.patient.email}</td>
                            <td><a class="cancel-btn" href="/doc-connect/doctor/cancel-appointment.htm?id=${appointment.id}"><i class="fa fa-times"></i> Cancel Appointment</a>
</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>

</html>