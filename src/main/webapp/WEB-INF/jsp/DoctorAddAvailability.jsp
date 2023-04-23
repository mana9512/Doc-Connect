<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    <form action="#" method="post">
      <div class="form-group mb-3">
        <label for="doctor">Doctor</label>
        <select class="form-select" name="doctor" id="doctor">
          <option value="1">Dr. John Smith</option>
          <option value="2">Dr. Jane Doe</option>
        </select>
      </div>
      <div class="form-group mb-3">
        <label for="date">Date</label>
        <input type="date" class="form-control" name="date" id="date" required min="<%= LocalDate.now() %>" >
      </div>
      <div class="form-group mb-3">
        <label for="time">Time</label>
        <input type="time" class="form-control" name="time" id="date" required>
      </div>
      <input type="submit" class="btn btn-success" value="Add Availability"/>
      </form>

</body>

</html>