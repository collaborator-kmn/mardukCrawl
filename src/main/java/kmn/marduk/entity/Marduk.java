package kmn.marduk.entity;

import java.time.LocalDateTime;

/** Сущности Мардук
 *
 */
public class Marduk {

    private LocalDateTime DATE_BEG;
    private String FREQ_HZ;
    private String WHO_IS_COUNTRY;
    private String WHO_IS_BRANCH;
    private String SIG_TYPE;
    private int SEANCE;
    private String RECEIVER;
    private String SENDER;
    private String WHO_IS;
    private String REM;
    private String PLACE_REGION;
    private String PLACE_COUNTRY;
    private String PLACE_NAME;

    public LocalDateTime getDATE_BEG() { return DATE_BEG;}
    public void setDATE_BEG(LocalDateTime DATE_BEG){this.DATE_BEG = DATE_BEG;}
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
    public String getRECEIVER() {return RECEIVER;}
    public void setRECEIVER(String RECEIVER){this.RECEIVER = RECEIVER;}
    public String getSENDER() {return SENDER;}
    public void setSENDER(String SENDER) {this.SENDER = SENDER;}
    public String getWHO_IS() {return WHO_IS;}
    public void setWHO_IS(String WHO_IS) {this.WHO_IS = WHO_IS;}
    public String getREM() {return REM;}
    public void setREM(String REM) {this.REM = REM;}
    public String getPLACE_REGION() {return PLACE_REGION;}
    public void setPLACE_REGION(String PLACE_REGION) {this.PLACE_REGION = PLACE_REGION;}
    public String getPLACE_COUNTRY() {return PLACE_COUNTRY;}
    public void setPLACE_COUNTRY(String PLACE_COUNTRY) {this.PLACE_COUNTRY = PLACE_COUNTRY;}
    public String getPLACE_NAME() {return PLACE_NAME;}
    public void setPLACE_NAME(String PLACE_NAME) {this.PLACE_NAME = PLACE_NAME;}

    public String toString(){
        return "marduk.Marduk{" +
                " DATE_BEG=" + DATE_BEG +
                ", FREQ_HZ=" + FREQ_HZ +'\'' +
                ", WHO_IS_COUNTRY=" + WHO_IS_COUNTRY +'\'' +
                ", WHO_IS_BRANCH="+ WHO_IS_BRANCH +'\'' +
                ", SIG_TYPE="+ SIG_TYPE +'\'' +
                ", SEANCE="+ SEANCE +'\'' +
                ", TO="+ RECEIVER +'\'' +
                ", FROM="+ SENDER + '\'' +
                '}';
    }
}
