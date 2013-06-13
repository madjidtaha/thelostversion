package vue;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import modele.*;

public class PanelCombatSauvage extends JPanel
{
	CombatSauvage modeleCombat;
	Image imageCombat, imageFond;
	ImageIcon imageRat, imageRouc, imageAspi, imageCheni, fond;
	
	public PanelCombatSauvage(Heros h)
	{
		modeleCombat = new CombatSauvage(h);
		
		
		System.out.println("combat !!!");
		
		fond = new ImageIcon("src/Images/blue_up.png");
		imageFond = fond.getImage();
		
		if (this.modeleCombat.getSauvage().getNom().equals("Aspicot"))
		{
			
			imageAspi = new ImageIcon("src/Images/blue_up.png");
			imageCombat = imageAspi.getImage();
			
		}
		else if (this.modeleCombat.getSauvage().getNom().equals("Chenipan"))
		{
			imageCheni = new ImageIcon("src/Images/blue_up.png");
			imageCombat = imageCheni.getImage();
		}
		else if (this.modeleCombat.getSauvage().getNom().equals("Rattata"))
		{
			imageRat = new ImageIcon("src/Images/blue_up.png");
			imageCombat = imageRat.getImage();
		}
		else if (this.modeleCombat.getSauvage().getNom().equals("Roucool"))
		{
			imageRouc = new ImageIcon("src/Images/blue_up.png");
			imageCombat = imageRouc.getImage();
		}
		
		//modeleCombat.declencherCombat();

	}
	
	public void retourJeu() {
		
	}
	
	public void paintComponent(Graphics g)
	{
		// g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
	}
}
