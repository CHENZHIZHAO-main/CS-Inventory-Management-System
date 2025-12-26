package com.utils;

import cn.hutool.core.date.DateUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Map工具类
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }


    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) throws Exception {
        T obj = clazz.newInstance();
        for (Entry<String, Object> entry : map.entrySet()) {
            Field field = null;
            try {
                field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                if (field.getType() == Date.class && entry.getValue() != null) {
                    if (entry.getValue() instanceof Date) {
                        field.set(obj, entry.getValue());
                    } else {
                        field.set(obj, DateUtil.parseDate(entry.getValue().toString()));
                    }
                } else {
                    // 添加Type转换逻辑
                    Object value = convertValueToFieldType(entry.getValue(), field.getType());
                    field.set(obj, value);
                }
            } catch (NoSuchFieldException ignored) {
            } catch (Exception e) {
                // 记录转换错误但不中断流程
                System.err.println("字段 " + entry.getKey() + " Type转换错误: " + e.getMessage());
                // 可以选择设置为默认值或者null
                field.set(obj, null);
            }
        }
        return obj;
    }

    /**
     * 将值转换为目标字段Type
     *
     * @param value      原始值
     * @param targetType 目标Type
     * @return 转换后的值
     */
    private static Object convertValueToFieldType(Object value, Class<?> targetType) {
        if (value == null) {
            return null;
        }

        try {
            // 数值Type之间的转换
            if (value instanceof Number) {
                Number number = (Number) value;
                if (targetType == Integer.class || targetType == int.class) {
                    return number.intValue();
                } else if (targetType == Long.class || targetType == long.class) {
                    return number.longValue();
                } else if (targetType == Float.class || targetType == float.class) {
                    // 保留两位小数
                    return new BigDecimal(number.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                } else if (targetType == Double.class || targetType == double.class) {
                    // 保留两位小数
                    return new BigDecimal(number.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                } else if (targetType == Short.class || targetType == short.class) {
                    return number.shortValue();
                } else if (targetType == Byte.class || targetType == byte.class) {
                    return number.byteValue();
                } else if (targetType == BigDecimal.class) {
                    if (value instanceof BigDecimal) {
                        return ((BigDecimal) value).setScale(2, BigDecimal.ROUND_HALF_UP);
                    } else {
                        return new BigDecimal(number.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                } else if (targetType == BigInteger.class) {
                    if (value instanceof BigInteger) {
                        return value;
                    } else {
                        return BigInteger.valueOf(number.longValue());
                    }
                }
            }

            // 字符串到数值的转换
            if (value instanceof String) {
                String strValue = (String) value;
                if (strValue.isEmpty()) {
                    return getDefaultValueForType(targetType);
                }

                if (targetType == Integer.class || targetType == int.class) {
                    return Integer.parseInt(strValue);
                } else if (targetType == Long.class || targetType == long.class) {
                    return Long.parseLong(strValue);
                } else if (targetType == Float.class || targetType == float.class) {
                    // 保留两位小数
                    return new BigDecimal(strValue).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                } else if (targetType == Double.class || targetType == double.class) {
                    // 保留两位小数
                    return new BigDecimal(strValue).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                } else if (targetType == Short.class || targetType == short.class) {
                    return Short.parseShort(strValue);
                } else if (targetType == Byte.class || targetType == byte.class) {
                    return Byte.parseByte(strValue);
                } else if (targetType == BigDecimal.class) {
                    return new BigDecimal(strValue).setScale(2, BigDecimal.ROUND_HALF_UP);
                } else if (targetType == BigInteger.class) {
                    return new BigInteger(strValue);
                } else if (targetType == Boolean.class || targetType == boolean.class) {
                    return Boolean.parseBoolean(strValue);
                }
            }

            // BooleanType转换
            if (value instanceof Boolean) {
                Boolean boolValue = (Boolean) value;
                if (targetType == Boolean.class || targetType == boolean.class) {
                    return boolValue;
                } else if (targetType == String.class) {
                    return boolValue.toString();
                } else if (targetType == Integer.class || targetType == int.class) {
                    return boolValue ? 1 : 0;
                }
            }
        } catch (NumberFormatException e) {
            // 数值转换失败时Back默认值
            return getDefaultValueForType(targetType);
        }

        // 其他情况保持原样
        return value;
    }


    /**
     * 获取指定Type的默认值
     *
     * @param type Type
     * @return 默认值
     */
    private static Object getDefaultValueForType(Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return 0;
        } else if (type == long.class || type == Long.class) {
            return 0L;
        } else if (type == float.class || type == Float.class) {
            return 0.0f;
        } else if (type == double.class || type == Double.class) {
            return 0.0;
        } else if (type == short.class || type == Short.class) {
            return (short) 0;
        } else if (type == byte.class || type == Byte.class) {
            return (byte) 0;
        } else if (type == boolean.class || type == Boolean.class) {
            return false;
        } else {
            return null;
        }
    }

}

