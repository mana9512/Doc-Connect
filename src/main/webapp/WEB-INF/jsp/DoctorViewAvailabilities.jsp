<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="Header.jsp" />
</head>

<body>
    <jsp:include page="DoctorNavbar.jsp" />
    <div class="container my-4">
    <h1 class="text-center mb-4">Availabilities</h1>
    <div class="card">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Time</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <c:forEach var="availability" items="${availabilities}">
                  
                        <tr>
                            <td>${availability.availableDate}</td>
                            <td>${availability.availableTime}</td>
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