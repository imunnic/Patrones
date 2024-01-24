package main.java;

public class GeneradorNumerosAleatorios {
  /**
   * @return un numero aleatorio entre 1 y 10
   */
  public static int generarNumero() {
    return (int) (Math.random() * 10 + 1);
  }
  
  /**
   * @return numero par aleatorio entre 1 y 10
   */
  public static int generaNumeroPar() {
    int numero;
    do {
      numero = (int) (Math.random() * 10 + 1);
    } while (numero % 2 != 0);
    return numero;
  }
  
  /**
   * @return numero impar aleatorio entre 1 y 10
   */
  public static int generaNumeroImpar() {
    int numero;
    do {
      numero = (int) (Math.random() * 10 + 1);
    } while (numero % 2 == 0);
    return numero;
  }
  
  /**
   * @param maximo el número máximo entre los que obtener el número a adivinar
   * @return numero aleatorio entre 1 y el máximo dado
   */
  public static int generarNumeroAletorioMax(int maximo) {
    return (int) (Math.random() * maximo + 1);
  }
}
