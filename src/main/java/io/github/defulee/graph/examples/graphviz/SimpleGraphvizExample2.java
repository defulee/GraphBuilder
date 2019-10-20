package io.github.defulee.graph.examples.graphviz;

import io.github.defulee.graph.graphviz.ArrowType;
import io.github.defulee.graph.graphviz.Color;
import io.github.defulee.graph.graphviz.Edge;
import io.github.defulee.graph.graphviz.Graphviz;
import io.github.defulee.graph.graphviz.Node;
import io.github.defulee.graph.graphviz.Shape;
import io.github.defulee.graph.graphviz.Style;

import java.util.Arrays;

/**
 * @author defu
 * @date 2019/10/20
 */
public class SimpleGraphvizExample2 {

    public static void main(String[] args) {
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
    }
}
