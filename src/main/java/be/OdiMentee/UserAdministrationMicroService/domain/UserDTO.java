package be.OdiMentee.UserAdministrationMicroService.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private String username;
    private String password;

    private String voornaam;

    private String achternaam;
    @JsonProperty
    private boolean isGeblokkeerd;
@JsonProperty
    private boolean isMentor;
    @JsonProperty
    private boolean isMentee;

    private Long opleidingfase;

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Boolean getGeblokkeerd() {
        return isGeblokkeerd;
    }

    public void setGeblokkeerd(Boolean geblokkeerd) {
        isGeblokkeerd = geblokkeerd;
    }

    public Boolean getMentor() {
        return isMentor;
    }

    public void setMentor(Boolean mentor) {
        isMentor = mentor;
    }

    public Boolean getMentee() {
        return isMentee;
    }

    public void setMentee(Boolean mentee) {
        isMentee = mentee;
    }

    public Long getOpleidingfase() {
        return opleidingfase;
    }

    public void setOpleidingfase(Long opleidingfase) {
        this.opleidingfase = opleidingfase;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    private String studierichting;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
