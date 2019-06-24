import java.util.Arrays;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class CombinacionPin {

    private Pin[] pines;

    public CombinacionPin() {
        this.pines = new Pin[4];
    }

    /*public void agregarPin(Pin p) {
        assert p != null : "Error: el pin recibido no puede ser nulo";

        for (int i = 0; i < pines.length; i++) {
            if (pines[i] == null) {
                pines[i] = p;
                break;
            }
        }
    }*/

    public void colocar(Pin p, int posicion) {
        assert p!= null : "Error: el pin recibido no puede ser nulo";

        pines[posicion]= p;
    }

    public Pin[] getPines() {
        return pines;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < pines.length; i++) {

            res += (pines[i]==null ? "\u25cb ": pines[i].toString());

        }
        res+= "\u2502";
        return res;
    }
}
