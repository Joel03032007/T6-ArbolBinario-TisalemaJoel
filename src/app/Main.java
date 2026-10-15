package app;

import java.util.Scanner;

import modelo.Nodo;
import negocio.ArbolBinario;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);        // Lectura de datos del usuario
    private static ArbolBinario<String> arbol = new ArbolBinario<>();     // Árbol de trabajo (inicia vacío)

    public static void main(String[] args) {
        int opcion;
        // El menú se repite hasta que el usuario elija 0 (Salir)
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();
            switch (opcion) {
                case 1:
                    arbol = construirArbolInicial();
                    System.out.println("Árbol inicial creado correctamente.");
                    break;
                case 2:
                    System.out.println("=== Estructura del árbol ===");
                    arbol.mostrarArbol();
                    break;
                case 3:
                    System.out.println("Número de nodos: " + arbol.contarNodos());
                    break;
                case 4:
                    System.out.println("Número de hojas: " + arbol.contarHojas());
                    break;
                case 5:
                    System.out.println("Altura (en aristas): " + arbol.altura());
                    break;
                case 6:
                    consultarGrado();
                    break;
                case 7:
                    consultarHoja();
                    break;
                case 8:
                    ejecutarCasosDePrueba();
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("===== ORGANIZACIÓN DE DEPARTAMENTOS =====");
        System.out.println("1. Crear el árbol inicial");
        System.out.println("2. Visualizar el árbol");
        System.out.println("3. Consultar número de nodos");
        System.out.println("4. Consultar número de hojas");
        System.out.println("5. Consultar altura");
        System.out.println("6. Consultar grado de un nodo");
        System.out.println("7. Verificar si un nodo es hoja");
        System.out.println("8. Ejecutar casos de prueba");
        System.out.println("0. Salir");
    }

    // Construye el árbol de 9 nodos del enunciado, nivel por nivel
    private static ArbolBinario<String> construirArbolInicial() {
        ArbolBinario<String> a = new ArbolBinario<>();
        Nodo<String> universidad = a.crearRaiz("UNIVERSIDAD");

        // Nivel 1
        Nodo<String> fisei = a.agregarIzquierdo(universidad, "FISEI");
        Nodo<String> dide = a.agregarDerecho(universidad, "DIDE");

        // Nivel 2: hijos de FISEI
        Nodo<String> software = a.agregarIzquierdo(fisei, "SOFTWARE");
        a.agregarDerecho(fisei, "TI");

        // Nivel 2: hijos de DIDE
        a.agregarIzquierdo(dide, "INVEST.");
        a.agregarDerecho(dide, "VINCULACIÓN");

        // Nivel 3: hijos de SOFTWARE
        a.agregarIzquierdo(software, "NIVEL1");
        a.agregarDerecho(software, "NIVEL3");
        return a;
    }

    // Opción 6: muestra cuántos hijos tiene el nodo indicado
    private static void consultarGrado() {
        Nodo<String> nodo = pedirNodo();
        if (nodo != null) {
            System.out.println("Grado de '" + nodo + "': " + nodo.grado());
        }
    }

    // Opción 7: indica si el nodo indicado es hoja
    private static void consultarHoja() {
        Nodo<String> nodo = pedirNodo();
        if (nodo != null) {
            System.out.println("'" + nodo + "' " + (nodo.esHoja() ? "SÍ es hoja." : "NO es hoja."));
        }
    }

    // Pide un nombre y devuelve el nodo; devuelve null si el árbol está vacío o no existe
    private static Nodo<String> pedirNodo() {
        if (arbol.esVacio()) {
            System.out.println("El árbol está vacío. Cree el árbol inicial primero (opción 1).");
            return null;
        }
        System.out.print("Nombre del nodo: ");
        String nombre = scanner.nextLine().trim();
        Nodo<String> nodo = arbol.buscar(nombre);
        if (nodo == null) {
            System.out.println("El nodo '" + nombre + "' no existe en el árbol.");
        }
        return nodo;
    }

    // Lee un entero; si el usuario escribe algo inválido devuelve -1 (opción no válida)
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ---------- Casos de prueba obligatorios ----------

    private static void ejecutarCasosDePrueba() {
        System.out.println("===== CASOS DE PRUEBA =====");

        // 1. Árbol vacío: 0 nodos y altura -1
        ArbolBinario<String> vacio = new ArbolBinario<>();
        System.out.println("\n[1] Árbol vacío");
        System.out.println("Nodos: " + vacio.contarNodos() + " (esperado 0)");
        System.out.println("Altura: " + vacio.altura() + " (esperado -1)");
        System.out.println("¿Vacío?: " + vacio.esVacio());

        // 2. Un solo nodo: 1 hoja y altura 0
        ArbolBinario<String> unico = new ArbolBinario<>();
        unico.crearRaiz("RAIZ");
        System.out.println("\n[2] Árbol con un solo nodo");
        System.out.println("Hojas: " + unico.contarHojas() + " (esperado 1)");
        System.out.println("Altura: " + unico.altura() + " (esperado 0)");

        // 3. Árbol inicial: 9 nodos, 5 hojas, altura 3
        ArbolBinario<String> inicial = construirArbolInicial();
        System.out.println("\n[3] Árbol inicial");
        System.out.println("Nodos: " + inicial.contarNodos() + " (esperado 9)");
        System.out.println("Hojas: " + inicial.contarHojas() + " (esperado 5)");
        System.out.println("Altura: " + inicial.altura() + " (esperado 3)");

        // 4. Insertar en una posición ocupada: debe lanzar excepción y capturarla
        System.out.println("\n[4] Insertar en posición ocupada");
        try {
            inicial.agregarIzquierdo(inicial.buscar("FISEI"), "NUEVO");
            System.out.println("ERROR: se permitió insertar en una posición ocupada.");
        } catch (IllegalStateException e) {
            System.out.println("Correcto, se rechazó la inserción: " + e.getMessage());
        }

        // 5. Grado de FISEI y SOFTWARE (ambos tienen 2 hijos)
        System.out.println("\n[5] Grado de nodos");
        System.out.println("Grado de FISEI: " + inicial.buscar("FISEI").grado() + " (esperado 2)");
        System.out.println("Grado de SOFTWARE: " + inicial.buscar("SOFTWARE").grado() + " (esperado 2)");
    }
}