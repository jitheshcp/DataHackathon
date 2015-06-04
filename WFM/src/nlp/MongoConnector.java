package nlp;
import java.net.UnknownHostException;



import com.mongodb.*;



public class MongoConnector {

	

public static void main(String args[]) throws UnknownHostException

{

	MongoClient mc = new MongoClient("113.128.161.135",27017);

	

	DB db= mc.getDB("sadb");

	DBCollection coll = db.getCollection("sentiment_analysis");

	BasicDBObject dbc = new BasicDBObject("feed_date", "22-MAY-2015")
						.append("feedback_txt", "Product is too bad")
						.append("sa_result", "Negative")
						.append("sa_result_id", "1")
						.append("is_chronic", "Y");

	

	coll.insert(dbc);

	

	DBCursor c = coll.find();

	

	while(c.hasNext())

	{

		DBObject dbo = c.next();

		System.out.println(dbo.get("feedback_txt"));		

	}

	

}



}