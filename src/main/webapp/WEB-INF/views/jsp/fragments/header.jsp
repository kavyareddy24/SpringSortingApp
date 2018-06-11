<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Word List Processor</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="home" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${home}">Home</a>
		</div>
	</div>
</nav>