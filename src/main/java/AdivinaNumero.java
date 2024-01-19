public class AdivinaNumero extends JuegoConVidas {
  private int numero;

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getNumero() {
    return numero;
  }

  public AdivinaNumero(int vidas, int numeroAdivinar) {
    super(vidas);
    setNumero(numeroAdivinar);
    setNombre("Adivina un número");
    setDescripcion("Tiene un número de " + getVidasIniciales() + " vidas determinado para acertar el "
        + "número al azar. Cuando falle se quitará una vida hasta llegar a 0.");
  }

  public AdivinaNumero(int vidas) {
    this(vidas, GeneradorNumerosAleatorios.generarNumero());
  }

  public boolean validaNumero(int numero) {
    if (getNumero() >= 0 && numero <= 10) {
      return true;
    } else {
      System.out.println("Número fuera de rango");
      return false;
    }
  }

  @Override
  public boolean juega(String valor) {
    int numero = Integer.parseInt(valor);
    if (!validaNumero(numero)) { //Si el numero está fuera de rango devuelve true
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

 
  
//TODO generar numero aleatorio

}
