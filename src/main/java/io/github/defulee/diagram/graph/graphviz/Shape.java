package io.github.defulee.diagram.graph.graphviz;

/**
 * graphviz node shape
 *
 * @author defu
 * @date 2019/10/17
 * @see <a href="https://www.graphviz.org/doc/info/shapes.html">https://www.graphviz.org/doc/info/shapes.html</a>
 */
public enum Shape {
    CIRCLE,
    POLYGON,
    PARALLELOGRAM,
    OCTAGON,
    MDIAMOND,
    MSQUARE,
    SIGNATURE,
    ASSEMBLY,
    INSULATOR,
    NOVERHANG,
    THREE_POVERHANG,
    FIVE_POVERHANG,
    FOLDER,
    NOTE,
    TAB,
    MCIRCLE,
    INVHOUSE,
    HOUSE,
    HEXAGON,
    DOUBLE_OCTAGON,
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
