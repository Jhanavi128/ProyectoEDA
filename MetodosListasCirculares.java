import javax.swing.JOptionPane;

import Listas.ListaCircular.NodoLC;

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
}
