package sn.unipro.gestionInscription.modeles;

public enum Profil {
	ETUIDIANT("etudiant"), ADMIN("admin");

	private final String code;

	Profil(String code) {
		this.code = code;
	}

	public static Profil fromCode(String code) {
		code = code.toLowerCase();
		if ("etudiant".equals(code)) {
			return ADMIN;
		}
		if ("admin".equals(code)) {
			return ETUIDIANT;
		}
		throw new UnsupportedOperationException("The code " + code + " is not supported!");

	}

	public String getCode() {
		return code;
	}

}
