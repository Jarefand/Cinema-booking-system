package com.mycompany.projekt_kino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sala1rezerwacja{
    private GUI1 mainGUI;
    private JFrame frame;
    private int sala;
    private ArrayList<JCheckBox> seat;
    private ArrayList<Boolean> isBusy;
    private int seansID;
    private JLabel ilosc_z;
    private JLabel ilosc_w;
    private JLabel tytul;
    private JLabel data;
    private JLabel cena;

    Sala1rezerwacja(GUI1 m) {
        this.mainGUI = m;
        this.isBusy = new ArrayList<Boolean>() ;
        this.seat = new ArrayList<JCheckBox>();
        this.isBusy.add(false);
        this.seat.add(new JCheckBox("poczatek"));
        
        frame = new JFrame();
        // JPanel panel = new JPanel();
        frame.setSize(450, 400);
        frame.setVisible(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size; 
        JLabel o = new JLabel("Wybierz wolne miejsca");
        size = o.getPreferredSize();
        o.setBounds(150, 240, size.width, size.height);
        frame.add(o);
        tytul = new JLabel("Tytul");
        tytul.setBounds(310, 15, 200, 15);
        frame.add(tytul);
        data = new JLabel("Data");
        data.setBounds(310, 35, 200, 15);
        frame.add(data);
        cena = new JLabel("Cena");
        cena.setBounds(310, 55, 200, 15);
        frame.add(cena);
        JLabel e = new JLabel("EKRAN");
        //size = e.getPreferredSize();
        e.setBounds(170, 15, 80, 30);
        e.setOpaque(true);
        e.setHorizontalAlignment(e.CENTER);
        e.setVerticalAlignment(e.CENTER);
        e.setBackground(Color.blue);
        //e.setForeground(Color.blue);
        frame.add(e);
        ilosc_z = new JLabel("0");
        size = ilosc_z.getPreferredSize();
        ilosc_z.setBounds(15, 290, 20, size.height);
        frame.add(ilosc_z);
        JLabel ilosc_zaj = new JLabel("Ilość miejsc:");
        size = ilosc_zaj.getPreferredSize();
        ilosc_zaj.setBounds(15, 270, size.width, size.height);
        frame.add(ilosc_zaj);
        ilosc_w = new JLabel("0");
        size = ilosc_w.getPreferredSize();
        ilosc_w.setBounds(15, 330, 20, size.height);
        frame.add(ilosc_w);
        JLabel ilosc_wol = new JLabel("Ilość wolnych miejsc:");
        size = ilosc_wol.getPreferredSize();
        ilosc_wol.setBounds(15, 310, size.width, size.height);
        frame.add(ilosc_wol);
        JButton kup = new JButton("Rezerwuj");
        //size = kup.getPreferredSize();
        kup.setBounds(150, 290, 100, 25);
        frame.add(kup);
        JButton wroc = new JButton("Cofnij");
        wroc.setBounds(345, 330, 70, 20);
        frame.add(wroc);
        
        frame.setResizable(false);
        
        kup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String kupione="";
                
                for (int i = 0; i < seat.size(); i++) {
                    if (seat.get(i).isSelected()) {
                        if(seat.get(i).isEnabled())
                        {
                            seat.get(i).setEnabled(false);
                            kupione+=Integer.toString(i+1) + " ";
                            
                            //zmiana w lisćie zajetości
                            isBusy.set(i, true);
                        }
                    }
                }
                mainGUI.kino.mapa_seansow.get(seansID).set_seatList(isBusy);
                try {
                    mainGUI.kino.write_csvSeans();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Sala1rezerwacja.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JOptionPane.showMessageDialog(null, "Zarezerwowano miejsca" + kupione);
                frame.setVisible(false);
                mainGUI.activate();
            }
        });
        
        
        
        wroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                mainGUI.activate();
            }
        });
        
    }
    
    public void activate(ArrayList<Boolean> zajetosc, int sal, int key){
        //czyszczenie list
        this.czyszczenie();
        
        
        this.isBusy = zajetosc;
        this.sala = sal;
        this.seansID = key;
        //System.out.println("List:"+ this.isBusy);
        
        //ustawienie label
        this.tytul.setText( key +". "+ this.mainGUI.kino.mapa_seansow.get(key).get_title());
        this.data.setText(this.mainGUI.kino.mapa_seansow.get(key).get_data_str());
        this.cena.setText("Cena: " + this.mainGUI.kino.mapa_seansow.get(key).get_cena());
        
        
        this.stworz_siedzenia();
        this.ustaw_siedzenia_sala1();
        
        this.frame.setVisible(true);
    }
    
    private void czyszczenie(){
  
        this.isBusy.removeAll(seat);
        
        for(JCheckBox s:this.seat){
            this.frame.remove(s);
        }
        this.seat.removeAll(seat);
        
        //this.isBusy = new ArrayList<Boolean>() ;
        //this.seat = new ArrayList<JCheckBox>();
    }
    
    private void stworz_siedzenia(){
        
        int tmp = 0;
        int tmp_wol = 0;
        for (Boolean z:this.isBusy) {
                this.seat.add(new JCheckBox(Integer.toString(tmp + 1)));
                if (z == false) {
                    this.seat.get(tmp).setSelected(false);
                    this.seat.get(tmp).setEnabled(true);
                    tmp_wol++;
                    
                }
                else{
                    this.seat.get(tmp).setSelected(true);
                    this.seat.get(tmp).setEnabled(false);
                }
                tmp++;
        }
        
        this.ilosc_w.setText(Integer.toString(tmp_wol));
        this.ilosc_z.setText(Integer.toString(tmp));
    }
    
    private void ustaw_siedzenia_sala1(){
        Dimension size;
        int x, y,tmp;
        switch (this.sala) {
            case 1:
                x = 85;
                y = 85;
                tmp = 0;
                for (JCheckBox s:this.seat) {
                    size = this.seat.get(tmp).getPreferredSize();
                    this.seat.get(tmp).setBounds(x, y, size.width, size.height);
                    this.frame.add(this.seat.get(tmp));
                    x = x + 45;
                    if (tmp == 4) {
                        y = y + 25;
                        x = 85;
                    }
                    if (tmp == 9) {
                        y = y + 25;
                        x = 85;
                    }
                    if (tmp == 14) {
                        y = y + 25;
                        x = 85;
                    }
                    if (tmp == 19) {
                        y = y + 25;
                        x = 85;
                    } 
                    tmp++;
                }
                break;
            case 2:
                x = 45;
                y = 85;
                tmp = 0;
                for (JCheckBox s:this.seat) {
                    size = this.seat.get(tmp).getPreferredSize();
                    this.seat.get(tmp).setBounds(x, y, size.width, size.height);
                    this.frame.add(this.seat.get(tmp));
                    x = x + 35;
                    if (tmp == 7) {
                        y = y + 25;
                        x = 45;
                    }
                    if (tmp == 15) {
                        y = y + 25;
                        x = 45;
                    }
                    if (tmp == 23) {
                        y = y + 25;
                        x = 45;
                    }
                    if (tmp == 31) {
                        y = y + 25;
                        x = 45;
                    }
                    
                    if (tmp == 1 || tmp == 9 || tmp == 17 || tmp == 25 || tmp == 33){
                        x = x+30;
                    }
                    if (tmp == 5 || tmp == 13 || tmp == 21 || tmp == 29 || tmp == 37){
                        x = x+30;
                    }
                    tmp++;
                }
                break;
            case 3:
                x = 15;
                y = 95;
                tmp = 0;
                for (JCheckBox s:this.seat) {
                    size = this.seat.get(tmp).getPreferredSize();
                    this.seat.get(tmp).setBounds(x, y, size.width, size.height);
                    this.frame.add(this.seat.get(tmp));
                    x = x + 35;
                    if (tmp == 8) {
                        y = y + 25;
                        x = 15;
                    }
                    if (tmp == 17) {
                        y = y + 25;
                        x = 15;
                    }
                    if (tmp == 26) {
                        y = y + 25;
                        x = 15;
                    }
                    if (tmp == 35) {
                        y = y + 25;
                        x = 15;
                    }
                    if (tmp == 1 || tmp == 10 || tmp == 19 || tmp == 28 || tmp == 37){
                        x = x+35;
                    }
                    if (tmp == 6 || tmp == 15 || tmp == 24 || tmp == 33 || tmp == 42){
                        x = x+35;
                    }
                    tmp++;
                }
                break;
            default:
                break;
        }
        
    }
    
}


