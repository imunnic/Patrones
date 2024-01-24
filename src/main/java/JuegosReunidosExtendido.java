package main.java;

import java.util.Arrays;
import java.util.List;

public class JuegosReunidosExtendido extends JuegosReunidos{

//  private List<String> words = Arrays.asList("Ignacio", "Rodrigo", "Xavi", "Justo", "Miguel", "Vicente");
  private List<String> words = MyInput.leeFichero("./resources/words.txt");
  public JuegosReunidosExtendido() {
    super();
    List<String> dicc = words;
    addJuego(new JuegoAhorcadoIngles(5, dicc));
  }

  public JuegosReunidosExtendido(Jugable... juegos) {
    super();
    Arrays.asList(juegos).forEach(a -> addJuego(a));
  }
  
}
