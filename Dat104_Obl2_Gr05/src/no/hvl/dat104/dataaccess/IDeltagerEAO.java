/**
 * 
 */
package no.hvl.dat104.dataaccess;

import java.util.List;

import no.hvl.dat104.model.DeltagerEntity;

/**
 * @author krist
 *
 */
public interface IDeltagerEAO {
	/**
	 * Legger til en deltager
	 * 
	 * @param d
	 *            Deltager
	 */
	public void leggTilDeltager(DeltagerEntity d);

	/**
	 * Finner en deltager basert på id, som er nummeret til deltageren
	 * 
	 * @param id
	 *            nummeret
	 * @return
	 */
	public DeltagerEntity finnDeltager(Integer id);

	/**
	 * Oppdaterer en deltager
	 * 
	 * @param d
	 *            Deltager
	 */
	public void oppdaterDeltager(DeltagerEntity d);

	/**
	 * Sletter en deltager
	 * 
	 * @param d
	 *            Deltager
	 */
	public void slettDeltager(DeltagerEntity d);

	/**
	 * Returnerer en liste med alle deltagerne
	 * 
	 * @return Alle deltagerne
	 */
	public List<DeltagerEntity> alleDeltagere();

}
