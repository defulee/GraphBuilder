package io.github.defulee.diagram.graph.graphviz;

import com.google.common.base.Joiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author defu
 * @date 2019/10/17
 */
@Data
@Builder
@AllArgsConstructor
public class Edge {
    private String name;
    private Node src;
    private Node dst;
    private String label;
    private ArrowType arrowHead;
    private ArrowType arrowTail;
    private Color color;
    private List<Style> styles;

    public Edge(Node src, Node dst) {
        this(src, dst, null);
    }

    public Edge(Node src, Node dst, String label) {
        this(src, dst, label, null, null, null);
    }

    public Edge(Node src, Node dst, String label, ArrowType arrowTail, Color color, Style... styles) {
        this.src = src;
        this.dst = dst;
        this.label = label;
        if (styles != null) {
            this.styles = Arrays.stream(styles).collect(Collectors.toList());
        } else {
            this.styles = Collections.emptyList();
        }
        this.arrowTail = arrowTail;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (src != null && dst != null) {
            //正常的边关系
            builder.append(src.getName()).append("->").append(dst.getName());
        } else if (name != null) {
            //边配置时
            builder.append(name);
        }
        if (label == null && CollectionUtils.isEmpty(styles) && arrowHead == null && arrowTail == null && color == null) {
            return builder.append(";").toString();
        }
        builder.append(" [ ");
        if (label != null) {
            builder.append("label=\"").append(label).append("\", ");
        }
        if (arrowHead != null) {
            builder.append(arrowHead.render("arrowhead")).append(", ");
        }
        if (arrowTail != null) {
            builder.append(arrowTail.render("arrowtail")).append(", ");
        }
        if (color != null) {
            builder.append(color.render(false)).append(", ");
        }
        if (CollectionUtils.isNotEmpty(styles)) {
            builder.append("style=\"").append(Joiner.on(",").skipNulls().join(styles)).append("\", ");
        }
        builder = builder.delete(builder.lastIndexOf(","), builder.length());
        return builder.append(" ];").toString();

    }
}
