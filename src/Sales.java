import java.util.ArrayList;


public class Sales {

	private static ArrayList<Sala> sales;



	//CONSTRUCTORS
	public Sales() {
		this.sales = new ArrayList<Sala>();
	}

	//Constructor 1
	//*********************************************************
	public Sales(ArrayList<Sala> sales) {
		this.sales = sales;
	}


	//*********************************************************
	//afegir SALA
	public static void afegirSala(Sala s){
		sales.add(s);
	}

	//*********************************************************
	//Llista les SALES
	public static void llistarSales(){
		if (quantitatSales()==0) 
			System.out.println("\n\t No hi ha cap SALA registrada");
		else {
			System.out.println("\n******** SALES *******");
			for(int i=1; i<=quantitatSales();i++){
				System.out.println("\n\t "+i+"-> "+sales.get(i-1).toString());
				System.out.println("\t---");
			}
			System.out.println();
		}

	}

	//*********************************************************
	//Verifica si el identificador de SALA existeix al Llistat
	//Retorna TRUE: Sala NO existeix
	//Retorna FALSE: Sala ja existeix
	public static  boolean validaIdSala(int s){
		boolean resultat = true;
		for(int i=0; i<quantitatSales();i++){
			if (sales.get(i).getNumeroSala()==s) return false;
		}
		return resultat;
	}

	//*********************************************************
	//Retorna la SALA de la posicio i
	public static  Sala retornaSala(int i){
		if (i <= quantitatSales())
			return sales.get(i-1);
		else {
			System.out.println("ERROR Sales.retornaSala: valor proporcionat fora de rang");
			return null;
		}

	}

	//*********************************************************
	//Modifica la SALA de la posicio i
	public static  void modificaSala(int i){
		if (i <= quantitatSales())
			sales.get(i-1).modificaSala();
		else {
			System.out.println("ERROR Sales.modificaSala: valor proporcionat fora de rang");
		}
	}

	//*********************************************************
	//Esborra la SALA de la posicio i
	public static void esborraSala(int i){
		if (i <= quantitatSales()){
			sales.get(i-1).esborraSala();
			sales.remove(i-1);
		}else {
			System.out.println("ERROR Sales.modificaSala: valor proporcionat fora de rang");
		}
	}

	//*********************************************************
	//Retorna la QUANTITAT de les SALES 
	public static int quantitatSales(){
		return sales.size();
	}

	//GETTERS & SETTERS
	//*********************************************************
	public  ArrayList<Sala> getSales() {
		return sales;
	}

	public  void setSales(ArrayList<Sala> sales) {
		this.sales = sales;
	}

}
