/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext.Alumno;
import pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext.DatosProfesor;
import pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext.Profesor;
import pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext.Requerimiento;
import pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext.Respuesta;
import pe.edu.cibertec.javaarq.mod1lab3.tools.JAXB;
import pe.edu.cibertec.javaarq.mod1lab3.tools.Serializer;

/**
 *
 * @author user
 */
@WebServlet(name = "profesor", urlPatterns = {"/profesor"})
public class ProfesorServlet extends HttpServlet {

    @Inject
    @JAXB
    private Serializer ser;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/xml;charset=UTF-8");
        try (PrintWriter out = response.getWriter(); InputStream in = request.getInputStream()) {
            switch (request.getMethod()) {
                case "GET": {
                    //buscar un profesor o la lista de profesores
                    Respuesta respuesta = new Respuesta(true, null);
                    respuesta.setDatos(new DatosProfesor(getProfesor()));
                    ser.marshall(respuesta, out);
                }
                break;
                case "PUT": {
                    Requerimiento requerimiento = (Requerimiento) ser.unmarshall(in);
                    Logger.getAnonymousLogger().log(Level.INFO, requerimiento.toString());
                }
                break;
                default:
                    response.setStatus(500);
                    Respuesta respuesta = new Respuesta(false, "Metodo no reconocido");
                    ser.marshall(respuesta, out);
                    break;
            }
            out.flush();
        }
    }

    private Profesor getProfesor() {
        Profesor profesor = new Profesor();
        profesor.setCodigo(20020317);
        profesor.setNombre("Carlos");
        profesor.setApellido("Echeverría");
        profesor.setFechaDeIngreso(new Date());
        profesor.setAlumnos(new ArrayList<Alumno>());

        profesor.getAlumnos().add(new Alumno("Amador", "Cabellos"));
        profesor.getAlumnos().add(new Alumno("Martin", "Calagua"));

        return profesor;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
