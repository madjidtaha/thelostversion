package modele;

import javax.swing.*;

public class MondeBourgPalette implements Direction, Batiment
{
	public int matriceBP[][];
	public Heros blue;
	final static int HEROS = 7;
	
	
	public MondeBourgPalette(int leBatiment, Monde leMonde)
	{
		this.matriceBP = new int[32][119];
		
		/* Valeurs des cases dans la matrice 
		 * Zones inaccessibles : 0
		 * Zones accessibles : 1
		 * Lit de Red : 3
		 * Potes : 4
		 * Escaliers : ESCALIER_HAUT ou ESCALIER_BAS
		 * Ordinateurs : 60
		 * */
		
		// Implémentation de la matrice des collisions de l'intérieur des bâtiments de Bourg-Palette 
		for (int x = 0; x < this.matriceBP.length; x++)
		{
			for (int y = 0; y < 119; y++)
			{
				// Collisions Maison de Red (étage)
				if ((x >= 10 && x <= 18) && (y >= 15 && y <= 25))
				{
					matriceBP[x][y] = 1;
					
					if (x >= 10 && x <= 11) // Mur du fond
						this.matriceBP[x][y] = 0;
					else if (x == 12 && y == 22)
						this.matriceBP[x][y] = 0;
					else if (x == 13 && (y >= 22 && y <= 23))
						this.matriceBP[x][y] = 0; 
					else if (x == 14 && y == 20)
						this.matriceBP[x][y] = 0;
					else if (x == 15 && y == 20)
						this.matriceBP[x][y] = 0;
					
					// Le lit 
					else if ((x >= 15 && x <= 16) && y == 16)
						this.matriceBP[x][y] = 3;
				}
		
				// Collisions Maison de Red (rez-de-chaussée)
				else if ((x >= 10 && x <= 18) && (y >= 40 && y <= 51))
				{
					matriceBP[x][y] = 1;
					
					if (x >= 10 && x <= 11) // Mur du fond
						this.matriceBP[x][y] = 0;
					else if (x == 13 && y == 51) // Main courante escalier
						this.matriceBP[x][y] = 0;
					else if ((x >= 14 && x <= 15) && (y >= 44 && y <= 47)) // Table et chaises
						this.matriceBP[x][y] = 0;
					else if ((x >= 16 && x <= 17) && (y == 40 || y == 51)) // Plantes
						this.matriceBP[x][y] = 0;			
				}
		
				// Collisions Maison de Blue
				else if ((x >= 10 && x <= 18) && (y >= 66 && y <= 78))
				{
					matriceBP[x][y] = 1;
					
					if (x >= 10 && x <= 11) // Mur du fond
						this.matriceBP[x][y] = 0;
					else if ((x >= 14 && x <= 15) && (y >= 71 && y <= 74)) // Table et chaises
						this.matriceBP[x][y] = 0;
					else if ((x >= 17 && x <= 18) && (y == 66 || y == 78)) // Plantes
						this.matriceBP[x][y] = 0;
				}
		
				// Collisions Labo du professeur Chen 
				else if ((x >= 10 && x <= 22) && (y >= 89 && y <= 101))
				{
					matriceBP[x][y] = 1;
					
					if (x >= 10 && x <= 11) // Mur du fond
						this.matriceBP[x][y] = 0;
					else if ((x >= 13 && x <= 14) && (y >= 89 && y <= 91))
						this.matriceBP[x][y] = 0;
					else if (x== 15 && (y >= 90 && y <= 91)) 
						this.matriceBP[x][y] = 0;
					else if ((x >= 17 && x <= 18) && ((y >= 89 && y <= 93) || (y >= 97 && y <= 101)))
						this.matriceBP[x][y] = 0;
					else if ((x >= 14 && x <= 15) && (y >= 97 && y <= 99)) // Table
						this.matriceBP[x][y] = 0;

					else if ((x >= 21 && x <= 22) && (y == 89 || y == 101)) // Plantes
						this.matriceBP[x][y] = 0;
				}
				
				// Les portes des bâtiments de Bourg-Palette
				else if (x==23 && y == 95) // Labo Prof Chen
				{
					this.matriceBP[x][y] = 4;
				}
				else if (x==19 && y == 70) // Maison de Blue
				{
					this.matriceBP[x][y] = 4;
				}
				else if (x==19 && y == 43) // Rez de chaussée maison de Red
				{
					this.matriceBP[x][y] = 4;
				}
				else if (x==12 && y == 49) // Escalier au rez de chaussée (Maison de Red)
				{
					this.matriceBP[x][y] = ESCALIER_HAUT;
				}
				else if (x==12 && y == 23) // Escalier à l'étage (Maison de Red)
				{
					this.matriceBP[x][y] = ESCALIER_BAS;
				}
				
				
				else 
					this.matriceBP[x][y] = 0;
			}
		}	
		
		
		this.blue = leMonde.blue;
		if (leBatiment == this.LABO)
		{
			this.blue.posXInt = 22;
			this.blue.posYInt = 95;
			this.matriceBP[22][95] = 7;
		}
		else if (leBatiment == this.MAISON_RED) 
		{
			this.blue.posXInt = 18;
			this.blue.posYInt = 43;
			this.matriceBP[18][43] = 7;
		}
		else if (leBatiment == this.MAISON_BLUE) 
		{
			this.blue.posXInt = 18;
			this.blue.posYInt = 70;
			this.matriceBP[18][70] = 7;
		}
	}
	
