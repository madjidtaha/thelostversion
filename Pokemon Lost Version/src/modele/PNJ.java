package modele;

public class PNJ extends Personnage
{
	String description; // Ceci est la phrase qui s'affichera lorsque le h�ros interagira avec ce PNJ
	
	PNJ(String n, int x, int y, String d)
	{
		super.nom = n;
		super.posX = x;
		super.posY = y;
		// super.img 
		this.description = d;
	}
	
	String getDescription()
	{
		return this.description;
	}
}
