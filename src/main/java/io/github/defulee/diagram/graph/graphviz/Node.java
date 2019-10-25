package io.github.defulee.diagram.graph.graphviz;

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
    private Color fillColor;
    private FixedSize fixedSize;
    /**
     * Width of node, in inches.
     */
    private Double width;
    /**
     * Height of node, in inches.
     */
    private Double height;


    public Node(String name) {
        this(name, null);
    }

    public Node(String name, String label) {
        this(name, label, Collections.emptyList(), null, null, null, null, null, null);
    }

    public Node(String name, String label, List<Style> styles, Shape shape, Color color, Color fillColor, FixedSize fixedSize, Double height,
                Double width) {
        this.name = name;
        this.label = label;
        if (CollectionUtils.isNotEmpty(styles)) {
            this.styles = styles;
        } else {
            this.styles = Collections.emptyList();
        }
        this.shape = shape;
        this.color = color;
        this.fillColor = fillColor;
        this.fixedSize = fixedSize;
        this.height = height;
        this.width = width;

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
        if (fixedSize != null) {
            builder.append(fixedSize.render()).append(", ");
        }
        if (height != null) {
            builder.append("height=").append(height).append(", ");
        }
        if (width != null) {
            builder.append("width=").append(width).append(", ");
        }
        if (color != null) {
            builder.append(color.render(false)).append(", ");
        }
        if (fillColor != null) {
            builder.append(fillColor.render(true)).append(", ");
        }
        if (CollectionUtils.isNotEmpty(styles)) {
            builder.append("style=\"").append(Joiner.on(",").skipNulls().join(styles)).append("\", ");
        }
        builder = builder.delete(builder.lastIndexOf(","), builder.length());
        return builder.append(" ];").toString();
    }
}
