package com.aladdin.basic.data;

import org.springframework.util.SerializationUtils;

import java.io.*;
import java.util.Arrays;

/**
 * @commons-lang3 |org.springframework.util  SerializationUtils
 * @author lgc
 */
public class SerializationAction {
    public static void main(String[] args){
        Ser ser = new Ser("123","123");
        byte[] serialize = SerializationUtils.serialize(ser);
        System.out.println(Arrays.toString(serialize));
        Ser deserialize = (Ser) SerializationUtils.deserialize(serialize);
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
            tel= (String) in.readObject();
        }
    }
}
