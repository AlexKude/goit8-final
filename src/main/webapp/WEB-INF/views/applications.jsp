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
            <h1>Applicants List</h1>
            <c:if test="${!empty listApps}">
                <table class="table table-hover borderless table-stripedd">
                    <c:forEach items="${listApps}" var="application">
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
                                                   href="/userdata/${application.id}"
                                                   target="_blank">${application.freelancer}
                                                </a>
                                            </h2>
                                        </header>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <small class="text-muted display-inline-block m-sm-bottom m-sm-top">
                                            <strong class="js-type">${application.project}</strong>
                                            -

                                            <span>Posted
                                            ${application.applydate}
                                        </span>
                                        </small>
                                        <div>
                                                ${application.note}
                                        </div>

                                    </div>
                                </div>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span class="col-md-offset-1">
                                                <a href="<c:url value='/edit_app/${application.id}'/>">Edit</a>
                                            </span>
                                            <span class="col-md-offset-9">
                                                <a href="<c:url value='/remove_app/${application.id}'/>">Delete</a>
                                            </span>
                                        </div>
                                    </div>
                                </sec:authorize>

                                <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span class="col-md-offset-9">
                                                <a href="<c:url value='/freelancers'/>">CHOOSE</a>  <%--To the /freelancers or to???--%>
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

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_FREELANCER')">
    <div class="row">
        <div class="col-md-6 col-md-offset-4 panel-body">
            <h1>Add Application:</h1>

            <c:url var="addAction" value="/application/add/{proj_id}"/>

            <form:form action="${addAction}" commandName="application">
                <table class="table-responsive">
                    <c:if test="${!empty application.applydate}">
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
                                 <form:label path="project">
                                     <spring:message text="Project ID"/>
                                 </form:label>
                             </td>
                             <td>
                                 <form:input path="project"/>
                             </td>
                         </tr>

                    <tr>
                        <td>
                            <form:label path="note">
                                <spring:message text="Note"/>
                            </form:label>
                        </td>
                        <td>
                            <form:textarea path="note"/>
                        </td>
                    </tr>

                    <td>
                        <c:if test="${!empty application.project}">
                            <input type="submit" class="form-control"
                                   value="<spring:message text="Edit Application"/>"/>
                        </c:if>
                        <c:if test="${empty application.project}">
                            <input type="submit" class="form-control"
                                   value="<spring:message text="Add Application"/>"/>
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
