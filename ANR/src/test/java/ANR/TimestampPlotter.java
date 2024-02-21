package ANR;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampPlotter extends JFrame{

    PrintLogs logs= new PrintLogs();
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            TimestampPlotter plotter = new TimestampPlotter("Timestamp Scatter Plot");
//            plotter.setSize(800, 600);
//            plotter.setLocationRelativeTo(null);
//            plotter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            plotter.setVisible(true);
//        });
//    }
//
//    public TimestampPlotter(String title) {
//
//        // Read timestamps and create dataset
//        TimeSeriesCollection dataset = createDataset();
//
//        // Create chart
//        JFreeChart chart = ChartFactory.createTimeSeriesChart(
//                "Timestamp Scatter Plot",
//                "Timestamp",
//                "Value",
//                dataset,
//                false,
//                true,
//                false
//        );
//
//        // Customize the plot
//        XYPlot plot = chart.getXYPlot();
//        DateAxis dateAxis = (DateAxis) plot.getDomainAxis();
//        dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.SECOND, 1));
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setAutoRange(true);
//
//        // Customize the renderer to add colors to points
//        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
//        renderer.setSeriesPaint(0, Color.BLUE); // Set color for series 0
//        plot.setRenderer(renderer);
//
//        // Create Panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new Dimension(800, 400));
//        setContentPane(chartPanel);
//    }
//
//    private TimeSeriesCollection createDataset() {
//        TimeSeries series = new TimeSeries("Data");
//
//        // Provided data
//        String[] timestamps = logs.flutterListSack.toArray(new String[0]);
//
//        String[] values = logs.unityListStack.toArray(new String[0]);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
//
//        for (int i = 0; i < timestamps.length; i++) {
//            try {
//                Date timestampDate = dateFormat.parse(timestamps[i]);
//                Date valueDate = dateFormat.parse(values[i]);
////                System.out.println(new Second(timestampDate));
////                System.out.println(valueDate.getTime());
//                series.add(new Second(timestampDate), valueDate.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//
//        TimeSeriesCollection dataset = new TimeSeriesCollection();
//        dataset.addSeries(series);
//
//        return dataset;
//
//    }

    public TimestampPlotter(String title) throws ParseException {
        super(title);

        // Read timestamps and create dataset
        TimeSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Timestamp Plot",
                "Timestamp",
                "Value",
                dataset,
                false,
                true,
                false
        );

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        DateAxis dateAxis = (DateAxis) plot.getDomainAxis();
        dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.SECOND, 1));
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAutoRange(true);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 400));
        setContentPane(chartPanel);
    }

    private TimeSeriesCollection createDataset() throws ParseException {
        TimeSeries series = new TimeSeries("Data");

        // Provided timestamps
//        String[] timestamps = {
//                "01-28 14:45:15.790",
//                "01-28 14:45:16.548",
//                "01-28 14:47:43.440",
//                "01-28 14:47:44.213",
//                "01-28 14:49:38.229",
//                "01-28 14:49:38.887",
//                "01-28 14:51:50.590",
//                "01-28 14:51:51.464",
//                "01-28 14:53:54.546",
//                "01-28 14:53:55.406",
//                "01-28 14:55:31.750",
//                "01-28 14:55:32.722",
//                "01-28 14:57:07.528",
//                "01-28 14:57:08.122",
//                "01-28 14:59:33.765",
//                "01-28 15:01:30.784",
//                "01-28 15:01:31.904",
//                "01-28 15:37:51.628"
//        };

        String [] timestamps= logs.commonListTimestamp.toArray(new String[0]);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");

//        for (String timestamp : timestamps) {
//            try {
//                Date date = dateFormat.parse(timestamp);
//                //series.add(new Second(date), 0); // Assuming a constant value (0) for demonstration
//                series.addOrUpdate(new FixedMillisecond(date), 0);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }

        SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        Second current = new Second();
        double count = 0.0;
        for (String data : timestamps) {
            Date myDate = standardDateFormat.parse(data);
            System.err.println(myDate.toString());
            count = count + 0.25;
            series.addOrUpdate(new Millisecond(myDate), count);
            current = (Second) current.next();
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TimestampPlotter plotter = null;
            try {
                plotter = new TimestampPlotter("Timestamp Plot");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            plotter.setSize(1000, 800);
            plotter.setLocationRelativeTo(null);
            plotter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            plotter.setVisible(true);
        });
    }
}
