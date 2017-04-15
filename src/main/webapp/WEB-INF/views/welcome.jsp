<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="starter-template">
        <h1>Freelancer</h1>
        <h2>Hire Freelancers & Get Freelance Jobs Online</h2>
        <ul class="user-links list-inline pull-right">
            <li><a href="${contextPath}/registration" class="header-link-signup text-uppercase" id="signup">Sign up</a></li><li><a href="/login" class="header-link-login text-uppercase">Login</a></li>
        </ul>
    </div>
</div>

<div class="container-fluid">
    <a href="/projects" target="_self">Go to Project list</a>
</div>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_FREELANCER', 'ROLE_CUSTOMER')">
    <div class="container-fluid">
        <a href="/freelancers" target="_self">Go to Freelancer List</a>
    </div>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div class="container-fluid">
        <a href="/admin" target="_self">Go to Admin Page</a>
    </div>
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
    <div class="container-fluid">
        <a href="/customer_apps" target="_self">Go to Applications List</a>
    </div>
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
    <div class="container-fluid">
        <a href="/customer_projects" target="_self">My Projects</a>
    </div>
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_FREELANCER')">
    <div class="container-fluid">
        <a href="/freelancer_apps" target="_self">My Applications</a>
    </div>
</sec:authorize>


<%--<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.displayName" />
</sec:authorize>--%>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>
    <span>${message}</span>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

