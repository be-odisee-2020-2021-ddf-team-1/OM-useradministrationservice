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

    public ProfielDTO() {

    }
}
