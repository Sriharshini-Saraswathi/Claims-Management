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
    <title>Claim Status</title>
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
		  <i class = "small material-icons custom " style="color: white;">home</i>
            <li class="nav-item"><a class="nav-link" href="./homepage">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="./viewbills">View Bills</a></li>
            <li class="nav-item"><a class="nav-link active" href="./claimstatus">Claim Status</a></li>
			<li class="nav-item"><a class="nav-link" href="./submitclaim">Submit Claim</a></li>
			<li class="nav-item"><a class="nav-link" href="./logout">Logout</a></li>
        </ul>
    </nav>
    
    <div class="container">
		<h1 class="display-6 py-2 text-white text-truncate text-center">Claim Status</h1>
        <div><p class="mt-4 text-warning" align="center" style = "font-size:150%;">${invalidMessage}</p></div>
        <form action="/claimstatus" method="post">
		<div align="center" class="mt-5 mb-15">
            <div class="form-row justify-content-center">
                <div class="col-sm-4">
                  <label class="text-white">Claim Id</label>
                  <input type="text" class="form-control" id="claimId" name="claimId" placeholder="Enter Claim Id" required>
                </div>
                </div>
            
			  <div class="form-row justify-content-center">
			  <div class="col-sm-4">
                <label class="text-white">Policy Id</label>
                <input type="text" class="form-control" id="policyId" name="policyId" placeholder="Enter Policy Id" required>
              </div>
			  </div>
              <div class="form-row justify-content-center" >
                <div class="col-sm-4">
                  <label class="text-white">Member Id</label>
                  <input type="text" class="form-control" id="memberId" name="memberId" placeholder="Enter Member Id" required>
                </div>
               </div>
			  
            <button type="submit" class="btn btn-primary my-4">Submit</button>
		</div>
        </form>
    </div>

</body>
</html>