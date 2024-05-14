package Proyecto;


import Proyecto.Abstractas.JuegoAbstracto;

import java.util.Scanner;

public class Juego extends JuegoAbstracto {

    private boolean terminado = false;
    private Scanner sc = new Scanner(System.in);

    private ConfigurarJuego configuracion;

    public Juego(ConfigurarJuego configuracion) {
        this.configuracion = configuracion;
    }


    @Override
    public void Start(Jugador[] jugadores) {

        Tablerito tablero = crearTablero();
        imprimirTablero(tablero);
        Jugar(tablero, jugadores);
    }

    @Override
    public Tablerito crearTablero() {
        System.out.println("Introduce el tamaño del tablero con el que quieres jugar: ");
        int fila = sc.nextInt();

        while (fila <= 2) {
            System.out.println("Introduce un tamaño de tablero posible, para que jueguen dos jugadores");
            fila = sc.nextInt();
        }

        return new Tablerito(fila);
    }

    @Override
    public void imprimirTablero(Tablerito tablero) {
        tablero.imprimirTablero();
    }

    @Override
    public void Jugar(Tablerito tablerito, Jugador[] jugadores) {
        int turno = 0;
        Jugador[] turnoJugadores = new Jugador[2];

        if (jugadores[0].getTurno()) {
            turnoJugadores[0] = jugadores[0];
            turnoJugadores[1] = jugadores[1];
        } else {
            turnoJugadores[0] = jugadores[1];
            turnoJugadores[1] = jugadores[0];
        }

        while (!terminado) {
            if (turno % 2 == 0) {
                System.out.println("Turno de " + turnoJugadores[0].getNombre());
                tablerito.imprimirTablero();
                introducirFicha(turnoJugadores[0], tablerito);
                tablerito.imprimirTablero();
                terminado = comprobarGanador(tablerito.getContenidoTablero(), turnoJugadores[0]);
                if (terminado) {
                    System.out.println("Ha ganado " + turnoJugadores[0]);
                    return;
                }

            } else {
                System.out.println("Turno de " + turnoJugadores[1].getNombre());
                tablerito.imprimirTablero();
                introducirFicha(turnoJugadores[1], tablerito);
                tablerito.imprimirTablero();
                terminado = comprobarGanador(tablerito.getContenidoTablero(), turnoJugadores[1]);
                if (terminado) {
                    System.out.println("Ha ganado " + turnoJugadores[1]);
                    return;
                }
            }
            turno++;
        }
    }

    @Override
    public void introducirFicha(Jugador jugador, Tablerito tablerito) {
        while (true) {
            System.out.println("Introduce una posición en la fila en la que quieres poner tu ficha");
            int fila = sc.nextInt();

            System.out.println("Introduce una posición en la columna en la que quieres poner tu ficha");
            int columna = sc.nextInt();

            if (tablerito.comprobarPoscioValida(fila, columna)) {
                tablerito.introducirFicha(fila, columna, jugador);
                return;
            }

            System.out.println("Posiciones no válidas, introducelas otra vez.");
        }
    }

    @Override
    public boolean comprobarGanador(String[][] tablero, Jugador jugador) {
        if (comprobarHorizontal(tablero, jugador)) {
            return true;
        } else if (comprobarVertical(tablero, jugador)) {
            return true;
        } else if (comprobarDiagonal(tablero, jugador)) {
            return true;
        } else if (comprobarDiagonalInversa(tablero, jugador)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean comprobarHorizontal(String[][] tablero, Jugador jugador) {
        boolean comprobar = false;
        for (int i = 0; i < tablero.length; i++) { // Este itera sobre la filas
            for (int j = 0; j < tablero[i].length - 1; j++) { // Este itera sobre las fila de esa columna
                String posicionActual = tablero[i][j];
                String posicionSiguiente = tablero[i][j + 1];
                if (!posicionActual.equals(posicionSiguiente) ||
                        posicionActual.equals("")) {
                    comprobar = false;
                    break;
                } else {
                    comprobar = true;
                }
                if (j == tablero.length - 2 && comprobar) {
                    return true;
                }
            }
        }
        return comprobar;
    }

    @Override
    public boolean comprobarVertical(String[][] tablero, Jugador jugador) {
        boolean comprobar = false;
        for (int i = 0; i < tablero.length; i++) { // Este itera sobre la filas
            for (int j = 0; j < tablero[i].length - 1; j++) { // Este itera sobre las fila de esa columna
                String posicionActual = tablero[j][i];
                String posicionSiguiente = tablero[j + 1][i];
                if (!posicionActual.equals(posicionSiguiente) ||
                        posicionActual.equals("")) {
                    comprobar = false;
                    break;
                } else {
                    comprobar = true;
                }
                if (j == tablero.length - 2 && comprobar) {
                    return true;
                }
            }
        }
        return comprobar;
    }

    @Override
    public boolean comprobarDiagonal(String[][] tablero, Jugador jugador) {
        boolean comprobar = false;

        for (int i = 0; i < tablero.length; i++) { // Este itera sobre la filas
            for (int j = 0; j < tablero[i].length - 1; j++) { // Este itera sobre las fila de esa columna
                String posicionActual = tablero[i][j];
                while (i < tablero.length - 1) {
                    String posicionSiguiente = tablero[i + 1][j + 1];
                    if (!posicionActual.equals(posicionSiguiente) ||
                            posicionActual.equals("")) {
                        comprobar = false;
                        break;
                    } else {
                        comprobar = true;
                    }
                    if (j == tablero.length - 2 && comprobar) {
                        return true;
                    }
                    i++;
                }
            }
        }
        // --- --- --- --- ---
        for (int i = 0; i < tablero.length; i++) { // Este itera sobre la filas
            for (int j = 0; j < tablero[i].length - 1; j++) { // Este itera sobre las fila de esa columna
                String posicionActual = tablero[j][i];
                while (i < tablero.length - 1) {
                    String posicionSiguiente = tablero[j + 1][i + 1];
                    if (!posicionActual.equals(posicionSiguiente) ||
                            posicionActual.equals("")) {
                        comprobar = false;
                        break;
                    } else {
                        comprobar = true;
                    }
                    if (j == tablero.length - 2 && comprobar) {
                        return true;
                    }
                    i++;
                }
            }
        }

        return comprobar;
    }

    @Override
    public boolean comprobarDiagonalInversa(String[][] tablero, Jugador jugador) {
        boolean comprobar = false;

        for (int i = 0; i < tablero.length; i++) { // Este itera sobre la filas
            for (int j = tablero[i].length - 1; j > 0; j--) { // Este itera sobre las fila de esa columna
                String posicionActual = tablero[i][j];
                while (i < tablero.length - 1 && j > 0) {
                    String posicionSiguiente = tablero[i + 1][j - 1];
                    if (!posicionActual.equals(posicionSiguiente) ||
                            posicionActual.equals("")) {
                        comprobar = false;
                        break;
                    } else {
                        comprobar = true;
                    }
                    if (j == tablero.length - 2 && comprobar) {
                        return true;
                    }
                    i++;
                    j--;
                }
            }
        }
        return comprobar;
    }

    @Override
    protected void Start() {

    }

    @Override
    protected void IniciarProgramaNraya() {

        System.out.println(".:.:. ¡Bienvenidos al Proyecto Juegos! .:.:.");

        configuracion.establecerJugadores();
        configuracion.seleccionarPrimerJugador();
        int numeroDeJuegos = configuracion.definirJuegos();


    }


    public boolean isTerminado() {
        return terminado;
    }
}