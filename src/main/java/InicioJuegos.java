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
    String respuesta = "";
    do {
      System.out.println("Tiene " + juego.getVidas() + "vidas");
      System.out.println("Introduzca el valor a adivinar");
      respuesta = MyInput.readString();
    } while (!juego.juega(respuesta));
    
    
    

  }

}
