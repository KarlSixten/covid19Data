public class Covid19Data {
    private String region;
    private String aldersgruppe;
    private int bekræftedeIAlt;
    private int døde;
    private int indlagtPåIntensiv;
    private int indlagte;
    private String dato;
    public Covid19Data(String region, String aldersgruppe, int bekræftedeIAlt, int døde, int indlagtPåIntensiv, int indlagte, String dato){
        this.region = region;
        this.aldersgruppe = aldersgruppe;
        this.bekræftedeIAlt = bekræftedeIAlt;
        this.døde = døde;
        this.indlagtPåIntensiv = indlagtPåIntensiv;
        this.indlagte = indlagte;
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "\n\nRegion: " + region + "\nAldersgruppe: " + aldersgruppe + "\nBekræftede tilfælde: " + bekræftedeIAlt +
                "\nAntal døde: " + døde + "\nIndlagt på intensiv: " + indlagtPåIntensiv + "\nIndlagte: " + indlagte +
                "\nDato: " + dato;
    }
}

