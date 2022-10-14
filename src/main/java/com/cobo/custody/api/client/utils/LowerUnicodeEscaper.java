package com.cobo.custody.api.client.utils;


import org.apache.commons.text.translate.UnicodeEscaper;

import java.io.IOException;
import java.io.Writer;

/**
 * python 序列化时，unicode 编码为小写
 * <p>
 * copy by @author CorningSun
 */
public class LowerUnicodeEscaper extends UnicodeEscaper {

    private static final char[] LOWER_HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private final int below;
    private final int above;
    private final boolean between;

    public LowerUnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    protected LowerUnicodeEscaper(final int below, final int above, final boolean between) {
        this.below = below;
        this.above = above;
        this.between = between;
    }

    public static UnicodeEscaper below(final int codepoint) {
        return outsideOf(codepoint, Integer.MAX_VALUE);
    }


    public static UnicodeEscaper above(final int codepoint) {
        return outsideOf(0, codepoint);
    }


    public static LowerUnicodeEscaper outsideOf(final int codepointLow, final int codepointHigh) {
        return new LowerUnicodeEscaper(codepointLow, codepointHigh, false);
    }

    public static LowerUnicodeEscaper between(final int codepointLow, final int codepointHigh) {
        return new LowerUnicodeEscaper(codepointLow, codepointHigh, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean translate(final int codepoint, final Writer out) throws IOException {
        if (between) {
            if (codepoint < below || codepoint > above) {
                return false;
            }
        } else {
            if (codepoint >= below && codepoint <= above) {
                return false;
            }
        }

        // Handle potential + sign per various Unicode escape implementations
        if (codepoint > 0xffff) {
            out.write(toUtf16Escape(codepoint));
        } else {
            out.write("\\u");
            out.write(LOWER_HEX_DIGITS[(codepoint >> 12) & 15]);
            out.write(LOWER_HEX_DIGITS[(codepoint >> 8) & 15]);
            out.write(LOWER_HEX_DIGITS[(codepoint >> 4) & 15]);
            out.write(LOWER_HEX_DIGITS[(codepoint) & 15]);
        }
        return true;
    }
}
