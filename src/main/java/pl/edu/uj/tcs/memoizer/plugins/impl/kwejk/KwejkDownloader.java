package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import pl.edu.uj.tcs.memoizer.plugins.*;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * Plugin submodule designed for downloading 
 * and extracting memes from page sources
 */
class KwejkDownloader {
	
	/*
	 * Get a page source, parse it,
	 * extract memes and return
	 */
	static List<Meme> downloadMemesFromPage(String url, EViewType viewType){
		return extractMemesFromNodes(
				extractMemeNodes(
				downloadPageSource(url)), viewType);
	}
	
	/*
	 * Download page source from specific url
	 * If success returns downloaded page
	 * otherwise returns null
	 */
	private static Document downloadPageSource(String url){
		try{
			return Jsoup
					.connect(url)
					.userAgent("Mozilla")
					.get();
		} catch(IOException e){}
		return null;
	}
	
	/*
	 * Extract html meme-linked elements 
	 * from given page source
	 */
	private static Elements extractMemeNodes(Document kwejkPageSource){
		Elements result = new Elements();
		
		if(kwejkPageSource == null)
			return result;
		
		Elements kwejkiDiv = kwejkPageSource.select("div.mediaPair");
		for(Element elem : kwejkiDiv){
			Elements kwejk = elem.select("div.shot[title]");
			result.addAll(kwejk);
		}
		
		return result;
	}
	
	/*
	 * Parse html meme-linked element and extract meme info
	 * returns list of parsed memes
	 */
	private static List<Meme> extractMemesFromNodes(Elements memeNodes, EViewType viewType){
		List<Meme> lst = new ArrayList<Meme>();
		
		for(Element meme : memeNodes){
			try{
				String description = "";
				
				Element desc = meme.select("div.desc > div.tooltip-title-container > div.tooltip-title-left-corner > div.tooltip-title").first();
				String title = extractTitleFromDesc(desc);
				
				Element media = meme.select("div.content > div.media").first();
				Element picLink = media.select("a.mOUrl[href]").first();
				URL pageLink = extractPageLinkFromATag(picLink);
				
				Element image = picLink.select("img[src]").first();
				URL imageLink = extractImageLinkFromImgTag(image);
				int width = extractWidthFromImgTag(image);
				int heigth = extractHeightFromImgTag(image);
				
				if(imageLink != null)
					lst.add(new Meme(imageLink, pageLink, title, description, width, heigth, null, viewType, null));
			} catch(Exception e){}
		}
		
		return lst;
	}
	
	private static URL extractPageLinkFromATag(Element aTagElement){
		try{
			return new URL(KwejkUrlFactory.getBaseUrl() + aTagElement.attr("href"));
		}catch(Exception e){}
		return null;
	}
	
	private static URL extractImageLinkFromImgTag(Element imgTagElement){
		try{
			return new URL(imgTagElement.attr("src"));
		} catch(Exception e){}
		return null;
	}
	
	private static String extractTitleFromDesc(Element desc){
		try{
			return desc.text();
		} catch(Exception e){}
		return "";
	}
	
	private static int extractWidthFromImgTag(Element imgTagElement){
		try{
			return Integer.parseInt(imgTagElement.attr("width"));
		} catch(Exception e){}
		return 0;
	}
	
	private static int extractHeightFromImgTag(Element imgTagElement){
		try{
			return Integer.parseInt(imgTagElement.attr("height"));
		} catch(Exception e){}
		return 0;
	}
}