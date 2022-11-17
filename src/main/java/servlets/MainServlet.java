package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("Hello World !  SERVLET MAIN");*/
    	
    	 String pageName = "/index.jsp";
         RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
         
         try {
             rd.forward(req, resp);

       } catch (ServletException e) {

             e.printStackTrace();

       } catch (IOException e) {

             e.printStackTrace();
       }

    }
}

