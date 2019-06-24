import java.util.Arrays;

public class Tablero {

    private CombinacionSecreta secreta;                                           // <<R>>
    private Linea[] lineas;                                                       // <<R>>

    public Tablero(CombinacionSecreta secreta, int intentos) {
        this.secreta = secreta;
        lineas = new Linea[intentos];
        inicializarLineas();
    }

    private void inicializarLineas() {

        for (int i = 0; i <lineas.length; i++) {
            lineas[i]= new Linea();
        }
    }

    public Linea[] getLineas() {
        return lineas;
    }

    @Override
    public String toString() {
        String res= "\u250c \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                "\u2500\u2500\u2500\u2500 \u2510 \n";

        for (int i = 0; i < lineas.length; i++) {
            res+= lineas[i]+"\n";
        }
        res+= "\u2502     \u24ff \u24ff \u24ff \u24ff     \u2502\n";
        res+= "\u2514 \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                "\u2500\u2500\u2500\u2500 \u2518";
        return res;
    }

    public String mostrarSecreta() {
        String res= "\u250c \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                "\u2500\u2500\u2500\u2500\u2510\n";

        for (int i = 0; i < lineas.length; i++) {
            res+= lineas[i]+"\n";
        }
        res+= "\u2502       "+secreta+"     \u2502\n";
        res+= "\u2514 \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                "\u2500\u2500\u2500\u2500 \u2518";

        return res;
    }


}
