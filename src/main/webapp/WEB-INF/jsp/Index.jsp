<!DOCTYPE html>
<html>

<head>
    <jsp:include page="Header.jsp" />
</head>

<body class="main-bg-image">

    <div class="container mt-5">
        <h2 class="text-center" >Doc-Connect!</h2>
        <h6 class="text-center" style="color:white">Connecting Patients and Doctors, One Click at a Time.</h6>
        <p class="text-center" style="color:white">Please select your user type:</p>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title text-center">Doctor</h3>
                            <p class="card-text text-center">Are you a doctor?</p>
                            <div class="text-center">
                                <a class="btn btn-primary" href="/doc-connect/register/doctor.htm">Sign Up</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title text-center">Patient</h3>
                            <p class="card-text text-center">Are you a patient?</p>
                            <div class="text-center">
                                <a class="btn btn-primary" href="/doc-connect/register/patient.htm">Sign Up</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <form action="login.htm" method="get">
        	<div class="text-center mt-3">
        		<button class="btn btn-outline-dark">Already have an account? Sign in here.</button>
        	</div>
        </form>
    </div>
</body>

</html>