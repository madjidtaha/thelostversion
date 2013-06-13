package controleur;

import java.awt.event.*;
import javax.swing.Timer;

import modele.*;
import vue.*;


public class ControleurPanelJeu implements KeyListener, ActionListener
{
	PanelJeu vueJeu;
	public Timer ecouteurTemps;
	
	public ControleurPanelJeu(PanelJeu unPanelJeu)
	{
		vueJeu = unPanelJeu;
		this.ecouteurTemps = new Timer(150, this);
	}
	
	public void keyPressed(KeyEvent key) 
	{

		System.out.println(this.vueJeu.world.blue.getPosX() + " | " +this.vueJeu.world.blue.getPosY() + "  " + this.vueJeu.world.matrice[this.vueJeu.world.blue.getPosX()][this.vueJeu.world.blue.getPosY()]);
	
		if (this.vueJeu.panelActif == true) // Si un JPanel lié à un panneau ou à un dialogue de PNJ est ouvert 
		{
			this.vueJeu.remove(this.vueJeu.interaction); // Alors il est enlevé de la vue du monde principal
		}
		
		if (key.getKeyCode() == KeyEvent.VK_UP)
		{
			this.vueJeu.world.blue.setDirection(this.vueJeu.world.HAUT);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_DOWN)
		{
			this.vueJeu.world.blue.setDirection(this.vueJeu.world.BAS);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_LEFT)
		{
			this.vueJeu.world.blue.setDirection(this.vueJeu.world.GAUCHE);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			this.vueJeu.world.blue.setDirection(this.vueJeu.world.DROITE);
				this.ecouteurTemps.start();
		}
		else if (key.getKeyCode() == KeyEvent.VK_X)
		{
			if (this.vueJeu.world.lecturePanneau(this.vueJeu.world.blue.getDirection()) != 0)
				this.vueJeu.ajoutPanneauPNJ();
		} 
		
//!\\//!\\//!\\ Pendant phase de test au moins : raccourci pour fermer la fenêtre //!\\//!\\//!\\
		
				if (key.isControlDown() && key.getKeyCode() == KeyEvent.VK_Q)
				{
					System.exit(0);
				}
//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\//!\\
		
	}

	public void keyReleased(KeyEvent key) 
	{
		
	}

	public void keyTyped(KeyEvent key) 
	{
		
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		
		if (this.vueJeu.world.entreeBatiment() == true)
		{
			this.vueJeu.maFenetre.add(new VueBourgPalette(this.vueJeu.world.blue.getPosX(), this.vueJeu.world.blue.getPosY(), this.vueJeu.world, this.vueJeu.maFenetre));
			this.vueJeu.setVisible(false);
			System.out.println("entrée");
		}

		if (this.vueJeu.world.blue.getDirection() == this.vueJeu.world.blue.HAUT)
		{
			if (this.vueJeu.world.detecteCollision(this.vueJeu.world.blue.getDirection()) == true)
				this.vueJeu.nord();
			
		}
		else if (this.vueJeu.world.blue.getDirection() == this.vueJeu.world.blue.BAS)
		{
			if (this.vueJeu.world.detecteCollision(this.vueJeu.world.blue.getDirection()) == true)
				this.vueJeu.sud();
		}
		else if (this.vueJeu.world.blue.getDirection() == this.vueJeu.world.blue.GAUCHE)
		{
			if (this.vueJeu.world.detecteCollision(this.vueJeu.world.blue.getDirection()) == true)
				this.vueJeu.ouest();
		}
		else if (this.vueJeu.world.blue.getDirection() == this.vueJeu.world.blue.DROITE)
		{
			if (this.vueJeu.world.detecteCollision(this.vueJeu.world.blue.getDirection()) == true)
				this.vueJeu.est();
		}
		
		this.ecouteurTemps.stop();
		
		
			
		
		
		
	}

}

