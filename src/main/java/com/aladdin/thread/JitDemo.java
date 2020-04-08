package com.aladdin.thread;

/**
 * JIT Just In Time Compiler
 * 热点代码即使编译机器语言提高效率
 * @author lgc
 **/
public class JitDemo {
    static volatile int i = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 1000000; j++) {
            m();
            n();
        }
    }

    static synchronized void m() {

    }

    static void n() {
        i = 1;
    }
}

