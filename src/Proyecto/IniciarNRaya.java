package Proyecto;

import Proyecto.Abstractas.ConfigurarJuegoAbstracto;

import java.util.Scanner;

    public class IniciarNRaya {
        private ConfigurarJuego configuracion;
        private Juego nRaya;
        private JuegoAleatorio juegoAleatorio;

        public IniciarNRaya(ConfigurarJuego configuracion, Juego nRaya, JuegoAleatorio juegoAleatorio) {
            this.configuracion = configuracion;
            this.nRaya = nRaya;
            this.juegoAleatorio = juegoAleatorio;
        }

        public void StartNRaya() {
            Scanner sc = new Scanner(System.in);
            System.out.println(".:.:. ¡Bienvenidos al Proyecto de Juegos! .:.:.");
            System.out.println("¿Cuántos juegos quieres jugar?");
            int cantidadJuegos = sc.nextInt();

            for (int i = 0; i < cantidadJuegos; i++) {
                System.out.println("Selecciona el juego:");
                System.out.println("1. N en Raya");
                System.out.println("2. Juego Aleatorio");
                int opcionJuego = sc.nextInt();
                switch (opcionJuego) {
                    case 1:
                        jugarNRaya();
                        break;
                    case 2:
                        jugarJuegoAleatorio();
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        }

        private void jugarNRaya() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Comenzando el juego N en Raya...");
            Jugador[] jugadores = configuracion.getJugadores();
            Tablerito tablero = configuracion.crearTablero();
            nRaya.Start(jugadores);
            nRaya.Jugar(tablero, jugadores);
            System.out.println("Fin del juego N en Raya.");
        }

        private void jugarJuegoAleatorio() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Comienza el juego Aleatorio");
            Jugador[] jugadores = configuracion.getJugadores();
            JuegoAleatorio juegoAleatorio = new JuegoAleatorio(jugadores);
            juegoAleatorio.Start();
            juegoAleatorio.IniciarProgramaNraya();
            System.out.println("Fin del juego de Números Aleatorios.");
        }
    }




