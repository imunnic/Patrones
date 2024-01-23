package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuegoAhorcadoIngles extends JuegoConVidas{
  private StringBuffer palabraAdivinar;
  private StringBuffer guiones;
  private Map<Integer,String> diccionario;


  public JuegoAhorcadoIngles(int vidas, List<String> diccionario) {
    super(vidas);
    this.diccionario = new HashMap<Integer, String>();
    diccionario.forEach(a -> this.diccionario.put(diccionario.indexOf(a) + 1, a));
    setNombre("Ahorcado inglés");
    setDescripcion("Tiene un número de " + getVidasIniciales() + " vidas determinado para "
        + "acertar la pabra. Cuando falle se quitará una vida hasta llegar a 0. Si acierta"
        + "podrá continuar hasta adivinar la palabra");
    reiniciaPartida();
  }

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

  private void rellenarGuiones(char caracter){
    for (int i = 0; i < guiones.length(); i++) {
      guiones.setCharAt(i, caracter);
    }
  }

  public void muestraGuiones() {
    System.out.println(guiones.toString());
  }
  
  private void seleccionarPalabra() {
    palabraAdivinar = new StringBuffer(this.diccionario
        .get(GeneradorNumerosAleatorios.generarNumeroAletorioMax(diccionario.size())+1));
    System.out.println(palabraAdivinar);
    guiones = new StringBuffer(palabraAdivinar.toString());
  }
  
  @Override
  public void reiniciaPartida() {
    super.reiniciaPartida();
    seleccionarPalabra();
    rellenarGuiones('-');
  }
  
  @Override
  public boolean juega(String valor) {
    System.out.println(palabraAdivinar);
    char caracter = valor.charAt(0); 
    if (existeCaracter(caracter)) {
      System.out.println("Ha acertado");
      muestraGuiones();
    }
    else {
      System.out.println("Ha fallado");
      quitaVida();
    }
    return palabraAdivinar.toString().equals(guiones.toString());
  }
  
  
  
}
