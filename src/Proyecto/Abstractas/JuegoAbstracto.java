package Proyecto.Abstractas;

import Proyecto.Jugador;
import Proyecto.Tablerito;

import javax.xml.stream.events.StartDocument;

public abstract class JuegoAbstracto {
    private boolean terminado = false;


    public abstract void Start(Jugador[] jugadores);
    public abstract Tablerito crearTablero();
    public abstract void imprimirTablero(Tablerito tablero);
    public abstract void Jugar(Tablerito tablerito, Jugador[] jugadores);
    public abstract void introducirFicha(Jugador jugador, Tablerito tablerito);
    public abstract boolean comprobarGanador(String[][] tablero, Jugador jugador);
    public abstract boolean comprobarHorizontal(String[][] tablero, Jugador jugador);
    public abstract boolean comprobarVertical(String[][] tablero, Jugador jugador);
    public abstract boolean comprobarDiagonal(String[][] tablero, Jugador jugador);
    public abstract boolean comprobarDiagonalInversa(String[][] tablero, Jugador jugador);
    protected abstract void Start();
    protected abstract void IniciarProgramaNraya();
}
