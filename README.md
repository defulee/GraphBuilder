# GraphBuilder
build graphviz graph

# Usage
- use node & edge: 
```java
Node nodeConfig = Node.builder().shape(Shape.RECTANGLE).styles(Arrays.asList(Style.filled, Style.rounded)).color(Color.LIGHTBLUE).build();
Edge edgeConfig = Edge.builder().color(Color.GREEN).arrowTail(ArrowType.NORMAL).build();

Node startNode = Node.builder().name("START").shape(Shape.DOUBLE_CIRCLE).styles(Arrays.asList(Style.filled)).color(Color.LIGHTBLUE).build();
Node node1 = Node.builder().name("node1").label("node-1").build();
Node node2 = Node.builder().name("node2").label("node-2").build();
Node node3 = Node.builder().name("node3").label("node-3").shape(Shape.DIAMOND).build();
Node node4 = Node.builder().name("node4").label("node-4").build();
Node node5 = Node.builder().name("node5").label("node-5").build();

Graphviz graphViz = Graphviz.of("SimpleGraphvizExample");
graphViz.config(nodeConfig);
graphViz.config(edgeConfig);

graphViz.addNode(startNode);
graphViz.addNode(node1);
graphViz.addNode(node2);
graphViz.addNode(node3);
graphViz.addNode(node4);
graphViz.addNode(node5);

graphViz.addEdge(Edge.builder().src(startNode).dst(node1).build());
graphViz.addEdge(Edge.builder().src(node1).dst(node2).label("node1->node2").build());
graphViz.addEdge(Edge.builder().src(node1).dst(node3).label("node1->node3").build());
graphViz.addEdge(Edge.builder().src(node2).dst(node4).label("node2->node4").build());
graphViz.addEdge(Edge.builder().src(node2).dst(node5).label("node2->node5").build());
graphViz.addEdge(Edge.builder().src(node1).dst(node5).build());

System.out.println(graphViz.render());

```
output is:

```
digraph SimpleGraphvizExample {
	node [ shape="rectangle", color="lightblue", style="filled,rounded" ];
	edge [ arrowtail="normal", color="green" ];
	START [ shape="doublecircle", color="lightblue", style="filled" ];
	node1 [ label="node-1" ];
	node2 [ label="node-2" ];
	node3 [ label="node-3", shape="diamond" ];
	node4 [ label="node-4" ];
	node5 [ label="node-5" ];
	START->node1;
	node1->node2 [ label="node1->node2" ];
	node1->node3 [ label="node1->node3" ];
	node2->node4 [ label="node2->node4" ];
	node2->node5 [ label="node2->node5" ];
	node1->node5;
}
```

- use edge only:
```java
Node nodeConfig = Node.builder().shape(Shape.RECTANGLE).styles(Arrays.asList(Style.filled, Style.rounded)).color(Color.LIGHTBLUE).build();
Edge edgeConfig = Edge.builder().color(Color.GREEN).arrowTail(ArrowType.NORMAL).build();

Graphviz graphViz = Graphviz.of("SimpleGraphvizExample");
graphViz.config(nodeConfig);
graphViz.config(edgeConfig);


graphViz.addEdge("node1", "node2", "node1->node2");
graphViz.addEdge("node1", "node3", "node1->node3");
graphViz.addEdge("node2", "node4", "node2->node4");
graphViz.addEdge("node2", "node5", "node2->node5");
graphViz.addEdge("node1", "node5", "node1->node5");

System.out.println(graphViz.render());
```

output:
```
digraph SimpleGraphvizExample {
	node [ shape="rectangle", color="lightblue", style="filled,rounded" ];
	edge [ arrowtail="normal", color="green" ];
	node1->node2 [ label="node1->node2" ];
	node1->node3 [ label="node1->node3" ];
	node2->node4 [ label="node2->node4" ];
	node2->node5 [ label="node2->node5" ];
	node1->node5 [ label="node1->node5" ];
}

```

