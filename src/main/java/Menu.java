package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Menu {
  public JuegosReunidosExtendido juegos;
  private final String PATH = "./resources/game.dat";

  public Menu() {
    File juegosGuardados = new File(PATH);
    cargarJuegos(juegosGuardados);
  }

  public void guardarJuegos(File gameFile) {
    try {
      FileOutputStream fos = new FileOutputStream(gameFile);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(juegos);
      oos.flush();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.err.println("No se ha guardado el juego");
    } 
  }
  
  public void cargarJuegos(File gameFile) {
    if (gameFile.exists()) {
      try {
        FileInputStream fis = new FileInputStream(gameFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        juegos = (JuegosReunidosExtendido) ois.readObject();
      } catch (Exception e) {
        e.printStackTrace();
        juegos = new JuegosReunidosExtendido();
      }
    } else {
      juegos = new JuegosReunidosExtendido();    
    }
  }
  
  public void jugar(Jugable game) {
    game.reiniciaPartida();
    System.out.println("Ha elegido el juego " + game.getNombre());
    System.out.println(game.getInfo());
    String respuesta;
    do {
      do {
        game.preview();
        respuesta = MyInput.readString();
      } while (!game.validaFormato(respuesta));
    } while (!game.juega(respuesta));
  }

  public void mostrarOpciones() {
    System.out.println("¿A qué juego quieres jugar");
    juegos.listarJuegos();
  }

  public boolean chequeoOpcion(int opcion) {
    return (opcion > 0 && opcion <= juegos.tamanoJuegos());
  }

  public int eligeOpcion() {
    int opcion;
    do {
      mostrarOpciones();
      System.out.println("Seleccione su opción mediante el número:");
      opcion = MyInput.readInt();
    } while (!chequeoOpcion(opcion));
    return opcion;
  }

  public void ejecuta() {
    String respuesta;
    do {
      Jugable juego = juegos.recuperarJuego(eligeOpcion());
      jugar(juego);
      guardarJuegos(new File(PATH));
      System.out.println("¿Desea jugar otra vez? s/n");
      respuesta = MyInput.readString().toLowerCase();
    } while (respuesta.equals("s"));

  }

}
