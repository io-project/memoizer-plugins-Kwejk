package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;
import pl.edu.uj.tcs.memoizer.serialization.StateObject;

import java.util.Map;

public class KwejkMemeBufferChrono extends MemeBuffer {

	private static EViewType viewType = EViewType.CHRONOLOGICAL;
	
	public KwejkMemeBufferChrono(StateObject state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return KwejkDownloader.downloadMemesFromPage(
				KwejkUrlFactory.getMainPageUrl(1),
				viewType);
	}
}