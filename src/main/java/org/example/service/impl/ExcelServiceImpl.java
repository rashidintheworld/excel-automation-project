package org.example.service.impl;
import org.example.service.ExcelService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelServiceImpl implements ExcelService {
    @Override
    public List<Integer> createValuesListColumn(List<Integer> values) {
        List<Integer> rankedValues = new ArrayList<>(values);
        return rankedValues;
    }

    @Override
    public List<Integer> createSortedListColumn(List<Integer> values) {
        List<Integer> rankedValues = new ArrayList<>(values);
        rankedValues.sort(Integer::compareTo);
        return rankedValues;
    }

    @Override
    public List<Integer> createStudentScoresColumn(List<Integer> values) {
        List<Integer> sortedUniqueValues = values.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        return sortedUniqueValues;
    }

    @Override
    public List<Integer> createStudentFrequencyColumn(List<Integer> values) {
        List<Integer> sortedList = values.stream()
                .sorted()
                .toList();

        return sortedList.stream()
                .distinct()
                .map(num -> Math.toIntExact(sortedList.stream().filter(n -> n.equals(num)).count()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> createSumFrequencyColumn(List<Integer> values) {
        List<Integer> frequencyList = createStudentFrequencyColumn(values);

        List<Integer> sumFrequencyList = new ArrayList<>();
        sumFrequencyList.add(frequencyList.get(0));

        int sum = frequencyList.get(0);
        for (int i = 1; i < frequencyList.size(); i++) {
            sum += frequencyList.get(i);
            if (sum >= 51) {
                sum = 51;
                sumFrequencyList.add(sum);
                break;
            } else {
                sumFrequencyList.add(sum);
            }
        }
        return sumFrequencyList;
    }

    @Override
    public List<Double> createRelativeFrequencyColumn(List<Integer> values) {
        List<Integer> studentFrequency = createStudentFrequencyColumn(values);
        List<Double> relativeFrequencyList = new ArrayList<>();
        for (int i = 0; i < studentFrequency.size(); i++) {
            double relativeFrequency = (double) studentFrequency.get(i) / 51;
            relativeFrequencyList.add(relativeFrequency);
        }
        return relativeFrequencyList;
    }

    @Override
    public List<Double> createSumRelativeFrequencyColumn(List<Integer> values) {
        List<Integer> studentFrequency = createSumFrequencyColumn(values);
        List<Double> relativeFrequencyList = new ArrayList<>();
        for (int i = 0; i < studentFrequency.size(); i++) {
            double relativeFrequency = (double) studentFrequency.get(i) / 51;
            relativeFrequencyList.add(relativeFrequency);
        }
        return relativeFrequencyList;
    }

    @Override
    public List<Integer> createMeanValueMxColumn(List<Integer> values) {
        List<Integer> valuesList = createValuesListColumn(values);
        List<Integer> studentFrequencyList = createStudentFrequencyColumn(values);

        List<Integer> meanValueMxList = new ArrayList<>();

        for (int i = 0; i < studentFrequencyList.size(); i++) {
            meanValueMxList.add(valuesList.get(i) * studentFrequencyList.get(i));
        }
        return meanValueMxList;
    }

    @Override
    public List<Double> createMeanValueWxColumn(List<Integer> values) {
        List<Integer> valuesList = createValuesListColumn(values);
        List<Double> studentFrequency = createRelativeFrequencyColumn(values);

        List<Double> meanValueWxList = new ArrayList<>();
        for (int i = 0; i < studentFrequency.size(); i++) {
            double meanValueWx = valuesList.get(i) * studentFrequency.get(i);
            meanValueWxList.add(meanValueWx);
        }
        return meanValueWxList;
    }


    @Override
    public List<Integer> createMedianColumn(List<Integer> values) {
        List<Integer> medianList = new ArrayList<>();
        int value = Math.round((values.size() / 2.0f));
        medianList.add(value);
        medianList.add(createSortedListColumn(values).get(value - 1));
        return medianList;
    }

    @Override
    public List<Integer> createModeColumn(List<Integer> values) {
        List<Integer> valuesList = createValuesListColumn(values);
        List<Integer> frequencyColumnList = createStudentFrequencyColumn(values);
        List<Integer> modeList = new ArrayList<>();
        int maxValue = Collections.max(frequencyColumnList);
        modeList.add(maxValue);
        modeList.add(valuesList.get(maxValue - 1));
        return modeList;
    }

    @Override
    public List<Double> createXMeanDeviationColumn(List<Integer> values) {
        List<Integer> valuesList = createValuesListColumn(values);
        List<Integer> meanValueMxColumnList = createMeanValueMxColumn(values);
        List<Integer> scoresList = createStudentScoresColumn(values);
        List<Double> resultList = new ArrayList<>();
        /* Olcu -> */
        int listSize = valuesList.size();
        /* Cem -> */
        int sum = meanValueMxColumnList.stream().reduce(0, Integer::sum);

        /* Telebe qiymetleri -> */
        for (Integer integer : scoresList) {
            double result = integer - ((double) sum / valuesList.size());
            resultList.add(result);
        }
        return resultList;
    }

    @Override
    public List<Double> createQuadraticXMeanColumn(List<Integer> values) {
        List<Double> xMeanDeviationColumnList = createXMeanDeviationColumn(values);
        List<Double> resultList = new ArrayList<>();

        for (Double doubleNum : xMeanDeviationColumnList) {
            double doubleNumQuadrat = Math.pow(doubleNum, 2);
            resultList.add(doubleNumQuadrat);
        }
        return resultList;
    }

    @Override
    public List<Double> createDispersionColumn(List<Integer> values) {
        List<Double> quadraticXMeanColumnList = createQuadraticXMeanColumn(values);
        List<Integer> frequencyColumnList = createStudentFrequencyColumn(values);
        List<Double> resultList = new ArrayList<>();
        if (quadraticXMeanColumnList.size() == frequencyColumnList.size()) {
            for (int i = 0; i < quadraticXMeanColumnList.size(); i++) {
                double result = quadraticXMeanColumnList.get(i) * frequencyColumnList.get(i);
                resultList.add(result);
            }
        } else {
            System.out.println("Xeta: Uzunluqlar ferqlidir...");
        }
        return resultList;
    }

    @Override
    public List<Double> createQuadraticMeanDeviationColumn(List<Integer> values) {
        List<Double> dispersionColumnList = createDispersionColumn(values);
        List<Double> resultList = new ArrayList<>();
        double sum = dispersionColumnList.stream().reduce(0.0, Double::sum);
        double sqrtNum = Math.sqrt(sum);
        resultList.add(sqrtNum);
        return resultList;
    }

    @Override
    public List<Double> createAssimetricColumn(List<Integer> values) {
        List<Double> xMeanDeviationColumnList = createXMeanDeviationColumn(values);
        List<Integer> frequencyColumnList = createStudentFrequencyColumn(values);
        List<Double> resultList = new ArrayList<>();
        resultList.add(Math.pow(xMeanDeviationColumnList.get(0), 4) * frequencyColumnList.get(0));
        if (xMeanDeviationColumnList.size() == frequencyColumnList.size()) {
            for (int i = 1; i < xMeanDeviationColumnList.size(); i++) {
                double xMeanDeviationPow4 = Math.pow(xMeanDeviationColumnList.get(i), 3);
                double result = frequencyColumnList.get(i) * xMeanDeviationPow4;
                resultList.add(result);
            }
        } else {
            System.out.println("Xeta: Uzunluqlar ferqlidir...");
        }
        return resultList;
    }

    @Override
    public List<Double> createEksesColumn(List<Integer> values) {
        List<Double> xMeanDeviationColumnList = createXMeanDeviationColumn(values);
        List<Integer> frequencyColumnList = createStudentFrequencyColumn(values);
        List<Double> resultList = new ArrayList<>();
        if (xMeanDeviationColumnList.size() == frequencyColumnList.size()) {
            for (int i = 0; i < xMeanDeviationColumnList.size(); i++) {
                double mathPowNum = Math.pow(xMeanDeviationColumnList.get(i),4);
                double result = frequencyColumnList.get(i) * mathPowNum ;
                resultList.add(result);
            }
        } else {
            System.out.println("Xeta: Uzunluqlar ferqlidir...");
        }
        return resultList;
    }
}
