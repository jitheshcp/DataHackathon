package nlp;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;




import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.ChartRenderingInfo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;



/**

 * A simple demonstration application showing how to create a bar chart.

 *

 */

public class BarChart  {



    /**

	 * 

	 */

	private static final long serialVersionUID = 1L;



	/**

     * Creates a new demo instance.

     *

     * @param title  the frame title.
	 * @throws UnknownHostException 

     */

    public static String BarChart(String fileName) throws UnknownHostException {



        //super(title);



        final CategoryDataset dataset = createDataset(fileName);

        final String chart = createChart(dataset,"D:/workspace/charts/");
		return fileName;

        /*final ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new Dimension(500, 270));

        setContentPane(chartPanel);*/



    }



    /**

     * Returns a sample dataset.

     * 

     * @return The dataset.
     * @throws UnknownHostException 

     */

    public static CategoryDataset createDataset(String fileName) throws UnknownHostException {

        
    	//Connecting to database
    	MongoClient mc = new MongoClient("113.128.161.135",27017);

    	//Creating database
    	DB db= mc.getDB("sadb");

    	//Creating collection i.e., table
    	DBCollection coll = db.getCollection("sentiment_analysis");
        // row keys...

        final String series1 = "Positive";

        final String series2 = "Neutral";

        final String series3 = "Negative";



        // column keys...

        final String category1 = "22-MAY-2015";

        final String category2 = "23-MAY-2015";

        final String category3 = "24-MAY-2015";

        final String category4 = "25-MAY-2015";

        final String category5 = "26-MAY-2015";
        
        final String category6 = "27-MAY-2015";
        
        final String category7 = "28-MAY-2015";

        List<Integer> positiveList = new ArrayList<Integer>();
  	  	positiveList.add(3);
  	  	positiveList.add(4);
  	  
        BasicDBObject positive22 = new BasicDBObject();
        positive22.put("feed_date", "22-MAY-2015");
        positive22.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults22 = coll.find(positive22);
        Integer positiveCount22 = positiveResults22.count();
        
        BasicDBObject positive23 = new BasicDBObject();
        positive23.put("feed_date", "23-MAY-2015");
        positive23.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults23 = coll.find(positive23);
        Integer positiveCount23 = positiveResults23.count();
        
        BasicDBObject positive24 = new BasicDBObject();
        positive24.put("feed_date", "24-MAY-2015");
        positive24.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults24 = coll.find(positive24);
        Integer positiveCount24 = positiveResults24.count();
        
        BasicDBObject positive25 = new BasicDBObject();
        positive25.put("feed_date", "25-MAY-2015");
        positive25.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults25 = coll.find(positive25);
        Integer positiveCount25 = positiveResults25.count();
        
        BasicDBObject positive26 = new BasicDBObject();
        positive26.put("feed_date", "26-MAY-2015");
        positive26.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults26 = coll.find(positive26);
        Integer positiveCount26 = positiveResults26.count();
        
        BasicDBObject positive27 = new BasicDBObject();
        positive27.put("feed_date", "27-MAY-2015");
        positive27.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults27 = coll.find(positive27);
        Integer positiveCount27 = positiveResults27.count();
        
        BasicDBObject positive28 = new BasicDBObject();
        positive28.put("feed_date", "28-MAY-2015");
        positive28.put("sa_result_id", new BasicDBObject("$in", positiveList));
        DBCursor positiveResults28 = coll.find(positive28);
        Integer positiveCount28 = positiveResults28.count();

        // create the dataset...

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();



        dataset.addValue(positiveCount22, series1, category1);
        dataset.addValue(positiveCount23, series1, category2);
        dataset.addValue(positiveCount24, series1, category3);
        dataset.addValue(positiveCount25, series1, category4);
        dataset.addValue(positiveCount26, series1, category5);
        dataset.addValue(positiveCount27, series1, category6);
        dataset.addValue(positiveCount28, series1, category7);



        
        
        BasicDBObject neutral22 = new BasicDBObject();
        neutral22.put("feed_date", "22-MAY-2015");
        neutral22.put("sa_result_id", 2);
        DBCursor neutralResults22 = coll.find(neutral22);
        Integer neutralCount22 = neutralResults22.count();
        
        BasicDBObject neutral23 = new BasicDBObject();
        neutral23.put("feed_date", "23-MAY-2015");
        neutral23.put("sa_result_id", 2);
        DBCursor neutralResults23 = coll.find(neutral23);
        Integer neutralCount23 = neutralResults23.count();
        
        BasicDBObject neutral24 = new BasicDBObject();
        neutral24.put("feed_date", "24-MAY-2015");
        neutral24.put("sa_result_id", 2);
        DBCursor neutralResults24 = coll.find(neutral24);
        Integer neutralCount24 = neutralResults24.count();
        
        BasicDBObject neutral25 = new BasicDBObject();
        neutral25.put("feed_date", "25-MAY-2015");
        neutral25.put("sa_result_id", 2);
        DBCursor neutralResults25 = coll.find(neutral25);
        Integer neutralCount25 = neutralResults25.count();
        
        BasicDBObject neutral26 = new BasicDBObject();
        neutral26.put("feed_date", "26-MAY-2015");
        neutral26.put("sa_result_id", 2);
        DBCursor neutralResults26 = coll.find(neutral26);
        Integer neutralCount26 = neutralResults26.count();
        
        BasicDBObject neutral27 = new BasicDBObject();
        neutral27.put("feed_date", "27-MAY-2015");
        neutral27.put("sa_result_id", 2);
        DBCursor neutralResults27 = coll.find(neutral27);
        Integer neutralCount27 = neutralResults27.count();
        
        BasicDBObject neutral28 = new BasicDBObject();
        neutral28.put("feed_date", "28-MAY-2015");
        neutral28.put("sa_result_id", 2);
        DBCursor neutralResults28 = coll.find(neutral28);
        Integer neutralCount28 = neutralResults28.count();

        
        dataset.addValue(neutralCount22, series2, category1);
        dataset.addValue(neutralCount23, series2, category2);
        dataset.addValue(neutralCount24, series2, category3);
        dataset.addValue(neutralCount25, series2, category4);
        dataset.addValue(neutralCount26, series2, category5);
        dataset.addValue(neutralCount27, series2, category6);
        dataset.addValue(neutralCount28, series2, category7);
        
        
        List<Integer> negativeList = new ArrayList<Integer>();
  	  	negativeList.add(0);
  	  	negativeList.add(1);
  	  
        BasicDBObject negative22 = new BasicDBObject();
        negative22.put("feed_date", "22-MAY-2015");
        negative22.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults22 = coll.find(negative22);
        Integer negativeCount22 = negativeResults22.count();
        
        BasicDBObject negative23 = new BasicDBObject();
        negative23.put("feed_date", "23-MAY-2015");
        negative23.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults23 = coll.find(negative23);
        Integer negativeCount23 = negativeResults23.count();
        
        BasicDBObject negative24 = new BasicDBObject();
        negative24.put("feed_date", "24-MAY-2015");
        negative24.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults24 = coll.find(negative24);
        Integer negativeCount24 = negativeResults24.count();
        
        BasicDBObject negative25 = new BasicDBObject();
        negative25.put("feed_date", "25-MAY-2015");
        negative25.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults25 = coll.find(negative25);
        Integer negativeCount25 = negativeResults25.count();
        
        BasicDBObject negative26 = new BasicDBObject();
        negative26.put("feed_date", "26-MAY-2015");
        negative26.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults26 = coll.find(negative26);
        Integer negativeCount26 = negativeResults26.count();
        
        BasicDBObject negative27 = new BasicDBObject();
        negative27.put("feed_date", "27-MAY-2015");
        negative27.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults27 = coll.find(negative27);
        Integer negativeCount27 = negativeResults27.count();
        
        BasicDBObject negative28 = new BasicDBObject();
        negative28.put("feed_date", "28-MAY-2015");
        negative28.put("sa_result_id", new BasicDBObject("$in", negativeList));
        DBCursor negativeResults28 = coll.find(negative28);
        Integer negativeCount28 = negativeResults28.count();

        
        dataset.addValue(negativeCount22, series3, category1);
        dataset.addValue(negativeCount23, series3, category2);
        dataset.addValue(negativeCount24, series3, category3);
        dataset.addValue(negativeCount25, series3, category4);
        dataset.addValue(negativeCount26, series3, category5);
        dataset.addValue(negativeCount27, series3, category6);
        dataset.addValue(negativeCount28, series3, category7);
        

        return dataset;

        

    }

    

