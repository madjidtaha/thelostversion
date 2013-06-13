package modele;

public class Pikachu extends Pokemon implements NomAttaque
{
	Pikachu()
	{
		this.nom = "Pikachu";
		this.niv = 5;
		this.statut = 0;
		this.exp = (int)(0.8*Math.pow(this.niv, 3));
		this.expDonne=82;
		this.pvBase = 35;
		this.atkBase = 55;
		this.defBase = 30;
		this.aspeBase = 50;
		this.dspeBase = 40;
		this.vitBase = 90;
		this.type1 = ELECTRIK;
		this.type2 = AUCUN;
		this.attaques[0] = new Attaque(ECLAIR);
		for(int i = 1; i<4; i++){
			this.attaques[i] = new Attaque(AUCUN);

		}
		this.miseAJourStat();
		this.pvMax = this.pv;
	
	}
}