package io.github.defulee.common.markdown;


import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;


/**
 * markdown 源码构建器
 *
 * @author defu
 * @date 2019/10/24
 */
public class MarkdownBuilder {

    private StringBuilder builder = new StringBuilder(1024);

    public MarkdownBuilder title(int level, String title) {
        if (level < 1) {
            level = 1;
        }
        if (level > 6) {
            level = 6;
        }
        ensureCapacity();
        builder.append(Strings.repeat("#", level)).append(' ').append(title);
        this.newLine();
        return this;
    }

    public MarkdownBuilder text(String text) {
        builder.append(text);
        return this;
    }

    public MarkdownBuilder ul(String element) {
        return ul(1, element);
    }

    public MarkdownBuilder ul(int ident, String element) {
        ensureCapacity();
        ident(ident);
        builder.append('*').append(' ').append(element);
        newLine();
        return this;
    }

    public MarkdownBuilder li(int n, String element) {
        return li(1, n, element);
    }

    public MarkdownBuilder li(int ident, int n, String element) {
        ensureCapacity();
        ident(ident);
        builder.append(n).append(' ').append(element);
        newLine();
        return this;
    }

    public MarkdownBuilder hr() {
        builder.append("-------");
        newLine();
        return this;
    }

    private void ident(int level) {
        builder.append(Strings.repeat(" ", level * 2));
    }

    public MarkdownBuilder append(MarkdownBuilder markdown) {
        builder.ensureCapacity(builder.capacity() + markdown.builder.capacity());
        builder.append(markdown.builder);
        return this;
    }

    public MarkdownBuilder newLine() {
        return newLine(1);
    }

    public MarkdownBuilder newLine(int n) {
        while (n-- > 0) {
            builder.append(System.lineSeparator());
        }
        return this;
    }

    public MarkdownBuilder tableHeader(Collection<String> headers) {
        if (CollectionUtils.isEmpty(headers)) {
            return this;
        }
        newLine();
        builder.append("| ").append(Joiner.on(" | ").join(headers)).append(" |");
        newLine();
        builder.append(Strings.repeat("|:---:", headers.size())).append("|");
        this.newLine();
        return this;
    }

    public MarkdownBuilder tableRow(Collection<String> headers) {
        if (CollectionUtils.isEmpty(headers)) {
            return this;
        }
        builder.append("| ").append(Joiner.on(" | ").join(headers)).append(" |");
        newLine();
        return this;
    }

    public MarkdownBuilder tableRowCol(String col, boolean startCol, boolean endCol) {
        builder.append(String.format("%s| ", startCol ? "" : " ")).append(col);
        if (endCol) {
            builder.append(" |");
            newLine();
        }
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    private void ensureCapacity() {
        if (builder.length() > builder.capacity()) {
            builder.ensureCapacity(builder.capacity() * 2);
        }
    }
}
