<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 네이비게이터 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="/test">R.now</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor03" aria-controls="navbarColor03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor03">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/test">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Features</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
			<c:choose>
				<c:when test="${user!= null}">
					<li class="nav-item"><a class="nav-link" href="/test/logout">logout</a>
					</li>
				</c:when>
				<c:otherwise>
				<li class="nav-item"><a class="nav-link" href="/test/login">login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/test/register">register</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>
<br>