import java.util.Arrays;

public class CombinacionSecreta {

    private Ficha[] fichas;                                          //  <<R>>
    private TipoColorFicha[] colores ;                               // <<R>>

    public CombinacionSecreta() {

        this.fichas = new Ficha[4];
        colores = TipoColorFicha.values();
        crearFichas();
        desordenar();
    }

    private void crearFichas() {

        for (int i = 0; i <fichas.length ; i++) {

            fichas[i] = new Ficha(colores[i]);
        }
    }

    private void desordenar() {

        for (int i = 0; i < 10 ; i++) {

            intercambiar();
        }
    }

    private void intercambiar() {

        int aleatorio = (int)(Math.random()*(fichas.length-1));

        Ficha aux =fichas[aleatorio];
        fichas[aleatorio]=fichas[aleatorio+1];
        fichas[aleatorio+1]=aux;
    }

    public Ficha[] getFichas() {
        return fichas;
    }



    @Override
    public String toString() {
        String res = "";

        for (int i = 0; i < fichas.length; i++) {
            res+= fichas[i].toString();
        }
        return res;
    }
}
