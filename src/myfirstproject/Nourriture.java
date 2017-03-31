package myfirstproject;

public class Nourriture {
	private String nom;
	private String couleur;
	
	private  Cochon cochon;
	
	  public Cochon getCochon() { return (cochon); }
	  
	  public void setCochon(Cochon vcochon){ this.cochon=vcochon; }
	  
	  public void addCochon(Cochon vcochon){ 
	    if(vcochon != null ) { 
	      if(!vcochon.getNourriture().contains(this)) { 
	        if (cochon!=null) cochon.remove(this);
	        this.setCochon(vcochon);
	        cochon.getNourriture().add(this);
	      }
	    }
	  }

	
	public Nourriture(String nom,String couleur)
    {
        // initialise instance variables
		this.setNom(nom);
		this.setCouleur(couleur);
    }

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
