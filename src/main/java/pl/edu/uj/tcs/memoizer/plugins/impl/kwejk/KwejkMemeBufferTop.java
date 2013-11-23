package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;
import pl.edu.uj.tcs.memoizer.serialization.StateObject;

import java.util.Map;

public class KwejkMemeBufferTop extends MemeBuffer {
	
	private static EViewType viewType = EViewType.FAVOURITE;
	
	public KwejkMemeBufferTop(StateObject state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return KwejkDownloader.downloadMemesFromPage(
				KwejkUrlFactory.getTopByPopularPageUrl(1),
				viewType);
	}
}