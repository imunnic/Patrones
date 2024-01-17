import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JuegosReunidos {
  private List<Jugable> juegos;
  private final int VIDASPORDEFECTO = 5;
  
  public List<Jugable> getJuegos() {
    return juegos;
  }
  
  public int getVIDASPORDEFECTO() {
    return VIDASPORDEFECTO;
  }
  
  private void setJuegos(List<Jugable> juegos) {
    this.juegos = juegos;
  }
  
  public JuegosReunidos() {
    juegos = new ArrayList<Jugable>();
    juegos.add(new AdivinaNumero(getVIDASPORDEFECTO()));
    juegos.add(new AdivinaNumeroPar(getVIDASPORDEFECTO()));
    juegos.add(new AdivinaNumeroImpar(getVIDASPORDEFECTO()));
  }
  
  public JuegosReunidos(Jugable... juegos) {
    setJuegos(new ArrayList<Jugable>());
    Arrays.asList(juegos).forEach(a -> addJuego(a));
  }
  
  public void listarJuegos() {
    int n = 1;
    for (Jugable jugable : juegos) {
      System.out.println("Introduce " + n +" si quieres jugar a " + jugable.muestraNombre());
      n = n + 1;
    }
  }
  
  public void addJuego(Jugable juego) {
    getJuegos().add(juego);
  }
  
  public Jugable recuperarJuego(int posicion) {
    return getJuegos().get(posicion - 1);
  }
  
  public int tamanoJuegos() {
    return getJuegos().size();
  }
}
