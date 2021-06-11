package be.OdiMentee.UserAdministrationMicroService.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfielDTO {

    private String voornaam;

    private String achternaam;

    private Boolean isGeblokkeerd;

    private Boolean isMentor;



    private Boolean isMentee;

    private Long opleidingfase;

    private String studierichting;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    private long userId;


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

    public Boolean getIsMentor() {
        return isMentor;
    }

    public void setIsMentor(Boolean mentor) {
        isMentor = mentor;
    }

    public Boolean getIsMentee() {
        return isMentee;
    }

    public void setIsMentee(Boolean mentee) {
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

    public ProfielDTO() {

    }
}
