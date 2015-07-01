

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>e-Administration Of Computer Labs</title>
        <link href="../stylesheets/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <!--Navigation Background Part Starts -->
        <div id="navigation-bg">
            <%@include file="../home/navigation_login.jsp" %>
        </div>
        <!--Our Company Left Part Starts -->
        <div id="ourCompany-leftPart2" align="center">
            <f:view>
                <a href="report.jsp">Report List</a>&nbsp;|&nbsp;
                <a href="myWork.jsp">My Work</a>
                 <h:form>
                <h:commandLink action="#{userBean.logout}"  title="">Logout</h:commandLink>
            </h:form> 
                <h3 class="ourCompany-hdr">Work List</h3>
                <h:form id="reportList">
                    <h:dataTable id="report" value="#{reportListBean.getWorkByTechnican()}" 
                                 var="report" border="1" >
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:commandLink value="#{report.id}" action="reportInfo" 
                                           actionListener="#{reportBean.getReportByID(report.id)}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Device"/>
                            </f:facet>
                            <h:commandLink value="#{report.device.id}" action="deviceInfo" 
                                           actionListener="#{deviceBean.getDeviceByID(report.device.id)}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Lab ID"/>
                            </f:facet>
                            <h:commandLink value="#{report.device.lab.id}" action="labInfo" 
                                           actionListener="#{labBean.getLabByID(report.device.lab.id)}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Sender"/>
                            </f:facet>
                            <h:commandLink value="#{report.userBySender.name}" action="userInfo" 
                                           actionListener="#{userBean.getUserByID(report.userBySender.id)}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Create Date"/>
                            </f:facet>
                            <h:outputText value="#{report.createDate}">
                                <f:convertDateTime pattern="HH:mm MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Title"/>
                            </f:facet>
                            <h:outputText value="#{report.title}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Status"/>
                            </f:facet>
                            <h:outputText value="#{report.status}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="End Date"/>
                            </f:facet>
                            <h:outputText value="#{report.endDate}">
                                <f:convertDateTime pattern="HH:mm MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Action"/>
                            </f:facet>                        
                            <h:commandLink value="Done" action="sucess" actionListener="#{reportBean.finishReport}">
                                <f:param id="reportDoneID" name="signID" value="#{report.id}"/>  
                            </h:commandLink>
                            &nbsp;&nbsp;
                            <h:commandLink value="Deny" action="sucess" actionListener="#{reportBean.denyReport}"
                                           rendered="#{reportBean.checkDoneReport(report.id)}">
                                <f:param id="reportDenyID" name="signID" value="#{report.id}"/>                            
                            </h:commandLink>
                        </h:column>
                    </h:dataTable>
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
