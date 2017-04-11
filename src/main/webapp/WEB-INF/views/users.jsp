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
                    <c:forEach items="${listUsers}" var="user">
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
                                                   href="/userdata/${user.id}" target="_blank">${user.login}
                                                </a>
                                            </h2>
                                        </header>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <small class="text-muted display-inline-block m-sm-bottom m-sm-top">
                                            <strong class="js-type">${user.firstName},${user.secondName}</strong>
                                            <strong class="js-type">User ID:  ${user.id} </strong>
                                            -
                                            <span>
                                           ${user.address} - ${user.eMail} - ${user.otherContacts} - ${user.portfolioLinks} - ${user.skills} - ${user.roles}
                                    </span>
                                        </small>
                                    </div>
                                </div>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span class="col-md-offset-1">
                                                <a href="<c:url value='/edit_user/${user.id}'/>">Edit</a>
                                            </span>
                                            <span class="col-md-offset-9">
                                                <a href="<c:url value='/remove_user/${user.id}'/>">Delete</a>
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

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div class="row">
        <div class="col-md-6 col-md-offset-4 panel-body">
            <c:if test="${!empty user.login}">
                <h1>User details:</h1>
                <c:url var="addAction" value="/user/add"/>
                <form:form action="${addAction}" commandName="user">
                    <table class="table-responsive">
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
                        <tr>
                            <td>
                                <form:label path="login">
                                    <spring:message text="Login"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="login" readonly="true" disabled="true"/>
                                <form:hidden path="login"/>
                                <form:input path="password" readonly="true" disabled="true" style="display:none;"/>
                                <form:hidden path="password"/>
                            </td>
                        </tr>
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
                                <spring:message text="Roles"/>
                            </td>
                            <td>
                                <select id="srfull" multiple="true">
                                    <c:forEach var="l" items="${allRolesList}">
                                        <option value="${l.id}">${l.name}</option>
                                    </c:forEach>
                                </select>
                                <select style="display:none;" id="srcurr" multiple="true">
                                    <c:forEach var="l" items="${user.roles}">
                                        <option value="${l.id}">${l.name}</option>
                                    </c:forEach>
                                </select>

                                <input id="rh" type="hidden" name="roles" value="${user.roles}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" class="form-control"
                                       value="<spring:message text="Edit User"/>" onclick="SetRolesForSubmit()"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </c:if>
        </div>
    </div>
</sec:authorize>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script>
    function SetSelectedRoles() {
        var IDs = [];
        $("#srcurr").find("option").each(function () {
            IDs.push(this.value);
        });
        $("#srfull option").each(function () {
            if (IDs.indexOf((this).value) >= 0) {
                $(this).attr("selected", "selected");
            }

        });
    }

    function SetRolesForSubmit() {
        var IDs = [];
        var IDs = $("#srfull option:selected").map(function () {
            return this.value;
        })
            .get();
        $("#rh").val(IDs);

        //alert($("#rh").val());
    }


    SetSelectedRoles();
</script>
</body>
</html>
