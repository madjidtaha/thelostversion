package modele;

public class Roucool extends Pokemon
{
	Roucool()
	{
		this.nom = "Roucool";
		this.niv = (int) Math.random()*5+2;
		this.statut = 0;
		this.expDonne=55;
		this.pvBase = 40;
		this.atkBase = 45;
		this.defBase = 40;
		this.aspeBase = 35;
		this.dspeBase = 35;
		this.vitBase = 56;
		this.miseAJourStat();
		this.pvMax = this.pv;
		this.attaques[0] = new Attaque(TORNADE);
		for(int i = 1; i<4; i++){
			this.attaques[i] = new Attaque(AUCUN);

		}
	}
}