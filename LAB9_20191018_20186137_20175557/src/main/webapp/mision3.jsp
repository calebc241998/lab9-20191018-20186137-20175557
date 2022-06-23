<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 21/06/2022
  Time: 07:08 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.BVirus" %>
<%@ page import="Beans.BVariante" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.lang.Integer" scope="request" id="cantidad"/>
<jsp:useBean type="java.util.ArrayList<Beans.BHumanos>" scope="request" id="listavirus"/>
<html>
    <jsp:include page="/static/cabecera.jsp">
        <jsp:param name="title" value="Menu de virus"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="WEB-INF/navbar.jsp">
                <jsp:param name="page" value="virus"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Misión 3 :Menú de Virus</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>Virus</th>
                        <th>IdVariante</th>
                        <th>Variante</th>
                        <th>Casos Encontrados(Campo Calculado)</th>
                    </thead>
                    <%
                        for (BVariante virus : listavirus) {
                    %>
                    <tr>
                        <td><%=virus.getIdVirus()%>
                        </td>
                        <td><%=virus.getNombreVirus()%>
                        </td>
                        <td><%=virus.getIdVariante()%>
                        </td>
                        <td><%=virus.getNombreVariante()%>
                        </td>
                        <td><%=virus.getCasos()%>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
            <ul>
                <li><a href="mision4.jsp">Menu de Zombies</a></li>
                <li><a href="mision2.jsp">Menu de Supervivientes</a></li>
            </ul>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
