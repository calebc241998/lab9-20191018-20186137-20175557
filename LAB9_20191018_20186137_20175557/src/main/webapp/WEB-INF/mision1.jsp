<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 21/06/2022
  Time: 06:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/ cabecera.jsp">
        <jsp:param name="title" value="Menu de humanos"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
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
                        <td><%=humanos.getIdBanda()%>
                        </td>
                        <td><%=humanos.getNombre_banda()%>
                        </td>
                        <td><%=humanos.getIdlider()%>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
