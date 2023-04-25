<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <form:form modelAttribute="patient" method="post" action="/doc-connect/register/patient.htm">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input type="text" class="form-control" id="name" path="name" />
                <font color="red">
                    <form:errors path="name" />
                </font>

            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input type="email" class="form-control" id="email" path="email" />
                <font color="red">
                    <form:errors path="email" />
                </font>

            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input type="password" class="form-control" id="password" path="password" />
                <font color="red">
                    <form:errors path="password" />
                </font>

            </div>
            <div class="form-group">
                <label for="age">Age</label>
                <form:input type="number" class="form-control" id="age" path="age" />
                <font color="red">
                    <form:errors path="age" />
                </font>
            </div>
            <div class="form-group">
                <label for="gender">Gender</label>
                <div class="form-check">
                	<form:radiobutton path="gender" value="Male" label="Male" />
                </div>
                <div class="form-check">
                	<form:radiobutton path="gender" value="Female" label="Female" />
                </div>
                <font color="red">
                    <form:errors path="gender" />
                </font>
            </div>
            <button type="submit" class="btn btn-primary btn-block" style="margin-top:20px">Register</button>
         
            <hr>
            <p style="text-align:center">or</p>
            <hr>
            <a href="/doc-connect" style="margin-top:15px" class="btn btn-primary btn-block">Sign In</a>

        </form:form>
    </div>

</body>

</html>