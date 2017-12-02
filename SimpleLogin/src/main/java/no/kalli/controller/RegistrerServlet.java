package no.kalli.controller;

import no.kalli.JspMapping;
import no.kalli.UrlMapping;
import no.kalli.dataaccess.KlasseEAO;
import no.kalli.dataaccess.StudentEAO;
import no.kalli.model.Klasse;
import no.kalli.model.Student;
import no.kalli.util.FlashUtil;
import no.kalli.util.PassordUtil;

import javax.ejb.EJB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class RegistrerServlet extends javax.servlet.http.HttpServlet {
    @EJB
    private StudentEAO studentEAO;
    @EJB
    private KlasseEAO klasseEAO;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RegistrerStudentValidator skjema = new RegistrerStudentValidator(request);
        if (skjema.erAlleDataGyldig()) {
            Student s = new Student();
            s.setId(skjema.getId());
            s.setNavn(skjema.getNavn());
            setOppSalt(s);
            String passord = PassordUtil.hashPassord(skjema.getPassord(), s.getSalt());
            s.setPassord(passord);
            studentEAO.leggTilStudent(s, skjema.getKlasseKode());
        } else {
            skjema.settOppFeilmeldinger(request);
            FlashUtil.Flash(request, "error", "Ugyldig input");
            request.getSession().setAttribute("registrerStudentSkjema", skjema);
            response.sendRedirect(UrlMapping.REGISTRER_URL);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Klasse> klasser = klasseEAO.alleKlasser();
        if (klasser == null) {
            FlashUtil.Flash(request, "error", "Beklager, ingen klasser");
        }
        request.setAttribute("klasser", klasser);
        request.getRequestDispatcher(JspMapping.REGISTRER_JSP).forward(request, response);
    }

    public void setOppSalt(Student s) {
        try {
            byte[] salt = PassordUtil.getSalt();
            s.setSalt(Arrays.toString(salt));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
