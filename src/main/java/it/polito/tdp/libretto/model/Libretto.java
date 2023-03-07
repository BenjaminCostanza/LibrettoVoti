package it.polito.tdp.libretto.model;
import java.util.*;

public class Libretto {
	private List<Voto> listaVoti;

	public Libretto() {
	  listaVoti = new ArrayList<Voto>();
	}
	/**
	 * Aggiunge un nuovo voto al libretto
	 * @param v Il nuovo voto da aggiungere al libretto
	 * @return true
	 */
	public boolean add(Voto v) { //Meno dipendenze fra le varie classi meglio è
		return listaVoti.add(v); //Richima add a livello di proprietà interna, si tratta di una delega
	}
	public void stampa() {
		for(Voto v : listaVoti) {
			System.out.println(v);
		}
	}
	
	public void stampaPuntiUguali(int valore) { //Quando si vedono costanti nel codice bisogna ragionare perchè probabilmente si può generalizzare
		for(Voto v : listaVoti) {
			if(v.getVotoOttenuto() == valore){
				System.out.println(v);
			}
		}
	}
	
	public Voto cercaVotoPerNome(String corso) {
		for(Voto v : listaVoti) {
			if(v.nomeCorso.compareTo(corso)==0) { //Si può usare anche equals, preferibile nel caso in cui non sia possibile ordinamento
				return v;  //Per le stringhe non vi è differenza
			}
		}
		return null; //Si preferisce il null rispetto al lancio di un'eccezione 
	}
	
	public boolean esisteVoto(Voto nuovo) {
		for(Voto v : listaVoti) { //Il metodo equals non sarebbe adatto perchè va a confrontare le istanze
			if(v.getNomeCorso().equals(nuovo.nomeCorso) && v.getVotoOttenuto() == nuovo.getVotoOttenuto()) {
				return true;
			}
		}
		return false;
	}
}
