package ANR;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ReadLogs {

    public ArrayList<ArrayList<String>> twoDArray= new ArrayList<>();
    public ArrayList<String> flutterList= new ArrayList<>();
    public ArrayList<String> unityList= new ArrayList<>();


    public static void main(String[] args) throws ParseException {

        ReadLogs test= new ReadLogs();
        test.readLogs();
        test.print2DArray();
        test.diffInDuration();
    }

    public void printDeviceLogs() throws FileNotFoundException, ParseException {
        String filePath="ANR/src/test/resources/logs.txt";
//        PrintStream fileStream = new PrintStream(new File(filePath));
//        // Redirect System.out to the file stream
//        System.setOut(fileStream);
//
//        long t0 = 0;
//        long t1 = 0;
//
//        List<LogEntry> logEntries = driver.manage().logs().get("logcat").getAll();
//        for (LogEntry logEntry : logEntries) {
//
//            if (logEntry.getMessage().contains("flutter : Lobby Event Added ::  lobby_play_now_clicked")) {
//                t0=logEntry.getTimestamp();
//                System.out.println(logEntry.getMessage());
//            }
//
//            if (logEntry.getMessage().contains("Unity   : Changing orientation from Game Table current Orientation Portrait change to LandscapeLeft")) {
//                t1=logEntry.getTimestamp();
//                System.out.println(logEntry.getMessage());
//            }
//        }
//        fileStream.close();

    }

    public void readLogs() {
        String filePath = "src/test/resources/output.txt"; // Replace with the actual path to your log file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            Pattern pattern = Pattern.compile("((.*?)\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+(.*?)) .* ((flutter|Unity))", Pattern.CASE_INSENSITIVE);

            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String timestamp = matcher.group(1);
                    String logType = matcher.group(4);
                  //  System.out.printf("[%s] -> Log type (Flutter/Unity): [%s]%n", timestamp, logType);

                    if(logType.equalsIgnoreCase("flutter"))
                    {
                        flutterList.add(timestamp);
                    }
                    if(logType.equalsIgnoreCase("unity"))
                    {
                        unityList.add(timestamp);
                    }
                }

            }
            // Close the resources
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void diffInDuration() throws ParseException {

         for(int i=0;i<flutterList.size();i++) {
            String timestamp0=flutterList.get(i);
            String timestamp1=unityList.get(i);

            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
            Date date1 = sdf.parse(timestamp0);
            Date date2 = sdf.parse(timestamp1);

            // Calculate the time difference in milliseconds
            long timeDifference = date2.getTime() - date1.getTime();

            // Convert milliseconds to seconds
            long secondsDifference = timeDifference / 1000;

            // Print the result
            System.out.println("Time difference: " + secondsDifference + " seconds");

        }

    }
    public void print2DArray()
    {
        System.out.print("      t0 (lobby)       " + "|| ");
        System.out.print("    t1 (game table)     || " );
        System.out.println();
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


}
