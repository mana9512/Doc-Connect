<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
</head>

<body>
    <jsp:include page="PatientNavBar.jsp" />
    <div class="container mt-5">
        <h2>Book an Appointment</h2>
        <form method="POST">
            <div class="form-group">
                <label for="doctorSelect">Select Doctor:</label>
                <select class="form-control" id="doctorSelect" name="doctor">
                    <option>Select a Doctor</option>
                    <option>Dr. John Smith</option>
                    <option>Dr. Jane Doe</option>
                </select>
            </div>
            <div class="form-group">
                <label for="dateSelect">Select Date:</label>
                <input type="date" class="form-control" id="dateSelect" name="date">
            </div>
            <div class="form-group">
                <label for="timeSelect">Select Time:</label>
                <select class="form-control" id="timeSelect" name="time">
                    <option>Select a Time</option>
                    <option>9:00 AM</option>
                    <option>10:00 AM</option>
                    <option>11:00 AM</option>
                    <option>1:00 PM</option>
                    <option>2:00 PM</option>
                    <option>3:00 PM</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Book Appointment</button>
        </form>
    </div>

</body>

</html>
