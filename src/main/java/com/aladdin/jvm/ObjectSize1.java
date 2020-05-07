package com.aladdin.jvm;

/**
 * @author lgc
 */
public class ObjectSize1 {
    public static void main(String[] args) {
        // 12+15*8+
//        System.out.println(ClassLayout.parseInstance(new RhsPadding()).toPrintable());
        C c = new C();
        c.name="123";
        test(c);
    }

   static void test(C c) {
        C c1 = new C();
        c1.name = "c";
        c = c == null ? c1 : c;
        System.out.println(c);
    }
}


class C {
    String name;

    @Override
    public String toString() {
        return "C{" +
                "name='" + name + '\'' +
                '}';
    }
}

class LhsPadding {
    protected long p1, p2, p3, p4, p5, p6, p7;
}

class Value extends LhsPadding {
    protected volatile long value;
}

class RhsPadding extends Value {
    protected long p9, p10, p11, p12, p13, p14;
}
