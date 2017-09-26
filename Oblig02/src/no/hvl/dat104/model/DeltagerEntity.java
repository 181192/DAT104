/**
 * 
 */
package no.hvl.dat104.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author krist
 *
 */
@Entity(name = "DeltagerEntity")
@Table(name = "deltager", schema = "fest", catalog = "DAT104")
public class DeltagerEntity {

	@Id
	private Integer mobil;
	
	private String fornavn;
	private String etternavn;

	@Column(name = "er_mann")
	private Boolean erMann;

	@Column(name = "har_betalt")
	private Boolean harBetalt;

	@Column(name = "er_kasserer")
	private Boolean erKasserer;

	/**
	 * 
	 */
	public DeltagerEntity() {
		this(0, "", "", false, false, false);
	}

	/**
	 * @param mobil
	 * @param fornavn
	 * @param etternavn
	 * @param erMann
	 * @param harBetalt
	 * @param erKasserer
	 */
	public DeltagerEntity(Integer mobil, String fornavn, String etternavn, Boolean erMann, Boolean harBetalt,
			Boolean erKasserer) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.erMann = erMann;
		this.harBetalt = harBetalt;
		this.erKasserer = erKasserer;
	}

	/**
	 * @return the mobil
	 */
	public Integer getMobil() {
		return mobil;
	}

	/**
	 * @param mobil the mobil to set
	 */
	public void setMobil(Integer mobil) {
		this.mobil = mobil;
	}

	/**
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * @param fornavn the fornavn to set
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	/**
	 * @return the etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * @param etternavn the etternavn to set
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	/**
	 * @return the erMann
	 */
	public Boolean getErMann() {
		return erMann;
	}

	/**
	 * @param erMann the erMann to set
	 */
	public void setErMann(Boolean erMann) {
		this.erMann = erMann;
	}

	/**
	 * @return the harBetalt
	 */
	public Boolean getHarBetalt() {
		return harBetalt;
	}

	/**
	 * @param harBetalt the harBetalt to set
	 */
	public void setHarBetalt(Boolean harBetalt) {
		this.harBetalt = harBetalt;
	}

	/**
	 * @return the erKasserer
	 */
	public Boolean getErKasserer() {
		return erKasserer;
	}

	/**
	 * @param erKasserer the erKasserer to set
	 */
	public void setErKasserer(Boolean erKasserer) {
		this.erKasserer = erKasserer;
	}
	
	

}
