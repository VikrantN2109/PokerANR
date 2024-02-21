package ANR;

import java.io.*;

public class ADBLogsExtractor {

    public static void main(String[] args) {
        // Define the ADB command
        String adbCommand = "adb logcat flutter Unity";

        // Define the file to write the logs
        String outputFile = "/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/logcat.txt";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(adbCommand.split("\\s+"));
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Get the input stream of the process
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Create FileWriter to write the logs to a file
            FileWriter writer = new FileWriter(outputFile);

            // Read the output of the process and write it to the file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }

            // Close resources
            reader.close();
            writer.close();
            process.destroy();

            System.out.println("ADB logs have been saved to " + outputFile);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
