package exemple;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

public class ConnectDB {
	public static void main(String[] args) throws Exception {

		Class.forName("org.h2.Driver");
		String url = "jdbc:h2:/Users/caspary5/eclipse-workspace-2023-03/H2_SecurePassword/data/DB_simple";
		String user = "sam";
		char[] pwd = { 't', 'i', 'a', 'E', 'T', 'r', 'p' };

		Properties prop = new Properties();
		prop.setProperty("user", "sam");
		prop.put("password", pwd);

		try {
			// Connection conn = null;
			Connection conn = DriverManager.getConnection(url, prop);

			Statement stat = conn.createStatement();
			stat.execute("drop table account if exists");
			stat.execute("create table account(" + "name varchar primary key, "
					+ "salt binary default secure_rand(10), " + "hash binary)");

			PreparedStatement prep;
			prep = conn.prepareStatement("insert into account(name) values(?)");
			prep.setString(1, "Toto");
			prep.execute();
			prep.close();

			System.out.println("Connected to H2 embedded database.");
			conn.close();
		} finally {
			Arrays.fill(pwd, (char) 0);
		}
		System.out.println("Connexion close");
	}
}