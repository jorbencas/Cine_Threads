import java.util.ArrayList;


public class Sales {

	private static ArrayList<Sala> sales;



	//CONSTRUCTORS
	public Sales() {
		 Sales.sales = new ArrayList<>();
	}

	//*********************************************************
	public Sales(ArrayList<Sala> sales) {
		 Sales.sales = sales;
	}
	//*********************************************************


	//METODES
	public static void afegirSala(Sala s){
		if (!Sales.validaIdSala(s.getNumeroSala())) {
            Sales.sales.add(s);
            System.out.println("Añadido exitosamente");
        } else {
            System.out.println("Ya existe... No se puede añadir la misma sala");
}
	}

	//*********************************************************
	//MOSTRA EL LLISTAT DE SALES
	public static void llistarSales(){
		 for (int i = 0; i < Sales.sales.size(); i++) {
	            System.out.println("[" + (i + 1 ) + "]" + Sales.sales.get(i).toString());
		 }

	}

	//*********************************************************
	//VERIFICA SI EL NUM DE SALA EXISTEIX AL LLISTAT
	public static  boolean validaIdSala(int s){
		 for (int i = 0; i < Sales.sales.size(); i++) {
	            if (Sales.sales.get(i).getNumeroSala() == (s - 1)) {
	                return true;
	            }
	        }
	return false;
	}

	//*********************************************************
	//RETORNA LA SALA DE LA POSICIO i
	public static Sala retornaSala(int i){
		 return Sales.sales.get(i);
	}

	//*********************************************************
	//MODIFICA LA SALA DE LA POSICIO i
	public static  void modificaSala(Sala s, int i){
		 Sales.sales.set(i, s);
	}

	//*********************************************************
	//ESBORRA LA SALA DE LA POSICIO i
	public static void esborraSala(int s){
		sales.get((s -1)).esborraSala(s);
		sales.remove((s -1 ));
	}

	//*********************************************************
	//RETORNA LA QUANTITAT DE SALES 
	public static int quantitatSales(){
		 return Sales.sales.size();
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
