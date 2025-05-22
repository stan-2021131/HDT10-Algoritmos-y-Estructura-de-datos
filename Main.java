public class Main {
    public static void main(String[] args) {
    // Crear el grafo con las ciudades del problema
    String[] ciudades = {"A", "B", "C", "D", "E"};
    Grafo grafo = new Grafo(ciudades.length, ciudades);
    FloydWarshall fw = new FloydWarshall();

    // Añadir las aristas con sus pesos (distancias en km)
    // A: Ciudad de Guatemala (0)
    // B: Zacapa (1)
    // C: Chiquimula (2)
    // D: Quetzaltenango (3)
    // E: Cobán (4)
    
    // Ejemplo de distancias (debes usar las reales de tu problema)
    grafo.agregarArista("A", "B", 3); // A -> B
    grafo.agregarArista("A", "D", 7); // A -> D
    grafo.agregarArista("B", "C", 1);  // B -> C
    grafo.agregarArista("C", "D", 2); // C -> D
    grafo.agregarArista("D", "E", 3); // D -> E
    grafo.agregarArista("E", "A", 4); // E -> A
    
    // Calcular caminos más cortos con Floyd-Warshall
    int[][] distancias = fw.floydWarshall(grafo);
    
    // Imprimir resultados
    System.out.println("Matriz de distancias más cortas:");
    fw.imprimirMatrizDistancias(distancias, grafo);
    
    // Calcular centro del grafo
    String centro = fw.calcularCentroGrafo(distancias, grafo);
    System.out.println("\nEl centro del grafo es: " + centro);
}
}
