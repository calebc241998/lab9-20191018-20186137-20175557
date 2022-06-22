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
        <jsp:param name="title" value="Menu de supervivientes"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="WEB-INF/navbar.jsp">
                <jsp:param name="page" value="supervivientes"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Misión 2 :Menú de Supervivientes</h1>
                </div>
            </div>

                <div class="caja1">
                    <div class="row g-3 align-items-center mt-2 ">
                        <div class="rows-auto">
                            <h4><center>FILTROS</center></h4>
                            <label for="inputtext6" class="col-form-label">Sexo</label>
                        </div>
                        <div class="rows-auto">
                            <input type="text" id="inputtext6" class="form-control" aria-describedby="textHelpInline">
                        </div>
                    </div>


            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>peso(kg)</th>
                        <th>fuerza(en N)</th>
                        <th>Nombre y Apellido de sus pareja</th>
                        <th>Peso cargado(kg)</th>
                    </thead>
                    <%
                        for (BSupervivientes supervivientes : listaSupervivientes) {
                    %>
                    <tr>
                        <td><%=supervivientes.getPeso()%>
                        </td>
                        <td><%=supervivientes.getFuerza()%>
                        </td>
                        <td><%=humanos.getnombre().getapellido()%>
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
                <section class="vh-100">
                    <div class="container py-4 h-100">
                        <div class="row justify-content-center align-items-center h-100">
                            <div class="col-12 col-lg-9 col-xl-7">
                                <div
                                        class="card shadow-2-strong card-registration"
                                        style="border-radius: 15px"
                                >
                                    <div
                                            class="card-header"
                                            style="background-color: #e72d4b; color: white"
                                    >
                                        <h4 class="my-2">Insertar Superviviente</h4>
                                    </div>
                                    <div class="card-body p-4 p-md-5">
                                        <form>
                                            <div class="row">
                                                <div class="col-md-6 mb-1">
                                                    <div class="form-outline mb-4">
                                                        <label class="form-label" for="productName"
                                                        >ID del Superviviente</label
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
                                                        >Nombre y Apellido  </label
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
                                                        >Sexo</label
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
                                                        >Peso(kg)</label
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
                                                        >Fuerza(N)</label
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
                                                        >Nombre y Apellido de la pareja</label
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
                                                        >Peso cargado (kg)</label
                                                        >
                                                        <input
                                                                type="text"
                                                                id="productName"
                                                                class="form-control"
                                                                placeholder="Ingrese "
                                                        />
                                                    </div>

                                                    <div class="">
                                                        <input
                                                                class="btn btn-tele"
                                                                type="submit"
                                                                value="Registrar"
                                                        />
                                                    </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
