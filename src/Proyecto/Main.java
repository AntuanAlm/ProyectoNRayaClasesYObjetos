package Proyecto;

import Proyecto.Juego;
import Proyecto.Jugador;

import java.util.Scanner;

public class Main {

    private static Jugador[] jugadores = new Jugador[2];
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(".:.:. Bienvenidos al Proyecto.Juego N en Raya .:.:.");

        establecerJugadores();
        seleccionarPrimerJugador();
        int numeroDeJuegos = definirJuegos();

        Juego[] juegos = new Juego[numeroDeJuegos];

        for (int i = 0; i < juegos.length; i++) {
            juegos[i] = new Juego();
        }

        for (int i = 0; i < juegos.length; i++) {
            System.out.println("Bienvenido al juego número " + (i + 1) + ", de " + juegos.length + " juegos N en Raya!!");
            juegos[i].Start(jugadores);
        }

    }

    private static void establecerJugadores() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Introduce el nombre del jugador" + (i + 1));
            String nombre = sc.nextLine();
            jugadores[i] = new Jugador(nombre);
        }
    }

    private static void seleccionarPrimerJugador() {
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
                jugadores[0].setFicha(1);
                jugadores[1].setFicha(2);
                break;
            case 2:
                System.out.println(jugadores[1].getNombre() + " empieza primero.");
                jugadores[1].setTurno(true);
                jugadores[1].setFicha(1);
                jugadores[0].setFicha(2);
                break;
        } // no hay default, ya que, tiene el bucle justo arriba y ya sólo puedes elegir un jugador 1 o 2.
    }

    private static int definirJuegos() {
        System.out.println("¿Cuántos juegos quieres jugar?");
        int cantidadJuegos = sc.nextInt();

        return cantidadJuegos;
    }
}
