<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background: linear-gradient(to right, #b92b27, #1565c0)
}
</style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href = "https://fonts.googleapis.com/icon?family=Material+Icons" rel = "stylesheet">
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>
    <title>viewBills</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand">Cognizant Claims</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <ul class="navbar-nav collapse navbar-collapse justify-content-end" id="navbarTogglerDemo01">
            <i class = "material-icons custom" style="color: white;">home</i>
            <li class="nav-item"><a class="nav-link" href="./homepage">Home</a></li>
            <li class="nav-item"><a class="nav-link active" href="./viewbills">View Bills</a></li>
            <li class="nav-item"><a class="nav-link" href="./claimstatus">Claim Status</a></li>
			<li class="nav-item"><a class="nav-link" href="./submitclaim">Submit Claim</a></li>
			<li class="nav-item"><a class="nav-link" href="./logout">Logout</a></li>
        </ul>
    </nav>
  
    <section class="min-vh-50">
      
          <div class="container">
          <div><p class="mt-4 text-warning" align="center" style = "font-size:150%;">${invalidMessage}</p></div>
              <div class="row ">
                  <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                      <h1 class="display-6 py-2 m-4 text-white text-truncate">View Bills</h1>
                      <div class="px-2">
                  
                          <form action="/showbill" method="post" modelAttribute="memberId" modelAttribute="policyId" class="justify-content-center">
                              
                              <div class="form-group">
                                  <label for="memberId"  class="text-white">Member Id</label>
                                  <input name="memberId" id="memberId" type="text" class="form-control" placeholder="Enter Member Id" required>
                              </div>
                             
                              
                              <div class="form-group">
                                  <label for="policyId"  class="text-white">Policy Id</label>
                                  <input name="policyId" id="policyId" type="text" class="form-control" placeholder="Enter Policy Id" required>
                              </div>
                              
                             <!--<input class="form-button" type="submit" name="submit" value="View"></input>-->
                              <button type="submit" class=" m-4 btn btn-primary btn-lg form-button">View</button> 
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      
  </section>
</body>
</html>