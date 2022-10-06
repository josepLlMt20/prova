/**
 * Classe de partida per la Practica 1 de PROGRAMACIO curs 2022-23
 * @author Professores PR
 *
 */

public class Album {

	private String nom;
	private final int cmAlt;
	private final int cmAmple;
	private int numTotalPagines;
	private int numFotosPagina;
	private int numPagPlenes;
	private int numFotosUltimaPag;
	private boolean albumPle;

	/**
	 * Constructor Album de Fotos
	 * @param nom  identificador de l'album
 	 * @param alt  mesura de alt, en centimetres
	 * @param ample  mesura de ample, en centimetres
	 * @param nPagines   nombre total de pagines
	 * @param nFotosPag  nombre de fotos per plana
	 */
	public Album (String nom, int alt, int ample, int nPagines, int nFotosPag) {
		this.nom=nom; cmAlt=alt; cmAmple=ample;
		numTotalPagines=nPagines;
		numFotosPagina=nFotosPag;
		numPagPlenes=0;
		numFotosUltimaPag=0;
		albumPle =  false;
	}
	
	
	// Getters
	
	public String getNom() {
		return nom;
	}



	public int getCmAlt() {
		return cmAlt;
	}


	public int getCmAmple() {
		return cmAmple;
	}


	public int getNumTotalPagines() {
		return numTotalPagines;
	}


	public int getNumFotosPagina() {
		return numFotosPagina;
	}

	public int getNumPaginesPlenes() {
		return numPagPlenes;
	}

	public boolean isAlbumPle() {
		return albumPle;
	}
	
	/**
	 * Getter que ens calcula quantes fotografies hi ha posades a l'album
	 * @return    nombre de fotos a l'album
	 */
	public int getNumTotalFotosPosades() {
		return (numFotosPagina * numPagPlenes) + numFotosUltimaPag;
	}
	
	/**
	 * Metode per afegir una fotografia nova a l'album.
	 * S'assumeix que les fotos es van guardant en ordre consecutiu quan s'afegeixen
	 * per tant, sempre va al final de la darrera pagina.
	 * 
	 */
	public void afegirFoto () {
		if (!albumPle) {
			numFotosUltimaPag++;
			if (numFotosUltimaPag == numFotosPagina) {
				numPagPlenes++;
				numFotosUltimaPag=0;
			}
			if (numPagPlenes==numTotalPagines)
				albumPle =  true;
		}
	}
	
	
	/**
	 * Afegir unes quantes pagines mes a l'album
	 * @param n   indica el nombre de pagines a afegir
	 */
	public void afegirPagines (int n) {
		numTotalPagines= numTotalPagines+n;
		albumPle =  false;
	}
	
	/**
	 * Treure pagines de l'album, excepte si ja contenen fotos
	 * @param n    indica el nombre de pagines a eliminar 
	 *             nom�s s'eliminen si estan totalment buides
	 */
	public void treurePagines (int n) {
		if (numTotalPagines-n >= numPagPlenes) {
			numTotalPagines = numTotalPagines-n;
			if ((numTotalPagines==numPagPlenes)) {
				albumPle=true;
			}
		}
	}


	/**
	 * Retorna el contingut de l'objecte en format cadena
	 * @return cadena amb l'estat de l'objecte
	 */
	public String toString() {
		return "Album [nom=" + nom + ", cmAlt=" + cmAlt + ", cmAmple=" + cmAmple + ", numTotalPagines="
				+ numTotalPagines + ", numFotosPagina=" + numFotosPagina + ", numPagPlenes=" + numPagPlenes
				+ ", numFotosUltimaPag=" + numFotosUltimaPag + "]";
	}
	
	/**
	 * Crea un duplicat d'una instancia
	 * @return una instancia duplicada
	 */
	public Album copia() {
		Album duplicat = new Album(nom, cmAlt, cmAmple, numTotalPagines, numFotosPagina);
		return duplicat;
	}
}