	public void afficherInterieurBP()
	{
		System.out.println("");
		System.out.println("");
		
		for (int x = 0; x < this.matriceBP.length; x++)
		{
			for (int y = 0; y < 119; y++)
			{
				System.out.print(this.matriceBP[x][y]);
			}
			System.out.println("");
		}
	}
	
	
	
	
	public void deplaceBlue(int newX, int newY, int uneDirection)
	{
		
		// Teste s'il n'y a pas de collisions de détectées 			
		
		if (detecteCollision(uneDirection) == true)
		{
			this.blue.setPosXInt(newX); // La nouvelle position sur l'axe des abscisses est accessible donc la position du personnage est modifiée
			this.blue.setPosYInt(newY); // // La nouvelle position sur l'axe des ordonnées			 ""				""				""

					
		
			for (int x=0;x<this.matriceBP.length; x++) // Parcours de la matrice
			{

				for (int y=0;y<119; y++)
				{
					if (this.matriceBP[x][y] == 7) // Si une case vaut 7 (ancienne position du perso) alors
						this.matriceBP[x][y] = 1; // la case vaut maintenant 1 
				}
			}
			
			this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()] = 7;
			
			
			
			// Ici on remet les portes à leur valeur initiale pour que lorsque le personnage est dessus, il sorte du bâtiment ou monte à l'étage
			this.matriceBP[23][95] = SORTIE;
			this.matriceBP[19][43] = SORTIE;
			this.matriceBP[19][70] = SORTIE;
			this.matriceBP[12][49] = ESCALIER_HAUT;
			this.matriceBP[12][22] = ESCALIER_BAS;
			
			
		}
	}
	
	public boolean detecteCollision(int uneDirection)
	{
		boolean autorisation; // Ce booléen servira à renvoyer l'autorisation d'accéder à une case, si elle vaut false, le personnage ne se déplace pas
		
		
		// Détection de collision axe des abscisses
		
				// Détection des cases inaccessibles
				if ((uneDirection == GAUCHE && this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()-1]    == 0) || // Collision en regardant la case à gauche du personnage
						(uneDirection == DROITE && this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()+1]    == 0) || // Collision en regardant la case à droite du personnage
							(uneDirection == HAUT && this.matriceBP[this.blue.getPosXInt()-1][this.blue.getPosYInt()]    == 0) || // Collision en regardant la case en haut du personnage
								(uneDirection == BAS && this.matriceBP[this.blue.getPosXInt()+1][this.blue.getPosYInt()]    == 0) ) // Collision en regardant la case en bas du personnage
				{
					this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()] = 7;
					System.out.println("Impossible d'accéder : zone inaccessible");
					autorisation = false;
				}
				
				// Condition qui vérifie s'il y a un lit
				else if ((uneDirection == GAUCHE && this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()-1]    == 3) || // Collision en regardant la case à gauche du personnage
						(uneDirection == DROITE && this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()+1]    == 3) || // Collision en regardant la case à droite du personnage
							(uneDirection == HAUT && this.matriceBP[this.blue.getPosXInt()-1][this.blue.getPosYInt()]    == 3) || // Collision en regardant la case en haut du personnage
								(uneDirection == BAS && this.matriceBP[this.blue.getPosXInt()+1][this.blue.getPosYInt()]    == 3) ) // Collision en regardant la case en bas du personnage
				{
					this.matriceBP[this.blue.getPosXInt()][this.blue.getPosYInt()] = 7;
					System.out.println("Impossible d'accéder : zone inaccessible");
					autorisation = false;
				}
				else 
				{
					autorisation = true;
				}
				
		return autorisation; 
	}
	
}
