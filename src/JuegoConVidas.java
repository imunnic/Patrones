
public abstract class JuegoConVidas implements Jugable {
  private String nombre;
  private String descripcion;
  private int vidas;
  private int vidasIniciales;
  private int record;

  private void setRecord(int record) {
    this.record = record;
  }

  private void setVidas(int vidas) {
    this.vidas = vidas;
  }

  private void setVidasIniciales(int vidasIniciales) {
    this.vidasIniciales = vidasIniciales;
  }

  private int getRecord() {
    return record;
  }

  private int getVidas() {
    return vidas;
  }

  protected int getVidasIniciales() {
    return vidasIniciales;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  protected void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getDescripcion() {
    return descripcion;
  }
  
  protected void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public JuegoConVidas(int vidas) {
    this("","",vidas);
  }

  public JuegoConVidas(String nombre, String descripcion, int vidas) {
    setNombre(nombre);
    setDescripcion(descripcion);
    setVidasIniciales(vidas);
    setVidas(getVidas());
    setRecord(0);
  }
  
  public void muestraVidasIniciales() {
    System.out.println(getVidasIniciales());
  }

  public void muestraVidasRestantes() {
    System.out.println(getVidas());
  }

  public boolean quitaVida() {
    setVidas(getVidas() - 1);
    if (getVidas() > 0) {
      System.out.println("Le quedan " + getVidas() + " vidas.");
      return true;
    } else {
      System.out.println("Juego terminado");
      return false;
    }
  }

  public void reiniciaPartida() {
    setVidas(getVidasIniciales());
  }

  public void actualizaRecord() {
    if (getVidas() == getRecord()) {
      System.out.println("Se ha alcanzado el record");
    } else if (getVidas() > getRecord()) {
      setRecord(getVidas());
      System.out.println("Se ha batido el record");
    }
  }

  @Override
  public String muestraNombre() {
    return getNombre();
    
  }

  @Override
  public void muestraInfo() {
    System.out.println(getDescripcion());
    
  }
  
}
