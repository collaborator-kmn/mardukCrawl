package identifying.entity;

import java.util.Date;

public class DataBaseIdentifying {
    private Date DBIdentifying_datatime;
    private double DBIdentifying_frequency;
    private String DBIdentifying_place;
    private String DBIdentifying_country;
    private String DBIdentifying_modulation;
    private int DBIdentifying_speed;
    private double DBIdentifying_period;
    private String DBIdentifying_KDS;
    private int DBIdentifying_ERBD;
    private String DBIdentifying_name;
    private String DBIdentifying_RadioNetwork; // р.сеть
    private String DBIdentifying_comment;
    private int DBIdentifying_operator;
    private String DBIdentifying_accounting;  //учёт
    private int DBIdentifying_score; //баллы
    private String DBIdentifying_analysis; //анализ
    private double DBIdentifying_NL; //С.Ш.
    private double DBIdentifying_EL; //В.Д.

    public Date getDBIdentifying_datatime() { return DBIdentifying_datatime;}
    public void setDBIdentifying_datatime(Date DBIdentifying_datatime){this.DBIdentifying_datatime = DBIdentifying_datatime;}
    public double getDBIdentifying_frequency() {return DBIdentifying_frequency;}
    public void setDBIdentifying_frequency(double DBIdentifying_frequency){this.DBIdentifying_frequency = DBIdentifying_frequency;}
    public String getDBIdentifying_place() {return DBIdentifying_place;}
    public void setDBIdentifying_place(String DBIdentifying_place) {this.DBIdentifying_place = DBIdentifying_place;}
    public String getDBIdentifying_country() {return DBIdentifying_country;}
    public void setDBIdentifying_country(String DBIdentifying_country){this.DBIdentifying_country = DBIdentifying_country;}
    public String getDBIdentifying_modulation(){return DBIdentifying_modulation;}
    public void setDBIdentifying_modulation(String DBIdentifying_modulation){this.DBIdentifying_modulation = DBIdentifying_modulation;}
    public int getDBIdentifying_speed() {return DBIdentifying_speed;}
    public void setDBIdentifying_speed(int DBIdentifying_speed){this.DBIdentifying_speed = DBIdentifying_speed;}
    public double getDBIdentifying_period(){return DBIdentifying_period;}
    public void setDBIdentifying_period(double DBIdentifying_period){this.DBIdentifying_period = DBIdentifying_period;}
    public String getDBIdentifying_KDS(){return DBIdentifying_KDS;}
    public void setDBIdentifying_KDS(String DBIdentifying_KDS){this.DBIdentifying_KDS = DBIdentifying_KDS;}
    public int getDBIdentifying_ERBD() {return DBIdentifying_ERBD;}
    public void setDBIdentifying_ERBD(int DBIdentifying_ERBD) {this.DBIdentifying_ERBD = DBIdentifying_ERBD;}
    public String getDBIdentifying_name(){return DBIdentifying_name;}
    public void setDBIdentifying_name(String DBIdentifying_name){this.DBIdentifying_name = DBIdentifying_name;}
    public String getDBIdentifying_RadioNetwork() {return DBIdentifying_RadioNetwork;}
    public void setDBIdentifying_RadioNetwork(String DBIdentifying_RadioNetwork){this.DBIdentifying_RadioNetwork = DBIdentifying_RadioNetwork;}
    public String getDBIdentifying_comment() {return DBIdentifying_comment;}
    public void setDBIdentifying_comment(String DBIdentifying_comment){this.DBIdentifying_comment = DBIdentifying_comment;}
    public int getDBIdentifying_operator(){return DBIdentifying_operator;}
    public void setDBIdentifying_operator(int DBIdentifying_operator){this.DBIdentifying_operator = DBIdentifying_operator;}
    public String getDBIdentifying_accounting() {return DBIdentifying_accounting;}
    public void setDBIdentifying_accounting(String DBIdentifying_accounting){this.DBIdentifying_accounting = DBIdentifying_accounting;}
    public int getDBIdentifying_score() {return DBIdentifying_score;}
    public void setDBIdentifying_score(int DBIdentifying_score){this.DBIdentifying_score = DBIdentifying_score;}
    public String getDBIdentifying_analysis() {return DBIdentifying_analysis;}
    public void setDBIdentifying_analysis(String DBIdentifying_analysis){this.DBIdentifying_analysis = DBIdentifying_analysis;}
    public double getDBIdentifying_NL(){return DBIdentifying_NL;}
    public void setDBIdentifying_NL(double DBIdentifying_NL){this.DBIdentifying_NL = DBIdentifying_NL;}
    public double getDBIdentifying_EL(){return DBIdentifying_EL;}
    public void setDBIdentifying_EL(double DBIdentifying_EL){this.DBIdentifying_EL = DBIdentifying_EL;}

    public String toString(){
        return "identifying.entity.DataBaseIdentifying{" +
                " DBIdentifying_datatime=" + DBIdentifying_datatime +
                ", DBIdentifying_frequency=" + DBIdentifying_frequency +
                ", DBIdentifying_place=" + DBIdentifying_place + '\'' +
                ", DBIdentifying_country="+ DBIdentifying_country + '\'' +
                ", DBIdentifying_modulation="+ DBIdentifying_modulation + '\'' +
                ", DBIdentifying_speed=" + DBIdentifying_speed +
                ", DBIdentifying_period=" + DBIdentifying_period +
                ", DBIdentifying_KDS=" + DBIdentifying_KDS + '\'' +
                ", DBIdentifying_ERBD=" + DBIdentifying_ERBD +
                ", DBIdentifying_name=" + DBIdentifying_name + '\'' +
                ", DBIdentifying_RadioNetwork=" + DBIdentifying_RadioNetwork + '\'' +
                ", DBIdentifying_comment=" + DBIdentifying_comment + '\'' +
                ", DBIdentifying_operator=" + DBIdentifying_operator +
                ", DBIdentifying_accounting=" + DBIdentifying_accounting +'\'' +
                ", DBIdentifying_score=" + DBIdentifying_score +
                ", DBIdentifying_analysis=" + DBIdentifying_analysis + '\'' +
                ", DBIdentifying_NL=" + DBIdentifying_NL +
                ", DBIdentifying_EL=" + DBIdentifying_EL +
                '}';
    }
}
