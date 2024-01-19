
public class AdivinaNumeroPar extends AdivinaNumero {

  public AdivinaNumeroPar(int vidas) {
    this(vidas, GeneradorNumerosAleatorios.generaNumeroPar());
  }
  public AdivinaNumeroPar(int vidas, int numeroAdivinar) {
    super(vidas, numeroAdivinar);
    setNombre("Adivina un número par");
    setDescripcion("Tiene un número de " + getVidasIniciales() + " vidas determinado para acertar el "
        + "número al azar que sea par. Cuando falle se quitará una vida hasta llegar a 0.");

  }
  /**
   * Modifica el validaNumero de AdivinaNumero para que solo valgan números pares
   */
  @Override
  public boolean validaNumero(int numero) {
    //TODO implementar notificar que el número no es par
    return super.validaNumero(numero) && (numero % 2 == 0);
  }

  
  
  
}
