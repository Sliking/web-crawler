package com.web.crawler;

import java.sql.Timestamp;

public class Anchor {
	
	/** Variables */
	private Domain domain;
	private String anchorHash;
	private String anchorURL;
	private int scanStatus;
	private boolean activated;
	private Timestamp modified;
	private Timestamp created;
	
	/** Getters */
	public Domain getDomain(){return domain;}
	public String getAnchorHash(){return anchorHash;}
	public String getAnchorURL(){return anchorURL;}
	public int getScanStatus(){return scanStatus;}
	public boolean isActivated(){return activated;}
	public Timestamp getModified(){return modified;}
	public Timestamp getCreated(){return created;}
	
	
	/**Constructors */
	public Anchor(Domain domain, String anchorHash, String anchorURL) {
		super();
		this.domain = domain;
		this.anchorHash = anchorHash;
		this.anchorURL = anchorURL;
	}
	
	public Anchor(Domain domain, String anchorHash, String anchorURL, int scanStatus, boolean activated,
			Timestamp modified, Timestamp created) {
		super();
		this.domain = domain;
		this.anchorHash = anchorHash;
		this.anchorURL = anchorURL;
		this.scanStatus = scanStatus;
		this.activated = activated;
		this.modified = modified;
		this.created = created;
	}

	
	
	
}
