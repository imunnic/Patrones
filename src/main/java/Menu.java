package main.java;

public class Menu {
  public JuegosReunidos juegos;

  public Menu() {
    juegos = new JuegosReunidos();
  }

  public void jugar(Jugable game) {
    game.reiniciaPartida();
    game.muestraNombre();
    game.muestraInfo();
    String respuesta;
    do {
      System.out.println("Introduzca un numero del 0 al 10:");
      respuesta = MyInput.readString();
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
      System.out.println("¿Desea jugar otra vez? s/n");
      respuesta = MyInput.readString().toLowerCase();
    } while (respuesta.equals("s"));

  }

}
