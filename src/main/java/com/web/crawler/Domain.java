package com.web.crawler;

import java.sql.Timestamp;

public class Domain {
	
	/** Variables */
	private String domainHash;
	private String domainURL;
	private boolean activated;
	private Timestamp modified;
	private Timestamp created;
	
	/** Getters */
	public String getDomainHash(){return domainHash;}
	public String getDomainURL(){return domainURL;}
	public boolean isActivated(){return activated;}
	public Timestamp getModified(){return modified;}
	public Timestamp getCreated(){return created;}
	
	/** Constructors */
	public Domain(String domainHash, String domainURL) {
		super();
		this.domainHash = domainHash;
		this.domainURL = domainURL;
	}
	
	public Domain(String domainHash, String domainURL, boolean activated, Timestamp modified, Timestamp created) {
		super();
		this.domainHash = domainHash;
		this.domainURL = domainURL;
		this.activated = activated;
		this.modified = modified;
		this.created = created;
	}
	
	
}
