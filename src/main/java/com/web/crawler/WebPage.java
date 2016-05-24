package com.web.crawler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
		this.webPageHash = Hasher.toSha256(anchor.getAnchorHash() + Common.getTimestamp().toString());
		this.anchorParseStatus = 0;
		this.emailParseStatus = 0;
	}
	
	public Document loadDocumentFromWeb(){        
        try{
        	document = Jsoup.connect(anchor.getAnchorURL()).get();
        	return document;
        }catch(IOException e){
        	Logger.getLogger(WebCrawlerApp.class.getName()).log(Level.SEVERE, null, e);
        	return null;
        }
	}
	
	public void proccessPage(DBConnection conn, Document doc, String url) throws SQLException, IOException{
		//check if the given URL is already in database
		String sql = "select * from Record where URL = '" + url + "'";
		ResultSet rs = conn.runSql(sql);
		if(rs.next()){
 
		}else{
			//store the URL to database to avoid parsing again
			sql = "INSERT INTO  `Crawler`.`Record` " + "(`URL`) VALUES " + "(?);";
			PreparedStatement stmt = conn.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, url);
			stmt.execute();
	
			if(doc.text().contains("research")){
				System.out.println(url);
			}
	
			//get all links and recursively call the processPage method
			Elements questions = doc.select("a[href]");
			for(Element link: questions){
				if(link.attr("href").contains("mit.edu"))
					proccessPage(conn, Jsoup.connect(link.attr("abs:href")).get(), link.attr("abs:href"));
			}
		}
	}
	
}
