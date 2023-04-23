<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
</head>

<body>
    <jsp:include page="DoctorNavbar.jsp" />
   <h1>Hello !<p>${requestScope.name}</p></h1>
   <div class="container mt-4">
   <div class="row">
     <div class="col-lg-4">
       <div class="card">
         <div class="card-body">
           <h5 class="card-title">Patients</h5>
           <p class="card-text">View and manage your patients.</p>
           <a href="#" class="btn btn-primary">View Patients</a>
         </div>
       </div>
     </div>
     <div class="col-lg-4">
       <div class="card">
         <div class="card-body">
           <h5 class="card-title">Appointments</h5>
           <p class="card-text">Schedule and manage appointments.</p>
           <a href="#" class="btn btn-primary">View Appointments</a>
         </div>
       </div>
     </div>
     <div class="col-lg-4">
       <div class="card">
         <div class="card-body">
           <h5 class="card-title">Settings</h5>
           <p class="card-text">Update your account settings.</p>
           <a href="#" class="btn btn-primary">Update Settings</a>
         </div>
       </div>
     </div>
   </div>
 </div>
   
</div>

</body>

</html>
