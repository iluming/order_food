package com.lsc.order.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description
 *              <li>日期工具类
 *              <li>{@docRoot java.util.Calendar}
 *              </ul>
 * @className DateTimeUtils
 * @package com.btc.microservice.common.utils
 * @createdTime 2016年8月20日 下午10:17:40
 *
 * @version V1.0.0
 */
public class DateTimeUtils
{
 
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
 
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd";
 
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
 
	public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
	public static final SimpleDateFormat UPPER_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
 
	public static final SimpleDateFormat LOWER_TIME_FORMAT = new SimpleDateFormat("hh:mm:ss");
 
	public static final SimpleDateFormat CHAR_TIME_FORMAT = new SimpleDateFormat("hh小时mm分ss秒");
 
	public static final int DAYS_OF_ONE_WEEK = 7;

	/**
	 *
	 * @return
	 */
	public static String nowTime(){
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		return dateFormat.format(calendar.getTime());
	}
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getEndOfDay
	 *        <ul>
	 * @description
	 *              <li>获得某天最大时间 yyyy-MM-dd 23:59:59
	 *              </ul>
	 * @createdTime 2016年8月20日 下午10:18:19
	 * @param date
	 * @return
	 * @return String
	 *
	 * @version : V1.0.0
	 */
	public static String getEndOfDay(Date date)
	{
		// 获取本地标准时间（本地默认的时区时间）
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),
				ZoneId.systemDefault());
		LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		Date from = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
		String strDete = DateTimeUtils.DATE_TIME_FORMAT.format(from);
		return strDete;
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getWhicthDay
	 *        <ul>
	 * @description
	 *              <li>获取当前日期是一周中的第几天、星期几
	 *              </ul>
	 * @createdTime 2016年8月20日 下午10:20:14
	 * @param today
	 * @return
	 * @return long
	 *
	 * @version : V1.0.0
	 */
	public static long getWeekDay(Date today)
	{
 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title daysBetweenWeeks
	 *        <ul>
	 * @description
	 *              <li>计算距离baseDate 若干天的 日期，例如：
	 *              <li>days=2 表示2天后的当前日期
	 *              <li>days=-1 表示一天前的当前日期
	 *              </ul>
	 * @createdTime 2016年8月20日 下午5:19:12
	 * @param baseDate
	 * @param days
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date daysBetweenWeeks(Date baseDate, int days)
	{
		Calendar calendar = Calendar.getInstance();
		if (baseDate != null)
		{
			calendar.setTime(baseDate);
		}
 
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title lastMonday
	 *        <ul>
	 * @description
	 *              <li>获取上周一的当前日期
	 *              </ul>
	 * @createdTime 2016年8月20日 下午5:21:12
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date lastMonday()
	{
		Date date = daysBetweenWeeks(null, -DAYS_OF_ONE_WEEK);
		return mondayOfThisWeek(date);
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title lastSunday
	 *        <ul>
	 * @description
	 *              <li>获取上周日的日期
	 *              </ul>
	 * @createdTime 2016年8月20日 下午5:23:15
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date lastSunday()
	{
		Date date = daysBetweenWeeks(null, -DAYS_OF_ONE_WEEK);
		return sundayOfThisWeek(date);
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title mondayOfThisWeek
	 *        <ul>
	 * @description
	 *              <li>获取某个日期对应的周一的当前日期
	 *              </ul>
	 * @createdTime 2016年8月21日 下午8:21:19
	 * @param date
	 *            如果日期为null的话，表示获取当前日期
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date mondayOfThisWeek(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		if (date != null)
		{
			calendar.setTime(date);
		}
		// 获取周一
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title sundayOfThisWeek
	 *        <ul>
	 * @description
	 *              <li>获取某个日期的 周日 日期
	 *              </ul>
	 * @createdTime 2016年8月21日 下午8:33:55
	 * @param date
	 *            <li>如果入参日期为 null 的话，表示获取当前日期的周日
	 *            <li>注意：日历获取的周期是 周日,1,2,3,4,5,6 不是中国传统的 1,2,3,4,5,6,周日 所以要加7
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date sundayOfThisWeek(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		if (date != null)
		{
			calendar.setTime(date);
		}
		// 获取周日
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 获取 中国意义上的 周日
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		if (getWeekDay(date) == 1)
		{
			calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - 8);
		}
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title stringToDate
	 *        <ul>
	 * @description 字符串转换为日期类型，时间格式：YYYY_MM_DD
	 *              </ul>
	 * @createdTime 2016年8月21日 下午8:49:53
	 * @param dateString
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date stringToDate(String str)
	{
 
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
			return sdf.parse(str);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title dateToString
	 *        <ul>
	 * @description 日期类型转换为字符串类型，字符串格式：YYYY_MM_DD
	 *              </ul>
	 * @createdTime 2016年8月21日 下午8:51:31
	 * @param date
	 * @return
	 * @return String
	 *
	 * @version : V1.0.0
	 */
	public static String dateToString(Date date)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
			return sdf.format(date);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return date.toString();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title timeToDate
	 *        <ul>
	 * @description 时间类型转换为日期类型，日期格式：YYYY:MM:DD hh:mm:ss --->YYYY:MM:DD
	 *              </ul>
	 * @createdTime 2016年8月21日 下午8:53:41
	 * @param date
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date timeToDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
		String str = sdf.format(date);
		try
		{
			return sdf.parse(str);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getThisWeekMonday
	 *        <ul>
	 * @description 获取某天当前周的周一的日期
	 *              </ul>
	 * @createdTime 2016年8月21日 下午8:58:15
	 * @param date
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date getThisWeekMonday(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 获得当前日期是一个星期的第几天
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek)
		{
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，当前日期减去 星期几与一个星期第一天的差值 即可计算当前周期第一天
		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title geLastWeekMonday
	 *        <ul>
	 * @description 获取某天上周一的日期
	 *              </ul>
	 * @createdTime 2016年8月21日 下午9:00:21
	 * @param date
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date geLastWeekMonday(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getThisWeekMonday(date));
		calendar.add(Calendar.DATE, -7);
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getNextWeekMonday
	 *        <ul>
	 * @description 获取某天下周一的日期
	 *              </ul>
	 * @createdTime 2016年8月21日 下午9:01:21
	 * @param date
	 * @return
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date getNextWeekMonday(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getThisWeekMonday(date));
		calendar.add(Calendar.DATE, 7);
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title addDay
	 *        <ul>
	 * @description
	 *              <li>获取某天的前/后几天的日期
	 *              </ul>
	 * @createdTime 2016年8月22日 上午10:15:51
	 * @param date
	 * @param day
	 *            <li>+ 表示获取往后多少天的日期
	 *            <li>- 表示获取往前多少天的日期
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date addDay(Date date, int day)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title addTime
	 *        <ul>
	 * @description 添加指定日期
	 *              </ul>
	 * @createdTime 2016年8月22日 上午10:21:30
	 * @param date
	 * @param time
	 *            <li>时间格式为： HH:mm:ss
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date addTime(Date date, String time)
	{
		if (StringUtils.isEmpty(time))
		{
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 先分别获取-> 时，分，秒 分别进行计算
		String[] times = time.split(":");
		int[] timeUnit =
		{ Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND };
		if (date != null)
		{
			for (int i = 0; i < times.length; i++)
			{
				calendar.add(timeUnit[i], Integer.valueOf(times[i]));
			}
		}
		return calendar.getTime();
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title plusDate
	 *        <ul>
	 * @description 多个日期时间相加的，获得总的时长
	 *              </ul>
	 * @createdTime 2016年8月22日 上午10:25:32
	 * @param dates
	 *            <li>日期集合
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public Date plusDate(List<Date> dates)
	{
		int hour = 0;
		int minute = 0;
		int second = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (Date date : dates)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			String str = sdf.format(date);
			String[] split = str.split(":");
			hour += Integer.parseInt(split[0]);
			minute += Integer.parseInt(split[1]);
			second += Integer.parseInt(split[2]);
		}
		Calendar instance = Calendar.getInstance();
		String s = simpleDateFormat.format(dates.get(0));
		String[] split = s.split("-");
		instance.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), hour, minute,
				second);
		return instance.getTime();
 
	}
 
	/**
	 * 获取初始化日期格式化
	 *
	 * @param day
	 *            :获取初始化日期格式化
	 */
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title dateFormatDate
	 *        <ul>
	 * @description 获取初始化日期格式化，格式：yyyy-MM-dd
	 *              </ul>
	 * @createdTime 2016年8月22日 上午10:39:28
	 * @param date
	 *            格式化的日期
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date dateFormatDate(Date date)
	{
		Date parse = null;
		try
		{
			String strDate = DATE_FORMAT.format(date);
			parse = DATE_FORMAT.parse(strDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return parse;
	}
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title dateFormatChar
	 *        <ul>
	 * @description 获取初始化日期格式化，格式：hh小时mm分ss秒
	 *              </ul>
	 * @createdTime 2016年8月22日 上午10:44:08
	 * @param date
	 *            格式化的日期
	 * @return Date
	 *
	 * @version : V1.0.0
	 */
	public static Date dateFormatChar(Date date)
	{
		Date parse = null;
		try
		{
			String strDate = CHAR_TIME_FORMAT.format(date);
			parse = CHAR_TIME_FORMAT.parse(strDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return parse;
	}
}
