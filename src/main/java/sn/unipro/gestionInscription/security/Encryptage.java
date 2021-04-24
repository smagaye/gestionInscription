package sn.unipro.gestionInscription.security;

import org.mindrot.jbcrypt.BCrypt;

public class Encryptage {

	public static String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public static boolean checkPass(String plainPassword, String hashedPassword) {
		boolean isValid = false;
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			System.out.println("The password matches.");
			isValid =  true;
		}
		return isValid;
	}

}
