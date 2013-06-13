package vue;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import controleur.*;
import modele.*;


public class PanelJeu extends JPanel implements Direction, Obstacle
{
	public Monde world;
	public Image carte;
	public int carteX, carteY;
	ControleurPanelJeu controleur;
	public PanneauPNJ interaction;
	public boolean panelActif;
	public Fenetre maFenetre;
	int lastValeur;
	PanelCombatSauvage panCombat;

	
	PanelJeu(Monde unMonde, Fenetre fen)
	{
		this.world = unMonde;
		this.panelActif = false;
		this.maFenetre = fen;
		
		try // Chargement de l'image de fond
		{
			this.carte = ImageIO.read(new File("mapcollision.png"));
		}	 catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("Erreur");
			}
		this.carteX = (-32*101);
		this.carteY = (-32*35);
		
		this.setFocusable(true); // Permet de mettre le focus sur ce JPanel pour qu'il détecte les entrées clavier 
		this.requestFocus();
		controleur = new ControleurPanelJeu(this);
		this.addKeyListener(controleur);
		this.setLayout(null);
	
	}
	
	public void ajoutPanneauPNJ()
	{
		this.interaction = new PanneauPNJ(this.world.lecturePanneau(this.world.blue.getDirection()));
		this.interaction.setBounds(10, 200, 460, 140);
		this.add(interaction);
		this.panelActif = true;
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(this.carte, this.carteY, this.carteX, this);
		g.drawImage(this.world.blue.directionPerso, (32*7), (32*4),(32*8),(32*5), 0,0 ,32,32, this);
		this.world.blue.persoStop();
	}
	
	public void nord()
	{
		
		this.world.blue.directionPerso = this.world.blue.hautAnim; // L'image du perso devient le gif
		
		if (this.world.matrice[this.world.blue.getPosX()-1][this.world.blue.getPosY()] == HERBES)
		{
			this.lastValeur = HERBES;
		}
		
		this.world.deplaceBlue((this.world.blue.getPosX()-1), (this.world.blue.getPosY()), this.world.blue.getDirection());
		
		for (int i = 0; i<4;i++)
		{
			this.carteX += 8; // L'image de fond se décale vers le haut
			this.repaint();
			
		}
		
		if (this.lastValeur == HERBES)
		{
			double combat = Math.random();
			combat = 0.2;
			System.out.println("Test combat : " +combat);
			if (combat <= 0.25)
			{
				/*this.setVisible(false);
				this.panCombat = new PanelCombatSauvage(cs);
				this.panCombat.setVisible(true);
				this.maFenetre.add(panCombat);*/
				maFenetre.removeAll();
				panCombat = new PanelCombatSauvage(this.world.blue);
				maFenetre.add(panCombat);
				maFenetre.repaint();
			}
			this.lastValeur = -1;
		}
		
		
		System.out.println(this.world.blue.getPosX() +" "+this.world.blue.getPosY());
		
		
		
	}
	public void sud()
	{
		this.world.blue.directionPerso = this.world.blue.basAnim;
		
		if (this.world.matrice[this.world.blue.getPosX()+1][this.world.blue.getPosY()] == HERBES)
		{
			this.lastValeur = HERBES;
		}
		
		this.world.deplaceBlue((this.world.blue.getPosX()+1), (this.world.blue.getPosY()), this.world.blue.getDirection());
		
		for (int i = 0; i<4;i++)
		{
			this.carteX -= 8; // L'image de fond se décale vers le bas
			this.repaint();
		}
		
		if (this.lastValeur == HERBES)
		{
			double combat = Math.random();
			System.out.println("Test combat : " +combat);
			if (combat <= 0.25)
			{
				new CombatSauvage(this.world.blue);			
			}
			this.lastValeur = -1;
		}
		
		System.out.println(this.world.blue.getPosX() +" "+this.world.blue.getPosY());
	}
	public void ouest()
	{
		
			this.world.blue.directionPerso = this.world.blue.gaucheAnim;
			
			if (this.world.matrice[this.world.blue.getPosX()][this.world.blue.getPosY()-1] == HERBES)
			{
				this.lastValeur = HERBES;
			}
			
			this.world.deplaceBlue((this.world.blue.getPosX()), (this.world.blue.getPosY()-1), this.world.blue.getDirection());
			
			for (int i = 0; i<4;i++)
			{
				this.carteY += 8; // L'image de fond se décale vers la gauche
				this.repaint();
			}
			
			if (this.lastValeur == HERBES)
			{
				double combat = Math.random();
				System.out.println("Test combat : " +combat);
				if (combat <= 0.25)
				{
					new CombatSauvage(this.world.blue);			
				}
				this.lastValeur = -1;
			}
			System.out.println(this.world.blue.getPosX() +" "+this.world.blue.getPosY());
	}
	public void est()
	{
		
		this.world.blue.directionPerso = this.world.blue.droiteAnim;
		
		if (this.world.matrice[this.world.blue.getPosX()][this.world.blue.getPosY()+1] == HERBES)
		{
			this.lastValeur = HERBES;
		}
		
		this.world.deplaceBlue((this.world.blue.getPosX()), (this.world.blue.getPosY()+1), this.world.blue.getDirection());
		
		for (int i = 0; i<4;i++)
		{
			this.carteY -= 8; // L'image de fond se décale vers la droite
			this.repaint();
		}
		
		if (this.lastValeur == HERBES)
		{
			double combat = Math.random();
			System.out.println("Test combat : " +combat);
			if (combat <= 0.25)
			{
				new CombatSauvage(this.world.blue);			
			}
			this.lastValeur = -1;
		}
		
		System.out.println(this.world.blue.getPosX() +" "+this.world.blue.getPosY());
	}
	
	
}
