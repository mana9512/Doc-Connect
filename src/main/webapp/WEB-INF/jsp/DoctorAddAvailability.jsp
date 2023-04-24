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

    <div class="container my-5">
    <h1 class="text-center mb-4">Add Availability</h1>
    <form:form modelAttribute="availability" method="post" action="/doc-connect/doctor/add/availability.htm">
      <div class="form-group mb-3">
        <label for="doctor">Doctor</label>
      </div>
      <div class="form-group mb-3">
        <label for="date">Date</label>
        <input type="date" class="form-control" name="availableDate" id="availableDate" required min="<%= LocalDate.now() %>" >
      </div>
      <div class="form-group mb-3">
        <label for="time">Time</label>
        <input type="time" class="form-control" name="availableTime" min="00:00" max="23:59" id="availableTime" required>
      </div>
      <input type="submit" class="btn btn-success" value="Add Availability"/>
      </form:form>

</body>

</html>