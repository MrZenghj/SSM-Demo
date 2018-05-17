package com.protobuff.util;

import java.io.IOException;

/**
 * protoc.exe
 * @author snipe
 *
 */
public class GenerateClass {
    public static void main(String[] args) {
        String protoFile = "person-entity.proto";//
        //protoc.exe -I=proto的输入目录 --java_out=java类输出目录 proto的输入目录包括包括proto文件
        String strCmd = "D:/javaSof/protobuf-master/src/protoc.exe " +  //java编译路径
                "-I=F:/idea-wordspace/SSM-Demo/src/main/java/com/protobuff/proto " +  //输入的目录
                "--java_out=F:/idea-wordspace/SSM-Demo/src/main/java/com/protobuff/proto " + //输出的目录
                "F:/idea-wordspace/SSM-Demo/src/main/java/com/protobuff/proto/person-entity.proto"; //输入的文件目录
        try {
            Runtime.getRuntime().exec(strCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序
    }
}
