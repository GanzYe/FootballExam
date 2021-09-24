package com.exam.footballleague.models.LiveSoccer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveSoccer {
    private String results;
    private List<Response> response;
}
