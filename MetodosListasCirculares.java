import javax.swing.JOptionPane;

public class MetodosListasCirculares {
    private NodoLC P;
    private NodoLC Q;
    private NodoLC T;
    public MetodosListasCirculares() {
    }

    /* 
     * ALGORITMO INSERTAR FINAL LISTA CIRCULAR
     * Pseudocodigo:
     * Algoritmo InsertarFinalListaCircular()
     * P, Q, T <- Punteros
     * I, L <- Campos del nodo
     * 
     * Si (P != null) Entonces
     *      Q <- P
     *      Mientras (Q^.L != P) Hacer
     *          Q <- Q^.L
     *      Fin Mientras
     *      Crear(T)
     *      Leer T^.I
     *      T^.L <- P
     *      Q^.L <- T 
     * Fin Si
     * Fin Algoritmo
     */
    public void insertarFinalListaCircular() {
        if (this.P != null) {
            this.Q = this.P;
            
            // Recorremos hasta encontrar el último nodo
            while (this.Q.getLIGA() != this.P) {
                this.Q = this.Q.getLIGA();
            }

            String info = JOptionPane.showInputDialog(null, "Escriba la información del nuevo nodo a insertar al final:");
            this.T = new NodoLC(info, this.P); // El nuevo nodo T apunta a P
            
            this.Q.setLIGA(this.T); // El que era el último, ahora apunta a T
            JOptionPane.showMessageDialog(null, "Nodo insertado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Use un método de creación primero.");
        }
    }

