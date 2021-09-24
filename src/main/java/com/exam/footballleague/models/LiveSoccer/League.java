package com.exam.footballleague.models.LiveSoccer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private String name;

    private String country;

    private String logo;

    private String round;

}
