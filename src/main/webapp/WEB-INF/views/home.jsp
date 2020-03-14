<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<title>Right now</title>
</head>
<body>
	<h1>R.now</h1>

		
	<a href="/rnow/login">로그인</a>
	<a href="/rnow/register">회원가입</a>

	<div>
		<input type="text" id="messageinput">
	</div>
	<div>
		<button onclick="openSocket();">Open</button>
		<button onclick="send();">Send</button>
		<button onclick="closeSocket();">close</button>
	</div>

	<div id="message"></div>
	<script>
		$(document).ready(function() {
			openSocket();
		})
	</script>
	<script>
		var ws;
		var messages = document.getElementById("message");

		function openSocket() {
			if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opend.");
				return;
			}

			//웹소켓 객체 만드는 코드
			var url = window.location.host;//웹브라우저의 주소창의 포트까지 가져옴
			var pathname = window.location.pathname; /* '/'부터 오른쪽에 있는 모든 경로*/
			var appCtx = pathname.substring(0, pathname.indexOf("/", 2));
			var root = url + appCtx;
			
			console.log(url);
			console.log(pathname);
			console.log(appCtx);
			console.log(root);

			ws = new WebSocket('ws://'+root+'/replyEcho');

			ws.onopen = function(event) {
				if (event.data === undefined)
					return;
				writeResponse(event.data);
			};
			ws.onmessage = function(event) {
				writeResponse(event.data);
			};
			ws.onclose = function(event) {
				writeResponse("Connection closed");
				setTimeout(function() {
					connect();
				}, 1000); // retry connection!!
			}
		}
		function send() {
			var text = document.getElementById("messageinput").value;
			ws.send(text);
			text = "";
		}
		function closeSocket() {
			ws.close();
		}
		function writeResponse(text) {
			message.innerHTML += "<br/>" + text;
		}
	</script>
</body>
</html>
