package metier;

import java.util.Date;

/**
 * Created by sdeniel on 09/11/17.
 */

public class Regate {

    private int regateID;
    private String nomRegate;
    private Date dateRegate;
    private int distance;
    private int challengeID;

    public Regate(int regateID, String nomRegate, Date dateRegate, int distance, int challengeID) {
        this.regateID = regateID;
        this.nomRegate = nomRegate;
        this.dateRegate = dateRegate;
        this.distance = distance;
        this.challengeID = challengeID;
    }

    public int getRegateID() {
        return regateID;
    }

    public String getNomRegate() {
        return nomRegate;
    }

    public Date getDateRegate() {
        return dateRegate;
    }

    public int getDistance() {
        return distance;
    }

    public int getChallengeID() {
        return challengeID;
    }

    @Override
    public String toString() {
        return "Regate N°" + regateID +
                " - '" + nomRegate + '\'' +
                "\nA lieu le :" + dateRegate +
                "\nsur " + distance +
                "kms" + '}';
    }

}