    /* * ALGORITMO INSERTAR INICIO LISTA CIRCULAR
     * Pseudocodigo:
     * Algoritmo InsertarInicioListaCircular()
     * P, Q, T <- Punteros
     * I, L <- Campos del nodo
     * * Si (P != null) Entonces
     * T <- P
     * Mientras (T^.L != P) Hacer
     * T <- T^.L 
     * Fin Mientras
     * Crear(Q)
     * Leer Q^.I
     * Q^.L <- P  
     * T^.L <- Q 
     * P <- Q      
     * Fin Si
     * Fin Algoritmo
     */
    public void insertarInicioListaCircular(){
        if(this.P != null){
            // Buscamos el último nodo
            this.T = this.P; 
            while(this.T.getLIGA() != this.P){
                this.T = this.T.getLIGA();
            }

            //Creamos el nuevo nodo que apunta al inicio
            String info = JOptionPane.showInputDialog(null, "Escriba la información del nuevo nodo a insertar al inicio:");
            this.Q = new NodoLC(info, this.P);

            //El último nodo ahora apunta al nuevo inicio
            this.T.setLIGA(this.Q);
            
            // Se actualiza el inicio
            this.P = this.Q;
            
            JOptionPane.showMessageDialog(null, "Nodo insertado al inicio con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
        }
    }

    /*
    ALGORITMO CREACIÓN AL INICIO
    Algoritmo CreacionInicioListaCircular()
    P, Q, T <- Punteros
    I, L <- Campos del nodo
    continuar <- verdadero
    Mientras (continuar) Hacer
        Si (preguntar("Desea ingresar un nodo?") == si) Entonces
            Si (P == null) Entonces
                Crear(Q)
                Leer Q^.I
                Q^.L <- Q
                P <- Q
            Sino
                InsertarInicioListaCircular()
            Fin Si
            Si (preguntar("Desea ingresar otro nodo?") == no) Entonces
                continuar <- falso
                Fin Si
            Sino
                continuar <- falso
            Fin Si
    Fin Mientras
    Fin Algoritmo
    */
    public void creacionInicioListaCircular() {
        if (this.P == null) {
            JOptionPane.showMessageDialog(null, "No existe la lista, se creará el primer nodo");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una lista");
        }
 
        boolean continuar = true;
 
        while (continuar) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea ingresar un nodo?", "Creación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (this.P == null) {
                    String info = JOptionPane.showInputDialog(null, "Escriba la información del primer nodo:");
                    this.Q = new NodoLC(info, null);
                    this.Q.setLIGA(this.Q);
                    this.P = this.Q;
                } else {
                    insertarInicioListaCircular();
                }
 
                int otro = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro nodo?", "Creación", JOptionPane.YES_NO_OPTION);
                if (otro == JOptionPane.NO_OPTION) {
                    continuar = false;
                }
            } else {
                continuar = false;
            }
        }
    }

    /*
    ALGORITMO CREACIÓN AL FINAL
    Algoritmo CreacionFinalListaCircular()
    P, Q, T <- Punteros
    I, L <- Campos del nodo
    continuar <- verdadero
    Mientras (continuar) Hacer
        Si (preguntar("¿Desea ingresar un nodo?") == si) Entonces
            Si (P == null) Entonces
            Crear(T)
            Leer T^.I
            T^.L <- T
            P <- T
        Sino
            InsertarFinalListaCircular()
        Fin Si
        Si (preguntar("¿Desea ingresar otro nodo?") == no) Entonces
            continuar <- falso
        Fin Si
        Sino
            continuar <- falso
        Fin Si
    Fin Mientras
    Fin Algoritmo
    */

    public void creacionFinalListaCircular() {
        if (this.P == null) {
            JOptionPane.showMessageDialog(null, "No existe la lista, se creará el primer nodo.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una lista.");
        }
 
        boolean continuar = true;
 
        while (continuar) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea ingresar un nodo?", "Creación", JOptionPane.YES_NO_OPTION);
 
            if (respuesta == JOptionPane.YES_OPTION) {
                if (this.P == null) {
                    String info = JOptionPane.showInputDialog(null, "Escriba el primer nodo:");
                    this.T = new NodoLC(info, null);
                    this.T.setLIGA(this.T);
                    this.P = this.T;
                } else {
                    insertarFinalListaCircular();
                }
 
                int otro = JOptionPane.showConfirmDialog(null, "Desea ingresar otro nodo?", "Creación", JOptionPane.YES_NO_OPTION);
                if (otro == JOptionPane.NO_OPTION) {
                    continuar = false;
                }
            } else {
                continuar = false;
            }
        }
    }

    /*
    ALGORITMO RECORRER
    Algoritmo RecorrerListaCircular()
    Q <- Puntero
        Si (P != null) Entonces
            Q <- P
            Repetir
                imprimir(Q^.I)
                Q <- Q^.L
            Hasta Que (Q == P)
        Sino
            imprimir("La lista está vacía")
        Fin Si
    Fin Algoritmo
    */

    public void recorrerListaCircular() {
        if (this.P != null) {
            this.Q = this.P;
            String recorrido = "";
            do {
                recorrido += this.Q.getINFO() + "\n";
                this.Q = this.Q.getLIGA();
            } while (this.Q != this.P);
 
            JOptionPane.showMessageDialog(null, "Elementos de la lista:\n" + recorrido);
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
        }
    }

    /*
    ALGORITMO BÚSQUEDA
    Algoritmo BusquedaListaCircular(valor)
        Q <- Puntero
        encontrado <- falso
        Si (P != null) Entonces
            Q <- P
            Repetir
                Si (Q^.I == valor) Entonces
                    encontrado <- verdadero
                Sino
                    Q <- Q^.L
                Fin Si
            Hasta Que (Q == P) O (encontrado == verdadero)
            Si (encontrado) Entonces
                imprimir("Dato encontrado")
            Sino
                imprimir("Dato no encontrado")
            Fin Si
        Sino
            imprimir("La lista está vacía")
        Fin Si
    Fin Algoritmo
    */

    public void busquedaListaCircular() {
        if (this.P != null) {
            String valor = JOptionPane.showInputDialog(null, "Escriba el valor a buscar:");
            this.Q = this.P;
            boolean encontrado = false;
            do {
                if (this.Q.getINFO().equals(valor)) {
                    encontrado = true;
                } else {
                    this.Q = this.Q.getLIGA();
                }
            } while (this.Q != this.P && !encontrado);
            if (encontrado) {
                JOptionPane.showMessageDialog(null, "Dato encontrado.");
            } else {
                JOptionPane.showMessageDialog(null, "Dato no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
        }
    }

}
