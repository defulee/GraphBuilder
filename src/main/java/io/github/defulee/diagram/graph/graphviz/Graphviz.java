package io.github.defulee.diagram.graph.graphviz;

import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author defu
 * @description: 生成GraphViz图形源码的工具
 * @date 2019/10/17
 */
public class Graphviz {
    private String name;
    private Node nodeConfig;
    private Edge edgeConfig;
    private List<Node> nodes;
    private List<Edge> edges;

    public Graphviz(String name) {
        this.name = name;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }


    public static Graphviz of(String name) {
        return new Graphviz(name);
    }

    public Graphviz config(Node node) {
        this.nodeConfig = node;
        this.nodeConfig.setName("node");
        return this;
    }

    public Graphviz config(Edge edge) {
        this.edgeConfig = edge;
        this.edgeConfig.setName("edge");
        return this;
    }

    public Graphviz addNode(Node node) {
        this.nodes.add(node);
        return this;
    }

    public Graphviz addEdge(Edge edge) {
        this.edges.add(edge);
        return this;
    }

    public Graphviz addEdge(String srcNodeName, String dstNodeName, String label) {
        this.edges.add(new Edge(new Node(srcNodeName), new Node(dstNodeName), label));
        return this;
    }

    public String build() {
        return toString();
    }

    public String render() {
        if (name == null || name.isEmpty()) {
            return "";
        }
        String ln = System.lineSeparator();
        StringBuilder builder = new StringBuilder("digraph ");
        builder.append(name).append(" {").append(ln);
        if (nodeConfig != null) {
            builder.append("\t").append(nodeConfig.toString()).append(ln);
        }
        if (edgeConfig != null) {
            builder.append("\t").append(edgeConfig.toString()).append(ln);
        }
        if (CollectionUtils.isNotEmpty(nodes)) {
            for (Node node : nodes) {
                builder.append("\t").append(node.toString()).append(ln);
            }
        }
        if (CollectionUtils.isNotEmpty(edges)) {
            for (Edge edge : edges) {
                builder.append("\t").append(edge.toString()).append(ln);
            }
        }
        return builder.append("}").toString();
    }

    public File render(String outputFilePath) throws IOException {
        String content = render();
        return toFile(content, new File(outputFilePath));
    }

    private File toFile(String content, File target) throws IOException {
        Files.createDirectories(target.getAbsoluteFile().getParentFile().toPath());

        try (final Writer out = new OutputStreamWriter(new FileOutputStream(target), UTF_8)) {
            out.write(content);
        }

        return target;
    }

    @Override
    public String toString() {
        return render();
    }

}
