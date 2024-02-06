package ANR;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampPlotter extends JFrame{

//    PrintLogs logs= new PrintLogs();
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

    public TimestampPlotter(String title) {
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

    private TimeSeriesCollection createDataset() {
        TimeSeries series = new TimeSeries("Data");

        // Provided timestamps
        String[] timestamps = {
                "01-21 15:56:45.577",
                "01-21 15:58:46.416",
                "01-21 17:00:15.846",
                "01-21 18:30:59.421",
                "01-21 19:14:00.127",
                "01-21 20:27:26.504",
                "01-21 21:30:27.151"
        };

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");

        for (String timestamp : timestamps) {
            try {
                Date date = dateFormat.parse(timestamp);
                series.add(new Second(date), 0); // Assuming a constant value (0) for demonstration
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TimestampPlotter plotter = new TimestampPlotter("Timestamp Plot");
            plotter.setSize(1000, 800);
            plotter.setLocationRelativeTo(null);
            plotter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            plotter.setVisible(true);
        });
    }
}
