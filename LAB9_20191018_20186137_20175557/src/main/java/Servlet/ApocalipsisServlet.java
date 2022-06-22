package Servlet;
import Beans.BHumanos;
import Beans.BSupervivientes;
import Daos.DaoApocalipsis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApocalipsisServlet", value = "/ApocalipsisServlet")
public class ApocalipsisServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoApocalipsis daoApocalipsis = new DaoApocalipsis();
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch(action){
            case "listar" -> {
                request.setAttribute("Mision1",daoApocalipsis.ObtenerListaHumanos());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision1.jsp");
                requestDispatcher.forward(request,response);
            }
            case "zombies" -> {
                //request.setAttribute("Mision4",daoApocalipsis.Mision4());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision4.jsp");
                requestDispatcher.forward(request,response);
            }
            case "supervivientes" -> {
                request.setAttribute("Mision2",daoApocalipsis.ObtenerListaSupervivientes());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "filtrarS" -> {
                //request.setAttribute("Mision4",daoApocalipsis.Mision2Filtrado());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "crearS" -> {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "editarS" -> {
                String id = request.getParameter("id");
                BSupervivientes bSupervivientes = daoApocalipsis.buscarPorId(id);
                if (bSupervivientes != null) {
                    request.setAttribute("BSupervivientes", bSupervivientes);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("editar.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/ApocalipsisServlet?a=supervivientes");
                }
            }
            case "eliminarS" -> {
                String id = request.getParameter("id");
                //request.setAttribute("Mision4",daoApocalipsis.Mision2EliminarS(id));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "inventario" -> {
                String id = request.getParameter("id");
                //request.setAttribute("Mision4",daoApocalipsis.Mision2Inventario(id));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("inventario.jsp");
                requestDispatcher.forward(request,response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        DaoApocalipsis daoApocalipsis = new DaoApocalipsis();

        switch(action) {
            case "guardar" -> {
                String id = request.getParameter("id");
                String nombre = request.getParameter("nombre");
                String sexo = request.getParameter("sexo");
                String peso = request.getParameter("peso");
                String fuerza = request.getParameter("fuerza");
                String nomPareja = request.getParameter("nomPareja");
                String pesocargado = request.getParameter("pesocargado");
                //daoApocalipsis.mision2CrearS(id, nombre, sexo, peso, fuerza, nomPareja, pesocargado);
                response.sendRedirect(request.getContextPath() + "/mision2.jsp");
            }
        }

    }
}

