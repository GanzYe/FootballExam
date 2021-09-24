package com.exam.footballleague.models.LastMatchesVideos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastMatchesVideos {
    private String embed;
}
