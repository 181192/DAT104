package no.kalli.controller;

import javax.servlet.http.HttpServletRequest;

public class RegistrerStudentValidator {
    private String navn;
    private String klasseKode;
    private String passord;
    private String salt;

    private String navnFeilmelding;
    private String klasseKodeFeilmelding;
    private String passordFeilmelding;

    public RegistrerStudentValidator(HttpServletRequest request) {
        navn = request.getParameter("navn");
        klasseKode = request.getParameter("klassekode");
        passord = request.getParameter("passord");
        salt = request.getParameter("salt");
    }

    private boolean erNavnGyldig() {
        return navn != null && !navn.equals("");
    }

    private boolean erKlassekodeGyldig() {
        return klasseKode != null && !navn.equals("");
    }

    private boolean erPassordGyldig() {
        return passord != null && !passord.equals("");
    }

    public boolean erAlleDataGyldig() {
        return erNavnGyldig() && erKlassekodeGyldig() && erPassordGyldig();
    }

    public void settOppFeilmeldinger(HttpServletRequest request) {

        if (!erNavnGyldig()) {
            navn = "";
            navnFeilmelding = "Navn er ikke gyldig";
        }
        if (!erKlassekodeGyldig()) {
            klasseKode = "";
            klasseKodeFeilmelding = "Mailadressen er ikke gyldig";
        }
        if (!erPassordGyldig()) {
            passord = "";
            passordFeilmelding = "Passord er ikke gyldig";
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKlasseKode() {
        return klasseKode;
    }

    public void setKlasseKode(String klasseKode) {
        this.klasseKode = klasseKode;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNavnFeilmelding() {
        return navnFeilmelding;
    }

    public void setNavnFeilmelding(String navnFeilmelding) {
        this.navnFeilmelding = navnFeilmelding;
    }

    public String getKlasseKodeFeilmelding() {
        return klasseKodeFeilmelding;
    }

    public void setKlasseKodeFeilmelding(String klasseKodeFeilmelding) {
        this.klasseKodeFeilmelding = klasseKodeFeilmelding;
    }

    public String getPassordFeilmelding() {
        return passordFeilmelding;
    }

    public void setPassordFeilmelding(String passordFeilmelding) {
        this.passordFeilmelding = passordFeilmelding;
    }
}
