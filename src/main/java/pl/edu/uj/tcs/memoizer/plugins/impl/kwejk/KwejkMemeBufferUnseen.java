package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import java.util.Map;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;

public class KwejkMemeBufferUnseen extends MemeBuffer {
	
	private static EViewType viewType = EViewType.UNSEEN;

	public KwejkMemeBufferUnseen(Map<String, byte[]> state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return null;
	}
}