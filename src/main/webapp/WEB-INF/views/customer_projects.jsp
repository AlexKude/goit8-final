<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1 panel-body">
            <h1>Freelance jobs</h1>
            <c:if test="${!empty listOfCustProjects}">
                <table class="table table-hover borderless table-stripedd">
                    <c:forEach items="${listOfCustProjects}" var="project">
                        <tr>
                            <td>
                                <div class="row">
                                    <div class="col-md-12">
                                        <header>
                                            <h2 class="m-0">
                                                <a class="break visited"
                                                   itemprop="url"
                                                   data-o-event-logging
                                                   data-relevance='{}'
                                                   data-position="1"
                                                   href="/projectdata/${project.id}" target="_blank">${project.name}
                                                </a>
                                            </h2>
                                        </header>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <small class="text-muted display-inline-block m-sm-bottom m-sm-top">
                                            <strong class="js-type">Project ID: ${project.id}</strong>
                                            <strong class="js-type">${project.cost}</strong>
                                            -
                                            <span>
                                                    ${project.deadline}
                                            </span>
                                            -
                                            <span>Posted
                                            ${project.startDate}
                                        </span>
                                        </small>
                                        <div>
                                                ${project.describe}
                                        </div>
                                        <div>
                                                ${project.demands}
                                        </div>
                                    </div>
                                </div>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span class="col-md-offset-1">
                                                <a href="<c:url value='/edit/${project.id}'/>">Edit</a>
                                            </span>
                                            <span class="col-md-offset-9">
                                                <a href="<c:url value='/remove/${project.id}'/>">Delete</a>
                                            </span>
                                        </div>
                                    </div>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_FREELANCER')">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span class="col-md-offset-9">
                                                <a href="<c:url value='/applications'/>">APPLY</a>
                                            </span>
                                        </div>
                                    </div>
                                </sec:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
    <div class="row">
        <div class="col-md-6 col-md-offset-4 panel-body">
            <h1>Add Project:</h1>

            <c:url var="addAction" value="/project/add"/>

            <form:form action="${addAction}" commandName="project">
                <table class="table-responsive">
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
                            <form:textarea path="describe"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="demands">
                                <spring:message text="Project Demands"/>
                            </form:label>
                        </td>
                        <td>
                            <form:textarea path="demands"/>
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
        </div>
    </div>
</sec:authorize>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
