package tablero;
import jugador.Mazo;
import cartas.Carta;

public class LadoDelCampo {
	private Cementerio miCementerio;
	private Mazo miMazo;
	private ZonaCampo miZonaCampo;
	private ZonaTrampaMagica miZonaDeTrampasYMagia;
	private ZonaMonstruo miZonaMonstruo;
	
	@Override
	public boolean equals(Object object){return this.getClass().equals(object.getClass());}

	public LadoDelCampo () {
		miCementerio = new Cementerio();
		miMazo = new Mazo();
		miZonaCampo = new ZonaCampo();
		miZonaDeTrampasYMagia = new ZonaTrampaMagica();
		miZonaMonstruo = new ZonaMonstruo();
	}

	public Cementerio mostrarCementerio() {
		return miCementerio;
	}

	public boolean colocarZonaTrampaMagica (Carta unaCarta) {
		return miZonaDeTrampasYMagia.colocarCarta(unaCarta);
	}

	public boolean colocarZonaMonstruo (Carta unaCarta) {
		return miZonaMonstruo.colocarCarta(unaCarta);
	}

	public void colocarCementerio(Carta unaCarta) { //Falta borrar la carta de la zona correspondiente
		miCementerio.colocarCarta(unaCarta);
	}
}