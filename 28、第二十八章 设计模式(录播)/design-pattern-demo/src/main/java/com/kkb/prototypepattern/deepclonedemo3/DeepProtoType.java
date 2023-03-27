package com.kkb.prototypepattern.deepclonedemo3;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {

    public String name; //

    public DeepCloneableTarget deepCloneableTarget; //

    public DeepProtoType() {
        super();
    }

    //完成深拷贝
    //实现方式二:通过对象序列化的方式

    public Object deepClone(){

        //类需要实现序列化接口
        //创建流对象
        ByteArrayOutputStream bos  = null;
        ObjectOutputStream oos  = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        //序列化操作
        try {
            bos = new ByteArrayOutputStream();

            oos = new ObjectOutputStream(bos);

            oos.writeObject(this); //序列化

            //反序列化操作
            bis = new ByteArrayInputStream(bos.toByteArray());

            ois = new ObjectInputStream(bis);

            DeepProtoType deepProtoType = (DeepProtoType) ois.readObject();

            return deepProtoType; //输出

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //关闭流对象
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }


    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", deepCloneableTarget=" + deepCloneableTarget +
                '}';
    }
}
