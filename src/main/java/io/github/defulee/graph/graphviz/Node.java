package io.github.defulee.graph.graphviz;

import com.google.common.base.Joiner;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * graphviz node
 *
 * @author defu
 * @date 2019/10/17
 */
@Data
@Builder
public class Node {
    private String name;
    private String label;
    private List<Style> styles;
    private Shape shape;
    private Color color;

    public Node() {
        this("node");
    }

    public Node(String name) {
        this(name, null);
    }

    public Node(String name, String label) {
        this(name, label, Collections.emptyList(), null, null);
    }

    public Node(String name, String label, Shape shape) {
        this(name, label, shape, null, null);
    }

    public Node(String name, String label, Color color) {
        this(name, label, null, color, null);
    }

    public Node(String name, String label, Style... styles) {
        this(name, label, null, null, styles);
    }

    public Node(String name, String label, Shape shape, Color color) {
        this(name, label, shape, color, null);
    }

    public Node(String name, String label, List<Style> styles, Shape shape, Color color) {
        this.name = name;
        this.label = label;
        if (CollectionUtils.isNotEmpty(styles)) {
            this.styles = styles;
        } else {
            this.styles = Collections.emptyList();
        }
        this.shape = shape;
        this.color = color;
    }

    public Node(String name, String label, Shape shape, Color color, Style... styles) {
        this.name = name;
        this.label = label;
        if (styles != null) {
            this.styles = Arrays.stream(styles).collect(Collectors.toList());
        } else {
            this.styles = Collections.emptyList();
        }
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String toString() {
        if (label == null && CollectionUtils.isEmpty(styles) && shape == null && color == null) {
            return String.format("%s;", name);
        }
        StringBuilder builder = new StringBuilder(name);
        builder.append(" [ ");
        if (label != null) {
            builder.append("label=\"").append(label).append("\", ");
        }
        if (shape != null) {
            builder.append(shape.render()).append(", ");
        }
        if (color != null) {
            builder.append(color.render()).append(", ");
        }
        if (CollectionUtils.isNotEmpty(styles)) {
            builder.append("style=\"").append(Joiner.on(",").skipNulls().join(styles)).append("\", ");
        }
        builder = builder.delete(builder.lastIndexOf(","), builder.length());
        return builder.append(" ];").toString();
    }
}
