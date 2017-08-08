package org.jagdeep.htmlunit;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class YahooTest {

	@Test
	public void googleTest() throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
		
		// below lines will help not to show verbose for WARNINGs
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
	    java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
	    
		HtmlPage currentPage = webClient.getPage("https://in.yahoo.com/?p=us");
		assertEquals("Yahoo", currentPage.getTitleText());
	

		webClient.close();
	}
}
