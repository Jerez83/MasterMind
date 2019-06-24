public class Jugador {

    private String alias;                               // NO NULO, NO VACIO, NO MODIFICABLE



    public Jugador(String alias) {
        setAlias(alias);
    }

    private void setAlias(String alias) {
        assert alias != null : "Error: el alias recibido no puede ser nulo";
        assert !alias.isEmpty() : "Error: el alias no puede estar vacio";
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return alias;
    }
}
