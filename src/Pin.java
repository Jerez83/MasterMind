import org.fusesource.jansi.Ansi;

public class Pin {

    private TipoColorPin color;           // NO NULO, NO MODIFICABLE

    public Pin(TipoColorPin color) {
        this.color = color;
    }


    public TipoColorPin getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color==TipoColorPin.NEGRO? Ansi.ansi().fg(Ansi.Color.BLACK).a("\u25CF ").reset().toString()
                : color==TipoColorPin.BLANCO ? Ansi.ansi().fg(Ansi.Color.WHITE).a("\u25CF ").reset().toString()
                : "Color desconocido";

    }
}
