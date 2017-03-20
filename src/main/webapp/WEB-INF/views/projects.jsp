<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Project List</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<a href="/welcome" target="_self">Back to main menu</a>

<br/>
<br/>

<h1>Project list</h1>
<c:if test="${!empty listProjects}">
    <table class="table-hover table-bordered table-striped">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="60">Cost</th>
            <th width="120">Description</th>
            <th width="60">Deadline</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProjects}" var="project">
            <tr>
                <td align="center">${project.id}</td>
                <td align="center"><a href="/projectdata/${project.id}" target="_blank">${project.name}</a></td>
                <td align="center">${project.cost}</td>
                <td align="center">${project.describe}</td>
                <td align="center">${project.deadline}</td>
                <td align="center"><a href="<c:url value='/edit/${project.id}'/>">Edit</a></td>
                <td align="center"><a href="<c:url value='/remove/${project.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add Projects</h1>

<c:url var="addAction" value="/project/add"/>

<form:form action="${addAction}" commandName="project">
    <table class="table-responsive col-md-2">
        <c:if test="${!empty project.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Project Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="cost">
                    <spring:message text="Cost"/>
                </form:label>
            </td>
            <td>
                <form:input path="cost"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="describe">
                    <spring:message text="Project Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="describe"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="demands">
                    <spring:message text="Project Demands"/>
                </form:label>
            </td>
            <td>
                <form:input path="demands"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="deadline">
                    <spring:message text="Deadline"/>
                </form:label>
            </td>
            <td>
                <form:input path="deadline"/>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${!empty project.name}">
                    <input type="submit" class="form-control"
                           value="<spring:message text="Edit Project"/>"/>
                </c:if>
                <c:if test="${empty project.name}">
                    <input type="submit" class="form-control"
                           value="<spring:message text="Add Project"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
