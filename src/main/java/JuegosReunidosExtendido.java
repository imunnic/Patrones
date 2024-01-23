package main.java;

import java.util.Arrays;
import java.util.List;

public class JuegosReunidosExtendido extends JuegosReunidos{
  private final String PATH = "./../resources/words.txt";;
  
  public JuegosReunidosExtendido() {
    super();
    List<String> dicc = MyInput.leeFichero(PATH);
    addJuego(new JuegoAhorcadoIngles(5, dicc));
  }

  public JuegosReunidosExtendido(Jugable... juegos) {
    super();
    Arrays.asList(juegos).forEach(a -> addJuego(a));
  }
  
}
