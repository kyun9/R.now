$(document).ready(function() {
	// enter 처리
	$('#messageinput').on('keydown', function(evt) {
		if (evt.keyCode == 13 && $('#messageinput').val() != "") {
			var msg = $('#messageinput').val();
			ws.send(msg);
			$('#messageinput').val('');
		}
	});
	openSocket();
})
function scrollAdjust() {
	$("#message").scrollTop($("#message")[0].scrollHeight);
}

var ws;
var messages = document.getElementById("message");

function openSocket() {
	if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
		writeResponse("WebSocket is already opend.");
		return;
	}

	// 웹소켓 객체 만드는 코드
	var url = window.location.host;// 웹브라우저의 주소창의 포트까지 가져옴
	var pathname = window.location.pathname; /* '/'부터 오른쪽에 있는 모든 경로 */
	var appCtx = pathname.substring(0, pathname.indexOf("/", 2));
	var root = url + appCtx;

	console.log(url);
	console.log(pathname);
	console.log(appCtx);
	console.log(root);

	ws = new WebSocket('ws://' + root + '/replyEcho');

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
	$('#messageinput').val('');
}
function closeSocket() {
	ws.close();
}
function writeResponse(text) {
	message.innerHTML += "<br/>" + text;
	scrollAdjust();
}