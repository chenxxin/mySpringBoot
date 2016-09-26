package demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by CHENXINXIN on 2016/8/16.
 */
public class DoubleTest {

    /**
     * double 转 百分数
     * @throws Exception
     */
    @Test
    public void testPercent() throws Exception {
        double percent = 2 * 1.0 / 3; // 0.6666666666666666

        java.text.NumberFormat percentFormat =java.text.NumberFormat.getPercentInstance();
//        percentFormat.setMaximumFractionDigits(2); //最大小数位数  66.67%
//        percentFormat.setMaximumIntegerDigits(2);//最大整数位数  67%
//        percentFormat.setMinimumFractionDigits(3); //最小小数位数  66.667%
//        percentFormat.setMinimumIntegerDigits(3);//最小整数位数   067%
        String format = percentFormat.format(percent);//自动转换成百分比显示. 67%
    }

    /**
     * double科学计数法 转 正常格式
     * @throws Exception
     */
    @Test
    public void name() throws Exception {
        double num = 24.21d;
        System.out.println(num/1024);  // 1.7636684157142856E9
        String number = formatFloatNumber(num / 1024);
        if (StringUtils.startsWith(number,".")){
            number = "0"+number;
        }
        System.out.println(number);  // 1763668415.71
    }

    /**
     * 当浮点型数据位数超过10位之后，数据变成科学计数法显示。用此方法可以使其正常显示。
     * @param value 待转换的double
     * @return Sting
     */
    private String formatFloatNumber(double value) {
        if(value != 0.00){
            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
            return df.format(value);
        }else{
            return "0.00";
        }

    }
    private String formatFloatNumber(Double value) {
        if(value != null){
            if(value != 0.00){
                java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
                return df.format(value.doubleValue());
            }else{
                return "0.00";
            }
        }
        return "";
    }
}
