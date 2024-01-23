package main.java;

public class Menu {
  public JuegosReunidosExtendido juegos;

  public Menu() {
    juegos = new JuegosReunidosExtendido();
    //TODO convertir a extendido
  }

  public void jugar(Jugable game) {
    game.reiniciaPartida();
    game.muestraNombre();
    game.muestraInfo();
    String respuesta;
    do {
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
