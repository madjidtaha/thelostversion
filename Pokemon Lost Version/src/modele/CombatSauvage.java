package modele;

import vue.*;

public class CombatSauvage extends Combat 
{
	Pokemon sauvage;
	

	public CombatSauvage(Dresseur h) 
	{
		heros = h;
		
		int PokemonAleatoire = (int) (Math.random()*4);
		switch (PokemonAleatoire)
		{
			case 0: 
				sauvage = new Rattata();
				sauvage.setNiv((int) (Math.random()*3+2));
			break;
			case 1: 
				sauvage = new Aspicot();
				sauvage.setNiv((int) (Math.random()*2+2));
				
			break;
			case 2: 
				sauvage = new Chenipan();
				sauvage.setNiv((int) (Math.random()*2+2));
				
			break;
			case 3: 
				sauvage = new Roucool();
				sauvage.setNiv((int) (Math.random()*4+2));
			break;
		}
		sauvage.miseAJourStat();

		
		
		
		
		
	}
	public void declencherCombat()
	{
		
		boolean victoire = false;
		boolean defaite = false;
		boolean fuite = false;
		System.out.println("Un "+sauvage.getNom()+" sauvage apparait ! (Nv. "+sauvage.getNiv()+")");
		System.out.println("En avant "+heros.getPokemon1().getNom()+" ! (Nv. "+heros.getPokemon1().getNiv()+")");
		while(victoire == false || defaite == false || fuite == false ){
				//DEBUGPV
				System.out.println(heros.getPokemon1().getNom()+" : "+heros.getPokemon1().getPV()+" PV");
				System.out.println(sauvage.getNom()+" ennemi : "+sauvage.getPV()+" PV");
				//DEBUGPV
				/*if(choixCombat() == 1){
			    	System.out.println(sauvage.getNom()+" lance "+sauvage.getAttaque1().getNom()+" !");
					System.out.println(this.attaqueAleatoire(sauvage)); 
			    }*/
				int tentativeFuite = 0;
				int choix;
				victoire = verifierDefaite(sauvage);
		    	defaite = verifierDefaite(heros.getPokemon1());
		    	if(victoire || defaite){
		    		break;
		    	}
		    	choix = choixCombat();
				 if(choix == 1){
					 	tentativeFuite = 0;
				    	if (this.calculerVitesse(heros.getPokemon1(), sauvage)){
				    		System.out.println(heros.getPokemon1().getNom()+" envoie "+heros.getPokemon1().getAttaque1().getNom());
				    		attaque(heros.getPokemon1(), sauvage);
				    		victoire = verifierDefaite(sauvage);
				    		if(victoire){
					    		break;
					    	}
				    		System.out.println(sauvage.getNom()+" envoie "+sauvage.getAttaque1().getNom());
				    		attaque(sauvage, heros.getPokemon1());
				    	}
				    	else{
				    		System.out.println(sauvage.getNom()+" envoie "+sauvage.getAttaque1().getNom());
				    		attaque(sauvage, heros.getPokemon1());
				    		defaite = verifierDefaite(heros.getPokemon1());
				    		if(defaite){
					    		break;
					    	}
				    		System.out.println(heros.getPokemon1().getNom()+" envoie "+heros.getPokemon1().getAttaque1().getNom());
				    		attaque(heros.getPokemon1(), sauvage);
				    	}
				    		
				    	/*System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom()+" !");
						System.out.println(this.attaque()); */
				    }
				 if(choix == 0){
					 	
				    	if (this.calculerVitesse(heros.getPokemon1(), sauvage)){
				    		System.out.println(heros.getPokemon1().getNom()+" ne veux pas attaquer!");
				    		System.out.println(sauvage.getNom()+" envoie "+sauvage.getAttaque1().getNom());
				    		attaque(sauvage, heros.getPokemon1());
				    	}
				    	else{
				    		System.out.println(sauvage.getNom()+" envoie "+sauvage.getAttaque1().getNom());
				    		attaque(sauvage, heros.getPokemon1());
				    		System.out.println(heros.getPokemon1().getNom()+" ne veux pas attaquer!");
				    	}
				    		
				    	/*System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom()+" !");
						System.out.println(this.attaque()); */
				    }
				 if(choix == 4){
					 if(this.testerFuite(tentativeFuite) == true){
						 fuite = true;
						 break;
					 }
					 else{
						 System.out.println("Fuite impossible!");
						 System.out.println(sauvage.getNom()+" envoie "+sauvage.getAttaque1().getNom());
				    		attaque(sauvage, heros.getPokemon1());
					 }
						 
				 }
		}
		if(victoire){
			System.out.println(sauvage.getNom()+" est vaincu !");
			System.out.println(heros.getPokemon1().getNom()+" gagne "+sauvage.donExperience()+" points d'experience!");
			heros.getPokemon1().verifExperience(sauvage.donExperience());
		}
		if(defaite){
			System.out.println(heros.getPokemon1().getNom()+" est vaincu!");
			System.out.println(heros.getNom()+" est hors-jeu!");
		}
		if(fuite){
			System.out.println(heros.getNom()+" prend la fuite.");
		}
		
	}
	
	public boolean verifierDefaite(Pokemon p)
	{
		if(p.getPV() == 0)
			return true;
		else
			return false;
	}
	
	
	public Pokemon getSauvage() {
		return sauvage;
	}
	public void setSauvage(Pokemon sauvage) {
		this.sauvage = sauvage;
	}
	public boolean testerFuite(int tentative)
	{
		int bEtape1 = sauvage.getVit()/4;
		int bEtape2 = bEtape1%255;
		if(bEtape2 == 0)
			return true;
		int fEtape1 = heros.getPokemon1().getVit()*32;
		int fEtape2 = fEtape1/bEtape2;
		int fEtape3 = fEtape2+30*tentative;
		if(fEtape3>255)
			return true;
		else{
			if(Math.random()*255 > 191)
				return true;
			else
				return false;
		}
		
	}
}