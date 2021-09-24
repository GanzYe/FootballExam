package com.exam.footballleague.services;

import com.exam.footballleague.models.LastMatchesVideos.LastMatchesVideos;
import com.exam.footballleague.models.LiveSoccer.LiveSoccer;
import com.exam.footballleague.models.Standings.Standings;
import com.exam.footballleague.models.Teams.Teams;

import java.util.List;

public interface RestSoccerService {

    LiveSoccer getAllLiveSoccers();

    List<LastMatchesVideos> getLastMatchesVideos();

    Standings getLeagueStanding();

    Teams getFootBallTeam(String name);
}
