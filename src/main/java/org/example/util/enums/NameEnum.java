package org.example.util.enums;

public enum NameEnum {
    SHEET_NAME("Lab-3"),
    SUBJECT_NAME("Tecrubi verilenler"),
    FILE_NAME("tecrubi-verilenler-serbest-java.xlsx"),
    PROGRAM_NAME("AI-ZMİU"),
    //Column names
    X_VALUES_NAME("X-in qiymetleri"),
    SORTED_VALUES_NAME("Ranqlanmis sira"),
    STUDENT_SCORES_NAME("Telebelerin qiymetleri"),
    STUDENT_COUNT_NAME("Telebelerin sayi"),
    SUM_FREQUENCY_NAME("Toplam tezlik"),
    RELATIVE_FREQUENCY_NAME("Nisbi tezlik"),
    SUM_RELATIVE_FREQUENCY_NAME("Toplam nisbi tezlik"),
    MEAN_VALUE_MX_NAME("Orta qiymet Mx"),
    MEAN_VALUE_WX_NAME("Orta qiymet Wx"),
    MEDIAN_NAME("Median"),
    MODA_NAME("Moda"),
    X_MEAN_DEVIATION_NAME("X orta yayinma"),
    QUADRATIC_X_MEAN_NAME("X orta kvadrat"),
    DISPERSION_NAME("Dispersiya"),
    QUADRATIC_X_MEAN_DEVIATION_NAME("Kvadratik orta yayinma"),
    ASSIMETRIC_NAME("Assimetriya"),
    EKSES_NAME("Ekses");
    private final String claim;
    NameEnum(String claim) {
        this.claim = claim;
    }
    public String getClaim() {
        return claim;
    }
}
