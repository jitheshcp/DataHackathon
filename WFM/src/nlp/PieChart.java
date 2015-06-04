package nlp;
import java.io.File;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
//import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.data.DefaultPieDataset;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class PieChart {
 
public static String generatePie(String fileName) throws UnknownHostException
 {
  String filename=null;
//Connecting to database
	MongoClient mc = new MongoClient("113.128.161.135",27017);

	//Creating database
	DB db= mc.getDB("sadb");

	//Creating collection i.e., table
	DBCollection coll = db.getCollection("sentiment_analysis");
  try
  {       
   // Create and populate a PieDataSet
	  
	  BasicDBObject positiveWhereQuery = new BasicDBObject();
	  List<Integer> positiveList = new ArrayList<Integer>();
	  positiveList.add(3);
	  positiveList.add(4);
	  positiveWhereQuery.put("file_name", fileName);
	  positiveWhereQuery.put("sa_result_id", new BasicDBObject("$in", positiveList));
      DBCursor positiveResults = coll.find(positiveWhereQuery);
      Integer positiveCount = positiveResults.count();
      System.out.println("positiveCount: "+positiveCount);
      
      BasicDBObject negativeWhereQuery = new BasicDBObject();
      negativeWhereQuery.put("file_name", fileName);
      negativeWhereQuery.put("sa_result_id", 2);
      DBCursor negativeResults = coll.find(negativeWhereQuery);
      Integer negativeCount = negativeResults.count();
      System.out.println("negativeCount: "+negativeCount);
      
      BasicDBObject neutralWhereQuery = new BasicDBObject();
	  List<Integer> neutralList = new ArrayList<Integer>();
	  neutralList.add(0);
	  neutralList.add(1);
	  neutralWhereQuery.put("file_name", fileName);
	  neutralWhereQuery.put("sa_result_id", new BasicDBObject("$in", neutralList));
      DBCursor neutralResults = coll.find(neutralWhereQuery);
      Integer neutralCount = neutralResults.count();
      System.out.println("neutralCount: "+neutralCount);
      
      DefaultPieDataset dataset = new DefaultPieDataset();
      
      dataset.setValue("Positive", positiveCount);
	  dataset.setValue("Negative", negativeCount);
	  dataset.setValue("Neutral", neutralCount);
   
  
   // Create the chart object
   PiePlot plot = new PiePlot(dataset);
   //plot.setInsets(new Insets(0, 5, 5, 5));
   plot.setURLGenerator(new StandardPieURLGenerator("xy_chart.jsp",
     "section"));
   plot.setToolTipGenerator(new StandardPieToolTipGenerator());
   JFreeChart chart = new JFreeChart("",
     JFreeChart.DEFAULT_TITLE_FONT, plot, true);
   chart.setBackgroundPaint(java.awt.Color.white);
   ChartRenderingInfo info = new ChartRenderingInfo(
     new StandardEntityCollection());
   
   // Write the dashboard chart image to a file
   //Random rdm = new Random();
   //filename = "pie"+rdm.nextInt();
   filename = "pie";
   String path = "D:/workspace/charts/";
   //File file = new File(path + "/WebContent/images/"+filename+".png");
   File file = new File(path + filename + ".png");
   //PrintWriter pw = new PrintWriter(new File(path + "/WebContent/images/"+filename+".html"));
   PrintWriter pw = new PrintWriter(new File(path +filename+".html"));
   System.out.println("New File path " + file.getAbsolutePath());
   ChartUtilities.saveChartAsPNG(file, chart, 300, 250, info);
   ChartUtilities.writeImageMap(pw, filename, info, true);
   pw.flush();
   
  } catch (Exception e) {
   System.out.println("Exception - " + e.toString());
   e.printStackTrace(System.out);
   filename = "public_error_500x300.png";
  }  
  return filename;
   
  }

/*public static void main(String args[])
{
	PieChart p = new PieChart();
	p.generatePie();
}*/

 }