<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="secondName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="secondName" class="form-control" placeholder="Second name"
                            autofocus="true"></form:input>
                <form:errors path="secondName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="address">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="address" class="form-control" placeholder="Address"
                            autofocus="true"></form:input>
                <form:errors path="address"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="eMail">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="eMail" class="form-control" placeholder="E-mail"
                            autofocus="true"></form:input>
                <form:errors path="eMail"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="otherContacts">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="otherContacts" class="form-control" placeholder="Other contacts"
                            autofocus="true"></form:input>
                <form:errors path="otherContacts"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="skills">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="skills" class="form-control" placeholder="Skills"
                            autofocus="true"></form:input>
                <form:errors path="skills"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="portfolioLinks">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="portfolioLinks" class="form-control" placeholder="Portfolio Links"
                            autofocus="true"></form:input>
                <form:errors path="portfolioLinks"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="login">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="login" class="form-control" placeholder="Login"
                            autofocus="true"></form:input>
                <form:errors path="login"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="roles">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-lable" for="roles">Roles</label>
                <div class="col-md-10">
                    <form:select path="roles" items="${rolesList}" multiple="true" itemValue="id" itemLabel="name"
                                 class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="roles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
