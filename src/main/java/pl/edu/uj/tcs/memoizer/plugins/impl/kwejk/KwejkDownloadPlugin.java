package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import pl.edu.uj.tcs.memoizer.plugins.*;
import pl.edu.uj.tcs.memoizer.plugins.impl.*;
import pl.edu.uj.tcs.memoizer.serialization.StateObject;

import java.net.*;
import java.util.*;
import java.lang.IllegalArgumentException;
import java.awt.Image;

/*
 * Plugin designed to downloading from Demotywatory page
 * @author pmikos (sokar92)
 */
public final class KwejkDownloadPlugin implements IDownloadPlugin {
	private StateObject _state;
	private EViewType _view;
	private Map<EViewType, IMemeBuffer> _viewBuffer;
	
	/*
	 * Instantiates new download plugin designed
	 * for "www.kwejk.pl" page
	 */
	public KwejkDownloadPlugin(StateObject state){		
		_state = state;
		_view = null;
		
		_viewBuffer = new HashMap<EViewType, IMemeBuffer>();
		_viewBuffer.put(EViewType.CHRONOLOGICAL, new KwejkMemeBufferChrono(_state));
		_viewBuffer.put(EViewType.UNSEEN, new KwejkMemeBufferUnseen(_state));
		_viewBuffer.put(EViewType.FAVOURITE, new KwejkMemeBufferTop(_state));
		_viewBuffer.put(EViewType.QUEUE, new KwejkMemeBufferQueue(_state));
	}
	
	@Override
	public StateObject getState(){
		return _state;
	}

	@Override
	public List<EViewType> getAvailableViews() {
		List<EViewType> list = new ArrayList<EViewType>();
		list.add(EViewType.CHRONOLOGICAL);
		list.add(EViewType.FAVOURITE);
		//list.add(EViewType.UNSEEN);
		list.add(EViewType.QUEUE);
		return list;
	}

	@Override
	public void setView(EViewType viewType) {
		if(!getAvailableViews().contains(viewType))
			throw new IllegalArgumentException(
					"Kwejk plugin does not support " + viewType.toString() + " view!");
		
		_view = viewType;
	}

	@Override
	public boolean hasNext(){
		if(_view == null)
			return false;
		return _viewBuffer.get(_view).hasNext();
	}
	
	@Override
	public Meme getNext(){
		if(_view == null)
			return null;
		Meme m = _viewBuffer.get(_view).getNext();
		m.setOwner(this);
		return m;
	}
	
	@Override
	public Iterable<Meme> getNext(int n){
		if(_view == null)
			return null;
		Iterable<Meme> results = _viewBuffer.get(_view).getNext(n);
		for(Meme m: results) {
			m.setOwner(this);
		}
		return results;
	}

	@Override
	public String getName() {
		return "Kwejk";
	}
}