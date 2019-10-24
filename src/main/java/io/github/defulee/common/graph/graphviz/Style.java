package io.github.defulee.common.graph.graphviz;

/**
 * graphviz node style
 *
 * @author defu
 * @date 2019/10/17
 * @see <a href="https://www.graphviz.org/doc/info/shapes.html">https://www.graphviz.org/doc/info/shapes.html</a>
 */
public enum Style {
    FILLED,
    INVISIBLE,
    DIAGONALS,
    ROUNDED,
    DASHED,
    DOTTED,
    SOLID,
    BOLD;

    @Override
    public String toString() {
        return value();
    }

    public String value() {
        return this.name().toLowerCase();
    }
}
