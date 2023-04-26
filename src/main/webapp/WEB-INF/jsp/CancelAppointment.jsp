<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
</head>

<body>
    <jsp:include page="DoctorNavbar.jsp" />
 
    <div class="container" style="padding:20px">
    <h3>Appointment Details</h3>
    <p>Doctor Name: ${booking.doctor.name}</p>
    <p>Patient Name: ${booking.patient.name}</p>
    <p>Appointment Date: ${booking.appointmentDate}</p>
    <p>Appointment Time: ${booking.appointmentTime}</p>
    <hr>
    <h3>Appointment Cancellation</h3>
    <form modelAttribute="cancelled" action="/doc-connect/doctor/cancel-appointment.htm" method="POST">
    	<input type="hidden" name="appointmentId" value="${booking.id}" />
      <div class="mb-3">
        <label for="cancellation-reason" class="form-label">Cancellation Reason</label>
        <textarea class="form-control" name="cancellationReason" rows="4" cols="50" style="resize: vertical;">

        </textarea>
      </div>
  
      <button type="submit" class="btn btn-primary"><i class="bi bi-check-circle"></i> Confirm Cancellation</button>
    </form>
  </div>

</body>

</html>
