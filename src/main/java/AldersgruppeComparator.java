import java.util.Comparator;

public class AldersgruppeComparator implements Comparator<Covid19Data> {
    @Override
    public int compare(Covid19Data data1, Covid19Data data2) {
        return data1.getAldersgruppe().compareTo(data2.getAldersgruppe());
    }
}
