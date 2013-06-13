package modele;

public class Missingno extends Pokemon implements NomAttaque
	{
		Missingno()
		{
			this.nom = "Missingno";
			this.niv = 0;
			this.statut = 0;
			this.exp = 0;
			this.pvBase = 0;
			this.pv = (int)((int)(2*pvBase+31))*this.niv+this.niv+10;
			this.pvMax = this.pv;
			this.atkBase = 0;
			this.defBase = 0;
			this.aspeBase = 0;
			this.dspeBase = 0;
			this.vitBase = 0;
			this.atk = (int)((int)(2*atkBase+31))*this.niv+5;
			this.def = (int)((int)(2*defBase+31))*this.niv+5;
			this.aspe = (int)((int)(2*aspeBase+31))*this.niv+5;
			this.dspe = (int)((int)(2*dspeBase+31))*this.niv+5;
			this.vit = (int)((int)(2*vitBase+31))*this.niv+5;
			this.type1 = AUCUN;
			this.type2 = AUCUN;
			for(int i =0; i<4; i++){
				this.attaques[i] = new Attaque(AUCUN);
			}
		}
}