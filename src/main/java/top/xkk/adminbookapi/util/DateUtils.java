package top.xkk.adminbookapi.util;

import java.util.Date;

public class DateUtils {
    // 24 * (differ / dayM) 这里拿到被舍弃的整数，整数是几，就代表相隔几天，一天24小时，那就整数乘以24即可。
    public static int getDifferHour(Date startDate, Date endDate) {
        long dayM = 1000 * 24 * 60 * 60;
        long hourM = 1000 * 60 * 60;
        long differ = endDate.getTime() - startDate.getTime();
        long hour = differ % dayM / hourM + 24 * (differ / dayM);
        return Integer.parseInt(String.valueOf(hour));
    }
}
