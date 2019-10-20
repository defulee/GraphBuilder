package io.github.defulee.graph.graphviz;

/**
 * graphviz node style
 *
 * @author defu
 * @date 2019/10/17
 * @see <a href="https://www.graphviz.org/doc/info/shapes.html">https://www.graphviz.org/doc/info/shapes.html</a>
 */
public enum Style {
    filled,
    invisible,
    diagonals,
    rounded,
    dashed,
    dotted,
    solid,
    bold;

    @Override
    public String toString() {
        return render();
    }

    public String render() {
        return this.name().toLowerCase();
    }
}
