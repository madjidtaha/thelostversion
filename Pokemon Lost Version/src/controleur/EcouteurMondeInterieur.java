package controleur;

import java.awt.event.*;

import javax.swing.Timer;

import vue.*;
import modele.*;
import javax.swing.*;

public class EcouteurMondeInterieur implements KeyListener, ActionListener, Batiment
{
	
	VueBourgPalette maVue;
	Timer ecouteurTemps;
	boolean sortie, escalierHaut, escalierBas;
	

	
	public EcouteurMondeInterieur(VueBourgPalette uneVue)
	{
		maVue = uneVue;
		this.ecouteurTemps = new Timer(150, this);
	}

	public void keyPressed(KeyEvent key) 
	{
		
		if (key.getKeyCode() == KeyEvent.VK_UP)
		{
			this.maVue.mondeInterieur.blue.setDirection(this.maVue.mondeInterieur.HAUT);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_DOWN)
		{
			this.maVue.mondeInterieur.blue.setDirection(this.maVue.mondeInterieur.BAS);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_LEFT)
		{
			this.maVue.mondeInterieur.blue.setDirection(this.maVue.mondeInterieur.GAUCHE);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			this.maVue.mondeInterieur.blue.setDirection(this.maVue.mondeInterieur.DROITE);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_X)
		{
			
		} 
		
//!\\//!\\//!\\ Pendant phase de test au moins : raccourci pour fermer la fenêtre //!\\//!\\//!\\
		
				if (key.isControlDown() && key.getKeyCode() == KeyEvent.VK_Q)
				{
					System.exit(0);
				}
//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\
		
	}

	
	public void keyReleased(KeyEvent e) 
	{
		
		
	}

	
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		
		System.out.println("Position image de fond : "+ this.maVue.getCarteX() + " | "+this.maVue.getCarteY());
		if (this.maVue.mondeInterieur.blue.getDirection() == this.maVue.mondeInterieur.blue.HAUT)
		{
			if (this.maVue.mondeInterieur.detecteCollision(this.maVue.mondeInterieur.blue.getDirection()) == true)
				this.maVue.nord();
			
		}
		else if (this.maVue.mondeInterieur.blue.getDirection() == this.maVue.mondeInterieur.blue.BAS)
		{
			if (this.maVue.mondeInterieur.detecteCollision(this.maVue.mondeInterieur.blue.getDirection()) == true)
				this.maVue.sud();
		}
		else if (this.maVue.mondeInterieur.blue.getDirection() == this.maVue.mondeInterieur.blue.GAUCHE)
		{
			if (this.maVue.mondeInterieur.detecteCollision(this.maVue.mondeInterieur.blue.getDirection()) == true)
				this.maVue.ouest();
		}
		else if (this.maVue.mondeInterieur.blue.getDirection() == this.maVue.mondeInterieur.blue.DROITE)
		{
			if (this.maVue.mondeInterieur.detecteCollision(this.maVue.mondeInterieur.blue.getDirection()) == true)
				this.maVue.est();
		}
		
		this.ecouteurTemps.stop();

		for (int x=0;x<this.maVue.mondeInterieur.matriceBP.length; x++) // Parcours de la matrice
		{
			System.out.println("Position : "+this.maVue.mondeInterieur.blue.getPosXInt() + " | " +this.maVue.mondeInterieur.blue.getPosYInt());
			for (int y=0;y<119; y++)
			{
				
				if (this.maVue.mondeInterieur.matriceBP[this.maVue.mondeInterieur.blue.getPosXInt()][this.maVue.mondeInterieur.blue.getPosYInt()] == SORTIE)
				{
					this.sortie = true;
				}
				else if (this.maVue.mondeInterieur.matriceBP[this.maVue.mondeInterieur.blue.getPosXInt()][this.maVue.mondeInterieur.blue.getPosYInt()] == ESCALIER_HAUT)
				{
					this.escalierHaut = true;
				}
				else if (this.maVue.mondeInterieur.matriceBP[this.maVue.mondeInterieur.blue.getPosXInt()][this.maVue.mondeInterieur.blue.getPosYInt()] == ESCALIER_BAS)
				{
					this.escalierBas = true;
				}
			}
		}
		
		if (this.sortie == true)
		{
			this.maVue.setVisible(false);
			this.maVue.setFocusable(false);
			this.maVue.laFenetre.vueMonde.setVisible(true);
			this.maVue.laFenetre.vueMonde.setFocusable(true);
			this.maVue.laFenetre.vueMonde.requestFocus();
			this.maVue.laFenetre.vueMonde.sud();
			System.out.println("Sortie");
			System.out.println("Position bâtiment à la sortie : "+ this.maVue.mondeInterieur.blue.getPosXInt()+"  "+this.maVue.mondeInterieur.blue.getPosYInt());
		}
		else if (this.escalierHaut == true)
		{
			// Alors le héros est téléporté dans la matrice à l'endroit où se trouve l'escalier de l'étage
			this.maVue.mondeInterieur.blue.setPosXInt(12);
			this.maVue.mondeInterieur.blue.setPosYInt(24);			
			this.maVue.setCarteX(-32*7);
			this.maVue.setCarteY(-32*16);
			this.maVue.repaint();
			System.out.println("Escaliers : "+this.maVue.mondeInterieur.blue.getPosXInt() + " | " +this.maVue.mondeInterieur.blue.getPosYInt());
			this.escalierHaut = false;
		}
		else if (this.escalierBas == true)
		{
			// Alors le héros est téléporté dans la matrice à l'endroit où se trouve l'escalier du rez de chaussée
			this.maVue.mondeInterieur.blue.setPosXInt(12);
			this.maVue.mondeInterieur.blue.setPosYInt(48);			
			this.maVue.setCarteX(-32*7);
			this.maVue.setCarteY(-32*40);
			this.maVue.repaint();
			System.out.println("Escaliers : "+this.maVue.mondeInterieur.blue.getPosXInt() + " | " +this.maVue.mondeInterieur.blue.getPosYInt());
			this.escalierBas = false;
		}
		
	}
}
