<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 21/06/2022
  Time: 07:09 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/cabecera.jsp">
        <jsp:param name="title" value="Menu de Objetos"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="WEB-INF/navbar.jsp">
                <jsp:param name="page" value="objetos"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Misión 5 :Menú de Objetos</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>Nombre del objeto</th>
                        <th>Peso(kg)</th>
                        <th>Tipo(Vacuna,normal)</th>
                    </thead>
                    <%
                        for (BObjetos objetos : listaobjetos) {
                    %>
                    <tr>
                        <td><%=objetos.nombreObjeto()%>
                        </td>
                        <td><%=objetos.getpeso()%>
                        </td>
                        <td><%=objetos.getvacuna()%>
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
