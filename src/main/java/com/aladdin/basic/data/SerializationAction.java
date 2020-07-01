package com.aladdin.basic.data;

import org.springframework.util.SerializationUtils;

import java.io.*;

/**
 * todo protobuf
 * @see <https://www.jianshu.com/p/a24c88c0526a>
 * 序列化  二进制 <-> object
 * @see Externalizable extends @linkSerializable 都是标示接口 优先级高于 transient
 * @author lgc
 * @commons-lang3 |org.springframework.util  SerializationUtils
 * 1.实现            1.Serializable   反射 不需要构造    需要   UID
 *                  2.Externalizable ⚠️ 需要无参构造函数 不需要 UID 较快
 *                  3.ObjectInputStream ObjectOutputStream
 * 2.部分属性序列化
 *  2.1 static    静态变量 反序列化是当前虚拟机变量值
 *  2.2 transient 瞬态变量 value null
 *  2.3 Implements Serializable
 *      override
 *          private void writeObject(ObjectOutputStream oos)
 *          private void readObject(ObjectInputStream ois)
 *  2.4 Implements Externalizable
 *
 *      override
 *         public void writeExternal(ObjectOutput out)
 *         public void readExternal(ObjectInput in)
 *
 * Java调用ObjectOutputStream类检查其是否有私有的，无返回值的writeObject方法，如果有，其会委托该方法进行对象序列化
 * InvalidClassException 重新设置UID
 */
public class SerializationAction {
    public static void main(String[] args) {
        Ser ser = new Ser("123", "456");
        SerAble serAble = new SerAble();
        serAble.setName("aa");
        serAble.setTel("123");
        serAble.setAddress("bj");
        byte[] serialize1 = SerializationUtils.serialize(serAble);
        byte[] serialize = SerializationUtils.serialize(ser);
        Ser deserialize = (Ser) SerializationUtils.deserialize(serialize);
        SerAble serAble1 = (SerAble) SerializationUtils.deserialize(serialize1);
        System.out.println(serAble1);
        System.out.println(deserialize);
    }

    static class Ser implements Externalizable {

        private static final long serialVersionUID = 7337878526417271163L;
        String name;
        transient String tel;

        @Override
        public String toString() {
            return "Ser{" +
                    "name='" + name + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }

        public Ser(String name, String tel) {
            this.name = name;
            this.tel = tel;
        }

        public Ser(String tel) {
            this.tel = tel;
        }

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

        public Ser() {
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(tel);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            tel = (String) in.readObject();
        }
    }

    static class SerAble implements Serializable {
        String name;
        String address;
        String tel;
        private static final long serialVersionUID = 6304621874148496717L;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            // oos.defaultWriteObject();
            oos.writeObject(name);
            oos.writeObject(address);
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            // ois.defaultReadObject();
            name = (String) ois.readObject();
            address = (String) ois.readObject();
        }

        @Override
        public String toString() {
            return "SerAble[" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", tel='" + tel + '\'' +
                    ']';
        }
    }
}
