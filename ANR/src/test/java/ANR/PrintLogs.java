package ANR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintLogs extends JFrame{

    public ArrayList<String> commonList = new ArrayList<>();
    public ArrayList<String> commonListTimestamp = new ArrayList<>();
    public ArrayList<Pair<String,String>> commonListTimestampWithPlatform = new ArrayList<>();
    public boolean flag = false;
    public ArrayList<String> flutterList = new ArrayList<>();
    public ArrayList<String> unityList = new ArrayList<>();
    public ArrayList<String> flutterListSack = new ArrayList<>();
    public ArrayList<String> unityListStack = new ArrayList<>();
    public Stack<Pair<String, String>> stack = new Stack<>();
    int j;
    public ArrayList<ArrayList<String>> twoDArray = new ArrayList<>();

    class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        PrintLogs test = new PrintLogs();
        test.getLogs();
      //  test.printLogs();
        test.stackWay();
//         SwingUtilities.invokeLater(() -> {
//            TimestampPlotter plotter = new TimestampPlotter("Timestamp Scatter Plot");
//            plotter.setSize(800, 600);
//            plotter.setLocationRelativeTo(null);
//            plotter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            plotter.setVisible(true);
//        });

       // test.print();

    }

    public void getLogs() {
        String filePath = "/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/demo1.txt"; // Replace with the actual path to your log file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
          //  Pattern pattern = Pattern.compile("((.*?)\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+(.*?)) .* ((flutter|Unity))", Pattern.CASE_INSENSITIVE);

            Pattern pattern = Pattern.compile("(\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+) (I/flutter|I/Unity  ) \\((\\d+)\\): (.*)");


            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
//                    String timestamp = matcher.group(1);
//                    String logType = matcher.group(4);
//                   //   System.out.printf("[%s] -> Log type (Flutter/Unity): [%s]%n", timestamp, logType);

                    String timestamp = matcher.group(1);
                    String logType = matcher.group(2);


//                    if (logType.equalsIgnoreCase("flutter")) {
//                        commonList.add(logType);
//                        commonList.add(timestamp);
//                        commonListTimestamp.add(timestamp);
//                        commonListTimestampWithPlatform.add(new Pair<>(logType,timestamp));
//                        stack.push(new Pair<>(logType, timestamp));
//                    }
//                    if (logType.equalsIgnoreCase("unity")) {
//                        commonList.add(logType);
//                        commonList.add(timestamp);
//                        commonListTimestamp.add(timestamp);
//                        commonListTimestampWithPlatform.add(new Pair<>(logType,timestamp));
//                        stack.push(new Pair<>(logType, timestamp));
//                    }

                    if (logType.equalsIgnoreCase("I/flutter")) {
                        commonList.add(logType);
                        commonList.add(timestamp);
                        commonListTimestamp.add(timestamp);
                        commonListTimestampWithPlatform.add(new Pair<>(logType,timestamp));
                        stack.push(new Pair<>(logType, timestamp));
                    }
                    if (logType.equalsIgnoreCase("I/Unity  ")) {
                        commonList.add(logType);
                        commonList.add(timestamp);
                        commonListTimestamp.add(timestamp);
                        commonListTimestampWithPlatform.add(new Pair<>(logType,timestamp));
                        stack.push(new Pair<>(logType, timestamp));
                    }
                }

            }
            // Close the resources
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print()
    {
        for(int i=0;i<commonListTimestamp.size();i++)
        {
            System.out.println(commonListTimestamp.get(i));
        }
    }

    public void printLogs() {
//        for(int i=0;i<commonList.size()-1;i+=2)
//        {
//            //System.out.println(commonList.get(i));
//            j=i+1;
//            String s=commonList.get(j);
//            if (s.equalsIgnoreCase("flutter")) {
//                if(!flag)
//                {
//                    flutterList.add(String.valueOf(i));
//                    flag=true;
//                }
//                else {
//                    unityList.add("Skipped");
//                    flag=false;
//                }
//
//            }
//            else if(s.equalsIgnoreCase("unity"))
//            {
//                if(flag)
//                {
//                    unityList.add((String.valueOf(i));
//                    flag=false;
//                }
//                else {
//                    flutterList.add("Skipped");
//                }
//
//        }

//        for(int i=0;i<commonList.size();i++)
//        {
//            System.out.println(commonList.get(i));
//        }

        for (int i = 0; i < commonList.size() - 4; i += 4) {
            String currentPlatform = commonList.get(i);
            String nextPlaform = commonList.get(i + 2);

            if (!currentPlatform.equalsIgnoreCase(nextPlaform)) {
                flutterList.add(commonList.get(i + 1));
                unityList.add(commonList.get(i + 3));
            } else {
                unityList.add("0         ");
                flutterList.add(commonList.get(i + 1));
                i += 2;
            }

        }

        twoDArray.add(flutterList);
        twoDArray.add(unityList);

        int numRows = twoDArray.size();
        int numCols = twoDArray.get(0).size();

        ArrayList<ArrayList<String>> transposed = new ArrayList<>();

        for (int col = 0; col < numCols; col++) {
            ArrayList<String> newRow = new ArrayList<>();
            for (int row = 0; row < numRows; row++) {
                newRow.add(twoDArray.get(row).get(col));
            }
            transposed.add(newRow);
        }

        for (ArrayList<String> row : transposed) {
            for (String element : row) {
                System.out.print(element + "     ||  ");
            }
            System.out.println();
        }

        System.out.println("====================================================");

    }

    public void stackWay() {
        while (!stack.isEmpty()) {
            Pair<String, String> currentPair = stack.pop();
            String eventType = currentPair.first;
            String timestamp = currentPair.second;

            if ("I/flutter".equals(eventType)) {
                //stack.pop();
                unityListStack.add("     0            ");
                flutterListSack.add(timestamp);
            } else if ("I/Unity  ".equals(eventType)) {
                unityListStack.add(timestamp);
                // Look for the corresponding "flutter" pair
                if(!stack.empty())
                {
                    Pair<String, String> flutterPair = stack.pop();
                    String currentEventType = flutterPair.first;
                    String currenttimestamp = flutterPair.second;
                    flutterListSack.add(currenttimestamp);
                }


            }
        }

        Collections.reverse(flutterListSack);
        Collections.reverse(unityListStack);

        twoDArray.add(flutterListSack);
        twoDArray.add(unityListStack);

        int numRows = twoDArray.size();
        int numCols = twoDArray.get(0).size();

        ArrayList<ArrayList<String>> transposed = new ArrayList<>();

        for (int col = 0; col < numCols; col++) {
            ArrayList<String> newRow = new ArrayList<>();
            for (int row = 0; row < numRows; row++) {
                newRow.add(twoDArray.get(row).get(col));
            }
            transposed.add(newRow);
        }

        for (ArrayList<String> row : transposed) {
            for (String element : row) {
                System.out.print(element + "     ||  ");
            }
            System.out.println();
        }

        System.out.println("====================================================");

    }

//    public void TimestampPlotter(String title) {
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
//        String[] timestamps = flutterListSack.toArray(new String[0]);
//
//        String[] values = unityListStack.toArray(new String[0]);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
//
//        for (int i = 0; i < timestamps.length; i++) {
//            try {
//                Date timestampDate = dateFormat.parse(timestamps[i]);
//                Date valueDate = dateFormat.parse(values[i]);
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





}
