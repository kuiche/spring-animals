<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>Name</th>
			<th>Noise</th>
		</tr>
	</thead>
	<c:forEach items="${animals}" var="animal">
		<tr>
			<td>${animal.id}</td>
			<td>${animal.getName()}</td>
			<td>${animal.getNoise()}</td>
		</tr>
	</c:forEach>
</table>
