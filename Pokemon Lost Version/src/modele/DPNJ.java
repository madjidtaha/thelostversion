package modele;
import java.util.*;

public class DPNJ extends Dresseur
{
	Vector <Pokemon> sesPokemon; // Ceci correspond aux Pokemon poss�d�s par le dresseur
	
	DPNJ(String n, int x, int y)
	{
		super.nom = n;
		super.posX = x;
		super.posY = y;
		sesPokemon = new Vector<Pokemon>();
		this.ajoutPokemon();
	}
	
	void ajoutPokemon() // M�thode qui choisit al�atoirement des Pokemon parmi ceux pr�sents dans le jeu
	{
		int nbPoke = (int)(Math.random()*4+1); // Choisit al�atoirement un nombre entre 1 et 4 
												// qui sera le nombre de Pokemon poss�d�s par le dresseur
	}
}
