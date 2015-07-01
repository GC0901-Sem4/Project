

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>e-Administration Of Computer Labs</title>
        <link href="<%= request.getContextPath() %>/stylesheets/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <!--Navigation Background Part Starts -->
        <div id="navigation-bg">
            <%@include file="../home/navigation.jsp" %>
        </div>
        <!--Our Company Left Part Starts -->
        <div id="ourCompany-leftPart2" align="center">
            <f:view>            
                <h2>Login Form</h2>
                <h:form id="login">
                    <h:panelGrid columns="2" border="1">
                        <h:outputText value="User: "/>
                        <h:inputText id="id" value="#{userBean.userID}"/>
                        <h:outputText value="Password:"/>
                        <h:inputSecret id="password" value="#{userBean.pass}"/>
                    </h:panelGrid>
                    <h:commandButton type="submit" value="login" action ="#{userBean.login}"/>
                </h:form>   
            </f:view>
        </div>

        <!--Our Company Right Part Starts -->
        <div id="ourCompany-rightPart">


        </div>
        <!--Our Company Right Part Ends -->
        <!--Our Company Left Part Ends -->

        <br class="spacer" />
        <!--Footer-->
        <%@include file="../home/footer.jsp" %>
    </body>
</html>
