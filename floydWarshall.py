import networkx as nx
from pprint import pprint
G = nx.DiGraph()

G.add_nodes_from(['A', 'B', 'C', 'D', 'E'])
G.add_weighted_edges_from([("A", "B", 3), ("A", "D", 7), ("B", "C", 1), ("C", "D", 2), ("D", "E", 3), ("E", "A", 4)])
fw = nx.floyd_warshall(G, weight='weight')
results = {a: dict(b) for a, b in fw.items()}
pprint(results)
pprint("Centro del grafo: " + str(nx.center(G)))