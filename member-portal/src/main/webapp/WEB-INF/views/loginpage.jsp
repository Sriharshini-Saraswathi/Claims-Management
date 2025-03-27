<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
body {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background: linear-gradient(to right, #b92b27, #1565c0)
}

.card {
    margin-bottom: 20px;
    border: none
}

.box {
    width: 500px;
    padding: 40px;
    position: absolute;
    top: 50%;
    left: 57%;
    border-style: solid;
  	border-color: #ffffff;
  	border-radius:10px;
    text-align: center;
    transition: 0.25s;
    margin-top: 50px
}

.box input[type="text"],
.box input[type="password"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 10px 10px;
    width: 250px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s
}

.box h1 {
    color: white;
    text-transform: uppercase;
    font-weight: 500
}

.box input[type="text"]:focus,
.box input[type="password"]:focus {
    width: 300px;
    border-color: #2ecc71
}

.box input[type="submit"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #2ecc71;
    padding: 14px 40px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer
}

.box input[type="submit"]:hover {
    background: #2ecc71
}

</style>
   

    <title>Login</title>
</head>

<body>

   
    <div class="container">
    <div align=center>
    	<p class="mt-4 text-warning">${loggedout}</p>
    </div>
    <div class="d-flex p2 justify-content-center" >
    <h1 class=" p-3 mb-2 text-center text-white">Cognizant Claims</h1>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form action="/login" modelAttribute="model" class="box" method="post">
                    <h1>Login</h1>
                    <p class="text-warning"> Please enter your login and password!</p> 
                    <input type="text" placeholder="Enter username" class="form-control" id="userName" name="userName">
                    <input type="password" placeholder="Enter password" class="form-control" id="password" name="password"> 
                    <input type="submit" name="submit" class="form-button" value="Login">
                    
                </form>
            </div>
        </div>
    </div>
</div>
    
    <!--<div class="container-fluid">
    <div align=center>
    	<p class="mt-4" style = "color : red;">${loggedout}</p>
    </div>
        <div class="left col-sm-7">
            <div style="margin: 200px 10px;">
                <h2>Hey, Welcome</h2>
                <p style="font-size:larger;"><strong>Cognizant Claims</strong> is your <strong>One Stop Application</strong> to manage your Claims</p>
            </div>
        </div>
        <div class="left col-sm-5">
            <div style="padding: 75px 0px;"></div>
            <div style="border-radius: 10px;background-color: rgba(98, 30, 223, 0.582);padding: 30px 30px;margin-right: 150px;">
                <h3>Login</h3>
				<form action="/login" method="post" modelAttribute="model">
                <div class="form-group">
                    <label for="userName">Username</label>
                    <input type="text" class="form-control" id="userName" name="userName">
                </div>
                <div class="form-group ">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div>
                    <button type="submit" name="submit" class="form-button btn btn-success form-control">Login</button>
                </div>
				</form>
            </div>
        </div>-->
    </div>
    </div>


    <script src=" https://code.jquery.com/jquery-3.3.1.slim.min.js " integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo " crossorigin="anonymous "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js " integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1 " crossorigin="anonymous "></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js " integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM " crossorigin="anonymous "></script>

</body>

</html>