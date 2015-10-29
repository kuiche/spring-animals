<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../../layout/taglib.jsp" %>

<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>Name</th>
			<th>Animal Type</th>
			<th>Noise</th>
			<th>DOB</th>
			<th>Delete</th>
		</tr>
	</thead>
	<c:forEach items="${animals}" var="animal">
		<tr>
			<td><a href="/animals/${animal.id}.html">${animal.id}</a></td>
			<td>${animal.getName()}</td>
			<td>${animal.getAnimalType()}</td>
			<td>${animal.getNoise()}</td>
			<td>${animal.getBirthDate()}</td>
			<td>
				<form action="/animals/${animal.id}.html" method="post">
					<input class="btn btn-sm btn-danger" type="submit" name="submit" value="Delete">
					<input type="hidden" name="_method" value="delete">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Create form and modal  -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#create-modal">
	Add animal
</button>
<div class="modal fade" id="create-modal" tabindex="-1" role="dialog" aria-labelledby="create-modal-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="create-modal-label">Create new animal</h4>
			</div>
			<div class="modal-body">
                <form class="form-horizontal" id="create-form" method="post">
					<!-- Name -->
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="text" name="name" class="form-control" required="required">
						</div>
					</div>   <!-- /.form-group -->

					<!-- Type -->
                    <div class="form-group">
                    	<label for="type" class="col-sm-2 control-label">Type</label>
                    	<div class="col-sm-10">
                    	    <%@ page import="animals.service.AnimalService" %>
                    		<select name="type" class="form-control" required="required">
                    			<option value="<%=AnimalService.COW%>">Cow</option>
                    			<option value="<%=AnimalService.SHEEP%>">Sheep</option>
                    			<option value="<%=AnimalService.GOAT%>">Goat</option>
                    			<option value="<%=AnimalService.MOUNTAIN_GOAT%>">Mountain goat</option>
                    		</select>
                    	</div>
                    </div>   <!-- /.form-group -->
				</form> <!-- /form -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<input type="submit" form="create-form" type="button" class="btn btn-primary" value="Save">
			</div>
		</div>
	</div>
</div>
