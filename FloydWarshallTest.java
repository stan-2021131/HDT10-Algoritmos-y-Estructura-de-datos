import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FloydWarshallTest {
    private Grafo grafo;
    private FloydWarshall floyd;

    @BeforeEach
    public void setup() {
        String[] ciudades = {"A", "B", "C", "D", "E"};
        grafo = new Grafo(ciudades.length, ciudades);
        floyd = new FloydWarshall();

        grafo.agregarArista("A", "B", 3);
        grafo.agregarArista("A", "D", 7);
        grafo.agregarArista("B", "C", 1);
        grafo.agregarArista("C", "D", 2);
        grafo.agregarArista("D", "E", 3);
        grafo.agregarArista("E", "A", 4);
    }

    @Test
    public void testMatrizDeDistanciasCorrecta() {
        int[][] dist = floyd.floydWarshall(grafo);

        assertEquals(4, dist[0][2]);

        assertEquals(6, dist[0][3]);

        assertEquals(10, dist[4][3]);

        assertEquals(5, dist[2][4]);
    }

    @Test
    public void testCentroDelGrafo() {
        int[][] distancias = floyd.floydWarshall(grafo);
        String centro = floyd.calcularCentroGrafo(distancias, grafo);

        // El vértice con las rutas más cortas hacia los otros (el centro) debería ser "C"
        assertEquals("A", centro);
    }

    @Test
    public void testExcepcionVerticeInexistente() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            grafo.agregarArista("A", "Z", 10);
        });
        assertTrue(ex.getMessage().contains("Vertice no encontrado"));
    }
}
