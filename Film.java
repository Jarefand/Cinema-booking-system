/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekt_kino;


/**
 *
 * @author Lenovo
 */
public class Film {
    private String nazwa;
    private String gatunek;
    private int rok;
    private int dlugosc;
    private int id;
    
    public Film(String n, String g, int r, int d, int i){
        this.nazwa = n;
        this.gatunek = g;
        this.rok = r;
        this.dlugosc = d;
        this.id = i;
    }
    
    public String getName()
    {
        return this.nazwa;
    }
    
    public String getGenre()
    {
        return this.gatunek;
    }
    
    public int getAge()
    {
        return this.rok;
    }
    
    public int getTime()
    {
        return this.dlugosc;
    }
    
    public int getID()
    {
        return this.id;
    }
    
}
