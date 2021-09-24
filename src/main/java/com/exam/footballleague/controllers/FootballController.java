package com.exam.footballleague.controllers;

import com.exam.footballleague.services.RestSoccerService;
import com.exam.footballleague.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FootballController {
    private final RestSoccerService restSoccerService;

    public FootballController(UserService userService, RestSoccerService restSoccerService) {
        this.restSoccerService = restSoccerService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {

        var liveSoccer = restSoccerService.getAllLiveSoccers();
        model.addAttribute("liveSoccer",liveSoccer);

        var leagueStanding = restSoccerService.getLeagueStanding();
        model.addAttribute("leagueStanding",leagueStanding.getData());

        var lastMatchesVideos = restSoccerService.getLastMatchesVideos();
        model.addAttribute("lastMatchesVideos",lastMatchesVideos);

        return "index";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value ="/search", method = RequestMethod.GET)
    public String searchFootballTeam(@RequestParam(value ="name",required = false)String name, Model model) {
        model.addAttribute("teams",restSoccerService.getFootBallTeam(name).getResponse());
        return "teams";
    }
}
