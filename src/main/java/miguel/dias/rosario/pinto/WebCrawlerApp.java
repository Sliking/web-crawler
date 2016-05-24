package miguel.dias.rosario.pinto;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebCrawlerApp{
    public static void main( String[] args ){
    	
        System.out.println( "Starting Web Crawler..." );
        
        try{
        	Document doc = Jsoup.connect("http://www.jsoup.org/").get();
        	org.jsoup.select.Elements links = doc.select("a");
        	for(Element e : links){
        		System.out.println(e.attr("abs:href"));
        	}
        }catch(IOException e){
        	Logger.getLogger(WebCrawlerApp.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