    /**

     * Creates a sample chart.

     * 

     * @param dataset  the dataset.

     * 

     * @return The chart.

     */

    private static String createChart(final CategoryDataset dataset, String path) {

        

        // create the chart...

        final JFreeChart chart = ChartFactory.createBarChart(

            "Bar Chart Demo",         // chart title

            "Category",               // domain axis label

            "Value",                  // range axis label

            dataset,                  // data

            PlotOrientation.VERTICAL, // orientation

            true,                     // include legend

            true,                     // tooltips?

            false                     // URLs?

        );



        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...



        // set the background color for the chart...

        chart.setBackgroundPaint(Color.white);



        // get a reference to the plot for further customisation...

        final CategoryPlot plot = chart.getCategoryPlot();

        plot.setBackgroundPaint(Color.lightGray);

        plot.setDomainGridlinePaint(Color.white);

        plot.setRangeGridlinePaint(Color.white);



        // set the range axis to display integers only...

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());



        // disable bar outlines...

        final BarRenderer renderer = (BarRenderer) plot.getRenderer();

        renderer.setDrawBarOutline(false);

        

        // set up gradient paints for series...

        final GradientPaint gp0 = new GradientPaint(

            0.0f, 0.0f, Color.blue, 

            0.0f, 0.0f, Color.lightGray

        );

