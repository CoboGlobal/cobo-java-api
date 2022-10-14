package com.cobo.custody.api.client.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * 用 Java 实现 Python json.dumps()
 * <p>
 * Python json.dumps(obj, sort_keys=True, ensure_ascii=True)
 * <p>
 * If ``ensure_ascii`` is false, then the return value can contain non-ASCII
 * characters if they appear in strings contained in ``obj``. Otherwise, all
 * such characters are escaped in JSON strings.
 *
 * copy by @author CorningSun
 */
public class JavaJsonDumps {

    /**
     * 非 ascii 的全部转换
     */
    private static final LowerUnicodeEscaper LOWER_UNICODE_ESCAPER = LowerUnicodeEscaper.outsideOf((int) '\u0000', (int) '\u007F');

    /**
     * 转换 Java 对象为 Json 字符串
     * <p>
     * 忽略空字段
     * 日期格式化
     * 按字段排序
     * 符号后加空格
     */
    private static final ObjectWriter JSON_WRITER = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
            .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
            .writer(new JsonPrettyPrinter());

    /**
     * 用 Java 实现 python json.dumps(obj, sort_keys=True, ensure_ascii=True)
     *
     * @param obj Java 对象
     * @return
     * @throws JsonProcessingException
     */
    public static String dumps(Object obj) throws JsonProcessingException {
        String jsonString = JSON_WRITER.writeValueAsString(obj);

        return LOWER_UNICODE_ESCAPER.translate(jsonString);
    }
}
