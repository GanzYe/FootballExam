package com.exam.footballleague.models.Teams;

import com.exam.footballleague.models.LiveSoccer.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    Team team;
}
