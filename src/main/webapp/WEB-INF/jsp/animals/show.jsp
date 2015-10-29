<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../../layout/taglib.jsp" %>

<a href="/animals.html" class="btn btn-primary btn-sm">Back</a>

<h1>${animal.name} - (${animal.animalType})</h1>

<p>
	${animal.name} is a ${animal.animalType}. He says "${animal.noise}".
</p>

<div class="col-md-2">
	<table class="table table-hover">
		<c:if test="${animal.produce.size() > 0}">
			<thead>
				<th>Type</th>
				<th>Count</th>
			</thead>
			<c:forEach items="${animal.produce}" var="produce">
				<tr>
					<td>${produce.type}</td>
					<td>${produce.count}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>

<div class="col-md-10">
	<form:form commandName="produce" cssClass="form-horizontal" method="post" action="/animals/${animal.id}/produce.html">
		<div class="form-group">
			<label for="type" class="col-sm-2 control-label">Type:</label>
			<div class="col-sm-10">
				<form:input path="type" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="count" class="col-sm-2 control-label">Count:</label>
			<div class="col-sm-10">
				<form:input type="number" path="count" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<input type="submit" value="Add Produce" class="btn btn-sm btn-primary">
			</div>
		</div>
	</form:form>
</div>