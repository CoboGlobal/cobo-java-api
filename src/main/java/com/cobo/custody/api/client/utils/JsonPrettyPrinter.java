package com.cobo.custody.api.client.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

import java.io.IOException;

/**
 * json 序列化时，在分隔符后加上空格
 *
 * copy by @author CorningSun
 */
public class JsonPrettyPrinter extends MinimalPrettyPrinter {

    @Override
    public void writeObjectFieldValueSeparator(JsonGenerator jg) throws IOException {
        writeSeparator(jg, ':');
    }

    @Override
    public void writeObjectEntrySeparator(JsonGenerator jg) throws IOException {
        writeSeparator(jg, ',');
    }

    @Override
    public void writeArrayValueSeparator(JsonGenerator jg) throws IOException {
        writeSeparator(jg, ',');
    }

    private void writeSeparator(JsonGenerator jg, char c) throws IOException {
        jg.writeRaw(c);
        jg.writeRaw(' ');
    }
}