package modele;

public class Red extends Dresseur {

	Red(){
		this.setNom("Red");
		for (int i = 0; i<6; i++){
			equipe[i] = new Missingno();
		}
		//TEST
		equipe[0]=new Pikachu();
		equipe[1]=new Roucool();
		//FINTEST
	}
}