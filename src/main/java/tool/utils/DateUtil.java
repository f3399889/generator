package tool.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

public class DateUtil {
	
	public static final SimpleDateFormat	yMdDateFormat		= new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat	yMdhmsDateFormat	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat	yMdhmDateFormat		= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat	sdf					= new SimpleDateFormat("yyMMddhhmmssSSS");
	public static final SimpleDateFormat	ymdSdf				= new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat	hmSdf				= new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat	ymdhmssdf			= new SimpleDateFormat("yyyyMMddHHmmss");
	
	
	public final static Date getDateYMD(String date) {
		try{
			return yMdDateFormat.parse(date);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public final static Date getDateYMD(String date, String sdf) {
		SimpleDateFormat formatter = new SimpleDateFormat(sdf);
		try{
			return formatter.parse(date);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public final static Date getDateHM(String date) {
		try{
			return hmSdf.parse(date);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public final static Date getDateYMDHMS(String date) {
		try{
			return yMdhmsDateFormat.parse(date);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public final static Date getDateYMDHM(String date) {
		try{
			return yMdhmDateFormat.parse(date);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public final static String getYMD4Date(Date date) {
		return yMdDateFormat.format(date);
	}
	
	
	public final static String getYMDHMS4Date(Date date) {
		return yMdhmsDateFormat.format(date);
	}
	
	
	public final static String getYMDHM4Date(Date date) {
		return yMdhmDateFormat.format(date);
	}
	
	
	public final static String getHM4Date(Date date) {
		return hmSdf.format(date);
	}
	
	
	public static String getDateTime() {
		Date date = new Date();
		return yMdhmsDateFormat.format(date);
	}
	
	
	public static String getDateTime2() {
		Date date = new Date();
		return sdf.format(date);
	}
	
	
	public static Date getNow() {
		return new Date();
	}
	
	
	public static int getYear() {
		Calendar sysDate = Calendar.getInstance();
		return sysDate.get(Calendar.YEAR);
	}
	
	
	public static int getYear(Date date) {
		Calendar sysDate = Calendar.getInstance();
		sysDate.setTime(date);
		return sysDate.get(Calendar.YEAR);
	}
	
	
	public static int getMonth() {
		Calendar sysDate = Calendar.getInstance();
		return sysDate.get(Calendar.MONTH) + 1;
	}
	
	
	public static int getMonth(Date date) {
		Calendar sysDate = Calendar.getInstance();
		sysDate.setTime(date);
		return sysDate.get(Calendar.MONTH) + 1;
	}
	
	
	public static int getDay(Date date) {
		Calendar sysDate = Calendar.getInstance();
		sysDate.setTime(date);
		return sysDate.get(Calendar.DAY_OF_MONTH);
	}
	
	
	public static int getHour(Date date) {
		Calendar sysDate = Calendar.getInstance();
		sysDate.setTime(date);
		return sysDate.get(Calendar.HOUR_OF_DAY);
	}
	
	
	public static int getMin(Date date) {
		Calendar sysDate = Calendar.getInstance();
		sysDate.setTime(date);
		return sysDate.get(Calendar.MINUTE);
	}
	
	
	public static String getYmd() {
		Date date = new Date();
		return ymdSdf.format(date);
	}
	
	
	public static String getYmdhms() {
		Date date = new Date();
		return ymdhmssdf.format(date);
	}
	
	
	public static long getUnixDate(String date) {
		try{
			return (ymdhmssdf.parse(date).getTime() / 1000);
		} catch (ParseException e){
			return 0;
		}
	}
	
	
	public static long getUnixDate(String date, SimpleDateFormat format) {
		try{
			return format.parse(date).getTime();
		} catch (ParseException e){
			return 0;
		}
	}
	
	
	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}
	
	
	/**
	 * 
	 * @Title: getDayOfBegin
	 * @Description: 获取0：00：00
	 * @param date
	 * @param num
	 * @return
	 * @createdBy:Luomingguo
	 * @createaAt:2016年1月26日上午11:23:51
	 */
	public static Date getDayOfBegin(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date = calendar.getTime();
		return date;
	}
	
	
	/**
	 * 
	 * @Title: getDayOfEnd
	 * @Description: 获取23:59:59
	 * @param date
	 * @param num
	 * @return
	 * @createdBy:Luomingguo
	 * @createaAt:2016年1月26日上午11:23:51
	 */
	public static Date getDayOfEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		date = calendar.getTime();
		return date;
	}
	
	
	/**
	 * @Title: diffMinuts
	 * @Description: TODO
	 * @param dateStart
	 * @param dateStop
	 * @return
	 * @createdBy:Luomingguo
	 * @createaAt:2015年11月19日下午3:34:48
	 */
	public static int diffMinuts(Date dateStart, Date dateStop) {
		try{
			
			DateTime dt1 = new DateTime(dateStart);
			DateTime dt2 = new DateTime(dateStop);
			return Minutes.minutesBetween(dt1, dt2).getMinutes();
		} catch (Exception e){
			return 0;
		}
	}

	
	public static Date getOtherDay(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, num);
		date = calendar.getTime();
		return date;
	}
	
	
	public static Date getPutOffMinuteDate(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, num);
		date = calendar.getTime();
		return date;
	}
	
	
	public static Date getDateByLongMillons(Long millons) {
		Date date = new Date(millons);
		return date;
	}
	
	
	public static Boolean compareDate(Date startDate, Date endDate) {
		Long startMillons = startDate.getTime();
		Long endMillons = endDate.getTime();
		if (startMillons > endMillons){
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(getYmdhms());
		Date date1 = new Date();
		
		int s = diffMinuts(date, date1);
		System.out.println(s);
	}
	
	
	/**
	 * String 类型时间 截取时分秒 Such as yyyy-MM-dd HH:mm:ss 截取后就是 yyyy-MM-dd
	 * 
	 * @param sourceDate
	 * @return
	 */
	public static String subHDS(String sourceDate) {
		Date resultDate = DateUtil.getDateYMD(sourceDate);
		sourceDate = DateUtil.getYMD4Date(resultDate);
		return sourceDate;
	}
	
	
	/**
	 * @Title: diffDays
	 * @Description: 判断时间差是否在？天之内
	 * @param dateStart
	 *            开始时间
	 * @param dateStop
	 *            结束时间
	 * @param day
	 *            天数
	 * @return
	 * @createdBy:xiewenjian
	 * @createaAt:2018年9月25日上午11:24:33
	 */
	public static boolean diffWithinDays(Date dateStart, Date dateStop, int day) {
		try{
			
			// DateTime dt1 = new DateTime(dateStart);
			// DateTime dt2 = new DateTime(dateStop);
			// int days = Days.daysBetween(dt1, dt2).getDays();
			Long diff = (long) (1000 * 60 * 60 * 24 * day);
			if ((dateStop.getTime() - dateStart.getTime()) > diff){
				return false;
			}
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
}
