# Implementación de un árbol binario en Java

**Asignatura:** Estructura de Datos
**Nivel:** Tercero – Ingeniería de Software
**Modalidad:** Individual
**Tipo:** Práctica de programación
**Herramientas:** Java, Visual Studio Code y GitHub
**Calificación:** 3 puntos

---

## 1. Objetivo

Implementar un árbol binario utilizando programación orientada a objetos en Java, aplicando operaciones de inserción, consulta y análisis de su estructura jerárquica mediante recursividad.

## 2. Descripción del proyecto

### Sistema de organización jerárquica de departamentos universitarios

El proyecto consiste en desarrollar una aplicación Java que represente la organización de las dependencias académicas de una universidad mediante un árbol binario.

Cada nodo almacena el nombre de una dependencia universitaria y puede contener como máximo dos hijos: izquierdo y derecho.

La aplicación permite construir, visualizar y analizar la estructura jerárquica mediante un menú interactivo en consola.

## 3. Estructura inicial del árbol binario

La estructura inicial representa las dependencias académicas de una universidad de la siguiente manera:

```text
                 UNIVERSIDAD
                 /         \
              FISEI         DIDE
             /    \         /   \
       SOFTWARE    TI   INVEST.  VINCULACIÓN
        /    \
     NIVEL1  NIVEL3
```

### Características del árbol

| Propiedad          | Resultado     |
| ------------------ | ------------- |
| Nodo raíz          | UNIVERSIDAD   |
| Número de nodos    | 9             |
| Número de hojas    | 5             |
| Altura del árbol   | 3 aristas     |
| Grado máximo       | 2             |
| Tipo de estructura | Árbol binario |

**Nodos hoja:** NIVEL1, NIVEL3, TI, INVEST. y VINCULACIÓN.

**Nodos internos:** UNIVERSIDAD, FISEI, SOFTWARE y DIDE.

La altura se calcula contando las aristas del camino más largo desde la raíz hasta una hoja.

## 4. Organización del proyecto

El proyecto está organizado en tres paquetes, aplicando los principios de programación orientada a objetos.

```text
T6-ArbolBinario-ApellidoNombre/
│
├── src/
│   ├── modelo/
│   │   └── Nodo.java
│   │
│   ├── negocio/
│   │   └── ArbolBinario.java
│   │
│   └── app/
│       └── Main.java
│
├── evidencias/
│   ├── menu.png
│   ├── arbol-inicial.png
│   ├── arbol-vacio.png
│   ├── arbol-un-nodo.png
│   ├── insercion-invalida.png
│   └── consultas.png
│
└── README.md
```

### 4.1. Clase Nodo.java — Paquete modelo

La clase genérica `Nodo<T>` representa cada elemento del árbol binario.

Sus principales atributos y métodos son:

* `dato`: almacena la información del nodo.
* `izquierdo`: referencia al hijo izquierdo.
* `derecho`: referencia al hijo derecho.
* `esHoja()`: determina si el nodo no tiene hijos.
* `grado()`: devuelve el número de hijos del nodo.
* Getters y setters para consultar y modificar sus atributos.

### 4.2. Clase ArbolBinario.java — Paquete negocio

Esta clase administra la estructura y las operaciones del árbol binario.

Implementa las siguientes funcionalidades:

* `crearRaiz(dato)`: crea la raíz del árbol.
* `agregarIzquierdo(padre, dato)`: agrega un hijo izquierdo.
* `agregarDerecho(padre, dato)`: agrega un hijo derecho.
* `contarNodos()`: calcula el número total de nodos.
* `contarHojas()`: calcula el número de hojas.
* `altura()`: calcula la altura del árbol en aristas.
* `esVacio()`: verifica si el árbol está vacío.
* `mostrarArbol()`: presenta la estructura del árbol en consola.

Las operaciones de conteo de nodos, conteo de hojas y cálculo de altura utilizan recursividad.

Además, las operaciones de inserción deben comprobar que la posición correspondiente esté disponible antes de agregar un nuevo nodo.

### 4.3. Clase Main.java — Paquete app

La clase `Main.java` contiene el método principal `main()` y permite interactuar con el usuario mediante la clase `Scanner`.

Presenta un menú de opciones para construir el árbol, visualizarlo, consultar sus propiedades y ejecutar las operaciones disponibles.

## 5. Funcionalidades del programa

El sistema dispone del siguiente menú interactivo:

```text
========================================
       SISTEMA DE ARBOL BINARIO
========================================

1. Crear el arbol inicial
2. Visualizar el arbol
3. Consultar numero de nodos
4. Consultar numero de hojas
5. Consultar altura del arbol
6. Consultar grado de un nodo
7. Verificar si un nodo es hoja
8. Salir

========================================
Seleccione una opcion:
```

### Operaciones disponibles

