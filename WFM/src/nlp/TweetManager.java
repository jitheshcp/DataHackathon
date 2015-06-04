package nlp;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TweetManager {
	
    public static List<String> getTweets(String topic, String path) {

        //Twitter twitter = new TwitterFactory().getInstance();

    	BufferedReader br = null;
    	List<String> tweetList = new ArrayList<String>();
    	System.out.println("path: "+path);
		try {
			tweetList = readTextFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		

        /*try {

            Query query = new Query(topic);

            QueryResult result;

            //do {

                result = twitter.search(query);

                List<Status> tweets = result.getTweets();

                for (Status tweet : tweets) {

                    tweetList.add(tweet.getText());

                }

                

        	
        	tweetList.add("Blazing fast internet speeds... I'm blown away");
        	tweetList.add("I have been talking to 5 agents so far, still no end to my pain... phone can't be dead for 10 days!!!"); 
        	tweetList.add("Been a loyal customer for 3 years enjoying the service, the last three months has been horrible ");
        	tweetList.add("Network quality is great but certainly not value for money.... I can get better deals elsewhere ");
        	tweetList.add("Summer is finally here ");
        	tweetList.add("Amazing picture quality... HD TV Rocks ");
        	tweetList.add("The entire ordering process was a breeze.... Loved it ");
        	tweetList.add("Arrived in a timely fashion. Plugged it in and it works like a charm! No more annoying beeping from the old battery. After doing some homework, we found this price extremely affordable."); 
        	tweetList.add("I took the day off yesterday for the installation, whole family was around and the technician did not show up. How do I cancel the service now? ");
        	tweetList.add("It's been a crazy day... traffic is horrible ");

        	
                tweetList.add("I hate the product");
                tweetList.add("I like the product");
                tweetList.add(" product is too bad");
                tweetList.add("I do not like the product");
                tweetList.add(" product is not bad");
                tweetList.add(" product is bad");
                tweetList.add(" product is neither good nor bad");
                tweetList.add(" I do not want to comment on the product");
                tweetList.add(" product is horrible");
                tweetList.add(" product is fantastic");
                tweetList.add(" product sucks");
                tweetList.add(" Product sucks.. I have no words to describe about the product");

                //i++;

                

            //} while (i<5);

        } catch (Exception te) {

            te.printStackTrace();

            System.out.println("Failed to search tweets: " + te.getMessage());

        }
*/
        return tweetList;

    }

    static List<String> readTextFile(String fileName) throws IOException {
	    Path path = Paths.get(fileName);
	    return Files.readAllLines(path, StandardCharsets.UTF_8);
	}

	static void writeTextFile(List<String> strLines, String fileName) throws IOException {
	    Path path = Paths.get(fileName);
	    Files.write(path, strLines, StandardCharsets.UTF_8);
	}
}

