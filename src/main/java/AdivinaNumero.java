package main.java;

/**
 * 
 */
public class AdivinaNumero extends JuegoConVidas {
  private int numero;
  private final String CADENAVALIDA ="\\d{1}";  //REGEX para la validación de la cadena de input
  
  public String getCadenaValida() {
    return CADENAVALIDA;
  }
  
  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getNumero() {
    return numero;
  }

  
  /**
   * @param vidas las vidas con las que se empieza el juego
   * @param numeroAdivinar el número que se va a adivinar
   * setea el nombre y la descripción al crearlo
   */
  public AdivinaNumero(int vidas, int numeroAdivinar) {
    super(vidas);
    setNumero(numeroAdivinar);
    setNombre("Adivina un número");
    setDescripcion("Tiene un número de " + getVidasIniciales() + " vidas determinado para acertar el "
        + "número al azar. Cuando falle se quitará una vida hasta llegar a 0.");
  }

  
  /**
   * aleatoriza el @param numeroAdivinar del constructor completo
   */
  public AdivinaNumero(int vidas) {
    this(vidas, GeneradorNumerosAleatorios.generarNumero());
  }

  /**
   * @param numero debe ser un número entero
   * @return booleano que indica si se encuentra entre 0 y 10
   */
  public boolean validaNumero(int numero) {
    if (numero >= 0 && numero <= 10) {
      return true;
    } else {
      System.out.println("Número fuera de rango");
      return false;
    }
  }
  
  /**
   *Al iniciar la partida resetea el número para que se genere de forma aleatoria de nuevo
   */
  @Override
  public void reiniciaPartida() {
    super.reiniciaPartida();
    setNumero(GeneradorNumerosAleatorios.generarNumero());
  }
  
  /**
   * Establece las reglas del juego adivina número
   */
  @Override
  public boolean juega(String valor) {
    int numero = Integer.parseInt(valor);
    if (!validaNumero(numero)) {
      return false;
    } else {
      if (numero == getNumero()) {
        System.out.println("Acertaste");
        actualizaRecord();
        return true;
      } else {
        if (numero > getNumero()) {
          System.out.println("El número dado es mayor");
        } else {
          System.out.println("El número dado es menor");
        }
        return !quitaVida();
      }
    }
  }
  
  @Override
  public void preview() {
    System.out.println("Introduzca un número");
    
  }

}
