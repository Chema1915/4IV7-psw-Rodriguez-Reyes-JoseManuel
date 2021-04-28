/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
public class EditarF extends HttpServlet {
 private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //vamos a crear el metodo constructor
    
    public void init(ServletConfig cfg) throws ServletException{
        //para conectarnos con la bd
        String url = "jdbc:mysql://localhost/registro4iv7";
                    //driver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "jose2015";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            /*
            a veces el driver ya maneja por defecto el puerto de comunicacion
            es por ello que pueden mandar un error, en ese caso
            url = "jdbc:mysql://localhost/registro4iv7";
            */
            url = "jdbc:mysql://localhost/registro4iv7";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Se ha conectado a la BD");
        
        }catch(Exception e ){
            System.out.println("No se ha conectado a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editar</title>");            
            out.println("</head>");
           out.println("<body  ondragstart='return false' oncontextmenu='return false' id= bloquear style='width:100% overflow-x:hidden;" +
"    background-color: whitesmoke;font-family: Roboto, sans-serif;font-size:20px; '>");
                 
           try{
                String nom,appat,appmat,correo;
                int edad,id;
                nom = request.getParameter("nombres");
                
                appat = request.getParameter("apellidops");
                appmat = request.getParameter("apellidoms");
                correo = request.getParameter("correos");
                edad = Integer.parseInt(request.getParameter("edads"));
                id = Integer.parseInt(request.getParameter("ids"));
                
                out.println("<center><div style='margin-top:8%;'><div ><br><h1>-Datos actualizados-</h1>Tu id es: "+id
                +"<br>");
                
                  out.println("Tu nombre es: "+nom
                  +"<br>");
                    out.println("Tu Apellido Paterno es: "+appat
                            +"<br>");
                      out.println("Tu Apellido Materno es: "+appmat
                              +"<br>");
                        out.println("Tu Edad es: "+edad
                                +"<br>");
                          out.println("Tu Correo es: "+correo
                          +"</div>");
                        
                      
                    

           
           String q= " UPDATE mregistro SET appat_usu='"+appat+"',appmat_usu='"+appmat+"',nom_usu='"+nom+"',edad_usu="+edad+""
                   + ",email_usu='"+correo+"'WHERE id_usu="+id;
            set.executeUpdate(q);
            
            
            System.out.println("Datos actualizados en la tabla");
           
                             
                      
                           
                

            }catch(Exception e){
               out.println("No se pudo actualizar los datos ");
                System.out.println( e.getMessage());
                System.out.println( e.getStackTrace());
            
            }

            out.println("<center><div><br><a href='index.html'>Regresar al Formulario</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar la Tabla General de Usuarios</a></div></div></center>");
            out.println("</body>");
            out.println("</html>");
        }
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
