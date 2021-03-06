package modelo.cartas;
import modelo.estadosDeCartas.BocaAbajo;
import modelo.estadosDeCartas.BocaArriba;
import modelo.estadosDeCartas.Estado;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public abstract class Carta {
    protected String descripcionEfecto;
    protected String nombre;
    private Estado estado;
    
    
    public Carta(String unNombre) {

        this.nombre = unNombre;
        this.estado = null;
    }

    public void colocarBocaArriba() throws VictoriaException {
        this.estado = new BocaArriba();
        this.activarEfecto();
    }

    public abstract void activarEfecto() throws VictoriaException;

    public void colocarBocaAbajo() {
    	this.estado = new BocaAbajo();
	}

	public Estado getEstado() {
		return estado;
	}

    public String getNombre(){
        return nombre;
    }

    public String obtenerEfecto(){
        return descripcionEfecto;
    }

    public void asignarJugador(Jugador jugador) {
        //normalmente una carta no necesita saberlo pero puede que necesiten hacerle un overload en caso de que sea necesario
    }

    public void asignarTablero(Tablero tablero) {
        //normalmente una carta no necesita saberlo pero puede que necesiten hacerle un overload en caso de que sea necesario
    }
}
