package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuegoAhorcadoIngles extends JuegoConVidas{
  private StringBuffer palabraAdivinar;
  private StringBuffer guiones;
  private Map<Integer,String> diccionario;
  private final String CADENAVALIDA ="\\D{1}";
  
  public String getCadenaValida() {
    return CADENAVALIDA;
  }
  
  /**
   * @param vidas
   * @param diccionario
   * crea el juego con una palabra entre todas las del diccionario seleccionadas
   */
  public JuegoAhorcadoIngles(int vidas, List<String> diccionario) {
    super(vidas);
    this.diccionario = new HashMap<Integer, String>();
    diccionario.forEach(a -> this.diccionario.put(diccionario.indexOf(a) + 1, a));
    setNombre("Ahorcado inglés");
    setDescripcion("Tiene un número de " + getVidasIniciales() + " vidas determinado para "
        + "acertar la pabra. Cuando falle se quitará una vida hasta llegar a 0. Si acierta"
        + " podrá continuar hasta adivinar la palabra");
    reiniciaPartida();
  }

  /**
   * @param caracter
   * @return el boleano de si el caracter existe o no
   * comprueba si el caracter existe o no y cambia el valor de ese caracter en el StringBuffer guiones
   */
  public boolean existeCaracter(char caracter){
    if (palabraAdivinar.indexOf(Character.toString(caracter)) >= 0) {
      for (int i = 0; i < palabraAdivinar.length(); i++) {
        if (palabraAdivinar.charAt(i) == caracter) {
          guiones.setCharAt(i, caracter);
        }
      } 
    }
    return palabraAdivinar.indexOf(Character.toString(caracter)) >= 0;
  }

  /**
   * @param caracter
   * setea el StringBuffer inicial de guiones al caracter marcado
   */
  private void rellenarGuiones(char caracter){
    for (int i = 0; i < guiones.length(); i++) {
      guiones.setCharAt(i, caracter);
    }
  }

  /**
   * muestra el estado de el StringBuffer guiones por pantalla 
   */
  public void muestraGuiones() {
    System.out.println(guiones.toString());
  }
  
  /**
   * de entre todas las opciones del diccionario, elige una y la guarda como palabraAdivinar 
   */
  private void seleccionarPalabra() {
    palabraAdivinar = new StringBuffer(this.diccionario
        .get(GeneradorNumerosAleatorios.generarNumeroAletorioMax(diccionario.size())+1));
    guiones = new StringBuffer(palabraAdivinar.toString());
  }
  
  /**
   * reinicia la partida con una nueva palabra y poniendo a cero los guiones
   */
  @Override
  public void reiniciaPartida() {
    super.reiniciaPartida();
    seleccionarPalabra();
    rellenarGuiones('-');
  }
  
  
  /**
   * establece las reglas del juego
   */
  @Override
  public boolean juega(String valor) {
    //TODO ver por qué se repite doble la vida
    char caracter = valor.toLowerCase().charAt(0); 
    if (existeCaracter(caracter)) {
      System.out.println("Ha acertado");

    }
    else {
      if (getVidas() <= 1) {
        System.out.println("Ha perdido, la palabra era: " + palabraAdivinar.toString());
        quitaVida();
      } else {
        System.out.println("Ha fallado");

        quitaVida();  
      }
    }
    if (palabraAdivinar.toString().equals(guiones.toString())) {
      System.out.println("Has adivinado la palabra!!");
    }
    return palabraAdivinar.toString().equals(guiones.toString()) | getVidas() <= 0;
  }
  
  /**
   * muestra lo primero que se ve del juego al ejecutar
   */
  @Override
  public void preview() {
    muestraGuiones();
    System.out.println("Introduzca una letra");
  }
  
}
