

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!--Navigation Part Starts -->
<div id="navigation">
    <ul class="mainMenu">
        <li><a href="<%= request.getContextPath() %>/faces/index.jsp"
                 <c:if test="${pageContext.request.servletPath == '/index.jsp'}" >
                        class="selectMenu"
                 </c:if>   
               title="Home">Home</a></li>
        <li><a href="<%= request.getContextPath() %>/faces/labInfo.jsp"
               title="Lab Information"
                 <c:if test="${pageContext.request.servletPath == '/labInfo.jsp'}" >
                        class="selectMenu"
                 </c:if>
               >Lab Info</a></li>
        <li><a href="<%= request.getContextPath() %>/faces/login_admin.xhtml" title="Login">Login</a></li>
<!--        <li><a href="customers.html" title="Customers">Customers</a></li>
        <li><a href="contact.html" title="Contact us">Contact us</a></li>-->
    </ul>
    <br class="spacer" />
    <br class="spacer" />
</div>
<!--Navigation Part Ends -->
