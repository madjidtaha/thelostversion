package modele;

public class Dresseur extends Personnage
{
	Pokemon[] equipe = new Pokemon[6];
	
	Dresseur()
	{
		// super.img 
	}
	
	Dresseur(String n, int x, int y)
	{
		super.nom = n; // utilise le champ de la classe m�re 
		super.posX = x; 
		super.posY = y;
		// super.img // 
		
	}
	
	// Accesseurs
	int getX() // retourne position X
	{
		return this.posX;
	}
	int getY() // retourne position Y
	{
		return this.posY;
	}
	Pokemon getPokemon1(){
		return equipe[0];
	}
	Pokemon getPokemon2(){
		return equipe[1];
	}
	Pokemon getPokemon3(){
		return equipe[2];
	}
	Pokemon getPokemon4(){
		return equipe[3];
	}
	Pokemon getPokemon5(){
		return equipe[4];
	}
	Pokemon getPokemon6(){
		return equipe[5];
	}
	
	// Modifieurs

	void setX(int p) // modifie position X
	{
		this.posX = p;
	}
	void setY(int p) // modifie position Y
	{
		this.posY = p;
	}
	void setNom(String n){
		this.nom = n;
	}
	
	
	
}