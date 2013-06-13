package vue; 

import javax.swing.*;

import controleur.ControleurPanelJeu;

import modele.*;


public class Fenetre extends JFrame
{
	Monde world;
	public PanelJeu vueMonde;

	public Fenetre()
	{
		this.setSize(480,320);
		this.setLocation(200,200);
		this.setTitle("Pokemon - The Lost Version");
		
		this.world = new Monde();
		vueMonde = new PanelJeu(this.world, this);
		
		this.add(vueMonde);
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
