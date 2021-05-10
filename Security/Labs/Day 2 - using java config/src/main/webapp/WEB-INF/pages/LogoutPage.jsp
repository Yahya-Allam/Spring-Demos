<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <%@ include file="utils/HeadTags.jsp" %>
            <title>Custom Login Page</title>
    </head>

    <c:set value="${pageContext.request.contextPath}" var="contextPath" />

    <body>
        <%@include file="utils/NavbarElement.jsp" %>
            <div>
                <form:form action="${contextPath}/logout" method="post">
                    <fieldset>

                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name !=null}">
                                <div class="form-actions">
                                    <strong>Welcome : ${pageContext.request.userPrincipal.name}</strong>
                                    <legend>Please Confirm Logout:
                                        <button type="submit" class="btn btn-info btn-lg">
                                            <span><i class="fas fa-sign-out-alt"></i></span> Log out
                                        </button>
                                    </legend>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:redirect url="/login" />
                            </c:otherwise>
                        </c:choose>
                    </fieldset>
                </form:form>
            </div>
            <%@ include file="utils/TailTags.jsp" %>
    </body>

    </html>