package nlp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nlp.TweetManager;


public class NLPFind1 {
	public static void main(String[] args) throws IOException {

        String topic = "ICCT20WC";
        List<String> tweetFeedback = new ArrayList<String>();
        NLP.init();

        for(String tweet : TweetManager.getTweets(topic, "D:\\output\\inputsample.txt")) {
        	String feedback = "";
        	
        	switch(NLP.findSentiment(tweet)){
	    		case 0 : feedback = "Very Negative"; break;
	    		case 1 : feedback = "Negative"; break;
	    		case 2 : feedback = "Neutral"; break;
	    		case 3 : feedback = "Positive"; break;
	    		case 4 : feedback = "Very Positive"; break;
	    		default : feedback = "";
	    	}
        	
            tweetFeedback.add(feedback);
        }
        
        TweetManager.writeTextFile(tweetFeedback, "C:\\ilakkiya\\myoutput.txt");
     }
}
