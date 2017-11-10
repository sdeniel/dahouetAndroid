package metier;

import java.util.Date;

public class Challenge {

    private int challengeID;
    private String nomChallenge;
    private Date dateDebut;
    private Date dateFin;

    public Challenge(int challengeID, String nomChallenge, Date dateDebut, Date dateFin) {
        this.challengeID = challengeID;
        this.nomChallenge = nomChallenge;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getChallengeID() {
        return challengeID;
    }

    public String getNomChallenge() {
        return nomChallenge;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    @Override
    public String toString() {
        return "Challenge N°" + challengeID +
                "\nNom : '" + nomChallenge + '\'' +
                "\nDébute le : " + dateDebut +
                "\nSe termine le :" + dateFin +
                '}';
    }
}
