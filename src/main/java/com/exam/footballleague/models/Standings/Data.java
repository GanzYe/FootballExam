package com.exam.footballleague.models.Standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private Integer position;

    private Integer played;

    private String team_id;

    private String team_name;

    private String team_logo;

    private String goals;

    private Integer goal_diff;

    private Integer wins;

    private Integer lost;

    private Integer draws;

    private Integer points;

    private String description;

}
