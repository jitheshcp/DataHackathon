package nlp;

import java.io.File; 
import java.io.IOException; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload; 

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import nlp.TweetManager;
import nlp.PieChart;
import nlp.BarChart;
 
public class FileUploadHandler extends HttpServlet { 
 
    private final String UPLOAD_DIRECTORY = "C:\\uploads"; 
 
    @Override 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 
            throws ServletException, IOException { 
 
    	// Connecting to database
    	MongoClient mc = new MongoClient("113.128.161.135",27017);

    	//Creating database
    	DB db= mc.getDB("sadb");

    	//Creating collection i.e., table
    	DBCollection coll = db.getCollection("sentiment_analysis");
    	
    	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
 	    //get current date time with Date()
 	    Date date = new Date();
 	    String currentDate = dateFormat.format(date);
 	    System.out.println("currentDate: "+currentDate);
 	    
        //process only if its multipart content 
 
        if(ServletFileUpload.isMultipartContent(request)){ 
 
            try { 
 
                List<FileItem> multiparts = new ServletFileUpload( new DiskFileItemFactory()).parseRequest(request); 
 
                for(FileItem item : multiparts){ 
 
                    if(!item.isFormField()){ 

                        String name = new File(item.getName()).getName(); 
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name)); 
                        	System.out.println(UPLOAD_DIRECTORY + File.separator + name);
                        	
                        	String filePath = UPLOAD_DIRECTORY + File.separator + name;
                        	String topic = "ICCT20WC";
                            List<String> tweetFeedback = new ArrayList<String>();
                            NLP.init();

                            for(String tweet : TweetManager.getTweets(topic, filePath)) {
                            	String feedback = "";
                            	Integer sentiment = NLP.findSentiment(tweet);
                            	switch(sentiment){
                            		case 0 : feedback = "Negative"; break;
                            		case 1 : feedback = "Negative"; break;
                            		case 2 : feedback = "Neutral"; break;
                            		case 3 : feedback = "Positive"; break;
                            		case 4 : feedback = "Positive"; break;
                            		default : feedback = "";
                            	}
                            	
                                tweetFeedback.add(feedback);
                         	   
                                BasicDBObject dbc = new BasicDBObject("feed_date", currentDate)
        						.append("feedback_txt", tweet)
        						.append("sa_result", feedback)
        						.append("sa_result_id", sentiment)
        						.append("is_chronic", "N")
                                .append("file_name", name);

                                coll.insert(dbc);
                                
                            }
                            
                            TweetManager.writeTextFile(tweetFeedback, "C:\\mydownloads\\myoutput_test.txt");
                            System.out.println("File written");	
                            PieChart.generatePie(name);
                            BarChart.BarChart(name);
                        
                    } 
 
                } 
 
               //File uploaded successfully 
 
               request.setAttribute("message", "File Uploaded Successfully"); 
 
            } catch (Exception ex) { 
 
               request.setAttribute("message", "File Upload Failed due to " + ex); 
 
            }           
 
        }else{ 
 
            request.setAttribute("message", 
 
                                 "Sorry this Servlet only handles file upload request"); 
 
        } 
 
        request.getRequestDispatcher("/index.jsp").forward(request, response); 

    } 

}
