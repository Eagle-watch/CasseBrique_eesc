package com.francois.cassebrique;

import java.awt.*;
import java.util.ArrayList;

public class Balle {

    protected  int x;
    protected  int y;
    protected  int vitesseHorizontale;
    protected  int vitesseVerticale;
    protected  int diametre;
    protected  int diametre2;
    protected  int decalle2;
    protected Color couleur;

    protected int indexFrame = 0;

    protected Balle[] listePoints = new Balle[10];

    public Balle(int x, int y, int vitesseHorizontale, int vitesseVerticale, int diametre, Color couleur) {
        this.x = x;
        this.y = y;
        this.vitesseHorizontale = vitesseHorizontale == 0 ? 1 : vitesseHorizontale;
        this.vitesseVerticale = vitesseVerticale == 0 ? 1 : vitesseVerticale;
        this.couleur = couleur;
        this.setDiametre(diametre);
    }

    public Balle(int x, int y) {
        this.x = x;
        this.y = y;
        this.couleur = Color.BLACK;
        this.setDiametre(5);
    }

    public void inverseVitesseVertical() {

        vitesseVerticale *= -1;

    }

    public void inverseVitesseHorizontale () {

        vitesseHorizontale *= -1;

    }

    public void deplacement() {

    x += vitesseHorizontale;
    y += vitesseVerticale;

    }

    int indexPoint = 0;

    public void dessiner(Graphics2D dessin) {
        indexFrame ++;

        //Balle[] tableauBalle = new Balle[10];


        //int dizaines = (indexFrame/10)%10;

        if (indexFrame % 10 == 0 && vitesseHorizontale != 0 && vitesseVerticale != 0)
        {



            if(indexFrame < 100) {
                listePoints[indexPoint] = new Balle(x, y);
            } else {

                listePoints[indexPoint].setX(x);
                listePoints[indexPoint].setY(y);

            }

            indexPoint++;

            if(indexPoint == 9) {
                indexPoint = 0;
            }


        }


        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
        dessin.setColor(Color.WHITE);
        dessin.fillOval(
                x + decalle2,
                y + decalle2,
                diametre2,
                diametre2);

       for (Balle balle:listePoints) {
           if(balle != null) {
               balle.dessiner(dessin);
           }
        }
    }

    public void testCollision (int largeurEcran, int hauteurEcran) {

        if (x < 0 || x > largeurEcran- diametre) {
            inverseVitesseHorizontale();
        }
        if (y < 0 || y > hauteurEcran - diametre) {
            inverseVitesseVertical();
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseHorizontale() {
        return vitesseHorizontale;
    }

    public void setVitesseHorizontale(int vitesseHorizontale) {
        this.vitesseHorizontale = vitesseHorizontale;
    }

    public int getVitesseVerticale() {
        return vitesseVerticale;
    }

    public void setVitesseVerticale(int vitesseVerticale) {
        this.vitesseVerticale = vitesseVerticale;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
        this.diametre2 = diametre * 20 / 100;
        this.decalle2 = diametre * 20 / 100;
    }

    public int getDiametre2() {
        return diametre2;
    }

    public int getDecalle2() {
        return decalle2;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
