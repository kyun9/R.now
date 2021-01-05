<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/test/resources/js/chat.js"></script>
<title>Right now</title>
</head>
<body>
	<!-- partial:partials/header.jsp -->
	<%@ include file="./partials/header.jsp"%>
	<!-- partial -->
	<!-- 채팅 -->
	<!-- 	<div>
		<input type="text" id="messageinput">
	</div>
	<div>
		<button onclick="openSocket();">Open</button>
		<button onclick="send();">Send</button>
		<button onclick="closeSocket();">close</button>
	</div>

	<div id="message"></div> -->



	<!-- chat -->
	<div class="card">
		<div class="card-header"></div>

		<div class="card-body" style="border: 1px solid #ccc; width: 100%">
			<div class="panel panel-info">
				<div class="panel-heading">
					<p class="h5" style="margin-top: 20px; margin-left: 20px;">채팅방</p>
				</div>
				<div class="panel-body">
					<ul class="media-list">

						<li class="media">

							<div class="media-body">

								<div class="media">
									<div class="media-body " id="message"
										style="overflow: scroll; width: 500px; height: 200px;"></div>
								</div>

							</div>
						</li>

					</ul>
				</div>
				<div class="panel-footer">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Enter Message" id="messageinput" /> <span
							class="input-group-btn">
							<button class="btn btn-info" type="button" onclick="send();">SEND</button>
						</span>
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- chat end -->


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
