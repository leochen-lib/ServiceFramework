package fw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jlib.util.ALHM;
import static jlib.tool.TooletStatic.list2json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leo
 */
public abstract class ControllerBase extends HttpServlet {
    protected String TAG = ControllerBase.class.getName();
    protected String contextPath = null;
    
    private void jsonBase(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            out.print(list2json((ALHM) jsonAction(request, response)).toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    protected abstract List jsonAction(HttpServletRequest request, HttpServletResponse response);

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
        jsonBase(request, response);
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
        jsonBase(request, response);
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
