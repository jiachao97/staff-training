package com.jc.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

public class JsonSerializerConfig extends JsonSerializer<Double> {

    //处理Double数据
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (aDouble != null) {
            jsonGenerator.writeString(decimalFormat.format(aDouble));
        }
    }
}
