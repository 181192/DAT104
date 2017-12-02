package no.kalli.controller;

import no.kalli.model.Klasse;
import no.kalli.model.Student;
import no.kalli.util.InnloggingUtil;
import no.kalli.util.PassordUtil;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static no.kalli.util.PassordUtil.hashPassord;

public class InnloggingValidator {

        private String id;
        private String navn;
        private String salt;
        private Klasse klasseKode;
        private String passord;
        private Student student;

        private String idFeilmelding;
        private String navnFeilmelding;
        private String klasseKodeFeilmelding;
        private String passordFeilmelding;

        public InnloggingValidator(HttpServletRequest request) {

           id = request.getParameter("id");
           navn = request.getParameter("navn");
           salt = request.getParameter("salt");
           passord = request.getParameter("passord");
        }

    private boolean erIdGyldig() {
        return id != null && !id.equals("");
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

    private boolean erHashet() { return hashPassord(passord, salt) !=null; }

    public boolean erAlleDataGyldig() {
        return erNavnGyldig() && erKlassekodeGyldig() && erPassordGyldig() && erIdGyldig() && erHashet();
    }

    public void settOppFeilmeldinger(HttpServletRequest request) {
        if (!erIdGyldig()) {
            id = "";
            id = "Studentnummer er ikke gyldig";
        }

        if (!erNavnGyldig()) {
            navn = "";
            navnFeilmelding = "Navn er ikke gyldig";
        }
        if (!erKlassekodeGyldig()) {
            klasseKode = null;
            klasseKodeFeilmelding = "Klassekoden er ikke gyldig";
        }
        if (!erPassordGyldig()) {
            passord = "";
            passordFeilmelding = "Passord er ikke gyldig";
        }
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFeilmelding() {
        return idFeilmelding;
    }

    public void setIdFeilmelding(String idFeilmelding) {
        this.idFeilmelding = idFeilmelding;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Klasse getKlasseKode() {
        return klasseKode;
    }

    public void setKlasseKode(Klasse klasseKode) {
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

    public Student getStudent() { return student; }

    public void setStudent(Student student) {this.student = student;}

}
