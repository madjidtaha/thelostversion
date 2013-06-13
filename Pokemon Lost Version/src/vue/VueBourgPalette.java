package vue;

import modele.*;
import controleur.*;
import vue.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VueBourgPalette extends JPanel implements Direction, Batiment
{
	Image carteInterieur;
	int carteX, carteY;
	public MondeBourgPalette mondeInterieur;
	public Monde mondePrincipal;
	int batiment;
	public Fenetre laFenetre;
	
	public VueBourgPalette(int x, int y, Monde leMonde, Fenetre uneFenetre)
	{
		
		this.mondePrincipal = leMonde;
		this.laFenetre = uneFenetre;
		
		
				/* Valeurs des portes de Bourg-Palette dans la classe Monde :
				 * this.matrice[98][32] = 54 : Maison de Red
					this.matrice[98][41] = 55 : Maison de Blue
					this.matrice[104][42] = 56 : Labo du Prof. Chen
				 * */
	
			// Conditions qui prenne la dernière position connue du héros dans le monde ouvert
				if (this.mondePrincipal.blue.getPosX() == 98 && this.mondePrincipal.blue.getPosY() == 32) // Ces coordonnées sont l'entrée de la maison de Red
				{
					this.carteY = -32*35;
					this.carteX = -32*13;
					this.batiment = MAISON_RED; 
				}
				else if (this.mondePrincipal.blue.getPosX() == 98 && this.mondePrincipal.blue.getPosY() == 41) // Ces coordonnées sont l'entrée de la maison de Blue
				{
					this.carteY = -32*62;
					this.carteX = -32*13;
					this.batiment = MAISON_BLUE;
				}
				
				else if (this.mondePrincipal.blue.getPosX() == 104 && this.mondePrincipal.blue.getPosY() == 42) // Ces coordonnées sont l'entrée du Labo
				{
					this.carteY = -32*91;
					this.carteX = -32*17;
					this.batiment = LABO;
				}
				
				
				
				
				
				
		this.mondeInterieur = new MondeBourgPalette(this.batiment, leMonde);
		
		try // Chargement de l'image de fond 
		{
			this.carteInterieur = ImageIO.read(new File("src/Images/bourgpalette.png"));
		}	 catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("Erreur");
			}
			
		this.setFocusable(true); // Permet de mettre le focus sur ce JPanel pour qu'il détecte les entrées clavier 
		this.requestFocus();
		this.addKeyListener(new EcouteurMondeInterieur(this));

	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(this.carteInterieur, this.carteY, this.carteX, this);
		g.drawImage(this.mondePrincipal.blue.directionPerso, (32*7), (32*4),(32*8),(32*5), 0,0 ,32,32, this);
		this.mondePrincipal.blue.persoStop();
	}
	
	// Accesseurs / Modifieurs
	
	public void setCarteX(int x)
	{
		this.carteX = x;
	}
	public void setCarteY(int y)
	{
		this.carteY = y;
	}
	public int getCarteX()
	{
		return this.carteX;
	}
	public int getCarteY()
	{
		return this.carteY;
	}
	
	
	
	
	
	// Méthodes de déplacement
	
	public void nord()
	{
		
		this.mondeInterieur.blue.directionPerso = this.mondeInterieur.blue.hautAnim; // L'image du perso devient le gif
		this.mondeInterieur.deplaceBlue((this.mondeInterieur.blue.getPosXInt()-1), (this.mondeInterieur.blue.getPosYInt()), this.mondeInterieur.blue.getDirection());
		
		for (int i = 0; i<4;i++)
		{
			this.carteX += 8; // L'image de fond se décale vers le haut
			this.repaint();
			
		}
		
		System.out.println("nord");
		
	}
	public void sud()
	{
		this.mondeInterieur.blue.directionPerso = this.mondeInterieur.blue.basAnim;
		this.mondeInterieur.deplaceBlue((this.mondeInterieur.blue.getPosXInt()+1), (this.mondeInterieur.blue.getPosYInt()), this.mondeInterieur.blue.getDirection());
		
		for (int i = 0; i<4;i++)
		{
			this.carteX -= 8; // L'image de fond se décale vers le bas
			this.repaint();
		}
		System.out.println("sud");
	}
	public void ouest()
	{
		
			this.mondeInterieur.blue.directionPerso = this.mondeInterieur.blue.gaucheAnim;
			this.mondeInterieur.deplaceBlue((this.mondeInterieur.blue.getPosXInt()), (this.mondeInterieur.blue.getPosYInt()-1), this.mondeInterieur.blue.getDirection());
			
			for (int i = 0; i<4;i++)
			{
				this.carteY += 8; // L'image de fond se décale vers la gauche
				this.repaint();
			}
			System.out.println("ouest");
	}
	public void est()
	{
		
		this.mondeInterieur.blue.directionPerso = this.mondeInterieur.blue.droiteAnim;
		this.mondeInterieur.deplaceBlue((this.mondeInterieur.blue.getPosXInt()), (this.mondeInterieur.blue.getPosYInt()+1), this.mondeInterieur.blue.getDirection());
		
		for (int i = 0; i<4;i++)
		{
			this.carteY -= 8; // L'image de fond se décale vers la droite
			this.repaint();
		}
		System.out.println("est");
	}
}
