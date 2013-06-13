package modele;


public class Attaque implements Type, NomAttaque
{
	String nom;
	int puissance, type;
	boolean special;
	
	Attaque(int i)
	{
		
		
		switch (i)
		{
			case AUCUNE: 
				this.nom = "-----";
				this.type = AUCUN;
				this.puissance = 0;
				this.special = false;
				
			break;
			case CHARGE: 
				this.nom = "CHARGE";
				this.type = NORMAL;
				this.puissance = 35;
				this.special = false;
				
			break;
			case ECLAIR: 
				this.nom = "ECLAIR";
				this.type = ELECTRIK;
				this.puissance = 40;
				this.special = true;
				
			break;
			case DARDVENIN: 
				this.nom = "DARDVENIN";
				this.type = POISON;
				this.puissance = 15;
				this.special = true;
			break;
			case TORNADE:
				this.nom = "TORNADE";
				this.type = VOL;
				this.puissance = 40;
				this.special = false;
		}
	}
	public int getType(){
		return this.type;
	}
	public String getNom(){
		return this.nom;
	}
	public int getPuissance(){
		return this.puissance;
	}
	public boolean getSpecial(){
		return this.special;
	}
}