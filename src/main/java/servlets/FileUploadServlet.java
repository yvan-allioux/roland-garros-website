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
        OutputStream outputStream = new FileOutputStream(new File("" + fileName));
        int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = fileContent.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        // Close the streams
        outputStream.close();
        fileContent.close();

        // Redirect the user to the success page
        //response.sendRedirect("success.jsp");

    }

}