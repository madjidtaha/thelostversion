package modele;

public class Rattata extends Pokemon
{
	Rattata()
	{
		this.nom = "Rattata";
		this.niv = (int) Math.random()*5+2;
		this.statut = 0;
		this.exp = (int)(0.8*Math.pow(this.niv, 3));
		this.expDonne=57;
		this.pvBase = 30;
		this.atkBase = 56;
		this.defBase = 35;
		this.aspeBase = 25;
		this.dspeBase = 35;
		this.vitBase = 72;
		this.type1 = NORMAL;
		this.type2 = AUCUN;
		this.miseAJourStat();
		this.pvMax = this.pv;
		this.attaques[0] = new Attaque(CHARGE);
		for(int i = 1; i<4; i++){
			this.attaques[i] = new Attaque(AUCUN);

		}
	}
}