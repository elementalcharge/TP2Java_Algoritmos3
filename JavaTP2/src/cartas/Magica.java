package cartas;
import efectos.Efecto;

public abstract class Magica extends Carta {
    protected Efecto efecto;

    public Magica(String unNombre) {
        super(unNombre);
    }
}