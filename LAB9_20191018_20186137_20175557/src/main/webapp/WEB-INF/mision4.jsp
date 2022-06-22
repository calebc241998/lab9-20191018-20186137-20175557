<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 21/06/2022
  Time: 07:09 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.BSupervivientes" %>
<%@ page import="com.example.lab9_20191018_20186137_20175557.Beans.BZombies" %>
<%@ page import="com.example.lab9_20191018_20186137_20175557.Beans.BVirus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/cabecera.jsp">
        <jsp:param name="title" value="Menu de Zombies"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="navbar.jsp">
                <jsp:param name="page" value="zombies"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Misión 4 :Menú de Zombies</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>Tiempo infectado(en horas respecto a la fecha actual)</th>
                        <th>Variante de virus</th>
                        <th>Numero de victimas</th>
                        <th>Tipo de Zombie</th>
                    </thead>
                    <%
                        for (BVirus virus : listavirus) {
                    %>
                    <tr>
                        <td><%=virus.getidVirus()%>
                        </td>
                        <td><%=virus.getnombreVirus()%>
                        </td>
                        <td><%=variante.getidVariante()%>
                        </td>
                        <td><%=variante.getnombreVariante()%>
                        </td>
                        <td><%=zombies.getnombreVariante()%>
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
