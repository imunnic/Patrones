package main.java;

public class GeneradorNumerosAleatorios {
  public static int generarNumero() {
    return (int) (Math.random() * 10);
  }
  
  public static int generaNumeroPar() {
    int numero;
    do {
      numero = (int) (Math.random() * 10);
    } while (numero % 2 != 0);
    return numero;
  }
  
  public static int generaNumeroImpar() {
    int numero;
    do {
      numero = (int) (Math.random() * 10);
    } while (numero % 2 == 0);
    return numero;
  }
  
  public static int generarNumeroAletorioMax(int maximo) {
    return (int) (Math.random() * maximo);
  }
}
