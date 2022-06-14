import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Labyrintprogram {
    private static int hoyde;
    private static int bredde;
    static Rute []ruter;
    private static Labyrint guiLab;
    public static void main(String[] args) throws FileNotFoundException {

        
        JFileChooser velger = new JFileChooser(".");
        velger.setDialogTitle("Velg en fil for aa aapne: ");
        
        int resultat = velger.showOpenDialog(null);
        if(resultat != JFileChooser.APPROVE_OPTION)
            System.exit(1);
        File f = velger.getSelectedFile();
        Labyrint guiLab = new Labyrint(f);

        try{
            guiLab.lesFraFil(f);
        }catch(FileNotFoundException e){
            System.exit(1);
        }
        
        

        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //lager hovedpanelet mitt
        JPanel hovedPanel = new JPanel(); //oppretter tegneflaten
        vindu.add(hovedPanel); //legger tegneflaten inn i vinduet
        JLabel storrelse = new JLabel("Storrelsen er: " + guiLab.hoyde + "x" + guiLab.bredde);
        hovedPanel.add(storrelse);



        //lager enda et panel for rutenettet
        JPanel rutenett = new JPanel();

        //oppretter rutenett og knapper
        rutenett.setLayout(new GridLayout(guiLab.bredde,guiLab.hoyde));

        

        hovedPanel.add(rutenett);

        for (int rad = 0; rad < guiLab.bredde; rad ++){
            for(int kolonne = 0; kolonne < guiLab.hoyde; kolonne++){
                Rute rute = guiLab.hentRute(rad, kolonne);
                rutenett.add(rute);
                rute.setOpaque(true);
                if(rute.tilTegn() == '#'){
                    rute.setBackground(Color.BLACK);
                }else if (rute.tilTegn() == '0'){
                    rute.setBackground(Color.WHITE);
                }else{
                    rute.setBackground(Color.WHITE);
                }
                
              
            }
           
        }

        //lager en knapp som avslutter
        JButton trykkeKnapp = new JButton("Avslutt");

        class Klikk implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        }

        
        

           
        trykkeKnapp.addActionListener(new Klikk());
        hovedPanel.add(trykkeKnapp);

        vindu.pack();
        vindu.setVisible(true);
        
    }

    private void finnLosning(ArrayList<Tuppel> utveier){
        boolean farget = false;
        for(Rute r : ruter){
            farget = false;
            for (Tuppel t : utveier){
                if(r.hentKolonne() == t.hentX() && r.hentRad() == t.hentY()){
                    farget = true;
                }

            }
            if(farget){
                r.farg();
            }
        }
        

    }
    
}
