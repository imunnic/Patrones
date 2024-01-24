package main.java;

import java.util.regex.Pattern;

public interface Jugable extends Describible {
  boolean juega(String valor);
  void reiniciaPartida();
  void preview();
  String getCadenaValida();
  default boolean validaFormato(String valor) {
      return Pattern.compile(getCadenaValida()).matcher(valor).matches();   
  }
}
