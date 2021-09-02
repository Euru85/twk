/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.LeagueEndpoint;


@Named(value = "listLeaguePageBean")
@RequestScoped
public class ListLeaguePageBean {

    @EJB
    private LeagueEndpoint leagueEndpoint;
    private List<LeagueDTO> listLeagueDTO;
    @Inject
    private LeagueController leagueController;
    
    public ListLeaguePageBean() {
    }

    public List<LeagueDTO> getListLeagueDTO() {
        return listLeagueDTO;
    }

    public void setListLeagueDTO(List<LeagueDTO> listtLeagueDTO) {
        this.listLeagueDTO = listtLeagueDTO;
    }
    
    public String showLeagueDetailsAction(LeagueDTO leagueDTO){
        leagueController.setSelectedLeagueDTO(leagueDTO);
        return "goToLeagueDetails";
    }
    
    
    @PostConstruct
    private void init(){
        listLeagueDTO = leagueEndpoint.listAllLeagues();
    }
    
}
