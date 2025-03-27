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
.padding-0{
    padding-right:0;
    padding-left:0;
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

    <div class="container">
        <h1 class="display-6 py-2 text-white text-truncate text-center">Bill Details</h1>        
        <table class="text-center table table-borderless">
          <thead>
            <tr class="text-white">
              <th class="col-md-2 padding-0">Info</th>
              <th class="col-md-2 padding-0">Member details</th>
            </tr>
          </thead>
          <tbody>
            <tr class="text-white">
              <td>Member ID</td>
              <td>${memberpremium.memberId}</td>
            </tr>
            <tr class="text-white">
            	<td>Policy ID</td>
              	<td>${memberpremium.policyId}</td>  
            </tr>
            <tr class="text-white">
                <td>Due Amount</td>
                <td>${memberpremium.dueAmount}</td>
            </tr>
            <tr class="text-white">
                <td>Late charges</td>
                <td>${memberpremium.charges}</td>
            </tr>
            <tr class="text-white">
                <td>Paid date</td>
                <td>${memberpremium.paidDate}</td>
            </tr>
            <tr class="text-white">
                <td>Due date</td>
                <td>${memberpremium.dueDate}</td>
            </tr>
          </tbody>
        </table>
      </div>
</body>
</html>