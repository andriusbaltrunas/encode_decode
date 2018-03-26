package coding;


import java.io.*;
import java.util.*;

/**
 * Created by andriusbaltrunas on 3/26/2018.
 */
public class ReadWriteDataHandler {

    private static final String CODE_FILE_NAME = "files/koduote.txt";
    private static final String FILE_PATH = "files/";

    public void readFileAndPutToMaps(Map<String, String> codeMap, Map<String, String> valuesMap) throws JACodeException {

        try (BufferedReader bf = new BufferedReader(new FileReader(CODE_FILE_NAME))) {

            String line;
            while ((line = bf.readLine()) != null) {
                String[] items = line.split(" ");
                if (items.length != 2) {
                    throw new JACodeException("Koduote yra bloga");
                }
                codeMap.put(items[0], items[1]);
                valuesMap.put(items[1], items[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeDataIntoFile(List<String> items, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH + fileName))) {
            for (String item : items) {
                bw.write(item);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Can t write data to file");
        }
    }


    public List<String> readEncodedFile(String fileName){
        List<String> result = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH + fileName))){
            String line;
            while ((line = bf.readLine()) != null){
                result.add(line);
            }
        }catch (IOException e){
            System.out.println("Can`t read file " +fileName);
        }
        return result;
    }
}
