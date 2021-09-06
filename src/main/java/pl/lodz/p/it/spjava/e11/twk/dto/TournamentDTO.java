/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import java.util.Date;
import java.util.List;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;
import pl.lodz.p.it.spjava.e11.twk.model.League;
import pl.lodz.p.it.spjava.e11.twk.model.Organizator;
import pl.lodz.p.it.spjava.e11.twk.model.TParticipant;
import pl.lodz.p.it.spjava.e11.twk.model.TRound;


/**
 *
 * @author Adam
 */
public class TournamentDTO {

   private Long id;
   private Boolean closed;
   private Integer currentRound;
   private String description;
   private Integer rounds;
   private String tournamentName;
   private GameSystem gameSystemId;
   private League leagueId;
   private Organizator organizatorId;
   private Date tDate;
   private List<TRound> tRoundList;
   private List<TParticipant> tParticipantList;

    public TournamentDTO(Long id, Boolean closed, Integer currentRound, String description, Integer rounds, String tournamentName, GameSystem gameSystemId, League leagueId, Organizator organizatorId, List<TRound> tRoundList, List<TParticipant> tParticipantList, Date tDate) {
        this.id = id;
        this.closed = closed;
        this.currentRound = currentRound;
        this.description = description;
        this.rounds = rounds;
        this.tournamentName = tournamentName;
        this.gameSystemId = gameSystemId;
        this.leagueId = leagueId;
        this.organizatorId = organizatorId;
        this.tRoundList = tRoundList;
        this.tParticipantList = tParticipantList;
        this.tDate =  tDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Integer currentRound) {
        this.currentRound = currentRound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public GameSystem getGameSystemId() {
        return gameSystemId;
    }

    public void setGameSystemId(GameSystem gameSystemId) {
        this.gameSystemId = gameSystemId;
    }

    public League getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(League leagueId) {
        this.leagueId = leagueId;
    }

    public Organizator getOrganizatorId() {
        return organizatorId;
    }

    public void setOrganizatorId(Organizator organizatorId) {
        this.organizatorId = organizatorId;
    }

    public List<TRound> gettRoundList() {
        return tRoundList;
    }

    public void settRoundList(List<TRound> tRoundList) {
        this.tRoundList = tRoundList;
    }

    public List<TParticipant> gettParticipantList() {
        return tParticipantList;
    }

    public void settParticipantList(List<TParticipant> tParticipantList) {
        this.tParticipantList = tParticipantList;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }
   
   
   

}
