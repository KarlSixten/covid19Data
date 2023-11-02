import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
    ArrayList<Covid19Data> dataListe;
    boolean uiIsRunning = true;

    public UserInterface() throws IOException {
        Filehandler filehandler = new Filehandler();
        this.dataListe = filehandler.loadData();
    }

    public void start() throws IOException {
        Scanner input = new Scanner(System.in);

        while (uiIsRunning) {
            showMainMenu();

            switch (input.nextInt()) {
                case 1 -> printData();
                case 2 -> sorterEfterRegion();
                case 3 -> sorterEfterAldersgruppe();
                case 4 -> sorterEfterAntalBekræftedeTilfælde();
                case 5 -> sorterEfterAntalDøde();
                case 6 -> sorterEfterAntalIndlagtePåIntensiv();
                case 7 -> sorterEfterAntalIndlagte();
                case 8 -> sorterEfterPrimærOgSekundær();
                case 9 -> afslut();
                default -> System.out.println("Ugyldigt input.\n");
            }
        }
    }
    private void showMainMenu() {
        System.out.println("1. Vis data." +
                "\n2. Sorter data efter region." +
                "\n3. Sorter data efter aldersgruppe." +
                "\n4. Sorter data efter bekræftede tilfælde." +
                "\n5. Sorter data efter antal døde" +
                "\n6. Sorter data efter antal indlagte på intensiv" +
                "\n7. Sorter data efter antal indlagte." +
                "\n8. Sorter efter primær og sekundær metode. [IKKE FUNKTIONEL]" +
                "\n9. Afslut.");
    }
    private void printData() {
        System.out.println("----------------------------");
        for (Covid19Data dataPunkt : dataListe) {
            System.out.println(dataPunkt +
                    "\n----------------------------");
        }
    }
    private void sorterEfterRegion() {
        dataListe.sort(new RegionComparator());
        System.out.println("Data sorteret efter region.\n");
    }
    private void sorterEfterAldersgruppe() {
        dataListe.sort(new AldersgruppeComparator());
        System.out.println("Data sorteret efter aldersgruppe.\n");
    }
    private void sorterEfterAntalBekræftedeTilfælde() {
        dataListe.sort(Comparator.comparing(Covid19Data::getBekræftedeIAlt));
        System.out.println("Data sorteret efter antal bekræftede tilfælde.\n");
    }
    private void sorterEfterAntalDøde() {
        dataListe.sort(Comparator.comparing(Covid19Data::getDøde));
        System.out.println("Data sorteret efter antal døde.\n");
    }
    private void sorterEfterAntalIndlagtePåIntensiv() {
        dataListe.sort(Comparator.comparing(Covid19Data::getIndlagtPåIntensiv));
        System.out.println("Data sorteret efter antal indlagte på intensiv.\n");
    }
    private void sorterEfterAntalIndlagte() {
        dataListe.sort(Comparator.comparing(Covid19Data::getIndlagte));
        System.out.println("Data sorteret efter antal indlagte.\n");
    }
    private void sorterEfterPrimærOgSekundær() {
        // Ikke funktionel endnu
        System.out.println("Vælg primær sortering:" +
                "\n1. Region." +
                "\n2. Aldersgruppe.+" +
                "\n3. Bekræftede tilfælde." +
                "\n4. Antal døde." +
                "\n5. Antal indlagte på intensiv." +
                "\n6. Antal indlagte.");
    }
    private void afslut() {
        uiIsRunning = false;
        System.out.println("Afslutter...");
    }
}
