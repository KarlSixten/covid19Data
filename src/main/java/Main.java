import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Filehandler filehandler = new Filehandler();
        filehandler.loadData();

        System.out.println(filehandler.loadData());
        System.out.println("\nAntal datapunkter: " + filehandler.loadData().size());
        System.out.println("");


    }
}
