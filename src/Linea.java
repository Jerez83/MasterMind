public class Linea {

    private CombinacionLinea combinacionLinea;         // NO NULO, <<R>>
    private CombinacionPin combinacionPin;             // NO NULO, <<R>>

    public Linea() {
        setCombinacionPin(new CombinacionPin());
        setCombinacionLinea(new CombinacionLinea());
    }

    public void setCombinacionPin(CombinacionPin combinacionPin) {
        assert combinacionPin != null : "Error: la combinacionPin recibida no puede ser nulo";
        this.combinacionPin = combinacionPin;
    }

    public void setCombinacionLinea(CombinacionLinea combinacionLinea) {
        assert combinacionLinea != null : "Error: la combinacionLinea recibida no puede ser nulo";
        this.combinacionLinea = combinacionLinea;
    }

    /*public void agregarLinea(Linea linea) {

        for (int i = 0; i < lineas.length ; i++) {

            if (lineas[i]== null)
                lineas[i]= linea;

        }
    }*/


    @Override
    public String toString() {
        String res = "";
        res+= combinacionLinea+"][ "+ combinacionPin;
        return res;
    }
}
