package tablero;
import java.util.HashMap;
import cartas.Carta;
import cartas.CartaMonstruo;
import jugador.Jugador;
import jugador.Punto;


public class Tablero {
    private HashMap<Jugador, LadoDelCampo> divisiones;

	public Tablero(Jugador jugador1, Jugador jugador2) {
		
		divisiones = new HashMap<Jugador, LadoDelCampo>();
		divisiones.put(jugador1, new LadoDelCampo());
		divisiones.put(jugador2, new LadoDelCampo());
	}

	public LadoDelCampo get(Jugador jugador1) {
		return divisiones.get(jugador1);
	}

	public Cementerio mostrarCementerio(Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		return ladoDelCampo.mostrarCementerio();
	}
	public boolean colocarZonaTrampaMagica(Carta unaCarta, Jugador jugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaTrampaMagica(unaCarta);
	}

	public boolean colocarZonaMonstruo(Carta unaCarta, Jugador jugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaMonstruo(unaCarta);
	}

	public void colocarCementerio(Carta unaCarta, Jugador jugador) { //zona como lugar del que vienen
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		ladoDelCampo.colocarCementerio(unaCarta);
	}


	public void atacarDosMonstruos(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo cartaDefensora,
								   Jugador jugadorDefensor) {

	    CartaMonstruo cartaGanadora = cartaAtacante.atacar(cartaDefensora);
		Jugador jugadorPerdedor;
		CartaMonstruo cartaPerdedora;
		if (cartaGanadora == cartaDefensora) {
			jugadorPerdedor = jugadorAtacante;
			cartaPerdedora = cartaAtacante;
		}
		else {
			jugadorPerdedor = jugadorDefensor;
			cartaPerdedora = cartaDefensora;
		}
		colocarCementerio(cartaPerdedora, jugadorPerdedor);
		Punto puntosGanadores = cartaGanadora.obtenerPuntosAtaque();
		Punto puntosPerdedores = cartaPerdedora.obtenerPuntosAtaque();
		Punto diferenciaPuntos = puntosGanadores.restar(puntosPerdedores);
		jugadorPerdedor.restarPuntos(diferenciaPuntos);
	}
}