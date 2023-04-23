<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="Header.jsp" />
</head>
<body>
    <jsp:include page="PatientNavBar.jsp" />
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
                                <th>Doctor</th>
                                <th>Location</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>2023-04-15</td>
                                <td>09:00 AM</td>
                                <td>Dr. John Doe</td>
                                <td>123 Main St.</td>
                            </tr>
                            <tr>
                                <td>2023-04-22</td>
                                <td>02:30 PM</td>
                                <td>Dr. Jane Smith</td>
                                <td>456 Elm St.</td>
                            </tr>
                            <tr>
                                <td>2023-04-29</td>
                                <td>11:15 AM</td>
                                <td>Dr. Michael Johnson</td>
                                <td>789 Oak St.</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>