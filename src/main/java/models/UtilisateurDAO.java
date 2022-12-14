package models;

public interface UtilisateurDAO {
    public boolean checkLogin(String login, String password);
    public boolean utilisateurExiste(String login);
    public char getRole(String login);
    public String getPassewordDataBase(String login);
}
