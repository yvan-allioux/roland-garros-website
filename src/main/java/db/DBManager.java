package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;


public class DBManager {

	// TODO : A suprimer c'est pas fou d'avoir ça ici vaux mieux le mettre dans un fichier de config
	private String JDBC_URL="jdbc:mysql://vps817240.ovh.net:3306/IMR_team03_schema?allowPublicKeyRetrieval=true&useSSL=false";
	private String DB_LOGIN= "IMR_team03";
	private String DB_PASSWORD="7KFJDo;tN1";
	private String DB_DRIVER="com.mysql.cj.jdbc.Driver";

	private static DBManager instance;

	private ResourceBundle properties;

	private static String resourceBundle = "config";

	private DBManager() {
		//properties = ResourceBundle.getBundle(resourceBundle);

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static DBManager getInstance() {
		if (instance == null) {
			synchronized (DBManager.class) {
				instance = new DBManager();
			}
		}
		return instance;
	}

	public Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL,DB_LOGIN,
					DB_PASSWORD);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;

	}

	public void cleanup(Connection connection, Statement stat, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * permet de tester la connexion à la DB
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Connection c = DBManager.getInstance().getConnection();
		if (c != null) {
			try {
				System.out.println("Connection to db : " + c.getCatalog());
				Properties p = c.getClientInfo();
				Enumeration<Object> keys = p.keys();
				while (keys.hasMoreElements()) {
					String key = (String) keys.nextElement();
					System.out.println(key + ":" + p.getProperty(key));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.getInstance().cleanup(c, null, null);
			}
		}
	}
}