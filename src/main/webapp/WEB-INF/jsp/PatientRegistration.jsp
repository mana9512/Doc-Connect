<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="Header.jsp" />
    <style>
        body {
            background-color: #f8f9fa;
        }

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

<body>
    <div class="form-container mt-5">
        <h1>Patient Registration Form</h1>
        <form:form modelAttribute="patient" method="post" action="register/patient.htm">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name">
                <font color="red"><form:errors  path="name" /></font>

            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email">
                <font color="red"><form:errors  path="email" /></font>

            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password">
                <font color="red"><form:errors  path="password" /></font>

            </div>
            <div class="form-group">
                <label for="age">Age</label>
                <input type="number" class="form-control" id="age" name="age" min="1" max="120">
                <font color="red"><form:errors  path="age" /></font>
            </div>
            <div class="form-group">
                <label for="gender">Gender</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                    <label class="form-check-label" for="female">Female</label>
                </div>
                <font color="red"><form:errors  path="gender" /></font>

            </div>
            <button type="submit" class="btn btn-primary btn-block" style="margin-top:20px">Register</button>
        </form:form>
    </div>

</body>

</html>