package myfirstproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class cochonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CochonTest
{
    private Cochon cochon2;
    private Habitat habitat2;

    /**
     * Default constructor for test class cochonTest
     */
    public CochonTest()
    {
    	
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        cochon2 = new Cochon();
        habitat2 = new Habitat();
        cochon2.construireHabitat("brique");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetter()
    {
        
    }
    
    @Test
    public void testConstructeur()
    {
    //Test constructeur cochon
       Cochon cochon = new Cochon();
       assertEquals(0, cochon.getAge());
       assertEquals(0, cochon.getNourriture().size());
     //Test constructeur Habitat
       Habitat habitat = new Habitat();
       assertEquals("paille", habitat.getHabitat());
     //Test constructeur Nourriture
       Nourriture nourriture = new Nourriture("pomme","rouge");
       assertEquals("pomme", nourriture.getNom());
       assertEquals("rouge", nourriture.getCouleur());
    }
    
    
    @Test
    public void testSetterCochon()
    {
       Cochon cochon = new Cochon();
       cochon.setAge(10);
       cochon.setCouleur("Vert");
       cochon.setNom("Patrick");
       Habitat maison = new Habitat();
       cochon.setMaison(maison);
  
       assertEquals(10, cochon.getAge());
       assertEquals("Vert", cochon.getCouleur());
       assertEquals("Patrick", cochon.getNom());
       assertEquals("paille", cochon.getMaison().getHabitat());
    }
    
    @Test
    public void testSetterHabitat()
    {
       Habitat habitat = new Habitat();
       habitat.setHabitat("brique");
       assertEquals("brique", habitat.getHabitat());
    }
    
    @Test
    public void testSetterNourriture()
    {
       Nourriture nourriture = new Nourriture("pomme","rouge");
       nourriture.setCouleur("vert");
       nourriture.setNom("poire");
       
       assertEquals("vert", nourriture.getCouleur());
       assertEquals("poire", nourriture.getNom());
       
       Cochon cochon = new Cochon();
       cochon.setNom("bob");
       nourriture.setCochon(cochon);
       
       assertEquals("bob", nourriture.getCochon().getNom());
      
    }
    
    @Test
    public void testMethodeAddNourriture1()
    {
       Cochon cochon = new Cochon();
       Nourriture nourriture = new Nourriture("vert","pomme");
       cochon.ajoutAliment(nourriture);
       cochon.ajoutAliment(nourriture);
       assertEquals(1, cochon.getNourriture().size());
    }
    
    @Test
    public void testMethodeAddNourriture2()
    {
       Cochon cochon = new Cochon();
       Cochon cochon2 = new Cochon();
       cochon.setNom("Bob");
       cochon2.setNom("Robert");
       Nourriture nourriture = new Nourriture("vert","pomme");
       Nourriture nourriture2 = new Nourriture("rouge","pomme");
       
       cochon.ajoutAliment(nourriture);
       nourriture.addCochon(cochon);
       
       nourriture2.addCochon(cochon2);
       cochon.ajoutAliment(nourriture2);
       
       assertEquals(2, cochon.getNourriture().size());
       assertEquals(0, cochon2.getNourriture().size());
    }
    
    @Test
    public void testAssociationNourritureCochonNull()
    {
        Nourriture nourriture = new Nourriture("vert", "pomme");
        Cochon cochon = null;
        nourriture.addCochon(cochon);
    }
    
    @Test
    public void testAssociationNourritureCochonDiffNull()
    {
    	Cochon cochon = new Cochon();
        Cochon cochon2 = new Cochon();
        cochon.setNom("Bob");
        cochon2.setNom("Robert");
        Nourriture nourriture = new Nourriture("vert","pomme");
        Nourriture nourriture2 = new Nourriture("rouge","pomme");
        
        nourriture.addCochon(cochon);
        cochon.ajoutAliment(nourriture);
        
        cochon.ajoutAliment(nourriture2);
        nourriture2.addCochon(cochon2);
        
        
        assertEquals("Bob", nourriture.getCochon().getNom());
        assertEquals("Robert", nourriture2.getCochon().getNom());
        
    }
    
    @Test
    public void testAssociationAddCochon()
    {
        Cochon cochon1 = new Cochon();
        cochon1.modifierCochon("blanc", 5, "Robert");
        assertEquals("blanc", cochon1.getCouleur());
        assertEquals("Robert", cochon1.getNom());
        assertEquals(5, cochon1.getAge());
    }
    
    
    @Test
    public void testModifCochon()
    {
        Cochon cochon1 = new Cochon();
        cochon1.modifierCochon("blanc", 5, "Robert");
        assertEquals("blanc", cochon1.getCouleur());
        assertEquals("Robert", cochon1.getNom());
        assertEquals(5, cochon1.getAge());
    }


    @Test
    public void testHabitat()
    {
        cochon2.construireHabitat("brique");
        assertEquals("brique", cochon2.getTypeHabitat());
    }
    
    @Test
    public void testNourriture(){
    	Cochon cochon = new Cochon();
    	Nourriture nourriture = new Nourriture("Pomme", "Rouge");
    	cochon.ajoutAliment(nourriture);
    	
    	assertEquals("Pomme", cochon.getNourriture().get(0).getNom());
    	assertEquals("Rouge", cochon.getNourriture().get(0).getCouleur());
    	assertEquals(0, nourriture.getCochon().getAge());
    }
    
    @Test
    public void testAppartenance(){
    	Cochon cochon = new Cochon();
    	cochon.modifierCochon("rose", 5, "Robert");
    	Nourriture nourriture = new Nourriture("Pomme", "Rouge");
    	cochon.ajoutAliment(nourriture);
    	
    	assertEquals("Pomme", cochon.getNourriture().get(0).getNom());
    	assertEquals("Rouge", cochon.getNourriture().get(0).getCouleur());
    	
    	testApparenance(nourriture);
    }
    
    @Test
    public void testAjoutPlusieurNourriture(){
    	Cochon cochon = new Cochon();
    	cochon.modifierCochon("rose", 5, "Robert");
    	Nourriture nourriture = new Nourriture("Pomme", "Rouge");
    	cochon.ajoutAliment(nourriture);
    	Nourriture nourriture2 = new Nourriture("Poire", "vert");
    	cochon.ajoutAliment(nourriture2);
    	//
    	assertEquals("Pomme", cochon.getNourriture().get(0).getNom());
    	assertEquals("Rouge", cochon.getNourriture().get(0).getCouleur());
    	//
    	assertEquals("Poire", cochon.getNourriture().get(1).getNom());
    	assertEquals("vert", cochon.getNourriture().get(1).getCouleur());
    	//
    	assertEquals(2, cochon.getNourriture().size());
    	testApparenance(nourriture);
    	testApparenance(nourriture2);
    }
    
    @Test
    public void testPlusieurCochonNourriture(){
    	Cochon cochon = new Cochon();
    	cochon.modifierCochon("rose", 5, "Robert");
    	Cochon michel = new Cochon();
    	michel.modifierCochon("noir", 10, "Michel");
    	Nourriture nourriture = new Nourriture("Pomme", "Rouge");
    	cochon.ajoutAliment(nourriture);
    	Nourriture nourriture2 = new Nourriture("Poire", "vert");
    	michel.ajoutAliment(nourriture2);
    	//
    	testApparenance(nourriture);
    	//
    	assertEquals(10, nourriture2.getCochon().getAge());
    	assertEquals("noir", nourriture2.getCochon().getCouleur());
    	assertEquals("Michel", nourriture2.getCochon().getNom());
    	//
    	assertEquals(1, cochon.getNourriture().size());
    	//
    	assertEquals(1, michel.getNourriture().size());
    }

	private void testApparenance(Nourriture nourriture) {
		assertEquals(5, nourriture.getCochon().getAge());
    	assertEquals("rose", nourriture.getCochon().getCouleur());
    	assertEquals("Robert", nourriture.getCochon().getNom());
	}
    
    @Test
    public void testSuppressionNourriture(){
    	Cochon cochon = new Cochon();
    	cochon.modifierCochon("rose", 5, "Robert");
    	Nourriture nourriture = new Nourriture("Pomme", "Rouge");
    	cochon.ajoutAliment(nourriture);
    	Nourriture nourriture2 = new Nourriture("Poire", "vert");
    	cochon.ajoutAliment(nourriture2);
    	cochon.remove(nourriture2);
    	//
    	assertEquals(1, cochon.getNourriture().size());
    	//
    	assertEquals("Pomme", cochon.getNourriture().get(0).getNom());
    	assertEquals("Rouge", cochon.getNourriture().get(0).getCouleur());
    	testApparenance(nourriture);
    	
    }   
}









