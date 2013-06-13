package modele;

import java.util.*;

public class Monde implements Direction, Obstacle
{
	public int matrice[][];
	public Heros blue;
	final static int HEROS = 7;
	
	public Monde()
	{
		this.matrice = new int[126][70];
		
		
		
		for (int x=0;x<this.matrice.length;x++)
		{
			for (int y=0;y<70;y++)
			{
				// Collisions de la ville de Jadielle 
				if ((x>=15 && x <=45) && (y>=21 && y<=55)) // Ces valeurs sont le rectangle qui contient la ville de Jadielle
				{
					matrice[x][y] = ACCESSIBLE;
					
					if ((x>=15 && x<=27) && (y>=21 && y<=32)) // Petit bois en haut à gauche de Jadielle
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=19 && x<=22) && (y>=38 && y<=42)) // Petite maison verte du haut
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=26 && x<=29) && (y>=38 && y<=42)) // Petite maison verte du bas
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=17 && x<=21) && (y>=47 && y<=52)) // Arène en haut à droite
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=26 && x<=30) && (y>=48 && y<=51)) // Magasin (bleu)
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=33 && x<=37) && (y>=38 && y<=42)) // Centre Pokemon (rouge)
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=33 && x<=35) && (y>=21 && y<=24)) // Arbres en bas à gauche (deux côte à côte)
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=34 && x<=36) && (y>=26 && y<=27)) // Arbre en bas à gauche (tout seul)
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x>=37 && x<=41) && (y>=25 && y<=30)) // Point d'eau 
						this.matrice[x][y] = INACCESSIBLE;	
					
					// Les barrières
					else if ((x==23 && (y>=41 && y<=55)) ) 
						this.matrice[x][y] = INACCESSIBLE; 
					else if ((x==26 && (y>=43 && y<=55)) )
						this.matrice[x][y] = INACCESSIBLE; 
					else if ((x==41 && (y>=20 && y<=33)) || (x==41 && (y>=37 && y<=55)) ) 
						this.matrice[x][y] = INACCESSIBLE; 
				}
				
				// Chemin entre route 1 et Jadielle
				else if ((x>=46 && x <=52) && (y>=36 && y<=39)) // Ces valeurs sont le rectangle qui contient la route 1
				{
					matrice[x][y] = ACCESSIBLE; 
				}
				
				// Route 1
				else if ((x>=53 && x <=86) && (y>=28 && y<=47)) // Ces valeurs sont le rectangle qui contient la route 1
				{
					matrice[x][y] = ACCESSIBLE; 
					
				/* Première partie de la route 1 en haut (jusqu'au début de la 2ème zone d'herbe) */
					// Arbres à la verticale en haut de la Route 1
					if ((x>=54 && x<=62) && (y>=34 && y<=35))
						this.matrice[x][y] = INACCESSIBLE;
					// Barrières du haut de la zone
					else if ((x==56) && (y>=28 && y<=41))
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x==61) && (y>=28 && y<=34))
						this.matrice[x][y] = INACCESSIBLE;
					// 1ère zone d'herbe en partant du haut
					else if ((x>=57 && x<=61) && (y>=36 && y<=47))
						this.matrice[x][y] = HERBES;
					
				/* Deuxième partie de la route 1 au milieu (jusqu'au début de la 3ème zone d'herbe) */
					else if ((x>=65 && x<=67) && ((y>=28 && y<=29) || (y>=36 && y<=41)) ) // Arbres 
						this.matrice[x][y] = INACCESSIBLE;
					// Barrières
					else if ((x==66) && (y>=30 && y<=35)) 
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x==71) && ((y>=28 && y<=29) || (y>=31 && y<=34) || (y>=37 && y<=47))) 
						this.matrice[x][y] = INACCESSIBLE;
					// Hautes herbes
					else if ((x>=64 && x<=68) && (y>=42 && y<=47)) 
						this.matrice[x][y] = HERBES;
					else if ((x>=75 && x<=79) && (y>=38 && y<=43))
						this.matrice[x][y] = HERBES;
					
				/* Troisième partie de la route 1 à la fin (jusqu'à la fin de la Route 1) */
					
					// Arbres
					else if ((x>=75 && x<=77) && (y>=28 && y<=37))
						this.matrice[x][y] = INACCESSIBLE;
					// Barrières
					else if ((x==77) && (y>=44 && y<=47)) 
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x==82) && ((y>=28 && y<=31) || (y>=36 && y<=47))) 
						this.matrice[x][y] = INACCESSIBLE;
					// Hautes herbes
					else if ((x>=83 && x<=84) && ((y>=30 && y<=36) || (y>=43 && y<=47)))
						this.matrice[x][y] = HERBES;
					else if ((x>=85 && x<=86) && ((y>=28 && y<=34) || (y>=41 && y<=45) || (y>=38 && y<=39)))
						this.matrice[x][y] = HERBES;
				}
				
				// Petit chemin entre la Route 1 et Bourg-Palette
				else if ((x>=87 && x <=92) && (y>=38 && y<=39)) // Ces valeurs représentent le rectangle qui contient le chemin
				{
					this.matrice[x][y] = ACCESSIBLE;
					
					if ((x>=87 && x<=90) && (y>=38 && y<=39))
						this.matrice[x][y] = HERBES;
				}
				
				// Rectangle contenant la ville de Bourg-Palette
				if ((x>=93 && x <=110) && (y>=28 && y<=47)) 
				{
					this.matrice[x][y] = ACCESSIBLE;
					
					// Les deux maisons en haut de la ville
					if ((x>=94 && x<=98) && ((y>=31 && y<=35) || (y>=40 && y<=44)))
						this.matrice[x][y] = INACCESSIBLE;
					// Boites aux lettres de ces deux maisons
					else if ((x==97) && ((y==30) || (y==39)))
						this.matrice[x][y] = INACCESSIBLE;
					// Maison en bas à droite (Laboratoire du professeur Chen)
					else if ((x>=100 && x<=104) && ((y>=39 && y<=45)))
						this.matrice[x][y] = INACCESSIBLE;
					// Barrières
					else if ((x==102) && ((y>=31 && y<=34)))
						this.matrice[x][y] = INACCESSIBLE;
					else if ((x==107) && ((y>=39 && y<=44)))
						this.matrice[x][y] = INACCESSIBLE;
					// Eau en bas de Bourg-Palette
					else if ((x>=108 && x<=110) && ((y>=33 && y<=36)))
						this.matrice[x][y] = INACCESSIBLE;
					// Arbres tout en bas de Bourg-Palette
					else if ((x==110) && ((y>=28 && y<=31) || (y>=44 && y<=47)))
						this.matrice[x][y] = INACCESSIBLE;
				}
			}
		}
		
		//!\\ Codage des PNJ //!\\
		
		
		//!\\ Codage des panneaux //!\\	
		
		this.matrice[15][37] = 40; // Panneau "Route en construction, chemin fermé" 
		this.matrice[21][46] = 41; // Panneau "Arène de Jadielle, temporairement fermée" 
		this.matrice[27][34] = 42; // Panneau "Vous ne trouvez pas la boutique ? Elle se trouve à l'est de la ville" 
		this.matrice[42][34] = 43; // Panneau "Bienvenue dans la ville de Jadielle" 
		this.matrice[82][35] = 44; // Panneau "Vous être sur la Route 1, attention aux Pokemon sauvages... et aux dresseurs !" 
		this.matrice[98][30] = 45; // Boîte aux lettres "Maison de Red" 
		this.matrice[98][39] = 46; // Boîte aux lettres "Maison de Blue" 
		this.matrice[102][35] = 47; // Panneau "Attention ! Des Pokemon sauvages peuvent apparaître dans les hautes herbes"		
		this.matrice[105][31] = 48; // Panneau "Bienvenue dans la ville de Bourg-Palette"
		this.matrice[107][42] = 49; // Panneau "Laboratoire du professeur Chen"
		
		
		//!\\ Codage des portes //!\\	
		
		//Jadielle
		this.matrice[22][39] = 50; // Maison verte du haut
		this.matrice[29][39] = 51; // Maison verte du bas 
		this.matrice[30][50] = 52; // Magasin 
		this.matrice[37][40] = 53; // Maison verte du bas 
		
		// Bourg-Palette
		this.matrice[98][32] = 54; // Maison de Red (en haut à gauche)
		this.matrice[98][41] = 55; // Maison de Blue (en haut à droite)
		this.matrice[104][42] = 56; // Laboratoire du professeur Chen (en bas à droite)
		
		
		//!\\ Codage des dresseurs PNJ //!\\	
				
			// En partant du Nord vers le Sud
				this.matrice[56][42] = 60; // DPNJ le plus haut au nord de la route 1
				this.matrice[64][28] = 61; // DPNJ à gauche
				this.matrice[67][42] = 62; // DPNJ hautes herbes droite
				this.matrice[70][37] = 63; // DPNJ milieu
				this.matrice[74][44] = 64; // DPNJ droite
				this.matrice[80][31] = 65; // DPNJ route
				this.matrice[84][40] = 66; // DPNJ tout au sud
				
				blue = new Heros();
				this.matrice[blue.getPosX()][blue.getPosY()] = HEROS;
	}
	
	public void afficher()
	{
		for (int x=0;x<this.matrice.length; x++)
		{

			for (int y=0;y<70; y++)
			{
				System.out.print(this.matrice[x][y]);
			}
			
			System.out.println(" "+x );
		}
	}
	
	public void deplaceBlue(int newX, int newY, int uneDirection)
	{
		
		// Teste s'il n'y a pas de collisions de détectées 			
		
		if (detecteCollision(uneDirection) == true)
		{
			this.blue.setPosX(newX); // La nouvelle position sur l'axe des abscisses est accessible donc la position du personnage est modifiée
			this.blue.setPosY(newY); // // La nouvelle position sur l'axe des ordonnées			 ""				""				""
			
					
		
			for (int x=0;x<this.matrice.length; x++) // Parcours de la matrice
			{

				for (int y=0;y<70; y++)
				{
					if (this.matrice[x][y] == HEROS) // Si une case vaut 7 (ancienne position du perso) alors
						this.matrice[x][y] = ACCESSIBLE; // la case vaut maintenant 1 
				}
			}
			
			this.matrice[this.blue.getPosX()][this.blue.getPosY()] = HEROS;
		}
	}
	
	public boolean detecteCollision(int uneDirection)
	{
		boolean autorisation; // Ce booléen servira à renvoyer l'autorisation d'accéder à une case, si elle vaut false, le personnage ne se déplace pas
		
		
		// Détection de collision axe des abscisses
		
				// Détection des cases inaccessibles
				if ((uneDirection == GAUCHE && this.matrice[this.blue.getPosX()][this.blue.getPosY()-1]    == 0) || // Collision en regardant la case à gauche du personnage
						(uneDirection == DROITE && this.matrice[this.blue.getPosX()][this.blue.getPosY()+1]    == 0) || // Collision en regardant la case à droite du personnage
							(uneDirection == HAUT && this.matrice[this.blue.getPosX()-1][this.blue.getPosY()]    == 0) || // Collision en regardant la case en haut du personnage
								(uneDirection == BAS && this.matrice[this.blue.getPosX()+1][this.blue.getPosY()]    == 0) ) // Collision en regardant la case en bas du personnage
				{
					this.matrice[this.blue.getPosX()][this.blue.getPosY()] = HEROS;
					System.out.println("Impossible d'accéder : zone inaccessible");
					autorisation = false;
				}
				
				// Détection des panneaux (qui ont des valeurs comprises entre 40 inclus et 49 inclus)
				
									// Collision en regardant la case à gauche du personnage
				else if ((uneDirection == GAUCHE && this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] >= 40  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] <=49) || 
						
								// Collision en regardant la case à droite du personnage
						(uneDirection == DROITE && this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] >= 40  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] <=49) ||
						
								// Collision en regardant la case en haut du personnage 
							(uneDirection == HAUT && this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] >= 40  &&  this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] <=49) || 
							
								// Collision en regardant la case en bas du personnage
								(uneDirection == BAS && this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] >= 40  &&  this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] <=49) ) 
				{
					this.matrice[this.blue.getPosX()][this.blue.getPosY()] = HEROS;
					System.out.println("Impossible d'accéder : panneau");
					autorisation = false;
				}
				
				// Détection des hautes herbes (qui ont des valeurs comprises entre 60 inclus et 66 inclus)
				
				// Collision en regardant la case à gauche du personnage
				else if ((uneDirection == GAUCHE && this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] == HERBES  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] == HERBES) || 

						// Collision en regardant la case à droite du personnage
						(uneDirection == DROITE && this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] == HERBES  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] == HERBES) ||

						// Collision en regardant la case en haut du personnage 
						(uneDirection == HAUT && this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] == HERBES  &&  this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] == HERBES) || 

						// Collision en regardant la case en bas du personnage
						(uneDirection == BAS && this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] == HERBES  &&  this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] == HERBES) ) 
				{
					this.matrice[this.blue.getPosX()][this.blue.getPosY()] = HEROS;
					System.out.println("Hautes herbes");
					autorisation = true;
				}
				
					
				// Détection des PNJ (qui ont des valeurs comprises entre 60 inclus et 66 inclus)
				
								// Collision en regardant la case à gauche du personnage
				else if ((uneDirection == GAUCHE && this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] >= 60  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] <=66) || 

								// Collision en regardant la case à droite du personnage
						(uneDirection == DROITE && this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] >= 60  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] <=66) ||

								// Collision en regardant la case en haut du personnage 
						(uneDirection == HAUT && this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] >= 60  &&  this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] <=66) || 

								// Collision en regardant la case en bas du personnage
						(uneDirection == BAS && this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] >= 60  &&  this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] <=66) ) 
				{
					this.matrice[this.blue.getPosX()][this.blue.getPosY()] = HEROS;
					System.out.println("Impossible d'accéder : dresseur de Pokemon");
					autorisation = false;
				}
				
				else 
				{
					autorisation = true;
				}
				
		return autorisation; 
	}
	
	

	
	
	public int lecturePanneau(int uneDirection)
	{
		int panneau = 0;
		
		// Condition qui regarde le panneau à gauche du personnage 
		if (uneDirection == GAUCHE && (this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] >= 40  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()-1] <=49))
		{
			panneau = this.matrice[this.blue.getPosX()][this.blue.getPosY()-1]; // met la valeur de la case à gauche du personnage dans la variable panneau
		}	
		
		// Condition qui regarde le panneau à droite du personnage 
		else if (uneDirection == DROITE && (this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] >= 40  &&  this.matrice[this.blue.getPosX()][this.blue.getPosY()+1] <=49))
		{
			panneau = this.matrice[this.blue.getPosX()][this.blue.getPosY()+1]; // met la valeur de la case à gauche du personnage dans la variable panneau
		}
		
		// Condition qui regarde le panneau en haut du personnage 
		else if (uneDirection == HAUT && (this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] >= 40  &&  this.matrice[this.blue.getPosX()-1][this.blue.getPosY()] <=49))
		{
			panneau = this.matrice[this.blue.getPosX()-1][this.blue.getPosY()]; // met la valeur de la case à gauche du personnage dans la variable panneau
		}
		
		// Condition qui regarde le panneau en bas du personnage 
		else if (uneDirection == BAS && (this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] >= 40  &&  this.matrice[this.blue.getPosX()+1][this.blue.getPosY()] <=49))
		{
			panneau = this.matrice[this.blue.getPosX()+1][this.blue.getPosY()]; // met la valeur de la case à gauche du personnage dans la variable panneau
		}
		
		return panneau;
	}
	
	
	public boolean entreeBatiment()
	{
		boolean autorisation = false;
		
		// On cherche donc si une des cases de la matrice représentant une porte a pris la valeur de la position du personnage (donc une case qui vaut 7)		
		if (this.matrice[22][39] == 7)
		{
			this.matrice[22][39] = 50; 
			autorisation = true;
		}
		else if (this.matrice[29][39] == 7)
		{
			this.matrice[29][39] = 51; 
			autorisation = true;
		}
		else if (this.matrice[30][50] == 7)
		{
			this.matrice[30][50] = 52; 
			autorisation = true;
		}
		else if (this.matrice[37][40] == 7)
		{
			this.matrice[37][40] = 53;  
			autorisation = true;
		}
		else if (this.matrice[98][32] == 7)
		{
			this.matrice[98][32] = 54;  
			autorisation = true;
		}
		else if (this.matrice[98][41] == 7)
		{
			this.matrice[98][41] = 55;  
			autorisation = true;
		}
		else if (this.matrice[104][42] == 7)
		{
			this.matrice[104][42] = 56;  
			autorisation = true;
		}
		
		return autorisation;
	}
}
