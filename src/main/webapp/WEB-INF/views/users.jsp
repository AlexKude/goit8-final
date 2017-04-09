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

    <title>User List</title>

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
            <h1>All Users</h1>
            <c:if test="${!empty listUsers}">
            <table class="table table-hover borderless table-stripedd">
                <c:forEach items="${listUsers}" var="users">
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
                                           href="/userdata/${users.id}" target="_blank">${users.login}
                                        </a>
                                    </h2>
                                </header>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <small class="text-muted display-inline-block m-sm-bottom m-sm-top">
                                    <strong class="js-type">${users.firstName},${users.secondName}</strong>
                                    -
                                    <span>
                                            ${users.id}
                                    </span>
                                    -
                                    <span>
                                            ${users.address}
                                    </span>
                                    -
                                    <span>
                                            ${users.eMail}
                                    </span>
                                    -
                                    <span>
                                            ${users.otherContacts}
                                    </span>
                                    -
                                    <span>
                                            ${users.portfolioLinks}
                                    </span>
                                    -
                                    <span>
                                            ${users.skills}
                                    </span>
                                    -
                                    <span>
                                            ${users.roles}
                                    </span>
                                    -

                            </div>
                        </div>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <div class="row">
                            <div class="col-md-12">
                                            <span class="col-md-offset-1">
                                                <a href="<c:url value='/edit_user/${users.id}'/>">Edit</a>
                                            </span>
                                <span class="col-md-offset-9">
                                                <a href="<c:url value='/remove_user/${users.id}'/>">Delete</a>
                                            </span>
                            </div>
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

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div class="row">
        <div class="col-md-6 col-md-offset-4 panel-body">
            <h1>Add User:</h1>

            <c:url var="addAction" value="/user/add"/>

            <form:form action="${addAction}" commandName="user">
                <table class="table-responsive">
                    <c:if test="${!empty user}">   <%--Need to correct!!!--%>
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
                            <form:label path="firstName">
                                <spring:message text="First Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="firstName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="secondName">
                                <spring:message text="Second Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="secondName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="address">
                                <spring:message text="Address"/>
                            </form:label>
                        </td>
                        <td>
                            <form:textarea path="address"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="eMail">
                                <spring:message text="E-mail"/>
                            </form:label>
                        </td>
                        <td>
                            <form:textarea path="eMail"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="otherContacts">
                                <spring:message text="Other contacts"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="otherContacts"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="skills">
                                <spring:message text="Skills"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="skills"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="portfolioLinks">
                                <spring:message text="Portfolio Links"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="portfolioLinks"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test="${!empty user}"> <%--Need to correct!!!--%>
                                <input type="submit" class="form-control"
                                       value="<spring:message text="Edit User"/>"/>
                            </c:if>
                            <c:if test="${empty user}"><%--Need to correct!!!--%>
                                <input type="submit" class="form-control"
                                       value="<spring:message text="Add User"/>"/>
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
