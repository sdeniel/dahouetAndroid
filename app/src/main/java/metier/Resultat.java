package metier;

/**
 * Created by sdeniel on 10/11/17.
 */

public class Resultat {
    private int participationID;
    private float tempsReel, tempsCompense;
    private int position;
    private boolean presence, retard, abandon;
    private int regateID, equipageID;
    private String numeroVoile;

    public Resultat(int participationID, float tempsReel, float tempsCompense, int position, boolean presence, boolean retard, boolean abandon, int regateID, int equipageID, String numeroVoile) {
        this.participationID = participationID;
        this.tempsReel = tempsReel;
        this.tempsCompense = tempsCompense;
        this.position = position;
        this.presence = presence;
        this.retard = retard;
        this.abandon = abandon;
        this.regateID = regateID;
        this.equipageID = equipageID;
        this.numeroVoile = numeroVoile;
    }

    public int getParticipationID() {
        return participationID;
    }

    public float getTempsReel() {
        return tempsReel;
    }

    public float getTempsCompense() {
        return tempsCompense;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPresence() {
        return presence;
    }

    public boolean isRetard() {
        return retard;
    }

    public boolean isAbandon() {
        return abandon;
    }

    public int getRegateID() {
        return regateID;
    }

    public int getEquipageID() {
        return equipageID;
    }

    public String getNumeroVoile() {
        return numeroVoile;
    }

    @Override
    public String toString() {
        return "Resultat{" +
                "participationID=" + participationID +
                ", tempsReel=" + tempsReel +
                ", tempsCompense=" + tempsCompense +
                ", position=" + position +
                ", presence=" + presence +
                ", retard=" + retard +
                ", abandon=" + abandon +
                ", regateID=" + regateID +
                ", equipageID=" + equipageID +
                ", numeroVoile='" + numeroVoile + '\'' +
                '}';
    }
}
