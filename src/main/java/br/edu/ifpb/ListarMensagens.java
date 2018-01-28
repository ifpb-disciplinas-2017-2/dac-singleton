package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ListarMensagens", urlPatterns = {"/mensagens"})
public class ListarMensagens extends HttpServlet {

    @Inject
    private SalaDeBatepapo sala;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mensagens</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mensagens</h1>");
            imprimirMensagens(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void imprimirMensagens(PrintWriter out) {
        sala.historico().forEach(m -> out.println("<p>"+m+"</p>"));
    }

}
