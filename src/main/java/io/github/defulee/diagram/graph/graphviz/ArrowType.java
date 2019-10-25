package io.github.defulee.diagram.graph.graphviz;

/**
 * @author defu
 * @date 2019/10/17
 */
public enum ArrowType {
    NORMAL,
    NONE;

    public String render(String type) {
        return String.format("%s=\"%s\"", type, this.name().toLowerCase());
    }

}
