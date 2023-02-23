package nata;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user="hbcustomer";
        String pass="hbcustomer";
        String jdbcUrl="jdbc:postgresql://localhost:5432/hbcustomer?useSSL=false&amp;serverTimezone=UTC";
        String driver="org.postgresql.Driver";

        try{
            System.out.println("Start");
            PrintWriter out=response.getWriter();
            out.println("Connected to database"+ jdbcUrl);

            Class.forName(driver);
            Connection myConn= DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("Conntion succesful");
            System.out.println("Success");
            myConn.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }


}
