package com.francois.cassebrique;

import javax.swing.*;
import java.awt.*;

public class CasseBrique extends Canvas {

    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(500, 500));
        setBounds(0, 0, 500,500);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {

        int indexFrame = 0;
       Balle balle = new Balle(
               250,
               250,
               4,
               -6 ,
               30,
               Color.GREEN);

        while(true) {
            indexFrame ++;
            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();
            //---------------
            // RESET DESSIN
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0,500,500);

            //Dessin Balle
            balle.setX(balle.getX()+ balle.getVitesseHorizontale());
            balle.setY(balle.getY() + balle.getVitesseVerticale());
            dessin.setColor(balle.getCouleur());
            dessin.fillOval(balle.getX(), balle.getY(), balle.getDiametre(), balle.getDiametre());
            dessin.setColor(Color.WHITE);
            dessin.fillOval(balle.getX() + balle.getDecalle2(), balle.getY() + balle.decalle2 ,balle.getDiametre2(),balle.getDiametre2());

            if (balle.getX() < 0 || balle.getX() > 500- balle.diametre) {
                balle.setVitesseHorizontale(balle.getVitesseHorizontale() *-1);
            }
            if (balle.getY() < 0 || balle.getY() > 500 - balle.getDiametre()){
                balle.setVitesseVerticale(balle.getVitesseVerticale() * -1);
            }


            //---------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }
}