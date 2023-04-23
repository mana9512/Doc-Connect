<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="Header.jsp" />
    <style>
        body {
            background-color: #f5f5f5;
        }

        .login-container {
            margin-top: 5rem;
            max-width: 500px;
            background-color: #fff;
            border-radius: 10px;
            padding: 2rem;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 2rem;
            color: #333;
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #e6e6e6;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            width: 100%;
            padding: 0.5rem 1.5rem;
            font-size: 1rem;
            font-weight: 500;
            letter-spacing: 0.05rem;
            margin-top: 2rem;
        }

        .btn-primary:hover {
            background-color: #0069d9;
            border-color: #0062cc;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="login-container">
                    <h2>Login</h2>
                    <form:form modelAttribute="user" method="post" action="login.htm">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input name="password" type="password" class="form-control" id="password" required>
                        </div>
                        <div class="mb-3">
                            <label for="role" class="form-label">I am a:</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="role" id="doctor" value="doctor">
                                <label class="form-check-label" for="doctor">
                                    Doctor
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="role" id="patient" value="patient">
                                <label class="form-check-label" for="patient">
                                    Patient
                                </label>
                            </div>
                        </div>
                       
                        <button type="submit" class="btn btn-primary">Login</button>
                        
                        </br>
                        <font color="red"><form:errors  path="*" /></font>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>