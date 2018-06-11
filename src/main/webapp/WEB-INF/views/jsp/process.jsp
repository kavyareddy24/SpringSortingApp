<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="./fragments/header.jsp" />

<div class="container">

	<spring:url value="/process" var="processUrl" />

	<form:form class="form-horizontal" method="post" action="${processUrl}">

		<spring:bind path="input">
			<div class="form-group">
				<label class="col-sm-2 control-label">Input</label>
				<div class="col-sm-10">
					<form:input path="input" type="text" class="form-control "
						id="input" placeholder="Enter Text Here" required="true"/>
					<form:errors path="input" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
			</div>
		</div>
	</form:form>

</div>
<div class="container">

	<c:if test="${not empty response}">
		<h1>Alphabetical list (with counts in parentheses)</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Word</th>
					<th>Count</th>
				</tr>
			</thead>

			<c:forEach var="word" items="${response.words}" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
					<td>${word.text}</td>
					<td>${word.count}</td>
				</tr>
			</c:forEach>
		</table>
        <br/>
		<h1>Frequency list (with counts in parentheses)</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Word</th>
					<th>Count</th>
				</tr>
			</thead>

			<c:forEach var="word" items="${response.frequencies}"
				varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
					<td>${word.text}</td>
					<td>${word.count}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>





</div>

<jsp:include page="./fragments/footer.jsp" />

</body>
</html>