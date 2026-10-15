package negocio;

import modelo.Nodo;

/**
 * Árbol binario genérico.
 * Conteo de nodos, hojas y altura implementados con recursividad.
 */
public class ArbolBinario<T> {

    private Nodo<T> raiz;   // Nodo raíz; null significa árbol vacío

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    // Crea la raíz. Si ya existe, lanza error para no perder el árbol
    public Nodo<T> crearRaiz(T dato) {
        if (raiz != null) {
            throw new IllegalStateException("La raíz ya existe.");
        }
        raiz = new Nodo<>(dato);
        return raiz;
    }

    // Agrega un hijo izquierdo; si esa posición está ocupada, rechaza la inserción
    public Nodo<T> agregarIzquierdo(Nodo<T> padre, T dato) {
        validarPadre(padre);
        if (padre.getIzquierdo() != null) {
            throw new IllegalStateException(
                "La posición izquierda de '" + padre + "' ya está ocupada por '" + padre.getIzquierdo() + "'.");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setIzquierdo(nuevo);
        return nuevo;
    }

    // Agrega un hijo derecho; si esa posición está ocupada, rechaza la inserción
    public Nodo<T> agregarDerecho(Nodo<T> padre, T dato) {
        validarPadre(padre);
        if (padre.getDerecho() != null) {
            throw new IllegalStateException(
                "La posición derecha de '" + padre + "' ya está ocupada por '" + padre.getDerecho() + "'.");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setDerecho(nuevo);
        return nuevo;
    }

    // Verifica que el padre exista antes de insertar
    private void validarPadre(Nodo<T> padre) {
        if (padre == null) {
            throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        }
    }

    // El árbol está vacío si no tiene raíz
    public boolean esVacio() {
        return raiz == null;
    }

    // ---------- Operaciones recursivas ----------

    public int contarNodos() {
        return contarNodos(raiz);
    }

    // Caso base: nodo nulo = 0. Caso recursivo: 1 (este nodo) + nodos de cada subárbol
    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    // Caso base: nodo nulo = 0 y hoja = 1. Si no, suma las hojas de ambos subárboles
    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) return 0;
        if (nodo.esHoja()) return 1;
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    // Altura en aristas: árbol vacío = -1, un solo nodo = 0
    public int altura() {
        return altura(raiz);
    }

    // Altura = 1 + la mayor altura entre los dos hijos (camino más largo hasta una hoja)
    private int altura(Nodo<T> nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

    // ---------- Búsqueda ----------

    // Busca un nodo por su dato (sin distinguir mayúsculas). Devuelve null si no existe
    public Nodo<T> buscar(T dato) {
        return buscar(raiz, dato);
    }

    private Nodo<T> buscar(Nodo<T> nodo, T dato) {
        if (nodo == null || dato == null) return null;
        if (String.valueOf(nodo.getDato()).equalsIgnoreCase(String.valueOf(dato))) {
            return nodo;
        }
        Nodo<T> encontrado = buscar(nodo.getIzquierdo(), dato);   // Primero busca a la izquierda
        if (encontrado != null) return encontrado;
        return buscar(nodo.getDerecho(), dato);                   // Si no, a la derecha
    }

    // ---------- Visualización ----------

    // Muestra el árbol en consola. (I) = hijo izquierdo, (D) = hijo derecho
    public void mostrarArbol() {
        if (esVacio()) {
            System.out.println("(árbol vacío)");
            return;
        }
        System.out.println(raiz);
        mostrarHijos(raiz, "");
    }

    // El prefijo acumula los espacios y barras para dibujar las ramas según el nivel
    private void mostrarHijos(Nodo<T> nodo, String prefijo) {
        Nodo<T> izq = nodo.getIzquierdo();
        Nodo<T> der = nodo.getDerecho();

        if (izq != null && der != null) {
            System.out.println(prefijo + "├── (I) " + izq);
            mostrarHijos(izq, prefijo + "│   ");
            System.out.println(prefijo + "└── (D) " + der);
            mostrarHijos(der, prefijo + "    ");
        } else if (izq != null) {
            System.out.println(prefijo + "└── (I) " + izq);
            mostrarHijos(izq, prefijo + "    ");
        } else if (der != null) {
            System.out.println(prefijo + "└── (D) " + der);
            mostrarHijos(der, prefijo + "    ");
        }
    }
}