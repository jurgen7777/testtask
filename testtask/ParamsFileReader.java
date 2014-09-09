package testtask;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParamsFileReader {

    private static ArrayList<String> itemsList;
    private static FileReader inputStream = null;

    public static ArrayList<String> readParamsFile(String filePath) {

        itemsList = new ArrayList<>();

        try {
            inputStream = new FileReader(filePath);

            int c;
            String item = "";

            while ((c = inputStream.read()) != -1) {
                char ch = (char)c;
                if (Character.toString(ch).compareTo(",") == 0) {

                    // Add string into the list
                    itemsList.add(item);

                    item = "";
                } else {
                    item += ch;
                }

            }

            itemsList.add(item);

        }
        catch(IOException e) {
            System.out.println("Params file not found");
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Cannot close stream");
                }
            }
        }
        return itemsList;
    }

}
