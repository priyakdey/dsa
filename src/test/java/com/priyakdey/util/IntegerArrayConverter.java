package com.priyakdey.util;

import java.util.Objects;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 * @author Priyak Dey
 */
public class IntegerArrayConverter extends SimpleArgumentConverter {
    /**
     * Convert the supplied {@code source} object into the supplied
     * {@code targetType}.
     *
     * @param source     the source object to convert; may be {@code null}
     * @param targetType the target type the source object should be converted
     *                   into; never {@code null}
     * @return the converted object; may be {@code null} but only if the target
     * type is a reference type
     * @throws ArgumentConversionException in case an error occurs during the
     *                                     conversion
     */
    @Override
    protected Object convert(Object source, Class<?> targetType)
        throws ArgumentConversionException {
        if (source instanceof String s && Integer[].class.isAssignableFrom(targetType)) {

            if (Objects.equals("[]", s)) return new Integer[0];

            String[] parts = s.substring(1, s.length() - 1).split(",");
            Integer[] array = new Integer[parts.length];
            int cursor = 0;
            for (String part : parts) {
                try {
                    array[cursor++] = Integer.valueOf(part.trim());
                } catch (NumberFormatException e) {
                    throw new ArgumentConversionException(String.format("cannot convert %s to number", part));
                }
            }

            return array;
        } else {
            throw new ArgumentConversionException("unexpected data format");
        }
    }
}
