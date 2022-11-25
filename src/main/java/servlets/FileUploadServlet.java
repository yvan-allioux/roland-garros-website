package servlets;

import java.io.*;

import classes.Joueur;
import models.JoueurDAOimpl;
import models.EntraineurDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUploadServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //init obj
        EntraineurDAOimpl entraineurDAO = new EntraineurDAOimpl();


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
            String date_naissance = res[0];
            //parse date
            LocalDate date_naissancePars = LocalDate.parse(date_naissance);
            String lieu_naissance = res[1];
            String nationalite = res[2];
            String taille = res[3];
            String poids = res[4];
            String classement_simple = res[5];
            String sexe = res[6];
            String main = res[7];
            String date_debut_carriere = res[8];
            //parse date
            LocalDate date_debut_carrierePars = LocalDate.parse(date_debut_carriere);
            String nom = res[9];
            String prenom = res[10];
            String id_entraineur = res[11];

            Joueur joueur = new Joueur(nom,prenom,sexe,entraineurDAO.getEntraineurById(Integer.parseInt(id_entraineur)),date_naissancePars,lieu_naissance,nationalite,Integer.parseInt(taille),Integer.parseInt(poids),main,date_debut_carrierePars);
            JoueurDAOimpl joueurImpl = new JoueurDAOimpl();
            joueurImpl.createJoueur(joueur);
        }



        //close the stream
        fileContent.close();

        //redirection vers la liste des joueurs
        response.sendRedirect("/joueurs/editer");


    }

}