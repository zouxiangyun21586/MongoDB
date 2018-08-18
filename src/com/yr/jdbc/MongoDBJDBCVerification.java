package com.yr.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * 单节点有验证连接
 * @author zxy-un
 * 
 * 2018年8月17日 下午2:54:13
 */
public class MongoDBJDBCVerification {  
    public static void main(String[] args){  
        try {  
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
            //ServerAddress()两个参数分别为 服务器地址 和 端口  
            ServerAddress serverAddress = new ServerAddress("192.168.1.130",20000);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
              
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
            MongoCredential credential = MongoCredential.createScramSha1Credential("zxy", "testaa", "123123".toCharArray());  
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
              
            //通过连接认证获取MongoDB连接  
            MongoClient mongoClient = new MongoClient(addrs,credentials);  
              
            //连接到数据库  
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");  
            System.out.println("Connect to database successfully");  
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }  
    }  
} 