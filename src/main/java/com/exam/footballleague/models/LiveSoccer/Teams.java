package com.exam.footballleague.models.LiveSoccer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {

    private Team home;

    private Team away;

}
