package com.exam.footballleague.services;

import com.exam.footballleague.models.LastMatchesVideos.LastMatchesVideos;
import com.exam.footballleague.models.LiveSoccer.LiveSoccer;
import com.exam.footballleague.models.Standings.Standings;
import com.exam.footballleague.models.Teams.Teams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class RestSoccerServiceImpl implements RestSoccerService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${myapi.key}")
    private String key;

    private HttpEntity GetHttpHeaders(String host){
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", host);
        headers.set("x-rapidapi-key", key);

        return new HttpEntity(headers);

    }


    @Override
    public LiveSoccer getAllLiveSoccers() {

        var response = restTemplate.exchange
                ("https://api-football-v1.p.rapidapi.com/v3/fixtures?live=all",
                        HttpMethod.GET,
                        GetHttpHeaders("api-football-v1.p.rapidapi.com"),
                        LiveSoccer.class);

        LiveSoccer liveSoccer = response.getBody();

        log.info(liveSoccer.toString());
        return liveSoccer;
    }

    @Override
    public List<LastMatchesVideos> getLastMatchesVideos() {

        ResponseEntity<List<LastMatchesVideos>> response = restTemplate.exchange
                ("https://free-football-soccer-videos.p.rapidapi.com/",
                        HttpMethod.GET,
                        GetHttpHeaders("free-football-soccer-videos.p.rapidapi.com"),
                        new ParameterizedTypeReference<List<LastMatchesVideos>>() {
                        });

        List<LastMatchesVideos> lastMatchesVideos = response.getBody();

        log.info(lastMatchesVideos.toString());

        return lastMatchesVideos.subList(1,5);
    }

    @Override
    public Standings getLeagueStanding() {
        var response = restTemplate.exchange
                ("https://football-pro.p.rapidapi.com/api/v2.0/standings/season/live/18576",
                        HttpMethod.GET,
                        GetHttpHeaders("football-pro.p.rapidapi.com"),
                        Standings.class);

        Standings leagueStanding = response.getBody();

        log.info(leagueStanding.toString());
        return leagueStanding;
    }

    @Override
    public Teams getFootBallTeam(String name) {

        var response = restTemplate.exchange
                ("https://api-football-v1.p.rapidapi.com/v3/teams?name="+name,
                        HttpMethod.GET,
                        GetHttpHeaders("api-football-v1.p.rapidapi.com"),
                        Teams.class);

        Teams teams = response.getBody();

        log.info(teams.toString());

        return teams;
    }
}