        final GradientPaint gp1 = new GradientPaint(

            0.0f, 0.0f, Color.green, 

            0.0f, 0.0f, Color.lightGray

        );

        final GradientPaint gp2 = new GradientPaint(

            0.0f, 0.0f, Color.red, 

            0.0f, 0.0f, Color.lightGray

        );

        renderer.setSeriesPaint(0, gp0);

        renderer.setSeriesPaint(1, gp1);

        renderer.setSeriesPaint(2, gp2);



        final CategoryAxis domainAxis = plot.getDomainAxis();

        domainAxis.setCategoryLabelPositions(

            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)

        );

        // OPTIONAL CUSTOMISATION COMPLETED.

        

        //return chart;

        ChartRenderingInfo info = new ChartRenderingInfo(

        	     new StandardEntityCollection());

        

        String filename = "bar";

        File file = new File(path + filename + ".png");   

        try{

        PrintWriter pw;		

			pw = new PrintWriter(new File(path +filename+".html"));

		

        System.out.println("New File path " + file.getAbsolutePath());

        

			ChartUtilities.saveChartAsPNG(file, chart, 300, 250, info);

				

        ChartUtilities.writeImageMap(pw, filename, info, true);

        pw.flush();

        }

        catch(Exception ex)

        {

        	ex.printStackTrace();

        }

        return filename;

    }

    

    // ****************************************************************************

    // * JFREECHART DEVELOPER GUIDE                                               *

    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *

    // * to purchase from Object Refinery Limited:                                *

    // *                                                                          *

    // * http://www.object-refinery.com/jfreechart/guide.html                     *

    // *                                                                          *

    // * Sales are used to provide funding for the JFreeChart project - please    * 

    // * support us so that we can continue developing free software.             *

    // ****************************************************************************

    

    /**

     * Starting point for the demonstration application.

     *

     * @param args  ignored.

     */

    /*public static void main(final String[] args) {



        final BarChart demo = new BarChart("Bar Chart Demo", );

        demo.pack();

        RefineryUtilities.centerFrameOnScreen(demo);

        demo.setVisible(true);

    }*/



}

