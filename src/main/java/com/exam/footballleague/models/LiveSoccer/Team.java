package com.exam.footballleague.models.LiveSoccer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private Long id;

    private String name;

    private String logo;

}
