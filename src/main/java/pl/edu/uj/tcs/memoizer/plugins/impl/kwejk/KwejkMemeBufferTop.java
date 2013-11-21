package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;

import java.util.Map;

public class KwejkMemeBufferTop extends MemeBuffer {
	
	private static EViewType viewType = EViewType.FAVOURITE;
	
	public KwejkMemeBufferTop(Map<String, byte[]> state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return null; 
		/*DemotyDownloader.downloadMemesFromPage(
				DemotyUrlFactory.getTopByPercentPageUrl(1),
				viewType);*/
	}
}