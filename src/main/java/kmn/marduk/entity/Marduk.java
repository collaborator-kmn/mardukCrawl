package kmn.marduk.entity;

import java.sql.Time;
import java.util.Date;

public class Marduk {

    private Date DATE_REG;
    private String FREQ_HZ;
    private String WHO_IS_COUNTRY;
    private String WHO_IS_BRANCH;
    private String SIG_TYPE;
    private int SEANCE;
    private String TO;
    private String FROM;

    public Date getDATE_REG() { return DATE_REG;}
    public void setDATE_REG(Date DATE_REG){this.DATE_REG = DATE_REG;}
    public String getFREQ_HZ() {return FREQ_HZ;}
    public void setFREQ_HZ(String FREQ_HZ){this.FREQ_HZ = FREQ_HZ;}
    public String getWHO_IS_COUNTRY() {return WHO_IS_COUNTRY;}
    public void setWHO_IS_COUNTRY(String WHO_IS_COUNTRY) {this.WHO_IS_COUNTRY = WHO_IS_COUNTRY;}
    public String getWHO_IS_BRANCH() {return WHO_IS_BRANCH;}
    public void setWHO_IS_BRANCH(String WHO_IS_BRANCH) {this.WHO_IS_BRANCH = WHO_IS_BRANCH;}
    public String getSIG_TYPE() {return SIG_TYPE;}
    public void setSIG_TYPE(String SIG_TYPE) {this.SIG_TYPE = SIG_TYPE;}
    public int getSEANCE() {return SEANCE;}
    public void setSEANCE(int SEANCE) {this.SEANCE = SEANCE;}
    public String getTO() {return TO;}
    public void setTO(String TO){this.TO = TO;}
    public String getFROM() {return FROM;}
    public void setFROM(String FROM) {this.FROM = FROM;}

    public String toString(){
        return "marduk.Marduk{" +
                " DATE_REG=" + DATE_REG +
                ", FREQ_HZ=" + FREQ_HZ +'\'' +
                ", WHO_IS_COUNTRY=" + WHO_IS_COUNTRY +'\'' +
                ", WHO_IS_BRANCH="+ WHO_IS_BRANCH +'\'' +
                ", SIG_TYPE="+ SIG_TYPE +'\'' +
                ", SEANCE="+ SEANCE +'\'' +
                ", TO="+ TO +'\'' +
                ", FROM="+ FROM + '\'' +
                '}';
    }
}
