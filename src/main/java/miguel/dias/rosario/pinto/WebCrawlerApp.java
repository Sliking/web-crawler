package miguel.dias.rosario.pinto;

import org.jsoup.nodes.Document;

import com.web.crawler.Anchor;
import com.web.crawler.DBConnection;
import com.web.crawler.Domain;
import com.web.crawler.WebPage;

public class WebCrawlerApp{
    public static void main( String[] args ) throws Exception{
    	
    	String URL = "http://www.mit.edu/";
    	
		System.out.println( "Starting Web Crawler..." );
			   
		System.out.println("Connecting to database...");
			   
		DBConnection conn = new DBConnection();
			    
		Domain domain = new Domain(URL);
			   
		Anchor anchor = new Anchor(domain, URL);
		WebPage webPage = new WebPage(anchor);
		Document document = webPage.loadDocumentFromWeb();
		webPage.proccessPage(conn, document, URL);
		
    }
}
