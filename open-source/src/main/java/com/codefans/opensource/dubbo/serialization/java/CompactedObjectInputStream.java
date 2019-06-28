/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codefans.opensource.dubbo.serialization.java;

import java.io.*;

public class CompactedObjectInputStream extends ObjectInputStream {
    private ClassLoader mClassLoader;

    public CompactedObjectInputStream(InputStream in) throws IOException {
        this(in, Thread.currentThread().getContextClassLoader());
    }

    public CompactedObjectInputStream(InputStream in, ClassLoader cl) throws IOException {
        super(in);
        mClassLoader = cl == null ? getClassLoader() : cl;
    }

    @Override
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        int type = read();
        if (type < 0)
            throw new EOFException();
        switch (type) {
            case 0:
                return super.readClassDescriptor();
            case 1:
                Class<?> clazz = loadClass(readUTF());
                return ObjectStreamClass.lookup(clazz);
            default:
                throw new StreamCorruptedException("Unexpected class descriptor type: " + type);
        }
    }

    private Class<?> loadClass(String className) throws ClassNotFoundException {
        return mClassLoader.loadClass(className);
    }

    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable var4) {
        }

        if (cl == null) {
            cl = clazz.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable var3) {
                }
            }
        }

        return cl;
    }

    public static ClassLoader getClassLoader() {
        return getClassLoader(CompactedObjectInputStream.class);
    }
}