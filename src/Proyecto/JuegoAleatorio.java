package Proyecto;

import Proyecto.Abstractas.JuegoAbstracto;

import java.util.Random;
import java.util.Scanner;

public class JuegoAleatorio extends JuegoAbstracto {
    private int numeroAdivinar;
    private boolean terminado;

    private Jugador[] jugadores;

    public JuegoAleatorio(Jugador[] jugadores){
        this.jugadores = jugadores;

    }

    @Override
    protected void Start() {
        this.terminado = false;
        establecerJugadores();
        seleccionarPrimerJugador();
        establecerNumero();
    }

    @Override
    protected void IniciarProgramaNraya() {
        while (!terminado) {
            introducirNumero();
            mostrarResultado();
            turno();
        }

    }

    protected void establecerJugadores() {
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1));
            String auxJugadores;
            auxJugadores = sc.nextLine();
            jugadores[i] = new Jugador(auxJugadores);

        }
        System.out.println(" ");
        System.out.println("Los jugadores que os vais a enfrentar sois");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getNombre());
        }
    }

    protected void turno() { // alternar el turno entre jugadores para ver, a quien le toca.
        if (jugadores[0].getTurno()) {
            jugadores[0].setTurno(false); // lo tiene desactivado el 0
            jugadores[1].setTurno(true);// lo tiene activo el 1

        } else {
            jugadores[0].setTurno(true); // lo tiene activo el 0
            jugadores[1].setTurno(false); // lo tiene desactivado el 1
        }
    }

    protected void seleccionarPrimerJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("El jugador 1 es : " + jugadores[0].getNombre());
        System.out.println("El jugador 2 es : " + jugadores[1].getNombre());
        System.out.println("¿Qué jugador queréis que empiece?");
        System.out.println("1. " + jugadores[0].getNombre());
        System.out.println("2. " + jugadores[1].getNombre());

        int opcion = sc.nextInt();

        while (opcion < 1 || opcion > 2) {
            System.out.println("Elige un jugador válido.");
            opcion = sc.nextInt();
        }

        switch (opcion) {
            case 1:
                System.out.println(jugadores[0].getNombre() + " empieza primero.");
                jugadores[0].setTurno(true);
                break;
            case 2:
                System.out.println(jugadores[1].getNombre() + " empieza primero.");
                jugadores[1].setTurno(true);
                break;
        }
    }

    protected void establecerNumero() {
        Random random = new Random();
        this.numeroAdivinar = random.nextInt(100) + 1;

    }

    protected void introducirNumero() {
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println(getJugadorActual() + ", es tu turno.");
        System.out.println("Introduce un número:");
        numero = sc.nextInt();
        verificarNumero(numero);
    }

    protected void verificarNumero(int numero) {

        if (numero > numeroAdivinar) {
            System.out.println("El número a adivinar es más pequeño");
        } else if (numero < numeroAdivinar) {
            System.out.println("El número a adivinar es más grande");
        } else {
            this.terminado = true;
        }
    }

    protected void mostrarResultado() {
        if (terminado) {
            System.out.println("Enhorabuena el ganador es " + getJugadorActual());
        }
    }

    protected Jugador getJugadorActual() {
        if (jugadores[0].getTurno()) {
            return jugadores[0];
        } else {
            return jugadores[1];
        }
    }

    @Override
    public void Start(Jugador[] jugadores) {

    }

    @Override
    public Tablerito crearTablero() {
        return null;
    }

    @Override
    public void imprimirTablero(Tablerito tablero) {

    }

    @Override
    public void Jugar(Tablerito tablerito, Jugador[] jugadores) {

    }

    @Override
    public void introducirFicha(Jugador jugador, Tablerito tablerito) {

    }

    @Override
    public boolean comprobarGanador(String[][] tablero, Jugador jugador) {
        return false;
    }

    @Override
    public boolean comprobarHorizontal(String[][] tablero, Jugador jugador) {
        return false;
    }

    @Override
    public boolean comprobarVertical(String[][] tablero, Jugador jugador) {
        return false;
    }

    @Override
    public boolean comprobarDiagonal(String[][] tablero, Jugador jugador) {
        return false;
    }

    @Override
    public boolean comprobarDiagonalInversa(String[][] tablero, Jugador jugador) {
        return false;
    }
}



