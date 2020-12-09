package marduk.entity;

import java.sql.Time;
import java.util.Date;

public class Marduk {
    private long marduk_id;
    private int marduk_mark;// отметак сигнала
    private Date marduk_date;
    private Time marduk_time;
    private double marduk_frequency;
    private double marduk_azimuth; // азимут обн
    private double marduk_duration; // длительность
    private int marduk_strip; // полоса
    private String marduk_source; // источник (М-ОБН Мардук)
    private double marduk_latitude; // широта
    private double marduk_longitude; // долгота
    private int marduk_autoDemodulator; // Ав.демодулятор
    private int marduk_typeSignal; // тип сигнала (номер ЕРБД)
    private String marduk_subtypeSignal; // подтип сигнала (название ЕРБД)
    private String marduk_to; // кому
    private String marduk_call; // позывной
    private String marduk_language; // язык
    private String marduk_object; // доп.данные (режим защиты связи, urf и тд)
    private String marduk_country; // страна
    private String marduk_typeVS; // вид ВС (Местоположение)
    private String marduk_RadioNetwork; // р.сеть
    private int marduk_session;// сеанс (номер оператора)
    private String marduk_placeWork; // место работы опр. автоматически
    private String marduk_countryWork;// страна работы опр. автоматически
    private String marduk_regionWork;// регион работы опр. автоматически
    private int marduk_direction; // направление
    private String marduk_note; // примечание (напр.28340 "Геркулес") прописывает оператор
    private String marduk_text; // текст передачи
    private char marduk_identification; // идентификация CHAR?
    private String marduk_formERBD;// формат ЕРБД
    private int marduk_speed; // скорость

    public long getId(){return marduk_id;}
    public void setMarduk_id(long marduk_id){this.marduk_id = marduk_id;}
    public int getMarduk_mark() { return marduk_mark;}
    public void setMarduk_mark(int marduk_mark){this.marduk_mark = marduk_mark;}
    public Date getMarduk_date() { return marduk_date;}
    public void setMarduk_date(Date marduk_date){this.marduk_date = marduk_date;}
    public Time getMarduk_time() {return marduk_time;}
    public void setMarduk_time(Time marduk_time){this.marduk_time = marduk_time;}
    public double getMarduk_frequency() {return marduk_frequency;}
    public void setMarduk_frequency(double marduk_frequency){this.marduk_frequency = marduk_frequency;}
    public double getMarduk_azimuth() {return marduk_azimuth;}
    public void setMarduk_azimuth(double marduk_azimuth){this.marduk_azimuth = marduk_azimuth;}
    public double getMarduk_duration() {return marduk_duration;}
    public void setMarduk_duration(double marduk_duration){this.marduk_duration = marduk_duration;}
    public int getMarduk_strip() { return marduk_strip;}
    public void setMarduk_strip(int marduk_strip){this.marduk_strip = marduk_strip;}
    public String getMarduk_source() {return marduk_source;}
    public void setMarduk_source(String marduk_source) {this.marduk_source = marduk_source;}
    public double getMarduk_latitude() {return marduk_latitude;}
    public void setMarduk_latitude(double marduk_latitude){this.marduk_latitude = marduk_latitude;}
    public double getMarduk_longitude() {return marduk_longitude;}
    public void setMarduk_longitude(double marduk_longitude){this.marduk_longitude = marduk_longitude;}
    public int getMarduk_autoDemodulator() { return marduk_autoDemodulator;}
    public void setMarduk_autoDemodulator(int marduk_autoDemodulator){this.marduk_autoDemodulator = marduk_autoDemodulator;}
    public int getMarduk_typeSignal() { return marduk_typeSignal;}
    public void setMarduk_typeSignal(int marduk_typeSignal){this.marduk_typeSignal = marduk_typeSignal;}
    public String getMarduk_subtypeSignal() {return marduk_subtypeSignal;}
    public void setMarduk_subtypeSignal(String marduk_subtypeSignal) {this.marduk_subtypeSignal = marduk_subtypeSignal;}
    public String getMarduk_to() {return marduk_to;}
    public void setMarduk_to(String marduk_to) {this.marduk_to = marduk_to;}
    public String getMarduk_call() {return marduk_call;}
    public void setMarduk_call(String marduk_call) {this.marduk_call = marduk_call;}
    public String getMarduk_language() {return marduk_language;}
    public void setMarduk_language(String marduk_language) {this.marduk_language = marduk_language;}
    public String getMarduk_object() {return marduk_object;}
    public void setMarduk_object(String marduk_object) {this.marduk_object = marduk_object;}
    public String getMarduk_country() {return marduk_country;}
    public void setMarduk_country(String marduk_country){this.marduk_country = marduk_country;}
    public String getMarduk_typeVS() {return marduk_typeVS;}
    public void setMarduk_typeVS(String marduk_typeVS) {this.marduk_typeVS = marduk_typeVS;}
    public String getMarduk_RadioNetwork() {return marduk_RadioNetwork;}
    public void setMarduk_RadioNetwork(String marduk_RadioNetwork){this.marduk_RadioNetwork = marduk_RadioNetwork;}
    public int getMarduk_session() {return marduk_session;}
    public void setMarduk_session(int marduk_session){this.marduk_session = marduk_session;}
    public String getMarduk_placeWork() {return marduk_placeWork;}
    public void setMarduk_placeWork(String marduk_placeWork) {this.marduk_placeWork = marduk_placeWork;}
    public String getMarduk_countryWork() {return marduk_countryWork;}
    public void setMarduk_countryWork(String marduk_countryWork) {this.marduk_countryWork = marduk_countryWork;}
    public String getMarduk_regionWork() {return marduk_regionWork;}
    public void setMarduk_regionWork(String marduk_regionWork) {this.marduk_regionWork = marduk_regionWork;}
    public int getMarduk_direction(){return marduk_direction;}
    public void setMarduk_direction(int marduk_direction){this.marduk_direction = marduk_direction;}
    public String getMarduk_note() {return marduk_note;}
    public void setMarduk_note(String marduk_note){this.marduk_note = marduk_note;}
    public String getMarduk_text() {return marduk_text;}
    public void setMarduk_text(String marduk_text){this.marduk_text = marduk_text;}
    public char getMarduk_identification(){return marduk_identification;}
    public void setMarduk_identification(char marduk_identification){this.marduk_identification = marduk_identification;}
    public String getMarduk_formERBD() {return marduk_formERBD;}
    public void setMarduk_formERBD(String marduk_formERBD){this.marduk_formERBD = marduk_formERBD;}
    public int getMarduk_speed(){return marduk_speed;}
    public void setMarduk_speed(int marduk_speed){this.marduk_speed = marduk_speed;}

