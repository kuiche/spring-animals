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
