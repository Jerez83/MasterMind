import org.fusesource.jansi.Ansi;

import java.util.Objects;

public class Ficha {

    private TipoColorFicha color;        // NO NULO, NO MODIFICABLE

    public Ficha(TipoColorFicha color) {
        setColor(color);
    }

    private void setColor(TipoColorFicha color) {
        assert color != null: "Error: el color recicbido no puyede ser nulo";
        this.color = color;
    }

    public TipoColorFicha getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha = (Ficha) o;
        return color == ficha.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return color==TipoColorFicha.AZUL ? Ansi.ansi().fg(Ansi.Color.BLUE).a("\u25CF ").reset().toString()
                : color==TipoColorFicha.VERDE ? Ansi.ansi().fg(Ansi.Color.GREEN).a("\u25CF ").reset().toString()
                : color==TipoColorFicha.ROJO ? Ansi.ansi().fg(Ansi.Color.RED).a("\u25CF ").reset().toString()
                : color==TipoColorFicha.AMARILLO ? Ansi.ansi().fg(Ansi.Color.YELLOW).a("\u25CF ").reset().toString()
                : "Color desconocido";

    }
}
