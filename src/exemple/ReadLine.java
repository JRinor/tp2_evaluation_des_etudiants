package exemple;
// Lien : https://www.javatpoint.com/java-console-readpassword-method 
// Exécuter le fichier en ligne de commandes (pas de sortie console sous Eclipse) 
// Commande : java ReadLine.java

import java.io.Console;

class ReadLine {
	public static void main(String args[]) {
		String str;
		// Obtaining a reference to the console.
		Console con = System.console();
		// Checking If there is no console available, then exit.
		if (con == null) {
			System.out.print("No console available");
			return;
		}
		//
		// Read a string and then display it.
		str = con.readLine("Enter your name: ");
		con.printf("Your name is: %s\n", str);

		// to read password and then display it
		System.out.println("Enter the password: ");
		char[] ch = con.readPassword();
		// converting char array into string
		String pass = String.valueOf(ch);
		System.out.println("Your Password is: " + pass);
	}
}