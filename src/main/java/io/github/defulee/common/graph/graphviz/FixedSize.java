package io.github.defulee.common.graph.graphviz;

/**
 * @author defu
 * @date 2019/10/22
 */
public enum FixedSize {
    TRUE,
    FALSE,
    SHAPE;

    public String render() {
        return String.format("fixedsize=\"%s\"", this.name().toLowerCase());
    }

}
