package com.Vlxdy.controlador;

import com.Vlxdy.modelo.GestorProductos;
import com.Vlxdy.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vlxdy Hishikawa
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Productos objProductos = new Productos();
        int id;
        int pos;
        String op = request.getParameter("op");
        
        if (op.equals("nuevo")){
            HttpSession ses = request.getSession();   
            GestorProductos stock = (GestorProductos) ses.getAttribute("stock");
            objProductos.setId(stock.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("ListProducto",objProductos);
            request.getRequestDispatcher("Editar.jsp").forward(request, response);
        }
        if (op.equals("modificar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();   
            GestorProductos stock = (GestorProductos) ses.getAttribute("stock");
            pos = stock.ubicarProductos(id);
            objProductos = stock.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("ListProducto",objProductos);
            request.getRequestDispatcher("Editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();   
            GestorProductos stock = (GestorProductos) ses.getAttribute("stock");
            pos = stock.ubicarProductos(id);
            stock.eliminarProductos(pos);
            ses.setAttribute("stock", stock);
            response.sendRedirect("Index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Productos objProductos=new Productos();
        int pos;
        String op=request.getParameter("op");
        if (op.equals("grabar")){
            objProductos.setId(Integer.parseInt(request.getParameter("id")));
            objProductos.setProducto(request.getParameter("producto"));
            objProductos.setPrecio(Double.parseDouble(request.getParameter("precio")));
            objProductos.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            
            HttpSession ses = request.getSession();   
            GestorProductos stock = (GestorProductos) ses.getAttribute("stock");
            
            String opg = request.getParameter("opg");
            if (opg.equals("nuevo")){
                stock.insertarProductos(objProductos);  
            }
            else{
                pos = stock.ubicarProductos(objProductos.getId());
                stock.modificarProductos(pos, objProductos);
            }
            ses.setAttribute("stock", stock);
            response.sendRedirect("Index.jsp");
        }
    }
}    