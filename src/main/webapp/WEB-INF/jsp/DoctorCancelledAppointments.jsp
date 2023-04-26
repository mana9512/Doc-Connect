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
    <h1 class="text-center mb-4">Cancelled Appointments</h1>
    <div class="card">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Appointment Date</th>
                            <th>Appointment Time</th>
                            <th>Patient</th>
                            <th>Cancelled Date</th>
                            <th>Reason</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cancelledData" items="${cancelledAppointments}">
                        <tr>
                            <td>${cancelledData.appointment.appointmentDate}</td>
                            <td>${cancelledData.appointment.appointmentTime}</td>
                            <td>${cancelledData.appointment.patient.name}</td>
                            <td>${cancelledData.cancelledDate}</td>
                            <td>${cancelledData.cancellationReason}</td>
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