| Operación        | Descripción                                                                    |
| ---------------- | ------------------------------------------------------------------------------ |
| Crear árbol      | Construye la estructura universitaria inicial.                                 |
| Visualizar árbol | Muestra los nodos y sus relaciones jerárquicas.                                |
| Contar nodos     | Obtiene el total de nodos del árbol.                                           |
| Contar hojas     | Obtiene el número de nodos sin hijos.                                          |
| Calcular altura  | Determina el camino más largo desde la raíz hasta una hoja, medido en aristas. |
| Consultar grado  | Determina cuántos hijos tiene un nodo específico.                              |
| Verificar hoja   | Comprueba si un nodo carece de hijos.                                          |
| Salir            | Finaliza la ejecución del programa.                                            |

## 6. Instrucciones de instalación y ejecución

### 6.1. Requisitos previos

Para ejecutar el proyecto se necesita:

* Java JDK instalado.
* Visual Studio Code.
* Extensión Extension Pack for Java en Visual Studio Code.
* Git instalado, si se desea clonar el repositorio desde la terminal.

Para comprobar que Java está instalado, ejecutar:

```bash
java -version
javac -version
```

### 6.2. Clonar el repositorio

Reemplazar la dirección de ejemplo por la URL real del repositorio de GitHub.

```bash
git clone https://github.com/USUARIO/T6-ArbolBinario-ApellidoNombre.git
```

### 6.3. Acceder a la carpeta del proyecto

```bash
cd T6-ArbolBinario-ApellidoNombre
```

### 6.4. Compilar las clases

Desde la carpeta principal del proyecto, ejecutar:

```bash
javac -d bin src/modelo/Nodo.java src/negocio/ArbolBinario.java src/app/Main.java
```

Este comando compila las tres clases y coloca los archivos `.class` generados en la carpeta `bin`.

### 6.5. Ejecutar el programa

```bash
java -cp bin app.Main
```

También es posible abrir el proyecto en Visual Studio Code y ejecutar la clase `Main.java`.

**Nota:** los comandos de compilación y ejecución suponen que las clases declaran los paquetes `modelo`, `negocio` y `app`, respectivamente.

## 7. Casos de prueba

Se consideran cinco casos de prueba obligatorios para verificar el comportamiento del programa.

### 7.1. Prueba 1: árbol vacío

**Objetivo:** comprobar el comportamiento del árbol antes de crear la raíz.

**Resultado esperado:**

```text
Numero de nodos: 0
Numero de hojas: 0
Altura del arbol: -1
```

Cuando el árbol está vacío, no existen nodos ni hojas. La altura es `-1` porque se utiliza la convención de medirla en aristas.

### 7.2. Prueba 2: árbol con un solo nodo

**Objetivo:** verificar el comportamiento del árbol cuando contiene únicamente la raíz.

**Resultado esperado:**

```text
Numero de nodos: 1
Numero de hojas: 1
Altura del arbol: 0
```

La raíz es también una hoja porque no tiene hijos. Su altura es cero, ya que no existe ninguna arista que recorrer.

### 7.3. Prueba 3: árbol universitario inicial

**Objetivo:** comprobar que la estructura inicial se construya correctamente.

**Resultado esperado:**

```text
Numero de nodos: 9
Numero de hojas: 5
Altura del arbol: 3
```

Las hojas son NIVEL1, NIVEL3, TI, INVEST. y VINCULACIÓN.

### 7.4. Prueba 4: inserción en una posición ocupada

**Objetivo:** verificar que no se permita insertar un nodo en una posición que ya contiene un hijo.

**Procedimiento:**

1. Crear el árbol inicial.
2. Intentar agregar un nuevo hijo izquierdo a UNIVERSIDAD, cuya posición izquierda ya está ocupada por FISEI.
3. Comprobar que la operación sea rechazada.

**Resultado esperado:** el programa informa que la posición está ocupada y conserva la estructura original del árbol.

### 7.5. Prueba 5: consulta del grado de los nodos

**Objetivo:** comprobar el número de hijos de diferentes nodos.

| Nodo        | Grado esperado |
| ----------- | -------------: |
| UNIVERSIDAD |              2 |
| FISEI       |              2 |
| SOFTWARE    |              2 |
| TI          |              0 |
| DIDE        |              2 |
| NIVEL1      |              0 |
| NIVEL3      |              0 |

El grado de un nodo corresponde al número de hijos que posee. En un árbol binario, su valor puede ser 0, 1 o 2.

## 8. Evidencias de ejecución

En esta sección se presentan las capturas de pantalla que demuestran el funcionamiento de la aplicación y la ejecución de los casos de prueba.

Las imágenes se encuentran almacenadas en la carpeta `evidencias/` del repositorio.

### 8.1. Menú principal

Captura del menú interactivo que permite seleccionar las operaciones del programa.

![Menú principal](evidencias/menu.png)

### 8.2. Visualización del árbol inicial

Captura de la estructura jerárquica de los departamentos universitarios después de crear el árbol inicial.

![Árbol binario inicial](evidencias/arbol-inicial.png)

### 8.3. Prueba del árbol vacío

Captura de los resultados obtenidos al consultar un árbol sin nodos.

![Árbol vacío](evidencias/arbol-vacio.png)

### 8.4. Prueba de un solo nodo

Captura de los resultados obtenidos al trabajar con un árbol que contiene únicamente la raíz.

