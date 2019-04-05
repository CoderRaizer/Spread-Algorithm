package spread_algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    private static final String FILENAME = "D:\\zFile\\recipe.txt";

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;

        try {
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);

                String currentLine;

                while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                }

            } catch (IOException e) {
                    e.printStackTrace();
                }

        // TODO : Close session read file
        finally {
                try {
                    if (br != null)
                    br.close();
                    if (fr != null)
                    fr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    }

            }

    }
}
