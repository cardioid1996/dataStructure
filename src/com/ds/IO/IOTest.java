package com.ds.IO;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {

    // 用NIO的buffer存取数据
    public static void bufferTest(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String s = "iolearning";
        byteBuffer.put(s.getBytes());
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));

        try (FileInputStream fileInputStream = new FileInputStream("/Users/luqian/Desktop/LAB/hello")) {
            FileChannel inchannel = fileInputStream.getChannel();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 递归打印文件
    public static void printFileRecursively(File file){
        if (file==null || !file.exists())
            return;
        if (!file.isDirectory()){
            System.out.println(file);
        }else{
            for (File f : file.listFiles()){
                printFileRecursively(f);
            }
        }
    }

    // 逐行输出文本文件
    public static void printTextLine(String filePath) throws Exception{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();   // 被包装的fileReader也会close
    }

    // test Serializable
    public static void serializaObject(String file) throws IOException, ClassNotFoundException{
        A a = new A(1, 2);

        // 序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();

        // 反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        A a1 = (A)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a1);
    }


    private static class A implements Serializable{
        private int x;
        private int y;

        public A(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return x + "," + y;
        }
    }


    public static void fastCopy(String src, String dist) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(src);
        FileOutputStream fileOutputStream = new FileOutputStream(dist);

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (inChannel.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
    }



    public static void main(String[] args) {
        try {
            serializaObject("/Users/luqian/Desktop/LAB/hello");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
