package first.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

public class WebUtils {
    public static void copyParamTOBean(Map map, Object bean){
        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static int parseInt(String str,int defaultValue){
        return str==null?defaultValue:Integer.parseInt(str);
    }
    public static BigDecimal parseBigDecimal(String str,BigDecimal defaultValue){
        return str==null?defaultValue:new BigDecimal(str);
    }
}
