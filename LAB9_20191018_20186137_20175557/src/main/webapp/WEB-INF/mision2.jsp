<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 21/06/2022
  Time: 07:08 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.BSupervivientes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/cabecera.jsp">
        <jsp:param name="title" value="Menu de humanos"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="navbar.jsp">
                <jsp:param name="page" value="humanos"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Misión 1 :Menú de humanos</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>Nombre y Apellido</th>
                        <th>Sexo</th>
                        <th>Estado (zombie o superviviente)</th>
                    </thead>
                    <%
                        for (BHumanos humanos : listahumanos) {
                    %>
                    <tr>
                        <td><%=humanos.getidHumanos()%>
                        </td>
                        <td><%=humanos.getnombre().getapellido()%>
                        </td>
                        <td><%=humanos.getsexo()%>
                        </td>
                        <td><%=humanos.getestado()%>
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
