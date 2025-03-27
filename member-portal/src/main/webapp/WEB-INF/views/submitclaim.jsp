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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<title>SubmitClaim</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark">
		<a class="navbar-brand">Cognizant Claims</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<ul class="navbar-nav collapse navbar-collapse justify-content-end"
			id="navbarTogglerDemo01">
			<i class="material-icons custom" style="color: white">home</i>
			<li class="nav-item"><a class="nav-link" href="./homepage">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="./viewbills">View
					Bills</a></li>
			<li class="nav-item"><a class="nav-link" href="./claimstatus">Claim
					Status</a></li>
			<li class="nav-item"><a class="nav-link active"
				href="./submitclaim">Submit Claim</a></li>
			<li class="nav-item"><a class="nav-link" href="./logout">Logout</a></li>
		</ul>
	</nav>

	<div class="container">
		<h1 class="display-6 py-2 text-white text-truncate text-center" style="margin: 10px 0px 60px 0px;">Submit Claim</h1>
		<form action="/submitclaim" method="post">
			<div class="row">
				<div class="form-group col-sm-2"></div>
				<div class="form-group col-sm-4">
					<label class="text-white">Policy Id</label> <input type="text"
						class="form-control" id="policyId" name="policyId"
						placeholder="Enter Policy Id" required>
				</div>
				<div class="form-group col-sm-4">
					<label class="text-white">Member Id</label> <input type="text"
						class="form-control" id="memberId" name="memberId"
						placeholder="Enter Member Id" required>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-2"></div>
				<div class="form-group col-sm-4">
					<label class="text-white">Total Billed Amount</label> <input
						type="text" class="form-control" id="totalBilledAmount"
						placeholder="Enter Total Billed Amount" name="totalBilledAmount"
						required>
				</div>

				<div class="form-group col-sm-4">
					<label class="text-white">Total Claimed Amount</label> <input
						type="text" class="form-control" id="totalClaimedAmount"
						placeholder="Enter Total Claimed Amount" name="totalClaimedAmount"
						required>
				</div>
			</div>
			<div></div>
			<div class="row mt-4">
				<div class="form-group col-sm-2"></div>
				<div class="form-group col-sm-4">
					<select class="form-select p-2 col-sm-12" id="hospitalId"
						name="hospitalId" aria-label="Default select example" required>
						<option value="">Choose Hospital</option>
						<option value="601">KIMS Hospital (Krishna Institute of
							Medical Sciences)</option>
						<option value="602">NIMS Hospital (Nizam Institute of
							Medical Sciences)</option>
						<option value="603">Gandhi Hospital</option>
						<option value="604">Osmania Hospital</option>
					</select>
				</div>

				<div class="form-group col-sm-4">
					<select class="form-select p-2 col-sm-12" id="benefitId"
						name="benefitId" aria-label="Default select example" required>
						<option value="">Benefits Availed</option>
						<option value="501">Free monthly checkup</option>
						<option value="502">Covid-19 coverage</option>
						<option value="503">Tax Benefits</option>
					</select>
				</div>
			</div>
			<div align="center">
				<button type="submit" class="btn btn-primary my-4">Submit</button>
			</div>
		</form>
	</div>
</body>

</html>