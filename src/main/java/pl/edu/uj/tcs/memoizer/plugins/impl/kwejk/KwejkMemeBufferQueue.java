package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import java.util.Map;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;
import pl.edu.uj.tcs.memoizer.serialization.StateObject;

public class KwejkMemeBufferQueue extends MemeBuffer {
	
	private static EViewType viewType = EViewType.QUEUE;

	public KwejkMemeBufferQueue(StateObject state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return KwejkDownloader.downloadMemesFromPage(
				KwejkUrlFactory.getQueuePageUrl(1),
				viewType);
	}
}