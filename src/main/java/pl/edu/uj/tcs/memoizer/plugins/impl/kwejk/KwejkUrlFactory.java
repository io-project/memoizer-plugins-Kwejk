package pl.edu.uj.tcs.memoizer.plugins.impl.kwejk;

class KwejkUrlFactory {
	
	private static String _workingUrl = "http://www.kwejk.pl";
	
	static String getBaseUrl(){
		return _workingUrl;
	}
	
	static String getMainPageUrl(int pageNum){
		return _workingUrl + "/strona/" + pageNum;
	}
	
	static String getQueuePageUrl(int pageNum){
		return _workingUrl + "/oczekujace/" + pageNum;
	}
	
	static String getTopByPopularPageUrl(int pageNum){
		return _workingUrl + "/top/" + pageNum;
	}
	
	static String getTopByVotesPageUrl(int pageNum){
		return _workingUrl + "/top/votes/" + pageNum;
	}
}