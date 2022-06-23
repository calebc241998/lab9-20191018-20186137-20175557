<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 21/06/2022
  Time: 07:08 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.BSupervivientes" %>
<%@ page import="Beans.BZombies" %>
<%@ page import="Beans.BVirus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h4 class="my-2">Insertar Nueva Variante</h4>
        </div>
        <div class="card-body p-4 p-md-5">
            <form>
                <div class="row">
                    <div class="col-md-6 mb-1">
                        <div class="form-outline mb-4">
                            <label class="form-label" for="productName"
                            >ID de la Variante</label
                            >
                            <input
                                    type="text"
                                    id="productName"
                                    class="form-control"
                                    placeholder="Ingrese Id"
                            />
                        </div>
                        <div class="form-outline mb-4">
                            <label class="form-label" for="productName"
                            >Nombre Variante </label
                            >
                            <input
                                    type="text"
                                    id="productName"
                                    class="form-control"
                                    placeholder="Ingrese "
                            />
                        </div>



                        <div class="form-outline mb-4">
                            <label class="form-label" for="productName"
                            >Virus</label
                            >
                            <input
                                    type="text"
                                    id="productName"
                                    class="form-control"
                                    placeholder="Ingrese "
                            />
                        </div>

                    </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
