package ANR;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.testng.internal.collections.Pair;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlotGraph {

    private static PrintLogs logs=new PrintLogs();
    public static void main(final String[] args) throws Exception {
        final TimeSeries series = new TimeSeries("Random Data");
        Millisecond current = new Millisecond();
        double value = 100.0;
//        String[] timeSeriesData = {
//                "02-16 11:24:59.126",
//                "02-16 11:24:59.768",
//                "02-16 11:26:42.396",
//                "02-16 11:26:42.945",
//                "02-16 11:28:32.914",
//                "02-16 11:28:33.417",
//                "02-16 11:30:21.226",
//                "02-16 11:30:21.744",
//                "02-16 11:32:08.520",
//                "02-16 11:32:09.014",
//                "02-16 11:33:58.373",
//                "02-16 11:33:58.957",
//                "02-16 11:35:44.882",
//                "02-16 11:35:45.400",
//                "02-16 11:37:31.722",
//                "02-16 11:37:32.235",
//                "02-16 11:39:14.559",
//                "02-16 11:39:15.060",
//                "02-16 11:41:04.251"
//        };

         logs.getLogs();

      //   String [] timeSeriesData= logs.commonListTimestamp.toArray(new String[0]);

      //   String [] timeSeriesData = logs.commonListTimestampWithPlatform.toArray(new String[0]);
//
//        for(String data:timeSeriesData)
//        {
//            System.err.println(data);
//        }

        SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        double count = 0.0;
//        for (String data : timeSeriesData) {
//
//            Date myDate = standardDateFormat.parse(data);
//            System.err.println(myDate.toString());
//            //count = count + 0.25;
//            series.addOrUpdate(new Millisecond(myDate), 0);
//            current = (Millisecond) current.next();
//        }

        for(int i=0;i<logs.commonListTimestampWithPlatform.size();i++)
        {
            PrintLogs.Pair<String, String> pair1 = logs.commonListTimestampWithPlatform.get(i);

            // Access elements from each pair
            String element1FromList1 = pair1.first;
            String element2FromList1 = pair1.second;

            Date myDate = standardDateFormat.parse(element2FromList1);
            System.err.println(element2FromList1.toString());

//            double yValue = element1FromList1.equals("flutter") ? 5 : 10; // Assign y-axis value based on platform
//            series.addOrUpdate(new Millisecond(myDate), yValue);

            double xValue = element1FromList1.equals("I/flutter") ? 5 : 10; // Assign x-axis value based on platform
            series.addOrUpdate(new Millisecond(myDate), xValue);

        }


//    for (int i = 0; i < 4000; i++) {
//
//      try {
//        value = value + Math.random() - 0.5;
//        System.err.println(value);
//        series.add(current, value);
//        current = (Second) current.next();
//      } catch (SeriesException e) {
//        System.err.println("Error adding to series");
//      }
//    }

        final XYDataset dataset = new TimeSeriesCollection(series);
        JFreeChart timechart =
                ChartFactory.createTimeSeriesChart(
                        "FLUTTER UNITY  ", "MilliSeconds", "5 = Flutter , 10 = Unity", dataset, false, false, false);


        //Swap the orientation to make time as the y-axis
        XYPlot plot = (XYPlot) timechart.getPlot();
        plot.setOrientation(PlotOrientation.HORIZONTAL);

        int width = 1600; /* Width of the image */
        int height = 1600; /* Height of the image */
        File timeChart = new File("TimeChart.jpeg");
        ChartUtils.saveChartAsJPEG(timeChart, timechart, width, height);
    }
}
