<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/xml; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container">
            <tilesx:useAttribute name="current"/>
            <ul class="nav nav-tabs">
                <li role="presentation" class="${current == 'index' ? 'active' : ''}">
                    <a href="<spring:url value="/" />">Home</a>
                </li>
                <li role="presentation" class="${current == 'animals.list' ? 'active' : ''}">
                    <a href="<spring:url value="/animals.html" />">Animals</a>
                </li>
            </ul>
        </div>
    </nav>

    <main class="container">
        <tiles:insertAttribute name="body" />
    </main>

    <footer class="footer">
        <div class="container">
            <tiles:insertAttribute name="footer" />
        </div>
    </footer>

</body>
</html>
