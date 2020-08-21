package com.aladdin.basic.data;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * @author lgc
 **/
public class LocalDateDemo {

    public static void main(String[] args) {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        //构造指定的年月日
        System.out.println(LocalDate.of(2019, 9, 10));
        //获取年月星期

        System.out.println(localDate.getYear());
        System.out.println(localDate.get(ChronoField.YEAR));
        System.out.println(localDate.getMonth());
        System.out.println(localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH));
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
        //时分秒
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime nowTime = LocalTime.now();

        //获取小时
        System.out.println(nowTime.getHour());
        System.out.println(nowTime.get(ChronoField.HOUR_OF_DAY));
        //获取分
        System.out.println(nowTime.getMinute());
        System.out.println(nowTime.get(ChronoField.MINUTE_OF_HOUR));
        //获取秒
        System.out.println(nowTime.getSecond());
        System.out.println(nowTime.get(ChronoField.SECOND_OF_MINUTE));

        System.out.println("--------");
        //年月日 是分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);
        System.out.println(localDateTime4);
        System.out.println("----转换---");
        LocalDate localDate2 = localDateTime.toLocalDate();
        LocalTime localTime2 = localDateTime.toLocalTime();
        System.out.println(localDate2);
        System.out.println(localTime2);

        //秒
        Instant instant = Instant.now();
        long currentSecond = instant.getEpochSecond();
        long currentMilli = instant.toEpochMilli();
        System.out.println(currentSecond);
        System.out.println(currentMilli);
    }

    static void test() {
        //LocalDate、LocalTime、LocalDateTime、Instant为不可变对象，修改这些对象对象会返回一个副本
        //增加、减少年数、月数、天数等 以LocalDateTime为例
        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        //增加一年
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        //减少一个月
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);
        //通过with修改某些值

        //修改年为2019
        localDateTime = localDateTime.withYear(2020);
        //修改为2022
        localDateTime = localDateTime.with(ChronoField.YEAR, 2022);
        //还可以修改月、日 时间计算

        //比如有些时候想知道这个月的最后一天是几号、下个周末是几号，通过提供的时间和日期API可以很快得到答案
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.with(firstDayOfYear());
        //比如通过firstDayOfYear()返回了当前日期的第一天日期，还有很多方法这里不在举例说明
    }

    static void test1() {
        //格式化时间
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);
        //DateTimeFormatter默认提供了多种格式化方式，如果默认提供的不能满足要求，

        //可以通过DateTimeFormatter的ofPattern方法创建自定义格式化方式

        //解析时间
        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