![Árbol con un nodo](evidencias/arbol-un-nodo.png)

### 8.5. Validación de posición ocupada

Captura del intento de inserción en una posición que ya contiene un hijo y del rechazo de la operación.

![Inserción inválida](evidencias/insercion-invalida.png)

### 8.6. Consultas de nodos, hojas, altura y grado

Captura de las consultas realizadas sobre la estructura inicial del árbol.

![Consultas del árbol](evidencias/consultas.png)

## 9. Restricciones de implementación

El desarrollo del proyecto considera las siguientes restricciones:

* Implementar el árbol binario mediante clases propias.
* Aplicar los principios de programación orientada a objetos.
* Utilizar la clase genérica `Nodo<T>`.
* Organizar el código en los paquetes `modelo`, `negocio` y `app`.
* Implementar mediante recursividad el conteo de nodos, el conteo de hojas y el cálculo de altura.
* Utilizar `Scanner` para la interacción con el usuario.
* Validar las posiciones de inserción para impedir que se sobrescriban los hijos existentes.
* No utilizar `TreeSet`, `TreeMap`, `PriorityQueue`, `NavigableSet` ni `NavigableMap`.

## 10. Preguntas de reflexión

### 10.1. ¿Por qué la altura de un árbol binario depende del camino más largo desde la raíz hasta una hoja?

La altura representa la máxima profundidad que alcanza el árbol. Por esta razón, se determina contando las aristas del camino más largo desde la raíz hasta una hoja. Esta medida permite conocer la profundidad máxima de la estructura y comprender cómo se distribuyen sus nodos.

En este proyecto, la altura del árbol inicial es de tres aristas. Si el árbol está vacío, su altura es `-1`; si contiene únicamente la raíz, su altura es `0`.

### 10.2. ¿Qué diferencias existen entre almacenar información en una lista enlazada y en un árbol binario?

Una lista enlazada organiza sus elementos de manera secuencial mediante referencias entre nodos. En cambio, un árbol binario organiza los elementos jerárquicamente, permitiendo que cada nodo tenga como máximo dos hijos.

La lista enlazada resulta útil cuando se necesita recorrer elementos en secuencia. El árbol binario permite representar relaciones entre padres e hijos y estructuras jerárquicas. Además, si se implementa como un árbol binario de búsqueda y mantiene una estructura equilibrada, puede facilitar las operaciones de búsqueda, inserción y eliminación.

### 10.3. ¿Cómo podría utilizarse un árbol binario en el proyecto integrador SmartETL para organizar o buscar registros?

En SmartETL, un árbol binario de búsqueda podría utilizarse para organizar registros mediante claves, como identificadores o fechas. Esto permitiría localizar información y realizar inserciones durante los procesos de extracción, transformación y carga de datos.

Por ejemplo, cada nodo podría almacenar el identificador de un registro y utilizar sus hijos para organizar otros identificadores según su valor. Para mantener un buen rendimiento cuando aumenta la cantidad de registros, sería conveniente utilizar un árbol balanceado. La estructura seleccionada dependería de las operaciones y necesidades específicas de SmartETL.

## 11. Conclusiones

La implementación de un árbol binario permite comprender el funcionamiento de las estructuras de datos jerárquicas y su aplicación en situaciones reales.

El proyecto refuerza los conocimientos de programación orientada a objetos, el uso de referencias entre nodos, la recursividad y la organización modular del código mediante paquetes.

Asimismo, permite analizar propiedades fundamentales de los árboles, como el número de nodos, la cantidad de hojas, el grado de cada nodo y la altura de la estructura.

Finalmente, las pruebas permiten comprobar el comportamiento del programa ante diferentes situaciones, como un árbol vacío, un árbol con una sola raíz y un intento de inserción en una posición ocupada.

## 12. Tecnologías utilizadas

* **Java:** desarrollo de la aplicación.
* **Java JDK:** compilación y ejecución del código.
* **Visual Studio Code:** entorno de desarrollo.
* **Git:** control de versiones.
* **GitHub:** almacenamiento del repositorio y documentación del proyecto.
* **Markdown:** elaboración del archivo README.

## 13. Repositorio y control de versiones

El proyecto debe publicarse en un repositorio público de GitHub con el nombre:

`T6-ArbolBinario-ApellidoNombre`

El historial debe incluir al menos tres commits significativos que evidencien el proceso de desarrollo individual.

Ejemplos de mensajes de commit:

```text
git commit -m "Crear clase generica Nodo"
git commit -m "Implementar operaciones recursivas del arbol"
git commit -m "Agregar menu interactivo y documentacion README"
```

Estos comandos son ejemplos de mensajes. Para registrar cada commit, primero se deben agregar los archivos correspondientes y ejecutar `git commit` después de realizar los cambios.

**Enlace al repositorio:** [Agregar aquí la URL real del repositorio de GitHub]

---

**Asignatura:** Estructura de Datos
**Carrera:** Ingeniería de Software
**Universidad:** Universidad Técnica de Ambato

**Proyecto académico individual — 2026**
