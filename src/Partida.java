import java.util.Scanner;

public class Partida {

    private static int MININTENTOS = 10;
    private static int MAXINTENTOS = 20;
    private Jugador[] jugadores;               // NO NULO, <<R>>
    private int turno;                         // [0-1]
    private Tablero tablero;                   // NO NULO, <<R>>
    private CombinacionSecreta secreta;        // NO NULO, <<R>>
    private int intentos;
    private int intento;
    private boolean tablas;

    public Partida(Jugador[] jugadores, int intentos) {
        this.jugadores = jugadores;
        setIntentos(intentos);
        inicializarJugadores();
        secreta = generarCombinacionSecreta();
        tablero = new Tablero(secreta, this.intentos);
        setTurno(0);
        intento = intentos - 1;
        tablas = false;

    }

    private void inicializarJugadores() {
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador(jugadores[i].getAlias());
        }
    }

    private void setIntentos(int intentos) {
        assert intentos >= MININTENTOS && intentos <= MAXINTENTOS :
                String.format("Error: el rango de intentos esta entre [%d-%d]", MININTENTOS, MAXINTENTOS);
        this.intentos = intentos;
    }

    public void jugar() {

        System.out.println(tablero);
        CombinacionPin p1;

        do {
            System.out.println("ES EL TURNO DE "+jugadores[turno]);
            CombinacionLinea c1 = leerCombinacionLinea();
            p1 = asignacionPines(c1);

            tablero.getLineas()[intento].setCombinacionLinea(c1);
            tablero.getLineas()[intento].setCombinacionPin(p1);

            System.out.println(tablero);
            cambiarTurno();
            --intento;

        } while (!esFinJuego(p1));

        if (tablas) {
            System.out.println("OHHH, LA PARTIDA HA TERMINADO EN TABLAS");
            System.out.println(tablero.mostrarSecreta());
        } else{
            cambiarTurno();
            System.out.println(tablero.mostrarSecreta());
            System.out.println("BRAVO, HAS GANADO "+jugadores[turno].getAlias());
        }


    }

    private CombinacionSecreta generarCombinacionSecreta() {
        return new CombinacionSecreta();
    }

    private void setTurno(int turno) {
        assert turno == 0 || turno == 1 : String.format("Error: el turno (%d) debe ser 0 o 1", turno);
        this.turno = turno;
    }

    private void cambiarTurno() {
        setTurno(turno == 0 ? 1 : 0);
    }

    private boolean esFinJuego(CombinacionPin combiPin) {

        if (intento == -1) {
            tablas=true;
            return true;
        }

        for (int i = 0; i < 4 ; i++) {

            if (combiPin.getPines()[i].getColor()==null || combiPin.getPines()[i].getColor() != TipoColorPin.NEGRO)
                return false;
        }

        return true;
    }

    private CombinacionLinea leerCombinacionLinea() {

        CombinacionLinea c1 = new CombinacionLinea();
        Scanner sc = new Scanner(System.in);
        String colores;
        do {

            System.out.println("1) ROJO, 2) VERDE, 3) AMARILLO, 4) AZUL  *) AZUL");

            System.out.print("Introduzca la combinacion de colores(1234): ");
            colores = sc.next();
        } while (colores.length() < 4);

        String f1 = colores.substring(0, 1);
        String f2 = colores.substring(1, 2);
        String f3 = colores.substring(2, 3);
        String f4 = colores.substring(3, 4);
        c1.colocar(new Ficha(casos(f1)), 0);
        c1.colocar(new Ficha(casos(f2)), 1);
        c1.colocar(new Ficha(casos(f3)), 2);
        c1.colocar(new Ficha(casos(f4)), 3);

        return c1;
    }

    /*
    private boolean esColor(String numero) {
        String primero = numero.substring(0, 1);
        String segundo = numero.substring(1, 2);
        String tercero = numero.substring(2, 3);
        String cuarto = numero.substring(3, 4);

        if (!primero.equals("1") || !primero.equals("2") || !primero.equals("3") || !primero.equals("4"))
            return true;
        else if (!segundo.equals("1") || !segundo.equals("2") || !segundo.equals("3") || !segundo.equals("4"))
            return true;
        else if (!tercero.equals("1") || !tercero.equals("2") || !tercero.equals("3") || !tercero.equals("4"))
            return true;
        else if (!cuarto.equals("1") || !cuarto.equals("2") || !cuarto.equals("3") || !cuarto.equals("4"))
            return true;
        return false;
    }*/

    private TipoColorFicha casos(String ficha) {
        TipoColorFicha aux;

        switch (ficha.toUpperCase()) {
            case "1":
                aux = TipoColorFicha.ROJO;
                break;
            case "2":
                aux = TipoColorFicha.VERDE;
                break;
            case "3":
                aux = TipoColorFicha.AMARILLO;
                break;
            case "4":
                aux = TipoColorFicha.AZUL;
                break;
            default:
                aux = TipoColorFicha.AZUL;
        }
        return aux;
    }

    private CombinacionPin asignacionPines(CombinacionLinea combiLin) {

        CombinacionPin combiPin = new CombinacionPin();

        for (int i = 0; i < 4 ; i++) {
            if (secreta.getFichas()[i].getColor().equals(combiLin.getFichas()[i].getColor()) )
                combiPin.colocar(new Pin(TipoColorPin.NEGRO),i);
            else
                for (int j = 0; j < 4; j++) {

                    if(combiLin.getFichas()[0].getColor().equals(secreta.getFichas()[j].getColor()))
                        combiPin.colocar(new Pin(TipoColorPin.BLANCO),i);
                }

        }

        return combiPin;

    }
}
