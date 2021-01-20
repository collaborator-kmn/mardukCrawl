package kmn.marduk.entity;

import java.time.LocalDateTime;

/** Сущности БД
 */
public class DataBaseIdentifying {
    private LocalDateTime date;
    private String freq;
    private String town;
    private String coun;
    private String num;
    private int oper;
    private String to;
    private String from;
    private String anal;

    private String comm;


    public LocalDateTime getDate() { return date;}
    public void setDate(LocalDateTime date){this.date = date;}
    public String getFreq() {return freq;}
    public void setFreq(String freq) {this.freq = freq;}
    public String getTown() {return town;}
    public void setTown(String town){this.town = town;}
    public String getCoun(){return coun;}
    public void setCoun(String coun){this.coun = coun;}
    public String getNum(){return num;}
    public void setNum(String num){this.num = num;}
    public int getOper(){return oper;}
    public void setOper(int oper){this.oper = oper;}
    public String getTo(){return to;}
    public void setTo(String to) {this.to = to;}
    public String getFrom(){return from;}
    public void setFrom(String from) {this.from = from;}
    public String getAnal() {return anal;}
    public void setAnal(String anal){this.anal = anal;}
    public String getComm() {return comm;}
    public void setComm(String comm){this.comm = comm;}


    public String toString(){
        return "main.java.DataBaseIdentifying{" +
                " date=" + date +
                ", freq=" + freq+'\'' +
                ", town=" + town + '\'' +
                ", coun="+ coun + '\'' +
                ", num="+ num + '\'' +
                ", oper=" + oper +
                ", to="+ to + '\'' +
                ", from="+ from + '\'' +
                ", anal=" + anal +'\'' +
                '}';
    }
}
