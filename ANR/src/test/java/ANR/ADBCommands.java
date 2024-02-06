package ANR;
import java.io.*;

public class ADBCommands {

    public static void main(String[] args) {
        try {
            // Specify your ADB command
          //  String adbCommand = "adb shell logcat | grep -E \"(flutter|Unity)\"";

        //    String adbCommand="adb logcat -d flutter Unity";

            String adbCommand="adb logcat -d --file=/sdcard/device.txt";

            // Create a FileWriter to write to a text file
            FileWriter fileWriter = new FileWriter("/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/demo.txt");

            // Execute the ADB command
            Process process = Runtime.getRuntime().exec(adbCommand);

            // Read the output of the ADB command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {

                if(line.contains("flutter : Lobby Event Added ::  lobby_play_now_clicked"))
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

            // Close the FileWriter
            fileWriter.close();

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Print the exit code of the process
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}