package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

import pl.edu.uj.tcs.memoizer.plugins.IPlugin;
import pl.edu.uj.tcs.memoizer.plugins.IPluginFactory;
import java.awt.Image;
import java.util.Map;

/*
 * Komixxy.pl download plugin factory implementation
 * @author pmikos (sokar92)
 */
public class KwejkDownloadPluginFactory implements IPluginFactory {
	
	public String getPluginName(){
		return "Kwejk";
	}
	
	public Image getIcon(){
		return null;
	}
	
	public IPlugin newInstance(Map<String, byte[]> pluginStateMap){
		return new KwejkDownloadPlugin(pluginStateMap);
	}
	
}