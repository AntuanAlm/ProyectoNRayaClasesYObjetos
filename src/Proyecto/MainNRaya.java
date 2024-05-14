package Proyecto;

import Proyecto.Abstractas.JuegoAbstracto;

import java.util.Scanner;

public class MainNRaya {
    public static void main(String[] args) {
        ConfigurarJuego configuracion = new ConfigurarJuego();
        Juego nRaya = new Juego();
        JuegoAleatorio juegoAleatorio = new JuegoAleatorio();
        IniciarNRaya iniciarNRaya = new IniciarNRaya(configuracion, nRaya, juegoAleatorio);
        iniciarNRaya.StartNRaya();
    }
}


