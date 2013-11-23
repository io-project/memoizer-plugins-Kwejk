package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import java.util.Map;

import pl.edu.uj.tcs.memoizer.plugins.EViewType;
import pl.edu.uj.tcs.memoizer.plugins.Meme;
import pl.edu.uj.tcs.memoizer.plugins.impl.MemeBuffer;
import pl.edu.uj.tcs.memoizer.serialization.StateObject;

public class KwejkMemeBufferUnseen extends MemeBuffer {
	
	private static EViewType viewType = EViewType.UNSEEN;

	public KwejkMemeBufferUnseen(StateObject state){
		super(state);
	}
	
	@Override
	protected Iterable<Meme> downloadMemes(){
		return null;
	}
}