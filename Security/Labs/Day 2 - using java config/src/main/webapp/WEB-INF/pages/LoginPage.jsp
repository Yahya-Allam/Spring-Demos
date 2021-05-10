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
                <form:form action="${contextPath}/submitlogin" method="post">
                    <fieldset>
                        <legend>Please Login</legend>

                        <c:if test="${param.maxSession != null}">
                            <div class="alert alert-error">
                                Sorry you have reached your maximum allowed concurrent session,
                                you have been logged out from this session.
                            </div>
                        </c:if>

                        <c:if test="${param.error != null}">
                            <div class="alert alert-error">
                                Invalid username and password.
                            </div>
                        </c:if>

                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                You have been logged out.
                            </div>
                        </c:if>

                      

                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" aria-describedby="username"
                                placeholder="Username">
                            <small id="username" class="form-text text-muted">We'll never share your information with
                                anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>

                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" name="remember-me" id="remember-me">
                            <label class="form-check-label" for="remember-me">Remember Me</label>
                        </div>
                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">Log in</button>
                        </div>
                    </fieldset>
                </form:form>
            </div>
            <%@ include file="utils/TailTags.jsp" %>
    </body>

    </html>