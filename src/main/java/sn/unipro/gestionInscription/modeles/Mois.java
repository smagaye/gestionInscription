package sn.unipro.gestionInscription.modeles;

public enum Mois {
	JANVIER("JANVIER"), FEVRIER("FEVRIER"), MARS("MARS"), AVRIL("AVRIL"), MAI("MAI"), JUIN("JUIN"), JUILLET("JUILLET"),
	AOUT("AOUT"), SEPTEMBRE("SEPTEMBRE"), OCTOBRE("OCTOBRE"), NOVEMBRE("NOVEMBRE"), DECEMBRE("DECEMBRE");

	private final String code;

	Mois(String code) {
		this.code = code;
	}

	public static Mois fromCode(String code) {
		code = code.toLowerCase();
		if (code.equals("janvier") || code.equals("jan") || code.equals("01") || code.equals("1")) {
			return JANVIER;
		}
		if (code.equals("février") || code.equals("fevrier") || code.equals("fév") || code.equals("fev")
				|| code.equals("02") || code.equals("2")) {
			return FEVRIER;
		}
		if (code.equals("mars") || code.equals("mar") || code.equals("03") || code.equals("3")) {
			return MARS;
		}
		if (code.equals("avril") || code.equals("avr") || code.equals("04") || code.equals("4")) {
			return AVRIL;
		}
		if (code.equals("mai") || code.equals("mai") || code.equals("05") || code.equals("5")) {
			return MAI;
		}
		if (code.equals("juin") || code.equals("jui") || code.equals("06") || code.equals("6")) {
			return JUIN;
		}
		if (code.equals("JUILLET") || code.equals("juil") || code.equals("07") || code.equals("7")) {
			return JUILLET;
		}
		if (code.equals("août") || code.equals("aout") || code.equals("aoûs") || code.equals("aou") || code.equals("08") || code.equals("8")) {
			return AOUT;
		}
		if (code.equals("septembre") || code.equals("sep") || code.equals("09") || code.equals("9")) {
			return SEPTEMBRE;
		}
		if (code.equals("OCTOBRE") || code.equals("oct") || code.equals("10") || code.equals("10")) {
			return OCTOBRE;
		}
		if (code.equals("novembre") || code.equals("nov") || code.equals("11") || code.equals("11")) {
			return NOVEMBRE;
		}
		if (code.equals("décembre") || code.equals("decembre") || code.equals("déc") || code.equals("dec")
				|| code.equals("12") || code.equals("12")) {
			return DECEMBRE;
		}
		throw new UnsupportedOperationException("The code " + code + " is not supported!");
	}

	public String getCode() {
		return code;
	}

}
