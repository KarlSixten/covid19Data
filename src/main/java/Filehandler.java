import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    public ArrayList<Covid19Data> loadData() throws IOException {
        Scanner scanner = new Scanner(new File("covid19Datasheet.csv"), StandardCharsets.ISO_8859_1);
        ArrayList<Covid19Data> dataPoints = new ArrayList<>();
        int invalidLines = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (lineIsValid(parts[0])) {
                Covid19Data dataObj = new Covid19Data(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6]);
                dataPoints.add(dataObj);
            } else { invalidLines++; }
        }
        return dataPoints;
    }

        public boolean lineIsValid (String line){
            switch (line) {
                case "Hovedstaden", "Midtjylland", "Nordjylland", "Sjælland", "Syddanmark" -> { return true; }
                default -> { return false; }
            }
        }
    }


