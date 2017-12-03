package no.kalli;

import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpSession;
import org.junit.Test;


import static no.kalli.util.InnloggingUtil.erInnlogget;
import static no.kalli.util.InnloggingUtil.loggUt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class InnloggingUtilTest {

    private MockHttpServletRequest fakeRequest = new MockHttpServletRequest();
    private MockHttpSession fakeSession = new MockHttpSession();


    @Test
    public void brukerUtenSesssionSkalIkkeVareInnlogget(){
        fakeRequest.setHttpSession(null);
        assertFalse(erInnlogget(fakeRequest));
    }

    @Test
    public void brukerSomIkkeerInnloggetISessionSkalIkkeVareInnlogget(){
        fakeRequest.setHttpSession(fakeSession);
        assertFalse(erInnlogget(fakeRequest));
    }




}
