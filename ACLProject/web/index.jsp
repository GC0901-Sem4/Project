

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>e-Administration Of Computer Labs</title>
        <link href="stylesheets/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%--
            <%
                Object objApplicationConnection = application.getAttribute("APP_CONN");
                if (objApplicationConnection != null) {
                    java.sql.Connection ApplicationConnection = (java.sql.Connection) objApplicationConnection;
                } else {
                    //java.sql.Connection ApplicationConnection = org.nvdung.db.MyConnection.getConnection();
                    //application.setAttribute("APP_CONN", ApplicationConnection);
                }
                Object objSessionUsername = request.getSession().getAttribute("_USERNAME");
                if (objSessionUsername != null) {
                    //boolean AppIsAdmin = (Boolean)request.getSession().getAttribute("_ISADMIN");
                }
            %>
        --%>
        <!--Navigation Background Part Starts -->
        <div id="navigation-bg">
            <%@include file="home/navigation.jsp" %>
        </div>
        <!--Navigation Background Part Ends -->
        <!--Our Company Bacground Part Starts -->
        <div id="ourCompany-bg">
            <!--Our Company Part Starts -->
            <div id="ourCompany-part">
                <h2 class="ourCompany-hdr">Welcome to e-Administration of Computer Labs</h2>
                <%@include file="home/ourCompany-leftPart.jsp" %>
                <%@include file="home/ourCompany-rightPart.jsp" %>
                <br class="spacer" />
            </div>
            <!--Our Company Part Ends -->
        </div>
        <!--Our Company Bacground Part Ends -->
        <!--Future Plans Part Starts -->
        <div id="futurePlan-bg">
            <!--Future Plans Contant Part Starts -->
            <div id="futurePlanContant">
                <!--Projects 2007 Part Starts --><!--Projects 2007 Part Ends -->
                <%@include file="home/futurePart.jsp" %>
                <%@include file="home/futurePart2.jsp" %>            
                <br class="spacer" />
                
                 
            </div>
            <!--Future Plans Contant Part Ends -->
        </div>
        <%--
        <%
            Object OBJMESS = request.getSession().getAttribute("MESS");
            if (OBJMESS != null) {
        %><script>alert("<%=OBJMESS.toString()%>");</script><%
                session.removeAttribute("MESS");
            }
        %>
        --%>
        <%--
        <%
            String option = request.getParameter("option");
            if (option != null) {
                if (option.equals("login")) {
        %><jsp:include page="home/login.jsp" /><%                    } else if (option.equals("register")) {
        %><jsp:include page="home/register.jsp" /><%                    } else if (option.equals("feedback")) {
        %><jsp:include page="home/feedback.jsp" /><%                   } else if (option.equals("personal")) {
        %><jsp:include page="home/personal.jsp" /><%                  } else if (option.equals("project")) {
        %><jsp:include page="home/project.jsp" /><%                  } else if (option.equals("contactUs")) {
        %><jsp:include page="home/contactUs.jsp" /><%                  } else if (option.equals("aboutUs")) {
        %><jsp:include page="home/aboutUs.jsp" /><%                  } else if (option.equals("service")) {
        %><jsp:include page="home/service.jsp" /><%                  } else if (option.equals("news")) {
        %><jsp:include page="home/news.jsp" /><%                  } else if (option.equals("cart")) {
        %><jsp:include page="home/cart.jsp" /><%                  } else if (option.equals("create")) {
        %><jsp:include page="home/createProject.jsp" /><%                  } else if (option.equals("finish")) {
        %><jsp:include page="home/finish.jsp" /><%                  } else if (option.equals("forgot")) {
        %><jsp:include page="home/forgot.jsp" /><%                  } else if (option.equals("history")) {
        %><jsp:include page="home/history.jsp" /><%                  } else if (option.equals("faq")) {
        %><jsp:include page="home/faq.jsp" /><%                  } else {
        %><jsp:include page="home/default.jsp" /><%                        }
        } else {
        %><jsp:include page="home/default.jsp" /><%                    }
        %>
        --%>
        <!--Footer-->
        <%@include file="home/footer.jsp" %>
    </body>
</html>

