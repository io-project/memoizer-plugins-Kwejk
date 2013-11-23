package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;

import java.util.Map;

public class KwejkMemeBufferChrono extends MemeBuffer {

	private static EViewType viewType = EViewType.CHRONOLOGICAL;
	
	public KwejkMemeBufferChrono(Map<String, byte[]> state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return KwejkDownloader.downloadMemesFromPage(
				KwejkUrlFactory.getMainPageUrl(1),
				viewType);
	}
}