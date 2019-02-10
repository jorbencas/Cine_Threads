import java.util.ArrayList;

public class FilCompraEntradesNoInteractiva implements Runnable {
	
	int nPelicula;
	int nSessio;
	ArrayList <Seient> llistaSeients;

	public FilCompraEntradesNoInteractiva(int nPelicula, int nSessio, ArrayList <Seient> llistaSeients) {
		this.nPelicula = nPelicula;
		this.nSessio = nSessio;
		this.llistaSeients = llistaSeients;
	}

	// ----------
	public void run() {

		compraEntradesNoInteractiva(nPelicula, nSessio, llistaSeients);

	}

	// --------------------- //COMPRA D'ENTRADES SENSE INTERACCIO AMB USUARI
	public void compraEntradesNoInteractiva(int nPelicula, int nSessio, ArrayList <Seient> llistaSeients) {

		if (Pelicules.quantitatPelicules() > 0) {
			if (Pelicules.retornaPelicula(nPelicula).getSessionsPeli().size() > 0) {
				Pelicula p = Pelicules.retornaPelicula(nPelicula);
				Sessio se = p.getSessionsPeli().get(nSessio-1);
				Sala sa = se.getSala();
				se.mapaSessio();
				try {
					Cine.reserva_numEntradesNoInteractiva(p, se, sa, llistaSeients);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				se.mapaSessio();
				
			}// if
		}// if
	}

	



}// class