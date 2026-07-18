package Listas.ListaCircular;

public class NodoLC {
    // Campos del nodo (I, L en tu pseudocódigo)
    private String INFO;
    private NodoLC LIGA;

    /**
     * Constructor vacío (Utilizado en tu primer método: new NodoLC())
     */
    public NodoLC() {
        this.INFO = null;
        this.LIGA = null;
    }

    /**
     * Constructor con parámetros 
     * (Utilizado cuando haces: new NodoLC(informacion, puntero))
     * 
     * @param INFO La información que almacenará el nodo.
     * @param LIGA El puntero al siguiente nodo.
     */
    public NodoLC(String INFO, NodoLC LIGA) {
        this.INFO = INFO;
        this.LIGA = LIGA;
    }

    // --- GETTERS Y SETTERS ---

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO;
    }

    public NodoLC getLIGA() {
        return LIGA;
    }

    public void setLIGA(NodoLC LIGA) {
        this.LIGA = LIGA;
    }
}
