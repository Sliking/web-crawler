package com.web.crawler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import miguel.dias.rosario.pinto.WebCrawlerApp;

public class WebPage {
	
	/** Variables */
	private Anchor anchor;
	private String webPageHash;
	private int anchorParseStatus;
	private int emailParseStatus;
	private Document document;
	
	/** Constructors */
	public WebPage(Anchor anchor) {
		super();
		this.anchor = anchor;
	}
	
	private void loadDocumentFromWeb(){
		System.out.println( "Starting Web Crawler..." );
        
        try{
        	document = Jsoup.connect(anchor.getAnchorURL()).get();
        }catch(IOException e){
        	Logger.getLogger(WebCrawlerApp.class.getName()).log(Level.SEVERE, null, e);
        }
	}
	
}
