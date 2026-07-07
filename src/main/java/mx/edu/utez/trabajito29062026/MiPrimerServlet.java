package mx.edu.utez.trabajito29062026;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "miPrimerServlet", value = "/miPrimerServlet") //para poder vincularle una url para poder ejecutarlo


public class MiPrimerServlet extends HttpServlet { //herencia

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hola desde mi primer Servlet 2");


}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String origen = req.getParameter("origen");
        String color = req.getParameter("color");
        int edad = Integer.parseInt(req.getParameter("edad"));
        int velocidad = Integer.parseInt(req.getParameter("velocidad"));

        Caballos caballo = new Caballos(name, origen, color, edad, velocidad);



       /* System.out.println("Hola " + name);
        System.out.println("Tu correo es " + email); */

        //Para mostrar los datos en una nueva vista: 1. guardar toda la información a enviar y darle una clave
        req.setAttribute("caballos", caballo);

        //2. redireccionar a la nueva vista
        req.getRequestDispatcher("/WEB-INF/views/mostrarinfo.jsp").forward(req,resp);
    }
}
