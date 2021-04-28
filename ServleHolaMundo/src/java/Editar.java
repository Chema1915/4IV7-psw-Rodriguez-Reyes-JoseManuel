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
public class Editar extends HttpServlet {
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
            out.println("<title>Servlet Editar</title>"
                    + "<link rel=stylesheet href=CSS/Registros.css\">"
                    + " <script>" +
"window.onload = function() {" +
"  var myInput = document.getElementById('bloquear');" +
"  myInput.onpaste = function(e) {" +
"    e.preventDefault();" +
"   " +
"  };" +
"" +
"  myInput.oncopy = function(e) {" +
"    e.preventDefault();" +
"   " +
"  };" +
"}" +
"" +
" " +
"</script>");
                      
            out.println("</head>");
           out.println("<body ondragstart='return false' oncontextmenu='return false' id= bloquear style='width:100% overflow-x:hidden;" +
"    background-color: whitesmoke;font-family: Roboto, sans-serif;font-size:20px; '>");
                 
           try{
           
                 String nom, appat, appmat, correo,q;
            int edad, id;
             id = Integer.parseInt(request.getParameter("ideditar"));
          
            
               q = "select * from mregistro where id_usu="+id;
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                 int count=0;
              while(rs.next()){
                       count=rs.getRow();
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    appmat = rs.getString("appmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("email_usu");
                    out.println("<center><h1  style='margin-top: 12%;' >-Actualizacion de Datos-</h1></center><center><div style='background-color: darkgray;\n" +
"    width: 28%;\n" +
"    font-size: 18px;\n" +
"    padding: 1.2%;  \n" +

"   border-radius: 7%;'>" +

"            <center><div style='background-color:gainsboro;\n" +
"    border-radius: 6%;'>" +
"            <center><div style='padding: 2%;'>"
                            
                            + "<form name=edit  method=post action=EditarF >"
                            + "<label>"
                            + "ID :"
                            + "</label>"
                            + "<input type=number name=ids readonly=readonly style=' font-size: 16px'  value="+id
                            + "><br>"
                            + "<label>"
                            + "Nombre:"
                            + "</label>"
                            + "<input type=text name=nombres autocomplete=off  style=' font-size: 16px' required    onkeypress='return (event.charCode == 32  || event.charCode == 209 || event.charCode == 241 || (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122))' value="+ nom
                            +"><br>"
                              + "<label>"
                            + "Apellido Paterno:"
                            + "</label>"
                            + "<input type=text name=apellidops autocomplete=off style=' font-size: 16px' onkeypress='return (event.charCode == 32  || event.charCode == 209 || event.charCode == 241 || (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122))' value="+appat
                             +"><br>"
                            + "<label>"
                            + "Apellido Materno:"
                            + "</label>"
                            + "<input type=text name=apellidoms autocomplete=off style=' font-size: 16px'  onkeypress='return (event.charCode == 32  || event.charCode == 209 || event.charCode == 241 || (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122))' value="+appmat
                            +"><br>"
                              + "<label>"
                            + "Edad:"
                            + "</label>"
                            + "<input type=number name=edads autocomplete=off style=' font-size: 16px'  min=01 max=99 onkeypress='return(event.charCode >= 48 && event.charCode <= 57)' required value="+edad
                            +"><br>"
                              + "<label>"
                            + "Correo:"
                            + "</label>"
                            + "<input type=email name=correos size= 25  style=' font-size: 16px'  autocomplete=off required onkeypress='return(event.charCode != 60 && event.charCode != 62  )' value="+correo
                            +"><br>"
                            + "<input type=submit class=button value=Editar style='font-size: 17px;    \n" +
"margin-top: 4px;\n" +
"border-color: white;'>"
                             + "</form>"
                                    + "</div></center>"
                                    + "</div></center>"
                                    + "</div></center>");
              }
              
              if(count== 0){
                  out.println("<center><h1 style='padding-top:17%;' >No Existe ese Usuario</h1></center>");
                  
              }
                 
                         
                       
                             
                      
                           
                

            }catch(Exception SQLException){
                
                System.out.println( SQLException.getMessage());
                System.out.println( SQLException.getStackTrace());
            
            }

            out.println("<br><center><a href='index.html'>Regresar al Formulario</a></center>");
                    
           
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
