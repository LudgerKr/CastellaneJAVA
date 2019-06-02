package controleur;

public class Seances {
    private int idseance;
    private String date;
    private String time;

    public Seances(int idseance, String date, String time)
    {
        this.idseance = idseance;
        this.date = date;
        this.time = time;
    }

    public Seances(String date, String time)
    {
        this.date = date;
        this.time = time;
    }

    public Seances(int idseance)
    {
        this.idseance = idseance;
    }

    @Override
    public String toString() {
        return "Numéro : " + getIdseance()+ "\n" + "Date : " + getDate() + "\n"
                + "Heure : " + getTime() + "\n";
    }

    public int getIdseance() {
        return idseance;
    }

    public void setIdseance(int idseance) {
        this.idseance = idseance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}