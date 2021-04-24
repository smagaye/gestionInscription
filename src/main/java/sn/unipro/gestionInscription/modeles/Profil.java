package sn.unipro.gestionInscription.modeles;

public enum Profil {
	ETUDIANT("etudiant"), ADMIN("admin");

	private final String code;

	Profil(String code) {
		this.code = code;
	}

	public static Profil fromCode(String code) {
		code = code.toLowerCase();
		if ("etudiant".equals(code) || "etu".equals(code)) {
			return ETUDIANT;
		}
		if ("admin".equals(code) || "adm".equals(code)) {
			return ADMIN;
		}
		throw new UnsupportedOperationException("The code " + code + " is not supported!");

	}

	public String getCode() {
		return code;
	}

}
