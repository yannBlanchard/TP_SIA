package myfirstproject;

import java.util.ArrayList;


/**
 * Write a description of class Cochon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cochon
{
    // instance variables - replace the example below with your own
    private int age;
    private String couleur;
    private String nom;
    private Habitat maison;

    private ArrayList<Nourriture> listAliment;
    
    public ArrayList<Nourriture> getNourriture() {return(listAliment);}
    
    public void remove(Nourriture n){listAliment.remove(n);}
    
    public void ajoutAliment(Nourriture n){
      if(!listAliment.contains(n)){ 
        if(n.getCochon()!=null){ 
        	n.getCochon().remove(n);
        }
        n.setCochon(this);
        listAliment.add(n);
      }
    }
    
    /**
     * Constructor for objects of class Cochon
     */
    public Cochon()
    {
        // initialise instance variables
        age = 0;
        listAliment = new  ArrayList<Nourriture>();
    }

    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getCouleur(){
        return this.couleur;
    }
    
    public void setCouleur(String couleur){
        this.couleur = couleur;
    }
    
    public void modifierCochon(String couleur,int age,String nom){
        this.nom = nom;
        this.couleur = couleur;
        this.age = age;
        
    }
    
    public void construireHabitat(String type){
        maison = new Habitat();
        maison.setHabitat(type);
    }

    public Habitat getMaison(){
        return this.maison;
    }
    
    public void setMaison(Habitat maison){
        this.maison = maison;
    }
    
    public String getTypeHabitat(){
        return this.maison.getHabitat();
    }
    
}
