package no.hvl.dat104.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Hentet fra Peder Aalen:
 * https://github.com/181221/dat104/blob/master/obligs/ob2/src/no/pederyo/utils/SjekkOpplysninger.java
 * 
 */
public class RegistrerUtil {
	private static final String FEIL_FORNAVN = "Fornavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) bindestrek og mellomrom. Første tegn skal være en stor bokstav.";
	private static final String FEIL_ETTERNAVN = "Etternavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og bindestrek (IKKE mellomrom). Første tegn skal være en stor bokstav.";
	private static final String FEIL_MOBIL = "Mobil skal være eksakt 8 siffer";

	private static boolean sjekkParams(String type, String param) {
		switch (type) {
		case "fornavn":
			return ValideringUtil.validerFornavn(param);
		case "etternavn":
			return ValideringUtil.validerEtternavn(param);
		case "mobil":
			return ValideringUtil.validerNummer(param);
		}
		return false;
	}

	public static void sjekkCookies(List<Cookie> cookies, HttpServletRequest request) {
		HashMap<String, String> feilmeldinger = new HashMap<>();
		String[] meldinger = { FEIL_FORNAVN, FEIL_ETTERNAVN, FEIL_MOBIL };
		for (int i = 0; i < cookies.size() - 1; i++) {
			String navn = cookies.get(i).getName();
			String verdi = cookies.get(i).getValue();
			if (!sjekkParams(navn, verdi)) {
				feilmeldinger.put(navn, meldinger[i]);
			}
		}
		request.getSession().setAttribute("feilmeldinger", feilmeldinger);
	}

	public static List<Cookie> hentPersonOpplysninger(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> k = request.getParameterNames();
		List<Cookie> cookies = new ArrayList<>();
		while (k.hasMoreElements()) {
			String param = k.nextElement();
			Cookie ny = new Cookie(param, request.getParameter(param));
			response.addCookie(ny);
			cookies.add(ny);
		}
		return cookies;
	}

	@SuppressWarnings("unchecked")
	public static void setUpfeilMeldinger(HttpServletRequest request) {
		HashMap<String, String> feil = (HashMap<String, String>) request.getSession().getAttribute("feilmeldinger");
		if (feil != null) {
			String feilfornavn = feil.get("fornavn");
			String feiletternavn = feil.get("etternavn");
			String feilmobil = feil.get("mobil");
			request.getSession().setAttribute("feilfornavn", feilfornavn);
			request.getSession().setAttribute("feiletternavn", feiletternavn);
			request.getSession().setAttribute("feilmobil", feilmobil);
		}
	}

	public static void setUpCookiesTilRequest(HttpServletRequest request) {
		String fornavn = CookieUtil.getCookieValue(request, "fornavn");
		String etternavn = CookieUtil.getCookieValue(request, "etternavn");
		String mobil = CookieUtil.getCookieValue(request, "mobil");
		request.getSession().setAttribute("fornavn", fornavn);
		request.getSession().setAttribute("etternavn", etternavn);
		request.getSession().setAttribute("mobil", mobil);
	}

}
