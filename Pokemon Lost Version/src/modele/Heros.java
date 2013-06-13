package modele;

import java.awt.*;
import java.io.File;

import java.util.Vector;
import javax.swing.ImageIcon;

public class Heros extends Dresseur implements Direction
{
	int direction, posXInt, posYInt;
	public ImageIcon h, b, g, d, ha, ba, ga, da;	
	public Image haut, bas, gauche, droite, hautAnim, basAnim, gaucheAnim, droiteAnim;
	public Image directionPerso;
	
	
	Heros()
	{
		super.nom = "Blue"; // Le nom du heros
		super.posX = 105; // Position X au lancement du jeu
		super.posY = 42; // Position Y au lancement du jeu
		this.direction = BAS;
		
		// On donne une equipe vide au dresseur à sa création
		for (int i = 0; i<6; i++){
			equipe[i] = new Missingno();
		}
		//TEST
		equipe[0]=new Evoli();
		//FINTEST
		
		
		
		// Instanciation des images
		h = new ImageIcon("src/Images/blue_up.png");
		haut = h.getImage();
		b = new ImageIcon("src/Images/blue_down.png");
		bas = b.getImage();
		g = new ImageIcon("src/Images/blue_left.png");
		gauche = g.getImage();
		d = new ImageIcon("src/Images/blue_right.png");
		droite = d.getImage();
		ha = new ImageIcon("src/Images/blue_up_1.gif");
		hautAnim = ha.getImage();
		ba = new ImageIcon("src/Images/blue_down_1.gif");
		basAnim = ba.getImage();
		ga = new ImageIcon("src/Images/blue_left_1.gif");
		gaucheAnim = ga.getImage();
		da = new ImageIcon("src/Images/blue_right_1.gif");
		droiteAnim = da.getImage();
		
		// Par défaut le personnage est dirigé vers le bas, directionPerso est donc l'image du personnage vers le bas
		directionPerso = bas;
	}
	
	public void seDeplace(int x, int y)
	{
		this.posX = x;
		this.posY = y;
	}
	
	public int getPosX()
	{
		return this.posX;
	}
	public int getPosY()
	{
		return this.posY;
	}
	public int getDirection()
	{
		return this.direction;
	}
	
	public void setPosX(int x)
	{
		this.posX = x;
	}
	public void setPosY(int y)
	{
		this.posY = y;
	}
	public void setDirection(int d)
	{
		this.direction = d;			
	}
	
	
	
	// Accesseur/Modifieurs pour le monde intérieur
	public void setPosXInt(int x)
	{
		this.posXInt = x;
	}
	public void setPosYInt(int y)
	{
		this.posYInt = y;
	}
	public int getPosXInt()
	{
		return this.posXInt;
	}
	public int getPosYInt()
	{
		return this.posYInt;
	}
	
	
	
	public void persoStop()
	{
		if (this.direction == HAUT)
			this.directionPerso = haut;
		if (this.direction == BAS)
			this.directionPerso = bas;
		if (this.direction == GAUCHE)
			this.directionPerso = gauche;
		if (this.direction == DROITE)
			this.directionPerso = droite;
	}
}
