package kmn.marduk.entity;

import java.util.Date;

public class DataBaseAle {
    private long ale_id;
    private Date ale_datatime;
    private double ale_frequency;
    private String ale_place;
    private String ale_country;
    private String ale_from;
    private String ale_to;
    private String ale_RadioNetwork; // р.сеть
    private String ale_affiliation; //принадлежность
    private String ale_comment;
    private int ale_operator;
    private String ale_accounting;  //учёт
    private int ale_score; //баллы
    private String ale_analysis; //анализ
    private double ale_NL; //С.Ш.
    private double ale_EL; //В.Д.

    public long getAle_id(){return ale_id;}
    public void setAle_id(long ale_id){this.ale_id = ale_id;}
    public Date getAle_datatime() { return ale_datatime;}
    public void setAle_datatime(Date a_datatime){this.ale_datatime = a_datatime;}
    public double getAle_frequency() {return ale_frequency;}
    public void setAle_frequency(double ale_frequency){this.ale_frequency = ale_frequency;}
    public String getAle_place() {return ale_place;}
    public void setAle_place(String ale_place) {this.ale_place = ale_place;}
    public String getAle_country() {return ale_country;}
    public void setAle_country(String ale_country){this.ale_country = ale_country;}
    public String getAle_from(){return ale_from;}
    public void setAle_from(String ale_from){this.ale_from = ale_from;}
    public String getAle_to(){return ale_to;}
    public void setAle_to(String ale_to){this.ale_to = ale_to;}
    public String getAle_RadioNetwork() {return ale_RadioNetwork;}
    public void setAle_RadioNetwork(String ale_RadioNetwork){this.ale_RadioNetwork = ale_RadioNetwork;}
    public String getAle_affiliation() {return ale_affiliation;}
    public void setAle_affiliation(String ale_affiliation){this.ale_affiliation = ale_affiliation;}
    public String getAle_comment() {return ale_comment;}
    public void setAle_comment(String ale_comment){this.ale_comment = ale_comment;}
    public int getAle_operator(){return ale_operator;}
    public void setAle_operator(int ale_operator){this.ale_operator = ale_operator;}
    public String getAle_accounting() {return ale_accounting;}
    public void setAle_accounting(String ale_accounting){this.ale_accounting = ale_accounting;}
    public int getAle_score() {return ale_score;}
    public void setAle_score(int ale_score){this.ale_score = ale_score;}
    public String getAle_analysis() {return ale_analysis;}
    public void setAle_analysis(String ale_analysis){this.ale_analysis = ale_analysis;}
    public double getAle_NL(){return ale_NL;}
    public void setAle_NL(double ale_NL){this.ale_NL = ale_NL;}
    public double getAle_EL(){return ale_EL;}
    public void setAle_EL(double ale_EL){this.ale_EL = ale_EL;}

    public String toString(){
        return "main.java.DataBaseAle{" +
                " ale_datatime=" + ale_datatime +
                ", ale_frequency=" + ale_frequency +
                ", ale_place=" + ale_place + '\'' +
                ", ale_country="+ ale_country + '\'' +
                ", ale_from="+ ale_from + '\'' +
                ", ale_to=" + ale_to +'\'' +
                ", ale_RadioNetwork=" + ale_RadioNetwork + '\'' +
                ", ale_affiliation=" + ale_affiliation + '\'' +
                ", ale_comment=" + ale_comment + '\'' +
                ", ale_operator=" + ale_operator +
                ", ale_accounting=" + ale_accounting +'\'' +
                ", ale_score=" + ale_score +
                ", ale_analysis=" + ale_analysis + '\'' +
                ", ale_NL=" + ale_NL +
                ", ale_EL=" + ale_EL +
                '}';
    }
}
