package coding;

import java.util.*;

/**
 * Created by andriusbaltrunas on 3/26/2018.
 */
public class JACodeExample {

    private static final String ENCODED_FILE_NAME = "encoded_file.txt";
    private static final String DECODED_FILE_NAME = "decoded_file.txt";
    private static final String SPACE = "tarpas";

    public static void main(String[] args) {

        Map<String, String> codeMap = new HashMap<>();
        Map<String, String> valuesMp = new HashMap<>();

        ReadWriteDataHandler readWriteDataHandler = new ReadWriteDataHandler();
        try {
            readWriteDataHandler.readFileAndPutToMaps(codeMap, valuesMp);

            encodeInsertedText(valuesMp, readWriteDataHandler);

            decodeTextAndSaveText(readWriteDataHandler, codeMap);

        } catch (JACodeException e) {
            System.out.println("Programa negali buti ivykdita, nes koduote pazeista");
        }


    }

    private static void encodeInsertedText(Map<String, String> valuesMap, ReadWriteDataHandler readWriteDataHandler) {
        List<String> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite teksta kodavimui");
        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            String temp = String.valueOf(line.charAt(i));
            String letter = temp.equals(" ") ? SPACE : temp;
            items.add(String.valueOf(valuesMap.get(letter)));
        }
        readWriteDataHandler.writeDataIntoFile(items, ENCODED_FILE_NAME);
    }

    private static void decodeTextAndSaveText(ReadWriteDataHandler readWriteDataHandler, Map<String, String> codeMap) {
        List<String> readCode = readWriteDataHandler.readEncodedFile(ENCODED_FILE_NAME);
        StringBuilder sb = new StringBuilder();
        for (String c : readCode) {
            String letter = codeMap.get(c);
            sb.append(letter.equals(SPACE) ? " " : letter);
        }
        List<String> items = new ArrayList<>();
        items.add(sb.toString());

        readWriteDataHandler.writeDataIntoFile(items, DECODED_FILE_NAME);
    }
}
