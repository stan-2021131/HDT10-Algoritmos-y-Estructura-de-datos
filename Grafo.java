
import java.util.Arrays;

public class Grafo{
    private final int[][] matrizAdyacencia;
    private final String[] vertices;
    private static final int MAX = Integer.MAX_VALUE/2;

    /**
     * Constructor del grafo
     * @param numVertices
     * @param vertices
     */
    public Grafo(int numVertices, String[] vertices) {
        //Inicializar variables
        this.vertices = vertices;
        matrizAdyacencia = new int[numVertices][numVertices];

        //Crear matriz de adyacencia con todos los valores en infinito
        for(int i = 0; i<numVertices; i++){
            Arrays.fill(matrizAdyacencia[i], MAX);
            matrizAdyacencia[i][i] = 0; //Valores en la diagonal son 0
        }
    }

    /**
     * Agrega una arista al grafo
     * @param origen
     * @param destino
     * @param peso
     * @throws IllegalArgumentException si el vertice no existe
     */
    public void agregarArista(String origen, String destino, int peso){
        if(buscarVertice(origen) == -1 || buscarVertice(destino) == -1)
            throw new IllegalArgumentException ("Vertice no encontrado");
        else{
            int indexOrigen = buscarVertice(origen);
            int indexDestino = buscarVertice(destino);
            matrizAdyacencia[indexOrigen][indexDestino] = peso;
        }
    }

    /**
     * Elimina una arista del grafo
     * @param origen
     * @param destino
     * @throws IllegalArgumentException si el vertice no existe
     */
    public void eliminarArista(String origen, String destino){
        if(buscarVertice(origen) == -1 || buscarVertice(destino) == -1)
            throw new IllegalArgumentException ("Vertice no encontrado");
        else{
            int indexOrigen = buscarVertice(origen);
            int indexDestino = buscarVertice(destino);
            matrizAdyacencia[indexOrigen][indexDestino] = MAX;
        }
    }

    /**
     * Obtiene el peso de una arista entre dos vertices
     * @param origen
     * @param destino
     * @throws IllegalArgumentException si el vertice no existe
     * @return el peso de la arista
     */
    public int obtenerPeso(String origen, String destino){
        if(buscarVertice(origen) == -1 || buscarVertice(destino) == -1)
            throw new IllegalArgumentException ("Vertice no encontrado");
        else {
            int indexOrigen = buscarVertice(origen);
            int indexDestino = buscarVertice(destino);
            return matrizAdyacencia[indexOrigen][indexDestino];
        }
    }

    /**
     * Obtiene el indice de un vertice en la matriz de adyacencia
     * @param vertice
     * @return el indice del vertice
     */
    public int buscarVertice(String vertice){
        for(int i = 0; i<vertices.length; i++){
            if(vertices[i].equals(vertice))
            return i;
        }
        return -1;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public String[] getVertices() {
        return vertices;
    }

    public static int getMax() {
        return MAX;
    }

    
}