    public String toString(){
        return "marduk.Marduk{" +
                " marduk_mark=" + marduk_mark +
                ", marduk_date=" + marduk_date +
                ", marduk_time=" + marduk_time +
                ", marduk_frequency="+ marduk_frequency +
                ", marduk_azimuth="+ marduk_azimuth +
                ", marduk_duration="+ marduk_duration +
                ", marduk_strip="+ marduk_strip +
                ", marduk_source="+ marduk_source + '\'' +
                ", marduk_latitude=" + marduk_latitude +
                ", marduk_longitude=" + marduk_longitude +
                ", marduk_autoDemodulator=" + marduk_autoDemodulator +
                ", mv_typeSignal=" + marduk_typeSignal +
                ", marduk_subtypeSignal=" + marduk_subtypeSignal +'\'' +
                ", marduk_to=" + marduk_to +'\'' +
                ", marduk_call=" + marduk_call +'\'' +
                ", marduk_language=" + marduk_language +'\'' +
                ", marduk_object=" + marduk_object +'\'' +
                ", marduk_country=" + marduk_country +'\'' +
                ", marduk_typeVS=" + marduk_typeVS +'\'' +
                ", marduk_RadioNetwork=" + marduk_RadioNetwork + '\'' +
                ", marduk_session=" + marduk_session +'\'' +
                ", marduk_placeWork=" + marduk_placeWork +'\'' +
                ", marduk_countryWork=" + marduk_countryWork +'\'' +
                ", marduk_regionWork=" + marduk_regionWork +'\'' +
                ", marduk_direction=" + marduk_direction +
                ", marduk_note=" + marduk_note +'\'' +
                ", marduk_text=" + marduk_text +'\'' +
                ", marduk_identifiaction=" + marduk_identification +
                ", marduk_formERBD=" + marduk_formERBD +'\'' +
                ", marduk_speed=" + marduk_speed +
                '}';
    }
}
