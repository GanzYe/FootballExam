package com.exam.footballleague.models.Standings;

import com.exam.footballleague.models.LiveSoccer.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standings {
    private List<Data> data;
}
