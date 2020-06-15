package com.aladdin.collection.stream;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lgc
 */
public class CreateStream {
    public static void main(String[] args) {
        List<Object> list = Lists.newArrayList();
        list.add("stream");
        String[] arr = {"s", "t", "r", "e", "a", "m"};
        /**
         * 1.创建 stream
         * 2.collection.stream()
         * 3.arr static method stream()
         * 4.static Of(value) 任意类型
         * 5.iterate()
         * 6.generator()
         */
        Stream<Object> listStream = list.stream();
        Stream<String> arrStream = Arrays.stream(arr);
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(5);
        Stream<String> limit1 = Stream.generate(() -> UUID.randomUUID().toString()).limit(10);
        /**
         * filter
         * distinct
         * limit
         * skip nullAble
         */
        ArrayList<Integer> integerArrayList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 8);
        integerArrayList.stream().
                filter(integer -> integer > 3).
                distinct().skip(1).limit(2).
                forEach(System.out::println);//5,6
        /**
         * map
         * mapToDouble
         * mapToInt
         * mapToLong
         * flatMap
         */
        MapStream mapStream = new MapStream();
        MapStream mapStream1 = new MapStream();
        mapStream.name = "123";
        mapStream1.name = "456";
        mapStream.tel = "123456";
        mapStream1.tel = "456678";
        ArrayList<MapStream> mapStreams = Lists.newArrayList(mapStream, mapStream1);
        List<String> collect = mapStreams.stream().map(ms -> "TEL:" + ms.tel).collect(Collectors.toList());
        System.out.println(collect);
        /**
         * sorted
         * sorted(comparator)
         */
        Map<String, String> convertMap = mapStreams.stream().
                collect(Collectors.toMap(MapStream::getTel, MapStream::getName));
        System.out.println(convertMap);
        /**
         * allMatch
         * anyMatch
         * noneMatch
         * findFirst
         * findAny
         * count
         * max
         * min
         */
//        boolean stream = listStream.allMatch(o -> o.equals("stream"));
//        System.out.println(stream);
//        boolean stream1 = listStream.anyMatch(o -> o.equals("stream"));
//        System.out.println(stream1);
//        boolean q = listStream.noneMatch(o -> o.equals("q"));
//        System.out.println(q);
//        System.out.println(listStream.findFirst().orElse("nil"));
        long count = listStream.count();
        System.out.println(Stream.of(1, 2, 3).max(Integer::compareTo).orElse(-1));
        System.out.println(Stream.of(1, 2, 3).min(Integer::compareTo).orElse(-1));
        IntSummaryStatistics summaryStatistics = Stream.of(5, 6, 7, 8).collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getSum());
        String collect1 = Stream.of("1", "2", "3", "4", "5").collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect1);
        /**
         * collect
         * toList
         */
        System.out.println("---collect---");
        List<Integer> collect3 = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        System.out.println(collect3);
        Set<Integer> collect4 = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet());
        System.out.println(collect4);
        ArrayList<Integer> collect2 = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect2);
        System.out.println((Long) Stream.of(1, 2, 3).count());
        System.out.println((Stream.of(1, 2, 3).max(Integer::compareTo)).orElse(-1));
        MapStream r = MapStream.of("1", "2");
        MapStream of = MapStream.of("2", "3");
//        System.out.println(Stream.of(1,2,3).collect(Collectors.maxBy(Comparator.comparingInt(Integer::intValue))));
//        System.out.println(Stream.of(r,of).collect(Collectors.maxBy(Comparator.comparing(MapStream::getTel))));
        System.out.println(Stream.of(r, of).max(Comparator.comparing(MapStream::getTel)));
        /**
         * reduce 规约
         * flatMap 合并流
         */
        System.out.println("---reduce---");
        Stream<MapStream> r1 = Stream.of(r, of);
        System.out.println(r1.map(MapStream::getTel).reduce((a, b) -> String.valueOf(Integer.parseInt(a) + Integer.parseInt(b))).orElse("-1"));
        System.out.println(Stream.of("helloflatmap").map(s -> s.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
        /**
         * group
         */
        System.out.println("---group---");
        Map<String, List<MapStream>> collect5 = Stream.of(r, of).collect(Collectors.groupingBy(m -> {
            if (Integer.parseInt(m.getTel()) > 1) return "a";
            if (Integer.parseInt(m.getTel()) >= 2) return "b";
            return "c";
        }));
        System.out.println(collect5);

        Map<Integer, Integer> collect6 = Stream.of(1, 2, 3, 4, 5, 5, 6).collect(Collectors.toMap(Integer::intValue, Function.identity(), (key1, key2) -> key2));
        System.out.println(collect6);

    }

    static class MapStream {

        String name;
        String tel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        static MapStream of(String tel, String name) {
            MapStream mapStream = new MapStream();
            mapStream.setName(name);
            mapStream.setTel(tel);
            return mapStream;
        }
    }
}
