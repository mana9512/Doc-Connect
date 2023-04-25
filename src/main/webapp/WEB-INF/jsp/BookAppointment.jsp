<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page session="true" %>
<!doctype html>
<html lang="en">

<head>
    <jsp:include page="Header.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>
    <title>Doctor Availability</title>
    <style>
        .form-check-label {
            display: inline-block;
            margin-bottom: .5rem;
            font-weight: 500;
            color: #212529;
            cursor: pointer;
        }

        .form-check-label:hover {
            color: #007bff;
        }

        .form-check-input:checked+.form-check-label {
            color: #fff;
            background-color: #007bff;
        }

        .form-check-input:checked+.form-check-label:hover {
            background-color: #0069d9;
        }
    </style>
</head>

<body>
    <jsp:include page="PatientNavBar.jsp" />
    <div class="container my-4">
        <form:form modelAttribute="booking" method="post" action="/doc-connect/scheduleAppointment.htm">
            <div class="card-deck">
                <!-- Iterate over the doctorAvailabilities map -->
                <c:forEach var="doctorEntry" items="${doctorAvailabilities}">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title">${doctorEntry.key.name}</h5>
                        </div>
                        <div class="card-body">
                            <h6 class="card-subtitle mb-2 text-muted">${doctorEntry.key.specialization}</h6>
                            <input type="hidden" name="doctorId" value="${doctorEntry.key.id}" />
                            <div class="card my-4">
                                <div class="card-body">
                                    <h4 class="card-title">Doctor Availability</h4>
                                    <hr>
                                    <!-- Existing code for iterating over doctor availabilities -->
                                    <c:forEach var="date" items="${doctorEntry.value}">
                                        <div class="row">
                                            <div class="col">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="appointmentDate"
                                                        id="${date.key}" value="${date.key}">
                                                    <label class="form-check-label" for=${date.key}>
                                                        ${date.key}
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col">
                                                <c:forEach var="time" items="${date.value}">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio"
                                                            name="appointmentTime" id="${time}" value="${time}">
                                                        <label class="form-check-label" for="time1option1">
                                                            ${time}
                                                        </label>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>
                    </div>
                </c:forEach>
            </div>
            <button type="submit" class="btn btn-primary" style="margin-top:25px">Schedule Appointment</button>

        </form:form>
    </div>
</body>


</html>