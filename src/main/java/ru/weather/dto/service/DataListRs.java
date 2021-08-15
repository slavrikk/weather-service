package ru.weather.dto.service;

import lombok.Data;

import java.util.List;

@Data
public class DataListRs {

    private String cod;
    private String message;
    private Integer count;
    private List<DataRs> list;

}
