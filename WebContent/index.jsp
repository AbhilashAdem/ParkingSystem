<%@ page import="EIS.DBConnection,java.util.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>USF Parking</title>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/css_reset.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
</head>

<body>
	<header class="navbar-fixed-top navbar-inverse">
		<div class="preHead">
			<div class="container">
				<div class="preHeadTitle">USF Parking</div>
				<ul>
				<!--  	<li><a href="#" class="logInLink">Log in</a><span> or </span><a
						href="#">Create account</a></li>
					<li><a href="/Student/Cart"> <i
							class="fa fa-shopping-cart" aria-hidden="true"></i>
					</a></li>
					<li>
						<form>
							<input type="text"><input type="Submit" value=" ">
						</form>
					</li>
-->				</ul>
			</div>
		</div>
		<div class="main">
			<div class="container">
				<a class="navbar-brand" href="#"> <img src="images/logo.png"
					alt="INTO USF Trips &amp; Events" itemprop="logo">
				</a>
			</div>
		</div>
		<!-- /.container -->
		<nav class="navbar" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="index.jsp">Home</a></li>

						<li><a href="contact.jsp">Contact Us</a></li>
					</ul>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>

	</header>
	<div class="container mainParkingWrap">
		<h1>Parking Layout</h1>
		<p>Hover to view Info and click to Book</p>
		<div class="imagewrap">
			<%
				DBConnection db = new DBConnection();
				System.out.println(db);
				Map<String, List<String>> slotsAvailable = db.getAvailableSlots();
			%>
			<div
				<%out.print("class=\"p1 pos " + slotsAvailable.get("p1").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p1").get(1));%>
				data-parkid="Parking 1"></div>
			<div
				<%out.print("class=\"p2 pos " + slotsAvailable.get("p2").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p2").get(1));%>
				data-parkid="Parking 2"></div>
			<div
				<%out.print("class=\"p3 pos " + slotsAvailable.get("p3").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p3").get(1));%>
				data-parkid="Parking 3"></div>
			<div
				<%out.print("class=\"p4 pos " + slotsAvailable.get("p4").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p4").get(1));%>
				data-parkid="Parking 4"></div>
			<div
				<%out.print("class=\"p5 pos " + slotsAvailable.get("p5").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p5").get(1));%>
				data-parkid="Parking 5"></div>
			<div
				<%out.print("class=\"p6 pos " + slotsAvailable.get("p6").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p6").get(1));%>
				data-parkid="Parking 6"></div>
			<div
				<%out.print("class=\"p7 pos " + slotsAvailable.get("p7").get(0));%>
				data-toggle="tooltip"
				<%out.print("title= Available-" + slotsAvailable.get("p7").get(1));%>
				data-parkid="Parking 7"></div>
			<img src="images/parking.jpg" style="width: 100%" />
		</div>
		<ul class="legend">
			<li><span class="red"></span> Parking Full</li>
			<li><span class="orange"></span> Filling Fast</li>
			<li><span class="green"></span> Available</li>
		</ul>

	</div>
	<footer class="container">
		<div class="row">
			<div class="col-lg-12">
				<p>
					Copyright © 2017, <a href="/" title="">USF Parking</a>.<img
						src="images/usf.png" />
				</p>
			</div>
		</div>
		<!-- /.row -->
	</footer>
	<div class="modal fade parkingFull" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Parking Full</h4>
				</div>
				<div class="modal-body">
					<p>Selected Parking is Full. Please select another Parking
						Area.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">New message</h4>
				</div>
				<div class="modal-body">
					<!-- <form id="SubmitDetailsServlet" action="SubmitDetailsServlet" method="post"> -->
					<% out.print("<form id=\"SubmitDetailsServlet\" action=\"SubmitDetailsServlet\" method=\"post\">"); 
					//out.print("<input type=\"hidden\" name=\"parkingID\" value=\"parkingID\">");
					%>
					<input class="parkingID hide" name="parkingID" />
					
					<!-- <input type="hidden" name="parkingID" value="p1">  -->
						<div class="form-group">
							<label for="recipient-name" class="control-label">Name:</label> <input
								type="text" class="form-control" name="recipient-name"
								id="recipient-name">
						</div>
						<div class="form-group err-div" id="err_recipient-name">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Recipient Name field is required.</span>
						</div>
						<div class="form-group">
							<label for="recipient-email" class="control-label">Email:</label>
							<input type="text" class="form-control" name="recipient-email"
								id="recipient-email">
						</div>
						<div class="form-group err-div" id="err_recipient-email">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Recipient Email field is required.</span>
						</div>
						<div class="form-group err-div" id="err_recipient-email-valid">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Recipient Email field needs to be valid eg:rock@usf.edu .</span>
						</div>
						<div class="form-group">
							<label for="recipient-phone" class="control-label">Phone
								No:</label> <input type="text" class="form-control"
								name="recipient-phone" id="recipient-phone">
						</div>
						<div class="form-group err-div" id="err_recipient-phone">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Recipient Phone No field is required.</span>
						</div>
						<div class="form-group">
							<label for="recipient-car" class="control-label">Car
								License:</label> <input type="text" class="form-control"
								name="recipient-car" id="recipient-car">
						</div>
						<div class="form-group err-div" id="err_recipient-car">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Car License field is required.</span>
						</div>
						<div class="form-group">
							<p>
								<label for="recipient-inDate" class="control-label">Entry:</label>
							</p>
							<input type="date"
								class="form-control half-width-form-control readonly"
								max="2050-12-31" name = "recipient-inDate" id="recipient-inDate" /> <input type="time"
								class="form-control half-width-form-control" name = "recipient-intime"
								id="recipient-intime">
						</div>
						<div class="form-group err-div" id="err_recipient-inDate">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Entry Date field is required.</span>
						</div>
						<div class="form-group err-div" id="err_recipient-intime">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Entry Time field is required.</span>
						</div>
						<div class="form-group">
							<p>
								<label for="recipient-outDate" class="control-label">Exit:</label>
							</p>
							<input type="date"
								class="form-control half-width-form-control readonly"
								max="2050-12-31" name = "endDate" id="recipient-outDate"> <input
								type="time"
								class="form-control half-width-form-control" name = "endTime" id="recipient-outtime">
						</div>
						<div class="form-group err-div" id="err_recipient-outDate">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Exit Date field is required.</span>
						</div>
						<div class="form-group err-div" id="err_recipient-outtime">
							<label class="control-label">&nbsp;</label> <span
								style="color: red">Exit Time field is required.</span>
						</div>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-default" data-dismiss="modal" value="Close"></input>
					<input type="submit" class="btn btn-primary" id="btnRegisterUser" onclick="return registerUser();"value ="Confirm"></input>

	<!--				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="btnRegisterUser">Confirm</button>
 					<button type="button" class="btn btn-primary" id="btnRegisterUser"
						onclick="registerUser()">Confirm</button>
-->				</div>
					</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="ResponseModal" tabindex="-1" role="dialog"
		aria-labelledby="ResponseModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="ResponseModalLabel">Success</h4>
				</div>
				<div class="modal-body">
					Congrats! You have been Successfully Registered.
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="loginModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="loginModalLabel">Login</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="username" class="control-label">Username:</label> <input
								type="text" class="form-control" id="username">
						</div>
						<div class="form-group">
							<label for="password" class="control-label">Password:</label> <input
								type="text" class="form-control" id="password">
						</div>
						<div class="form-group">
							<a href="#">Forgot Password</a>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Login</button>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
		integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"
		type="application/javascript"></script>
	<script src="jscript/default.js"></script>
</body>

</html>