package exemple;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

// https://www.geeketfier.fr/2012/08/29/exemple-de-stockage-de-mot-de-passe-en-java-hashage-et-salage-est-ce-suffisant/
// Lien : https://www.bcrypt.fr/questions
// Lien : https://github.com/patrickfav/bcrypt 
// Last version : https://jar-download.com/artifacts/de.svenkubiak/jBCrypt/0.4.3

public class SecureJbcrypt {

	public static void main(String args[]) throws Exception {

		String password = "secret";
		String val_name = "";
		String val_hash = "";

		// Hashage d'un mot de passe
		// String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

		// Il est possible d'augmenter la complexité (et donc le temps
		// de traitement) en passant le "workfactor" en paramètre
		// ici : 14 La valeur par défaut est 10
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(14));

		// Vérification d'un mot de passe à partir du hash
		if (BCrypt.checkpw("secret", hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");

		// --------------------------------------------------------------
		// Connexion à la Database H2 :

		Class.forName("org.h2.Driver");
		// String url = "jdbc:h2:data/simple";
		String DB_url = "jdbc:h2:/Users/caspary5/eclipse-workspace-2023-03/H2_SecurePassword/data/DB_simple";
		String DB_user = "sam";
		char[] DB_pwd = { 't', 'i', 'a', 'E', 'T', 'r', 'p' };

		// This is the normal, but 'unsafe' way to connect:
		// the password may reside in the main memory for an undefined time,
		// or even written to disk (swap file):
		// Connection conn =
		// DriverManager.getConnection(url, user, new String(password));

		// This is the most safe way to connect: the password is overwritten
		// after use
		Properties prop = new Properties();
		prop.setProperty("user", DB_user);
		prop.put("password", DB_pwd);
		Connection conn = DriverManager.getConnection(DB_url, prop);

		// For security reasons, account passwords should not be stored directly
		// in a database. Instead, only the hash should be stored. Also,
		// PreparedStatements must be used to avoid SQL injection:
		Statement stat = conn.createStatement();
		stat.execute("drop table account if exists");
		stat.execute("create table account(" + "name varchar primary key, " + "hash varchar)");
		PreparedStatement prep;
		prep = conn.prepareStatement("insert into account values(?,?)");
		prep.setString(1, "Toto");
		prep.setString(2, hashed);
		prep.execute();
		prep.close();

		prep = conn.prepareStatement("select * from account " + "where name=?");
		prep.setString(1, "Toto");

		ResultSet rs = prep.executeQuery();

		// Valable pour une seule valeur (sinon prévoir un tableau) :
		while (rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("hash"));
			val_name = rs.getString("name");
			val_hash = rs.getString("hash");
		}
		rs.close();
		prep.close();
		stat.close();
		conn.close();

		// Vérifie "secret" sous la forme "hashed" de la BDD :
		if (BCrypt.checkpw("secret", val_hash))
			System.out.println("It matches good");
		else
			System.out.println("It does not match");

	}

}