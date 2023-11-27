package org.example.service;

import java.util.List;

public interface ExcelService {
    List<Integer> createValuesListColumn(List<Integer> values); //X-in qiymetleri
    List<Integer> createSortedListColumn(List<Integer> values); //Ranqlanmis sira
    List<Integer> createStudentScoresColumn(List<Integer> values); //Telebe qiymetleri
    List<Integer> createStudentFrequencyColumn(List<Integer> values); //Telebe tezlik
    List<Integer> createSumFrequencyColumn(List<Integer> values); //Toplam tezlik
    List<Double> createRelativeFrequencyColumn(List<Integer> values); //Nisbi tezlik
    List<Double> createSumRelativeFrequencyColumn(List<Integer> values); //Toplam Nisbi tezlik
    List<Integer> createMeanValueMxColumn(List<Integer> values); //Orta qiymet
    List<Double> createMeanValueWxColumn(List<Integer> values); //Orta qiymet
    List<Integer> createMedianColumn(List<Integer> values); //Median
    List<Integer> createModeColumn(List<Integer> values); //Moda
    List<Double> createXMeanDeviationColumn(List<Integer> values); //X orta yayinma
    List<Double> createQuadraticXMeanColumn(List<Integer> values); //X orta kvadrati
    List<Double> createDispersionColumn(List<Integer> values); //Dispersiya
    List<Double> createQuadraticMeanDeviationColumn(List<Integer> values); //Kvadratik orta yayinma
    List<Double> createAssimetricColumn(List<Integer> values); // Assimetriya
    List<Double> createEksesColumn(List<Integer> values); // Ekses

}
