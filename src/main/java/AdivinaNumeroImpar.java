package main.java;

public class AdivinaNumeroImpar extends AdivinaNumero {

  public AdivinaNumeroImpar(int vidas) {
    this(vidas, GeneradorNumerosAleatorios.generaNumeroImpar());
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
  
  @Override
  public void reiniciaPartida() {
    // TODO Auto-generated method stub
    super.reiniciaPartida();
    setNumero(GeneradorNumerosAleatorios.generaNumeroImpar());
  }

}
