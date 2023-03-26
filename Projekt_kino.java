  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projekt_kino;
import java.util.ArrayList;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Projekt_kino {
    
    Map<Integer,Film> mapa_filmow;
    Map<Integer,Seans> mapa_seansow;
    LinkedHashMap<Integer, Seans> sort_mapa_seansow;
    LinkedHashMap<Integer, Film> sort_mapa_filmow;
    
    public Projekt_kino() throws IOException
    {
        this.mapa_filmow = new HashMap<>();
        this.mapa_seansow = new HashMap<>();
        this.sort_mapa_seansow = new LinkedHashMap<>();
        this.sort_mapa_filmow = new LinkedHashMap<>();    
        this.read_csvFilm();
        this.read_csvSeans();
        
    }
    
    private void read_csvFilm() throws IOException{
      
       File file = new File("lista_filmow.csv");
       String naz, gat, f_line;
       int rok, id, czas;
        if(!file.exists()){
            file.createNewFile();
        }
        else{
            try (Scanner inputFile = new Scanner(file)) {
        inputFile.useDelimiter(";|\\R");
        
        f_line = inputFile.nextLine();
        
        while (inputFile.hasNext()) {
            id = inputFile.nextInt();
            naz = inputFile.next();
            gat = inputFile.next();
            rok = inputFile.nextInt();
            czas = inputFile.nextInt();
            Film f = new Film(naz, gat, rok, czas,id);
            this.mapa_filmow.put(f.getID(), f);
            }} 
        catch(FileNotFoundException e) {
            System.out.println("Check file");
                }
            }        
   }
    
    
    private void read_csvSeans() throws IOException{
      
       File file = new File("lista_seansow5.csv");
       String data, f_line, siedzenia;
       int id, id_film, nr_sali;
       float cena;
       String godzina;
        if(!file.exists()){
            file.createNewFile();
        }
        else{
            try (Scanner inputFile = new Scanner(file)) {
        inputFile.useDelimiter(";|\\R");
        //Odczytanie pierwszej lini, naglowkow
        f_line = inputFile.nextLine();
        
        while (inputFile.hasNext()) {
            id = inputFile.nextInt();
            id_film = inputFile.nextInt();
            data = inputFile.next();
            nr_sali = inputFile.nextInt();
            cena = inputFile.nextFloat();
            siedzenia = inputFile.next();
            Seans s = new Seans(id, id_film, data, nr_sali, cena, siedzenia);
            this.mapa_seansow.put(s.getID(), s);
            }} 
        catch(FileNotFoundException e) {
            System.out.println("Check file");
                }
            }  
   }
    
   
   private void write_csvFilm() throws FileNotFoundException
   {
       //Zapisywanie listy filmow do pliku
       File file = new File("lista_filmow.csv");
       PrintWriter out = new PrintWriter(file);
       
       Set<Map.Entry<Integer, Film>> entries = this.mapa_filmow.entrySet();
       Iterator<Map.Entry<Integer, Film>> filmyIterator = entries.iterator();
       out.printf("%s\n", "ID;Tytul;Gatunek;Rok;Czas");

        while(filmyIterator.hasNext()) {
            Map.Entry<Integer, Film> entry = filmyIterator.next();
           out.printf("%d;%s;%s;%d;%d\n",entry.getKey(),
                   entry.getValue().getName(), entry.getValue().getGenre(),
                   entry.getValue().getAge(), entry.getValue().getTime());
       }
       out.close();
       
   }
   
   public void write_csvSeans() throws FileNotFoundException
   {
       //Zapisywanie listy filmow do pliku
       File file = new File("lista_seansow.csv");
       PrintWriter out = new PrintWriter(file);
       
       Set<Map.Entry<Integer, Seans>> entries = this.mapa_seansow.entrySet();
       Iterator<Map.Entry<Integer, Seans>> seansyIterator = entries.iterator();
       out.printf("%s\n", "ID;ID_Filmu;Data;Nr_Sali;Cena;zajetoscMiejsc  ");

        while(seansyIterator.hasNext()) {
            Map.Entry<Integer, Seans> entry = seansyIterator.next();
           out.printf("%d;%d;%s;%d;%f;%s\n",entry.getKey(),
                   entry.getValue().get_filmID(), entry.getValue().get_data_pom(),
                   entry.getValue().get_sala(), entry.getValue().get_cena(), entry.getValue().get_seatList_String());
       }
       out.close();
       
   }
    //Sortowanie HashMapy zawierającej seanse do LinkedHashMap 
   //paramentr s odpowiada za to, według których wartość należy posortować
   //parametr con przekazuje w którą stronę sortować
   public void sort_seans(int s, boolean con){
       
       ArrayList<Seans> list = new ArrayList<>();
       sort_mapa_seansow.clear();
       
        Entry<Integer,Seans> en = mapa_seansow.entrySet().iterator().next();
        en.getValue().set_listaFilmow(mapa_filmow);
       
       for(Map.Entry<Integer, Seans> entry : mapa_seansow.entrySet()){
           list.add(new Seans(entry.getKey(), entry.getValue().get_filmID(), entry.getValue().get_data_str(),
                   entry.getValue().get_sala(), entry.getValue().get_cena()));
       }
       
       
       //Sortowanie listy wybranych elementów       
       switch (s){
               case 0:
                   if(con){
                       list.sort(Comparator.comparing(Seans::getID));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::getID).reversed());
                   }
                   break;
               case 1:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_title));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_title).reversed());
                   }
                   break;
               case 2:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_genre));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_genre).reversed());
                   }
                   break;
               case 3:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_age));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_age).reversed());
                   }
                   break;
               case 4:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_time));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_time).reversed());
                   }
                   break;
                case 5:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_data));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_data).reversed());
                   }
                   break; 
                case 6:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_sala));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_sala).reversed());
                   }
                   break;
                case 7:
                   if(con){
                       list.sort(Comparator.comparing(Seans::get_cena));
                   }
                   else{
                       list.sort(Comparator.comparing(Seans::get_cena).reversed());
                   }
                   break;
                }
       
       
       
       boolean pom;
       for(Seans seans : list){
           for(Entry<Integer, Seans> entry : mapa_seansow.entrySet()){
               pom = false;
               
               switch (s){
               case 0:
                   if(entry.getKey().equals(seans.getID())){
                       pom =true;
                   }
                   break;
               case 1:
                   if(this.mapa_filmow.get(entry.getValue().get_filmID()).getName().equals(seans.get_title())){
                       pom = true;
                   }
                   break;
               case 2:
                   if(this.mapa_filmow.get(entry.getValue().get_filmID()).getGenre().equals(seans.get_genre())){
                       pom = true;
                   }
                   break;
               case 3:
                   if(this.mapa_filmow.get(entry.getValue().get_filmID()).getAge() == seans.get_age()){
                       pom = true;
                   }
                   break;
               case 4:
                   if(this.mapa_filmow.get(entry.getValue().get_filmID()).getTime() == seans.get_time()){
                       pom = true;
                   }
                   break;
               case 5:
                   if(entry.getValue().get_data().equals(seans.get_data())){
                       pom = true;
                   }
                   break;
               case 6:
                   if(entry.getValue().get_sala() == seans.get_sala()){
                       pom = true;
                   }
                   break;
               case 7:
                   if(entry.getValue().get_cena() == seans.get_cena()){
                       pom = true;
                   }
                   break;   
                }
               
               if(pom){
                   sort_mapa_seansow.put(entry.getKey(), entry.getValue());
               }
           }
       }   
   }
   
   public void sort_film(int sw, boolean con){
       ArrayList<Film> list = new ArrayList<>();
       sort_mapa_filmow.clear();
       
       //Stworzenie listy elementów po których dokonujemy sortowania
       for(Map.Entry<Integer, Film> entry : mapa_filmow.entrySet()){
          list.add(new Film(entry.getValue().getName(), entry.getValue().getGenre(), entry.getValue().getAge(),
                            entry.getValue().getTime(), entry.getValue().getID()));
       }
       //Sortowanie listy wybranych elementów
       switch (sw){
               case 0:
                   if(con){
                       list.sort(Comparator.comparing(Film::getID));
                   }
                   else{
                       list.sort(Comparator.comparing(Film::getID).reversed());
                   }
                   break;
               case 1:
                   if(con){
                       list.sort(Comparator.comparing(Film::getName));
                   }
                   else{
                       list.sort(Comparator.comparing(Film::getName).reversed());
                   }
                   break;
               case 2:
                   if(con){
                       list.sort(Comparator.comparing(Film::getGenre));
                   }
                   else{
                       list.sort(Comparator.comparing(Film::getGenre).reversed());
                   }
                   break;
               case 3:
                   if(con){
                       list.sort(Comparator.comparing(Film::getAge));
                   }
                   else{
                       list.sort(Comparator.comparing(Film::getAge).reversed());
                   }
                   break;
               case 4:
                   if(con){
                       list.sort(Comparator.comparing(Film::getTime));
                   }
                   else{
                       list.sort(Comparator.comparing(Film::getTime).reversed());
                   }
                   break;   
                }
       
       boolean pom;
       for(Film f : list){
           for(Entry<Integer, Film> entry : mapa_filmow.entrySet()){
               pom = false;
               
               switch (sw){
               case 0:
                   if(entry.getKey().equals(f.getID())){
                       pom =true;
                   }
                   break;
               case 1:
                   if(entry.getValue().getName().equals(f.getName())){
                       pom = true;
                   }
                   break;
               case 2:
                   if(entry.getValue().getGenre().equals(f.getGenre())){
                       pom = true;
                   }
                   break;
               case 3:
                   if(entry.getValue().getAge() == f.getAge()){
                       pom = true;
                   }
                   break;
               case 4:
                   if(entry.getValue().getTime() == f.getTime()){
                       pom = true;
                   }
                   break;   
                }
               
               if(pom){
                   sort_mapa_filmow.put(entry.getKey(), entry.getValue());
               }
           }    
       }
       
   }
   
   public void dodajFilm(String title, String genre, int age, int time) throws FileNotFoundException{
       
       //znalezienie największej wartości klucza w posortowanej LinkedHashMap
       sort_film(0,false);
       
       Set<Map.Entry<Integer, Film>> entries = sort_mapa_filmow.entrySet();
       Iterator<Map.Entry<Integer, Film>> filmyIterator = entries.iterator();
       
       int id = filmyIterator.next().getKey() + 1;
       
       Film nowy = new Film(title,genre,age,time,id);
       
       mapa_filmow.put(id, nowy);
       
       write_csvFilm();
   }
   
   public boolean usunFilm(int id) throws FileNotFoundException{
       if(mapa_filmow.remove(id) == null){
           return false;
       }
       else{
           write_csvFilm();
           return true;
       }
   }
   
   public void dodajSeans(int film_id, String data, int nr_sali, float cena) throws FileNotFoundException{
       this.sort_seans(0, false);
       
       Set<Map.Entry<Integer, Seans>> entries = sort_mapa_seansow.entrySet();
       Iterator<Map.Entry<Integer, Seans>> seansyIterator = entries.iterator();
       
       int id = seansyIterator.next().getKey() + 1;
       
       Seans nowy = new Seans(id, film_id, data, nr_sali, cena);
       
       mapa_seansow.put(id, nowy);
       
       write_csvSeans();
   }
   
   public boolean usunSeans(int id) throws FileNotFoundException{
       if(mapa_seansow.remove(id) == null){
           return false;
       }
       else{
           write_csvSeans();
           return true;
       }
   }
   
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI1().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Projekt_kino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    
    
}
