package main.java;

public interface ConNumero {
  static int generarNumero() {
    return (int) (Math.random() * 10);
  }
}
