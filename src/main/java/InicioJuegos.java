package main.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InicioJuegos {
  public static void main(String[] args) {

//    Menu menu = new Menu();
//    menu.mostrarOpciones();
//    menu.ejecuta();
    List<String> dicc = new ArrayList<String>();
    dicc.add("Ignacio");
    dicc.add("Rodrigo");
    dicc.add("Xavi");
    dicc.add("Justo");
    dicc.add("Vicente");
    JuegoAhorcadoIngles juego = new JuegoAhorcadoIngles(5, dicc);
    boolean fin = true;
    do {
      fin = juego.juega(null);
    } while (!fin);
    
    
    

  }

}
