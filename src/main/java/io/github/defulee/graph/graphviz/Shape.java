package io.github.defulee.graph.graphviz;

/**
 * graphviz node shape
 *
 * @author defu
 * @date 2019/10/17
 * @see <a href="https://www.graphviz.org/doc/info/shapes.html">https://www.graphviz.org/doc/info/shapes.html</a>
 */
public enum Shape {
    ELLIPSE,
    BOX,
    RECTANGLE,
    RECT,
    DOUBLE_CIRCLE,
    UNDERLINE,
    PLAIN,
    PLAINTEXT,
    DIAMOND,
    CYLINDER,
    COMPONENT,
    RARROW,
    LARROW;

    public String render() {
        return String.format("shape=\"%s\"", this.name().toLowerCase().replaceAll("_", ""));
    }
}
