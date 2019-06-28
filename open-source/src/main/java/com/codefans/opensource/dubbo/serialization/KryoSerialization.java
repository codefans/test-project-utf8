package com.codefans.opensource.dubbo.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * @author: codefans
 * @date: 2019-06-26 20:47
 */
public class KryoSerialization {

    public static byte[] kryoSerizlize(Object obj) {
        Kryo kryo = new Kryo();
        byte[] buffer = new byte[2048];
        try(
                Output output = new Output(buffer);
        ) {

            kryo.writeClassAndObject(output, obj);
            return output.toBytes();
        } catch (Exception e) {
        }
        return buffer;
    }

    static Kryo kryo = new Kryo();
    public static Object kryoUnSerizlize(byte[] src) {
        try(
                Input input = new Input(src);
        ){
            return kryo.readClassAndObject(input);
        }catch (Exception e) {
        }
        return kryo;
    }


}
