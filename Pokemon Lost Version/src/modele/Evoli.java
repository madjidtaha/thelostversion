package modele;

public class Evoli extends Pokemon
{
	Evoli()
	{
		this.nom = "Evoli";
		this.niv = 5;
		this.statut = 0;
		this.exp = 60;
		this.expDonne=92;
		this.pvBase = 55;
		this.atkBase = 55;
		this.defBase = 50;
		this.aspeBase = 45;
		this.dspeBase = 65;
		this.vitBase = 55;
		this.type1 = NORMAL;
		this.type2 = AUCUN;
		this.attaques[0] = new Attaque(CHARGE);
		for(int i = 1; i<4; i++){
			this.attaques[i] = new Attaque(AUCUN);

		}
		this.miseAJourStat();
		this.pvMax = this.pv;
		
	}

}