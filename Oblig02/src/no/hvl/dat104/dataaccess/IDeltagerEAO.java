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
	public void leggTilDeltager(DeltagerEntity d);

	public DeltagerEntity finnDeltager(Integer id);

	public void oppdaterDeltager(DeltagerEntity d);

	public void slettDeltager(DeltagerEntity d);

	public List<DeltagerEntity> alleDeltagere();

}
