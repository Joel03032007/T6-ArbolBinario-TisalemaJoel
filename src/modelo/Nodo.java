package modelo;

/**
 * Nodo genérico de un árbol binario.
 * T permite guardar cualquier tipo de dato (String, Integer, etc.).
 */
public class Nodo<T> {

    private T dato;               // Información almacenada en el nodo
    private Nodo<T> izquierdo;    // Referencia al hijo izquierdo (null si no tiene)
    private Nodo<T> derecho;      // Referencia al hijo derecho (null si no tiene)

    // Constructor: el nodo nace sin hijos
    public Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Un nodo es hoja si no tiene ningún hijo
    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }

    // Grado = número de hijos que tiene el nodo (0, 1 o 2)
    public int grado() {
        int grado = 0;
        if (izquierdo != null) grado++;
        if (derecho != null) grado++;
        return grado;
    }

    // ---------- Getters y setters ----------
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }

    // Permite imprimir el nodo mostrando directamente su dato
    @Override
    public String toString() {
        return String.valueOf(dato);
    }
}