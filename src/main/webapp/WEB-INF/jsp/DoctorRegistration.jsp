<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="Header.jsp" />
    <style>
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
    </style>
</head>

<body class="bg-image">
    <div class="form-container mt-5">
        <h1>Doctor Registration Form</h1>
        <form:form modelAttribute="doctor" method="post" action="register/doctor.htm">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
    
            <div class="form-group">
                <label for="specialization">Specialization</label>
                <select class="form-control" id="specialization" name="specialization" required>
                    <option value="">-- Select --</option>
                    <option value="Cardiologist">Cardiologist</option>
                    <option value="Dermatologist">Dermatologist</option>
                    <option value="Gynecologist">Gynecologist</option>
                    <option value="Neurologist">Neurologist</option>
                    <option value="Oncologist">Oncologist</option>
                    <option value="Pediatrician">Pediatrician</option>
                </select>
            </div>
            <button type="submit" style="margin-top:15px" class="btn btn-primary btn-block">Register</button>
        </form:form>
    </div>
</body>

</html>