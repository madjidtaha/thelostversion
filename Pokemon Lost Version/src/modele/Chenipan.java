package modele;

public class Chenipan extends Pokemon
{
	Chenipan()
	{
		this.nom = "Chenipan";
		this.niv = (int) Math.random()*5+2;
		this.statut = 0;
		this.exp = (int)(0.8*Math.pow(this.niv, 3));
		this.expDonne=53;
		this.pvBase = 45;
		this.atkBase = 30;
		this.defBase = 35;
		this.aspeBase = 20;
		this.dspeBase = 20;
		this.vitBase = 45;
		this.type1 = INSECTE;
		this.type2 = AUCUN;
		this.miseAJourStat();
		this.pvMax = this.pv;
		this.attaques[0] = new Attaque(CHARGE);
		for(int i = 1; i<4; i++){
			this.attaques[i] = new Attaque(AUCUN);

		}

	}
}