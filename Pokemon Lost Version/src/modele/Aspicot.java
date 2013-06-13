package modele;

public class Aspicot extends Pokemon
{
	Aspicot()
	{
		this.nom = "Aspicot";
		this.niv = (int) Math.random()*5+2;
		this.statut = 0;
		this.exp = (int)(0.8*Math.pow(this.niv, 3));
		this.expDonne=52;
		this.pvBase = 40;
		this.atkBase = 35;
		this.defBase = 30;
		this.aspeBase = 20;
		this.dspeBase = 20;
		this.vitBase = 50;
		this.type1 = INSECTE;
		this.type2 = POISON;
		this.miseAJourStat();
		this.pvMax = this.pv;
		this.attaques[0] = new Attaque(DARDVENIN);
		for(int i = 1; i<4; i++){
			this.attaques[i] = new Attaque(AUCUN);

		}

	}
}