package ANR;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalADBLogs {
    public ArrayList<String> commonList = new ArrayList<>();
    public ArrayList<String> commonListTimestamp = new ArrayList<>();
    public ArrayList<FinalADBLogs.Pair<String, String>> commonListTimestampWithPlatform = new ArrayList<>();
    public ArrayList<String> flutterList = new ArrayList<>();
    public ArrayList<String> unityList = new ArrayList<>();
    public ArrayList<String> flutterListSack = new ArrayList<>();
    public ArrayList<String> unityListStack = new ArrayList<>();

    public Stack<FinalADBLogs.Pair<String, String>> stack = new Stack<>();
    public ArrayList<ArrayList<String>> twoDArray = new ArrayList<>();
    static class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws ParseException, IOException {

        String platform ="ipa";
        FinalADBLogs object = new FinalADBLogs();
        object.extractLogs(platform);
        object.adbExecuteCode(platform);
       // object.printLogs();
        object.stackWay();
        object.plotGraph(platform);
    }

    public void extractLogs(String platform) throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/demo1.txt");

            // Execute the ADB command
            //  Process process = Runtime.getRuntime().exec(adbCommand);

            // Read the output of the ADB command
            BufferedReader reader = new BufferedReader(new FileReader("/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/BSlogs.txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                if(platform.equalsIgnoreCase("android"))
                {
                   // if(line.contains("flutter : Lobby Event Added :: lobby_play_now_clicked"))

                    if(line.contains("flutter : Lobby Event Added ::  game_table_pushed_to_route"))
                    {
                        System.out.println(line);
                        fileWriter.write(line + "\n");
                    }
                    if(line.contains("Unity   : Changing orientation from Game Table current Orientation Portrait change to LandscapeLeft"))
                    {
                        System.out.println(line);
                        fileWriter.write(line + "\n");
                    }
                }
                else {
                    if(line.contains("Lobby Event Added ::  game_table_pushed_to_route"))
                    {
                        System.out.println(line);
                        fileWriter.write(line + "\n");
                    }
                    if(line.contains("Setting full screen from Game Table currently isfullscreen False change to isfullscreen True"))
                    {
                        System.out.println(line);
                        fileWriter.write(line + "\n");
                    }
                }
            }

            // Close the FileWriter
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void adbExecuteCode(String platform) {
        String filePath = "/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/demo1.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            Pattern pattern;

            if (platform.equalsIgnoreCase("android")) {
                pattern = Pattern.compile("((.*?)\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+(.*?)) .* ((flutter|Unity))", Pattern.CASE_INSENSITIVE);
                while ((line = bufferedReader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String timestamp = matcher.group(1);
                        String logType = matcher.group(4);
                        System.out.printf("[%s] -> Log type (Flutter/Unity): [%s]%n", timestamp, logType);

                        if (logType.equalsIgnoreCase("flutter")) {
                            commonList.add(logType);
                            commonList.add(timestamp);
                            commonListTimestamp.add(timestamp);
                            commonListTimestampWithPlatform.add(new Pair<>(logType, timestamp));
                            stack.push(new Pair<>(logType, timestamp));
                        }
                        if (logType.equalsIgnoreCase("unity")) {
                            commonList.add(logType);
                            commonList.add(timestamp);
                            commonListTimestamp.add(timestamp);
                            commonListTimestampWithPlatform.add(new Pair<>(logType, timestamp));
                            stack.push(new Pair<>(logType, timestamp));
                        }

                    }

                }
            } else {
                pattern = Pattern.compile("(\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+) (I/flutter|I/Unity  ) \\((\\d+)\\): (.*)");
                while ((line = bufferedReader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {

                        String timestamp = matcher.group(1);
                        String logType = matcher.group(2);

                        if (logType.equalsIgnoreCase("I/flutter")) {
                            commonList.add(logType);
                            commonList.add(timestamp);
                            commonListTimestamp.add(timestamp);
                            commonListTimestampWithPlatform.add(new FinalADBLogs.Pair<>(logType, timestamp));
                            stack.push(new FinalADBLogs.Pair<>(logType, timestamp));
                        }
                        if (logType.equalsIgnoreCase("I/Unity  ")) {
                            commonList.add(logType);
                            commonList.add(timestamp);
                            commonListTimestamp.add(timestamp);
                            commonListTimestampWithPlatform.add(new FinalADBLogs.Pair<>(logType, timestamp));
                            stack.push(new FinalADBLogs.Pair<>(logType, timestamp));
                        }
                    }
                }
            }
            // Close the resources
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
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
            FinalADBLogs.Pair<String, String> currentPair = stack.pop();
            String eventType = currentPair.first;
            String timestamp = currentPair.second;

            if ("I/flutter".equals(eventType)) {
                //stack.pop();
                unityListStack.add("     0            ");
                flutterListSack.add(timestamp);
            } else if ("I/Unity  ".equals(eventType)) {
                unityListStack.add(timestamp);
                // Look for the corresponding "flutter" pair
                if (!stack.empty()) {
                    FinalADBLogs.Pair<String, String> flutterPair = stack.pop();
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

    public void plotGraph(String platform) throws ParseException, IOException {

        final TimeSeries series = new TimeSeries("Random Data");
        SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        double count = 0.0;
        for (int i = 0; i < commonListTimestampWithPlatform.size(); i++) {
            Pair<String, String> pair1 = commonListTimestampWithPlatform.get(i);

            // Access elements from each pair
            String element1FromList1 = pair1.first;
            String element2FromList1 = pair1.second;

            Date myDate = standardDateFormat.parse(element2FromList1);
            System.err.println(element2FromList1.toString());

            if (platform.equalsIgnoreCase("android")) {
                double yValue = element1FromList1.equals("flutter") ? 5 : 10; // Assign y-axis value based on platform
                series.addOrUpdate(new Millisecond(myDate), yValue);
            } else {
                double xValue = element1FromList1.equals("I/flutter") ? 5 : 10; // Assign x-axis value based on platform
                series.addOrUpdate(new Millisecond(myDate), xValue);
            }


            final XYDataset dataset = new TimeSeriesCollection(series);
            JFreeChart timechart =
                    ChartFactory.createTimeSeriesChart(
                            "FLUTTER UNITY  ", "MilliSeconds", "5 = Flutter , 10 = Unity", dataset, false, false, false);

            //Swap the orientation to make time as the y-axis
            XYPlot plot = (XYPlot) timechart.getPlot();
            plot.setOrientation(PlotOrientation.HORIZONTAL);

            int width = 1600; /* Width of the image */
            int height = 1600; /* Height of the image */
            File timeChart = new File("TimeChart1.jpeg");
            ChartUtils.saveChartAsJPEG(timeChart, timechart, width, height);

        }
    }

}
