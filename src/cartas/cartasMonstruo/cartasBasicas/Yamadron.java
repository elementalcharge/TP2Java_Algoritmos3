package cartas.cartasMonstruo.cartasBasicas;

import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.Nivel;
import estadosDeCartas.Modo;
import jugador.Punto;

public class Yamadron extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Yamadron() {
        super("Yamadron", 1600, 1800, 5);
        modo = null;
    }
}