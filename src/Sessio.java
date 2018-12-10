import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Sessio {

    private String nomSessio;
    private Calendar data = Calendar.getInstance();
    private Sala sala;
    private Seient[][] seients;
    private BigDecimal preu;

    //*********************************************************
    //CONSTRUCTOR1
    public Sessio(String nomSessio, Calendar data, Sala sala, BigDecimal preu) {
        this.nomSessio = nomSessio;
        this.data = data;
        this.sala = sala;
        this.preu = preu;
    }

    //*********************************************************
    //CONSTRUCTOR2
    public Sessio(String nomSessio, int dia, int mes, int any, int hora, int minuts, Sala sala, BigDecimal preu) {
        this.nomSessio = nomSessio;
        this.data.set(any, mes, dia, hora, minuts);
        this.sala = sala;
        this.preu = preu;
    }

    //*********************************************************
    //CONSTRUCTOR INTERACTIU
    public Sessio() {

    }

    //*********************************************************
    //MODIFICA DADES DE LA SESSIO
    public void modificaSessio() {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    //*********************************************************
    //ESBORRA LA SESSIO
    public void esborraSessio() {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    //*********************************************************
    //ASIGNA DISTRIBUCIO DE SEIENTS A LA SALA
    public void setMapaSessio() {
        for (int i = 0; i < this.seients.length; i++) {
            for (int j = 0; j < this.seients[0].length; j++) {
                this.seients[i][j] = new Seient();
                this.seients[i][j].setFilaSeient(i);
                this.seients[i][j].setNumeroSeient(j);

                //System.out.print(this.seients[i][j].iconaSeient() + " ");
            }

        }
    }

    //*********************************************************
    //MOSTRA DISTRIBUCIO DE SEIENTS A LA SALA
    public void mapaSessio() {
        System.out.println("Mapa de la session " + this.getNomSessio());
        for (int i = 0; i < this.seients.length; i++) {
            for (int j = 0; j < this.seients[0].length; j++) {
                System.out.print(this.seients[i][j].iconaSeient() + " ");
            }
            System.out.println("");
        }
    }

    //*********************************************************
    //MOSTRA DATA EN FORMAT ESPANYOL
    public void mostraDataFormatada() {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    //*********************************************************
    //MOSTRA TICKET DE COMPRA DE LA PELICULA
    public void imprimirTicket(Seient s, Sessio se, Sala sa, Pelicula p) {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...

    }

    //*********************************************************
    //Metode TOSTRING
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
        return "Sessio [nomSessio=" + nomSessio + "\t data=" + sdf.format(data.getTime()) + "\t sala=" + sala + "\t preu=" + preu + "]";
    }

    //GETTERS & SETTERS
    public String getNomSessio() {
        return nomSessio;
    }

    public void setNomSessio(String nomSessio) {
        this.nomSessio = nomSessio;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public BigDecimal getPreu() {
        return preu;
    }

    public void setPreu(BigDecimal preu) {
        this.preu = preu;
    }

    public Seient[][] getSeients() {
        return seients;
    }

    public void setSeients(Seient[][] seients) {
        this.seients = seients;
    }

}
