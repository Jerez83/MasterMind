import org.fusesource.jansi.Ansi;

import java.util.Arrays;

public class CombinacionLinea {

    private Ficha[] fichas ;                           //<<R>>

    public CombinacionLinea() {

       fichas = new Ficha[4];

    }

    public void colocar(Ficha f , int posicion) {
        assert f != null : "Error: el pin recibido no puede ser nulo";

        fichas[posicion]= f;
    }

    public Ficha[] getFichas() {
        return fichas;
    }


    @Override
    public String toString() {
        String res = "";
        res+="\u2502 ";
        for (int i = 0; i < fichas.length; i++) {
            res += (fichas[i]==null ? "\u25cb " : fichas[i].toString());

        }

        return res;
    }
}
