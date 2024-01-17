import java.util.Scanner;

public class InicioJuegos {
  public static void main(String[] args) {

//    Menu menu = new Menu();
//    // menu.juegos.getJuegos().forEach(Jugable::muestraInfo);
//    menu.ejecuta();
    Jugable juego1 = new AdivinaNumero(5);
    Jugable juego2 = new AdivinaNumeroPar(5);
    Jugable juego3 = new AdivinaNumeroImpar(5);
    
    System.out.println(juego1.muestraNombre());
    System.out.println(juego2.muestraNombre());
    System.out.println(juego3.muestraNombre());

  }

}
