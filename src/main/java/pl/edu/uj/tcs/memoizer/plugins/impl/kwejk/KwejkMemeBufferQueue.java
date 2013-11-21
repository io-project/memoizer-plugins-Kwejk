package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import java.util.Map;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;

public class KwejkMemeBufferQueue extends MemeBuffer {
	
	private static EViewType viewType = EViewType.QUEUE;

	public KwejkMemeBufferQueue(Map<String, byte[]> state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return null;
		/*DemotyDownloader.downloadMemesFromPage(
				DemotyUrlFactory.getQueuePageUrl(1),
				viewType);*/
	}
}