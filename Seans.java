/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekt_kino;

/**
 *
 * @author Lenovo
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class Seans {
    private int id;
    private int id_film;
    private Date data;
    private String data_pom;
    private int nr_sali;
    private float cena;
    private static Map<Integer,Film> filmy;
    private int ilosc_miejsc;
    private ArrayList<Boolean> siedzenia;
    
    public Seans(int k, int f, String d, int nr, float c){
        this.id =  k;
        this.id_film = f;
        data_pom = d;
        SimpleDateFormat formatterdata = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            this.data = formatterdata.parse(d);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        this.nr_sali = nr;
        this.cena = c;
        
        switch (this.nr_sali) {
            case 1:
                this.ilosc_miejsc = 25;
                break;
            case 2:
                this.ilosc_miejsc = 40;
                break;
            case 3:
                this.ilosc_miejsc = 45;
                break;
            default:
                break;
        }
        
        //wypelinienie listy zajecia miejsc 0
        this.siedzenia = new ArrayList<Boolean>();
        for(int i=0; i < this.ilosc_miejsc; i++){
            this.siedzenia.add(false);
        }  
    }
    
    
    public Seans(int k, int f, String d, int nr, float c, String miejsca){
        this.id =  k;
        this.id_film = f;
        data_pom = d;
        SimpleDateFormat formatterdata = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            this.data = formatterdata.parse(d);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        this.nr_sali = nr;
        this.cena = c;
        
        switch (this.nr_sali) {
            case 1:
                this.ilosc_miejsc = 25;
                break;
            case 2:
                this.ilosc_miejsc = 35;
                break;
            case 3:
                this.ilosc_miejsc = 40;
                break;
            default:
                break;
        }
        
        //wypelinienie listy zajecia miejsc 0
        this.siedzenia = new ArrayList<Boolean>();
        char[] chars = miejsca.toCharArray();
        
        for(Character ch:chars){
            if(ch.equals('0')){
                this.siedzenia.add(false);
            }
            else if(ch.equals('1')){
                this.siedzenia.add(true);
            }
        }
    }
    
    
    
    public int getID(){
        return this.id;
    }
    
    public int get_filmID(){
        return this.id_film;
    }
    
    public Date get_data(){
        return this.data;
    }
    
    public int get_sala(){
        return this.nr_sali;
    }
    
    public float get_cena(){
        return this.cena;
    }
    
    public String get_data_str(){
        
        return this.data_pom;
    }
    
    public void set_listaFilmow(Map<Integer,Film> m){
        this.filmy = m;
    }
    
    public String get_title(){
        return this.filmy.get(this.id_film).getName();
    }
    
    public String get_genre(){
        return this.filmy.get(this.id_film).getGenre();
    }
    
    public Integer get_time(){
        return this.filmy.get(this.id_film).getTime();
    }
    
    public Integer get_age(){
        return this.filmy.get(this.id_film).getAge();
    }

    public String get_data_pom() {
        return this.data_pom;
    }
    
    public  ArrayList<Boolean> get_seatList(){
        
        return this.siedzenia;
    }
    
    public void set_seatList(ArrayList<Boolean> list){
        
        this.siedzenia = list;
    }
    
    public String get_seatList_String(){
        String napis ="";
        for(Boolean s:this.siedzenia){
            if(s == true){
                napis = napis +"1";
            }
            if(s == false){
                napis = napis + "0";
            }
        }
        
        return napis;
    }
    
}
