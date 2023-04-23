<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="Header.jsp" />
</head>

<body>
    <jsp:include page="DoctorNavbar.jsp" />

    <div class="container my-4">
        <h1 class="text-center mb-4">Your Patients</h1>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">2</th>
                    <td>Jane Smith</td>
                    <td>janesmith@example.com</td>
                    <td>555-555-5555</td>
                    <td>
                        <a href="#" class="btn btn-sm btn-primary"><i class="fa fa-eye"></i> View</a>
                        <a href="#" class="btn btn-sm btn-warning"><i class="fa fa-edit"></i> Edit</a>
                        <a href="#" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Delete</a>
                    </td>
                </tr>
            </tbody>
        </table>

</body>

</html>