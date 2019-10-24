package io.github.defulee.common.graph.examples.graphviz;

import io.github.defulee.common.graph.graphviz.Color;
import io.github.defulee.common.graph.graphviz.Edge;
import io.github.defulee.common.graph.graphviz.Node;
import io.github.defulee.common.graph.graphviz.Shape;
import io.github.defulee.common.graph.graphviz.Style;
import io.github.defulee.common.graph.graphviz.ArrowType;
import io.github.defulee.common.graph.graphviz.Graphviz;

import java.util.Arrays;

/**
 * @author defu
 * @date 2019/10/20
 */
public class SimpleGraphvizExample {

    public static void main(String[] args) {
        Node nodeConfig = Node.builder().shape(Shape.RECTANGLE).styles(Arrays.asList(Style.FILLED, Style.ROUNDED)).color(Color.LIGHTBLUE).build();
        Edge edgeConfig = Edge.builder().color(Color.GREEN).arrowTail(ArrowType.NORMAL).build();

        Node startNode = Node.builder().name("START").shape(Shape.DOUBLE_CIRCLE).styles(Arrays.asList(Style.FILLED)).color(Color.LIGHTBLUE).build();
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
    }
}
