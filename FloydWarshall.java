public class FloydWarshall {
    public int[][] floydWarshall(Grafo grafo){
        int[][] distanciasFin = new int[grafo.getVertices().length][grafo.getVertices().length];
        for(int i = 0; i<grafo.getVertices().length; i++){
            System.arraycopy(grafo.getMatrizAdyacencia()[i], 0, distanciasFin[i], 0, grafo.getVertices().length);
        }
        for (int k = 0; k < grafo.getVertices().length; k++) {       // Nodo intermedio
            for (int i = 0; i < grafo.getVertices().length; i++) {   // Nodo origen
                for (int j = 0; j < grafo.getVertices().length; j++) { // Nodo destino
                    if (distanciasFin[i][k] + distanciasFin[k][j] < distanciasFin[i][j]) 
                        distanciasFin[i][j] = distanciasFin[i][k] + distanciasFin[k][j];
                }
            }
        }
        return distanciasFin;
    }


    public String calcularCentroGrafo(int[][] distancias, Grafo grafo) {
    int[] maximos = new int[grafo.getVertices().length];
    int centro = 0;
    
    // Encontrar la máxima distancia para cada vértice
    for (int i = 0; i < grafo.getVertices().length; i++) {
        int max = 0;
        for (int j = 0; j < grafo.getVertices().length; j++) {
            if (distancias[i][j] > max && i != j) {
                max = distancias[i][j];
            }
        }
        maximos[i] = max;
    }
    
    // Encontrar el vértice con el mínimo de los máximos
    int minMax = Integer.MAX_VALUE;
    for (int i = 0; i < maximos.length; i++) {
        if (maximos[i] < minMax) {
            minMax = maximos[i];
            centro = i;
        }
    }
    
    return grafo.getVertices()[centro];
    }

    public void imprimirMatrizDistancias(int[][] matriz, Grafo grafo) {
        System.out.print("    ");
        for (String vertice : grafo.getVertices()) {
            System.out.printf("%5s", vertice);
        }
        System.out.println();
        
        for (int i = 0; i < grafo.getVertices().length; i++) {
            System.out.printf("%5s", grafo.getVertices()[i]);
            for (int j = 0; j < grafo.getVertices().length; j++) {
                if (matriz[i][j] == grafo.getMax()) {
                    System.out.print("∞");
                } else {
                    System.out.printf("%5d", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
}
