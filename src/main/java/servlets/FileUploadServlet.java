package servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUploadServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get the file chosen by the user
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        // Write the file to the server
        InputStream fileContent = filePart.getInputStream();
        //afiicher le contenu du fichier
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String str = line;
            String[] res = str.split("[,]", 0);
            for(String myStr: res) {
                System.out.println(myStr);
            }
        }


        //close the stream
        fileContent.close();

        //redirection vers la liste des joueurs
        response.sendRedirect("/joueurs/editer");


    }

}