package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JuegosReunidosExtendido extends JuegosReunidos{
  
  public JuegosReunidosExtendido() {
    super();
    List<String> dicc = new ArrayList<String>();
    dicc.add("Ignacio");
    dicc.add("Rodrigo");
    dicc.add("Xavi");
    dicc.add("Justo");
    dicc.add("Vicente");
    addJuego(new JuegoAhorcadoIngles(5, dicc));
  }

  public JuegosReunidosExtendido(Jugable... juegos) {
    super();
    Arrays.asList(juegos).forEach(a -> addJuego(a));
  }
  
}
