/**
 * 
 */
package no.hvl.dat104.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author krist
 *
 */
public class ValidatorTest {

	private String f0 = "kristoffer";
	private String f1 = "Kristoffer";
	private String f2 = "KristoffeR";
	private String f3 = "KRISTOFFER";
	private String f4 = "Kristoffer-Andre";
	private String f5 = "Kristoffer Andre";

	private String e0 = "kalliainen";
	private String e1 = "Kalliainen";
	private String e2 = "KalliaineN";
	private String e3 = "KALLIAINEN";
	private String e4 = "Bakkland Kalliainen";
	private String e5 = "Bakkland-Kalliainen";

	private String d0 = "D";
	private String d1 = "Du";
	private String d2 = "Dummydummydummydummy";
	private String d3 = "Dummydummydummydummydummy";

	private String n0 = "98684488";
	private String n1 = "9-8-6-4-";
	private String n2 = "9a8a6a4a";
	private String n3 = "123456781";

	// TODO Lage en metode for hver test...
	
	@Test
	public void testFornavn() {
		assertFalse(ValideringUtil.validerFornavn(f0));
		assertTrue(ValideringUtil.validerFornavn(f1));
		assertFalse(ValideringUtil.validerFornavn(f2));
		assertFalse(ValideringUtil.validerFornavn(f3));
		assertTrue(ValideringUtil.validerFornavn(f4));
		assertTrue(ValideringUtil.validerFornavn(f5));
		assertFalse(ValideringUtil.validerFornavn(d0));
		assertTrue(ValideringUtil.validerFornavn(d1));
		assertTrue(ValideringUtil.validerFornavn(d2));
		assertFalse(ValideringUtil.validerFornavn(d3));

	}

	@Test
	public void testEtternavn() {
		assertFalse(ValideringUtil.validerEtternavn(e0));
		assertTrue(ValideringUtil.validerEtternavn(e1));
		assertFalse(ValideringUtil.validerEtternavn(e2));
		assertFalse(ValideringUtil.validerEtternavn(e3));
		assertFalse(ValideringUtil.validerEtternavn(e4));
		assertTrue(ValideringUtil.validerEtternavn(e5));
		assertFalse(ValideringUtil.validerEtternavn(d0));
		assertTrue(ValideringUtil.validerEtternavn(d1));
		assertTrue(ValideringUtil.validerEtternavn(d2));
		assertFalse(ValideringUtil.validerEtternavn(d3));
	}

	@Test
	public void testNummer() {
		assertTrue(ValideringUtil.validerNummer(n0));
		assertFalse(ValideringUtil.validerNummer(n1));
		assertFalse(ValideringUtil.validerNummer(n2));
		assertFalse(ValideringUtil.validerNummer(n3));
	}

}
