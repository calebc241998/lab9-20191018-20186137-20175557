package Servlet;

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
                request.setAttribute("Mision1",daoApocalipsis.Mision1());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Apocalipsis.jsp");
                requestDispatcher.forward(request,response);
            }
            case "zombies" -> {
                //request.setAttribute("Mision4",daoApocalipsis.Mision4());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Zombies.jsp");
                requestDispatcher.forward(request,response);
            }
            case "supervivientes" -> {
                //request.setAttribute("Mision4",daoApocalipsis.Mision2());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Supervivientes.jsp");
                requestDispatcher.forward(request,response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

