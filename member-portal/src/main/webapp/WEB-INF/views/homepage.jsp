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
    
    <title>Claims Management</title>
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
            <li class="nav-item"><a class="nav-link active" href="./homepage">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="./logout">Logout</a></li>
        </ul>
    </nav>
    <div class="container">
      <h1 class="display-6 py-2 text-white text-truncate text-center" style="margin: 10px 0px 60px 0px;">Services</h1>
        <div class="card-rows m-20">
        <div class="card bg-primary px-2 p-2 col-sm-4 mb-5 container">
          <div class="card-body text-center">
            <h6 class="card-text text-white">View Bills</h6>
            <a href="./viewbills" class="stretched-link"></a>
          </div>
        </div>
        <div class="card bg-info px-2 p-2 col-sm-4 mb-5 container">
          <div class="card-body text-center">
            <h6 class="card-text text-white">Get Claim Status</h6>
            <a href="./claimstatus" class="stretched-link"></a>
          </div>
        </div>
        <div class="card bg-success px-2 p-2 col-sm-4 mb-5 container">
          <div class="card-body text-center">
            <h6 class="card-text text-white">Submit Claim</h6>
            <a href="./submitclaim" class="stretched-link"></a>
          </div>
        </div>
      </div>
      </div>
    </div>
</body>
</html>