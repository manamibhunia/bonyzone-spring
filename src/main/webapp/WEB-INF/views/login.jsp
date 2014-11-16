<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/favicon.ico">
<title>Bonyzone</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">
</head>
<body>
	<section id="user-login">
		<div class="container">
			<div class="row login-form">
				<div class="col-xs-12">
					<div class="form-wrap">
						<h1>Log in with your email id</h1>
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="email" class="sr-only">Email</label> <input
									type="email" name="email" id="email" class="form-control"
									placeholder="-----@----.com" required>
								<p class="help-block"></p>
							</div>
							<div class="form-group">
								<label for="password" class="sr-only">Password</label> <input
									type="password" name="password" id="password"
									class="form-control" placeholder="Password" required>
								<p class="help-block"></p>
							</div>
							<div class="checkbox">
								<span class="show-checkbox show-password"></span> <span
									class="label">Show password</span>
							</div>
							<button id="login"
								class="btn btn-custom btn-lg btn-block login-submit"
								value="Log in">Login</button>
						</form>
						<button id="register" class="btn btn-lg btn-block" value="Log in">Register</button>
					</div>
				</div>
				<!-- /.col-xs-12 -->
			</div>
			<!-- /login-form .row -->


			<div class="row register-form">
				<form class="form-horizontal" role="form">

					<div class="form-group">
						<label for="first-name" class="col-sm-2 control-label">First
							Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="first-name"
								placeholder="First Name" required>
							<p class="help-block"></p>
						</div>
					</div>

					<div class="form-group">
						<label for="last-name" class="col-sm-2 control-label">Last
							Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="last-name"
								placeholder="Last Name">
						</div>
					</div>

					<div class="form-group">
						<label for="email-id" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email-id"
								placeholder="Email" required>
							<p class="help-block"></p>
						</div>
					</div>

					<div class="form-group">
						<label for="email-id2" class="col-sm-2 control-label">Enter
							Email again</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email-id2"
								placeholder="Email" data-validation-matches-match="email"
								data-validation-matches-message="Must match email address entered above"
								required>
							<p class="help-block"></p>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="rg-password"
								placeholder="Password" required minlength="10">
						</div>
					</div>

					<div class="form-group">
						<label for="password2" class="col-sm-2 control-label">Re-type
							Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="rg-password2"
								placeholder="Password" data-validation-matches-match="password"
								data-validation-matches-message="Must match password entered above"
								required>
						</div>
					</div>

					<div class="form-group">
						<label for="address" class="col-sm-2 control-label">Address</label>
						<div class="col-sm-10">
							<textarea class="form-control" id="address" placeholder="Address"
								required></textarea>
						</div>
					</div>

					<div class="form-group pull-right">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-default submit-registration">Sign
								Up</button>
						</div>
					</div>
				</form>
				<!-- /.form-horizontal -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>

	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<p>
						Current time : ${serverTime}.
					</p>
				</div>
			</div>
		</div>
	</footer>

	<script src="resources/js/jquery-2.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jqBootstrapValidation.js"></script>
	<script src="resources/js/login.js"></script>
</body>
</html>
