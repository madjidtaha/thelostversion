package vue;

import java.awt.*;

import javax.swing.*;

import controleur.*;
import modele.*;

public class PanneauPNJ extends JPanel 
{
	JLabel ecriture;
	Monde mondePanneau;
	PanelJeu vueJeu;
	int element;
	ImageIcon f;	
	Image fond;
	
	public PanneauPNJ(int n)
	{
		this.element = n;
		f = new ImageIcon("src/Images/fond_dialogues.png");
		fond = f.getImage();

		this.add(ecriture = new JLabel("Par défaut"));
		this.ecriture.setLocation(90,0);
		this.ecriture.setForeground(Color.BLACK);
		this.ecriture.setSize(460, 64); 
		panneau();
	}
	
	public void panneau()
	{
		if (this.element >= 40 || this.element <= 49)
		{
			switch (this.element)
			{
				case 40: this.ecriture.setText("Route en construction, chemin fermé"); break;
				case 41: this.ecriture.setText("Arène de Jadielle, temporairement fermée"); break;
				case 42: this.ecriture.setText("<html>Vous ne trouvez pas la boutique ?<br>Elle se trouve à l'est de la ville.</html>"); break;
				case 43: this.ecriture.setText("Bienvenue dans la ville de Jadielle"); break;
				case 44: this.ecriture.setText("<html>Vous être sur la Route 1,<br>attention aux Pokemon sauvages...<br>Et aux dresseurs !</html>"); break;
				case 45: this.ecriture.setText("Maison de Red"); break;
				case 46: this.ecriture.setText("Maison de Blue"); break;
				case 47: this.ecriture.setText("<html>Attention !<br> Des Pokemon sauvages peuvent<br> apparaître dans les hautes herbes.</html>"); break;
				case 48: this.ecriture.setText("Bienvenue dans la ville de Bourg-Palette"); break;
				case 49: this.ecriture.setText("Laboratoire du professeur Chen"); break;
			}
			System.out.println(this.element + " : "+this.ecriture.getText());
			
		}
	}
	
	public void setNumElement(int n)
	{
		this.element = n;
	}
	
	protected void paintComponent(Graphics g)
	{
		g.drawImage(fond, 0, 0, 460, 64, null);
	}

}
