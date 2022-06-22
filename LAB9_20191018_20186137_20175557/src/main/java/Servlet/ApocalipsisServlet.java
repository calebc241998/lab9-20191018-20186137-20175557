package Servlet;
import Daos.HumanosDao;
import Daos.SupervivientesDao;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApocalipsisServlet", value = "/ApocalipsisServlet")
public class ApocalipsisServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HumanosDao humanosdao = new HumanosDao();
        //VarianteDao varianteDao = new VarianteDao();
        SupervivientesDao supervivientesdao = new SupervivientesDao();
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch(action){
            case "listar" -> {
                request.setAttribute("listahumanos",humanosdao.ObtenerListaHumanos());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("mision1.jsp");
                requestDispatcher.forward(request,response);
            }
            case "zombies" -> {
                //request.setAttribute("Mision4",ZombiesDao.Mision4());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision4.jsp");
                requestDispatcher.forward(request,response);
            }
            case "supervivientes" -> {
                request.setAttribute("Mision2", supervivientesdao.ObtenerListaSupervivientes());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "filtrarS" -> {
                //request.setAttribute("Mision4",daoApocalipsis.Mision2Filtrado());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "crearS" -> {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("formSuperviviente.jsp");
                requestDispatcher.forward(request,response);
            }
            /*case "editarS" -> {
                String id = request.getParameter("id");
                BSupervivientes bSupervivientes = daoApocalipsis.buscarPorId(id);
                if (bSupervivientes != null) {
                    request.setAttribute("BSupervivientes", bSupervivientes);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("editar.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/ApocalipsisServlet?a=supervivientes");
                }
            }*/
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
            //Menú virus
            case "virus" -> {
                //request.setAttribute("Mision4",VirusDao.Mision3());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mision3.jsp");
                requestDispatcher.forward(request,response);
            }
            /*case "variante" -> {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("nuevaVariante.jsp");
                requestDispatcher.forward(request,response);
            }*/
            /*case "eliminarV" -> {
                String idVariante = request.getParameter("idVariante");
                request.setAttribute("Mision4",VarianteDao.eliminarVariante(id));
                if (varianteDao.obteneridVariante(idVariante) != null) {
                    varianteDao.eliminarVariante(idVariante);
                }
                response.sendRedirect(request.getContextPath() + "/Mision3.jsp");
            }*/
            //Menu Zombies
            case "crearZ" -> {
                //request.setAttribute("listaZombies",zombiesDao.ObtenerListaZombies());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("formZombie.jsp");
                requestDispatcher.forward(request,response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        SupervivientesDao supervivientesdao = new SupervivientesDao();

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
            /*case "añadirV" -> {
                String nomVirus = request.getParameter("nomVirus");
                String nomVariante = request.getParameter("nomVariante");
                VarianteDao.verificarVirus(nomVirus , NomVariante)
                response.sendRedirect(request.getContextPath() + "/mision3.jsp");
            }*/
            /*case "añadirZ" -> {
                String idHumano = request.getParameter("idHumano");
                String fechainfeccion = request.getParameter("fechainfeccion");
                String idVariante = request.getParameter("idvariante");
                String idTipo = request.getParameter("idTipo");
                String victimas = request.getParameter("victimas");
                VarianteDao.añadirZombie(idHumano, fechainfeccion, idVariante, idTipo, victimas)
                response.sendRedirect(request.getContextPath() + "/mision4.jsp");
            }*/
        }

    }
}

