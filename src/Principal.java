import javax.sound.sampled.Line;
import java.util.Stack;

public class Principal {



    public static void main(String[] args) {


        Jugador[] jugadores = {new Jugador("PEPE"), new Jugador("JOSE")};


        Partida p1 = new Partida(jugadores,10);
        p1.jugar();
    }

}
