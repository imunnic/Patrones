
public class AdivinaNumeroImpar extends AdivinaNumero {

  public AdivinaNumeroImpar(int vidas) {
    this(vidas, generaNumeroImpar());
  }
  
  public AdivinaNumeroImpar(int vidas, int numeroAdivinar) {
    super(vidas, numeroAdivinar);
    setNombre("Adivina un número impar");
    setDescripcion("Tiene un número de " + getVidasIniciales() + " vidas para acertar el "
        + "número al azar que sea impar. Cuando falle se quitará una vida hasta llegar a 0.");
  }
  /**
   * Modifica el validaNumero de AdivinaNumero para que solo valgan números impares
   */
  @Override
  public boolean validaNumero(int numero) {
    //TODO implementar notificar que el número no es impar
    return super.validaNumero(numero) && (numero % 2 != 0);
  }
  
  private static int generaNumeroImpar() {
    int numero;
    do {
      numero = (int) (Math.random() * 10);
    } while (numero % 2 == 0);
    return numero;
  }
  
  
  //TODO cambiar métodos nombre y descripción, extraer interfaz
}
