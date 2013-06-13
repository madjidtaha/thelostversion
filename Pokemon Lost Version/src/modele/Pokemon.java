package modele;

public class Pokemon implements Type, NomAttaque
{
	String nom;
	// Image img;
	int exp, niv, statut; // exp est l'exp�rience accumul�e par le dresseur, en fonction de son avanc�e, le niveau augmente
	// Vector <Attaque> // les attaques du Pokemon
	int pv, pvMax; // le nombre de pv du Pokemon et le nombre de points de vie maximum qu'il peut avoir en fonction de son niveau 
	int atk, def, vit, aspe, dspe;
	int pvBase, atkBase, defBase, vitBase, aspeBase, dspeBase;
	int expDonne;
	int type1, type2;
	Attaque[] attaques = new Attaque[4];
	
	
	

/*	void calculExp() // M�thode servant � calculer l'exp�rience et s'il faut augmenter le niveau en appellant le modifieur de niveau
	{
		//!\\ Ceci est un exemple //!\\
		//!\\ L'intervalle d'exp�rience entre chaque niveau est � d�finir avec Madjid (21/05/2013)
		if (this.exp > 50 && this.exp < 150)
		{
			this.niv = 2;
			this.pvMax = 30;
		}
	}
	*/
		
	void attaquer(Pokemon adversaire) // M�thode qui permet de calculer le nombre de PV enlev�s en fonction du pokemon adverse
	{
		
	}
	public String getNom(){
		return this.nom;
	}
	public int getPV(){
		return this.pv;
	}
	public int getPVMAX(){
		return this.pvMax;
	}
	public int getNiv(){
		return this.niv;
	}
	public int getAtk(){
		return this.atk;
	}
	public int getDef(){
		return this.def;
	}
	public int getVit(){
		return this.vit;
	}
	public int getAspe(){
		return this.aspe;
	}
	public int getDspe(){
		return this.dspe;
	}
	public int getType1(){
		return this.type1;
	}
	public int getType2(){
		return this.type2;
	}
	public int getExp(){
		return this.exp;
	}
	public int getExpDonne(){
		return this.expDonne;
	}
	public int getStatut(){
		return this.statut;
	}
	public Attaque getAttaque1(){
		return this.attaques[0];
	}
	public Attaque getAttaque2(){
		return this.attaques[1];
	}
	public Attaque getAttaque3(){
		return this.attaques[2];
	}
	public Attaque getAttaque4(){
		return this.attaques[3];
	}
	public Attaque getAttaques(int choix){
		return this.attaques[choix];
	}
	
	//Les modifieurs
	public void setPV(int newPV){
		this.pv = newPV;
	}
	public void setNiv(int newNiv){
		this.niv = newNiv;
	}
	public void setExp(int newExp){
		this.exp = newExp;
	}
	public void setStatut(int newStatut){
		this.statut = newStatut;
	}
	public void setAttaque1(Attaque a){
		this.attaques[0] = a;
	}
	public void setAttaque2(Attaque a){
		this.attaques[1] = a;
	}
	public void setAttaque3(Attaque a){
		this.attaques[2] = a;
	}
	public void setAttaque4(Attaque a){
		this.attaques[3] = a;
	}
	
	
	public void miseAJourStat(){
		this.pv = (int)((int)(2*pvBase+31))*this.niv/100+this.niv+10;
		this.atk = (int)((int)(2*atkBase+31))*this.niv/100+5;
		this.def = (int)((int)(2*defBase+31))*this.niv/100+5;
		this.aspe = (int)((int)(2*aspeBase+31))*this.niv/100+5;
		this.dspe = (int)((int)(2*dspeBase+31))*this.niv/100+5;
		this.vit = (int)((int)(2*vitBase+31))*this.niv/100+5;
		this.pvMax = this.pv;
	}
	/*Cette fonction prend en parametre l'experience donné par un Pokémon vaincu,
	 *l'ajoute à l'experience du Pokémon l'ayant vaincu et renvoie true si le niveau
	 *du Pokémon augmente, sinon elle renvoie false
	 *
	 *Elle met aussi à jour les stats du Pokemon ayant augmenté de niveau
	 */
	
	public boolean verifExperience(int experienceRecu){
		int expTotal = this.getExp()+experienceRecu;
		this.setExp(expTotal);
		if (expTotal >= 0.8*(Math.pow(this.getNiv()+1, 3))){
			System.out.println("ATK : "+this.getAtk()+" DEF "+this.getDef()+" VIT : "+this.getVit());
			this.setNiv(getNiv()+1);
			this.miseAJourStat();
			System.out.println(this.getNom()+" monte au niveau "+this.getNiv());
			System.out.println("ATK : "+this.getAtk()+" DEF "+this.getDef()+" VIT : "+this.getVit());
			return true;
		}
		else
			return false;
	}
	//Retourne l'experience donné par un Pokemon
	public int donExperience(){
		return this.getExpDonne()*this.getNiv()/7;
	}
	public void soigner(){
		this.setPV(this.getPVMAX());
	}
	
}