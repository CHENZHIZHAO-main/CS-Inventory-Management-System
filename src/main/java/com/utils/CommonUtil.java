package com.utils;

import java.lang.reflect.Method;
import java.util.*;
import java.io.*;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommonUtil {
	/**
     * 获取随机字符串
     *
     * @param num
     * @return
     */
    public static String getRandomString(Integer num) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

	/**
	 * 获取随机验证码
	 *
	 * @param num
	 * @return
	 */
	public static String getRandomNumber(Integer num) {
	    String base = "0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < num; i++) {
	        int number = random.nextInt(base.length());
	        sb.append(base.charAt(number));
	    }
	    return sb.toString();
	}

    public static String getCellValue(Cell cell) {
        String resultValue = "";
        // 判空
        if (Objects.isNull(cell)) {
            return resultValue;
        }

        DataFormatter formatter = new DataFormatter();
        // 创建公式求值器
        FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();

        // 拿到单元格Type
        int cellType = cell.getCellType();
        switch (cellType) {
            // 字符串Type
            case Cell.CELL_TYPE_STRING:
                resultValue = StringUtils.isEmpty(cell.getStringCellValue()) ? "" : cell.getStringCellValue().trim();
                break;
            // 计算公式
            case Cell.CELL_TYPE_FORMULA:
                resultValue = formatter.formatCellValue(cell, evaluator);
                break;
            // 布尔Type
            case Cell.CELL_TYPE_BOOLEAN:
                resultValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 数值Type
            case Cell.CELL_TYPE_NUMERIC:
                /**
                 * format 的值可能为以下这些 yyyyMMddHHmmss
                 * yyyy-MM-dd----- 14
                 * yyyyyearmmonthdday----- 31
                 * yyyyyearmmonth--------57
                 * mmonthdday  -----------58
                 * HH:mm-----------20
                 * h时mm分  --------- 32
                 */
                Object val = cell.getNumericCellValue();
                // POI Excel day期格式转换
                String formatDate = "";
                if (DateUtil.isCellDateFormatted(cell)) {
                    switch (cell.getCellStyle().getDataFormat()) {
                        case 14:
                            formatDate = "yyyy-MM-dd";
                            break;
                        case 20:
                            formatDate = "HH:mm";
                            break;
                        case 21:
                            formatDate = "HH:mm:ss";
                            break;
                        case 31:
                            formatDate = "yyyyyearMMmonthddday";
                            break;
                        case 32:
                            formatDate = "HH时mm分";
                            break;
                        case 33:
                            formatDate = "HH时mm分mm秒";
                            break;
                        case 57:
                            formatDate = "yyyyyearMMmonth";
                            break;
                        case 58:
                            formatDate = "MMmonthddday";
                            break;
                        case 176:
                            formatDate = "yyyy-MM-dd HH:mm:ss";
                            break;
                    }
                    if(!"".equals(formatDate)){
                        resultValue = new SimpleDateFormat(formatDate).format(DateUtil.getJavaDate((Double) val));
                    }
                }else{
                    resultValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                }
                break;
            // 取空串
            default:
                break;
        }
        return resultValue;
    }

    /**
     * 检查实体中SURE存在数组中的属性字段，并Back第一个匹配的属性的get方法的结果
     * @param entity 实体对象
     * @param fieldNames 属性字段名称数组
     * @return 第一个匹配的属性的get方法的结果，如果没有匹配则Backnull
     */
    public static Object getPropertyByFieldNames(Object entity, String... fieldNames) {
        if (entity == null || fieldNames == null) {
            return null;
        }
        Class<?> clazz = entity.getClass();
        for (String fieldName : fieldNames) {
            try {
                // 构造get方法名
                String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method method = clazz.getMethod(methodName);
                // 调用get方法并Back结果
                return method.invoke(entity);
            } catch (NoSuchMethodException e) {
                // get方法不存在，继续下一个字段
                continue;
            } catch (Exception e) {
                // 其他异常，打印堆栈信息
                e.printStackTrace();
                return null;
            }
        }
        // 没有找到匹配的字段
        return null;
    }

    /**
     * 解析Request parameters
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Map<String, Object> parseRequest(HttpServletRequest request) throws IOException {
        Map<String, Object> paramMap = new HashMap<>();

        // 判断Request method
        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method)) {
            // 解析 GET Request parameters
            Map<String, String[]> parameterMap = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                paramMap.put(entry.getKey(), entry.getValue()[0]);
            }
        } else if ("POST".equalsIgnoreCase(method)) {
            // 解析 POST Request parameters
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            if (sb.length() > 0) {
                @SuppressWarnings("unchecked")
                Map<String, Object> jsonMap = (new ObjectMapper()).readValue(sb.toString(), Map.class);
                paramMap.putAll(jsonMap);
            }
        }

        return paramMap;
    }







}
