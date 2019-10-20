package io.github.defulee.graph.graphviz;

/**
 * @author defu
 * @date 2019/10/17
 */
public enum Dir {
    NONE,
    BOTH,
    FORWARD,
    BACK;

    public String getValue() {
        return this.name().toLowerCase().replaceAll("_", "");
    }

}
