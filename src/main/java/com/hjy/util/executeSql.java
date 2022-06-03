package com.hjy.util;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class executeSql {
    public void run() throws SQLException, FileNotFoundException {
        //注册驱动程序
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //获得连接
        String mysqlUrl = "jdbc:mysql://localhost:3306/tice_test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "123456");
        System.out.println("Connection established......");
        //初始化脚本运行器
        ScriptRunner sr = new ScriptRunner(con);
        //创建阅读器对象
        Reader reader = new BufferedReader(new FileReader("D:\\program1\\test_tice\\src\\main\\java\\com\\hjy\\sql\\upgradeAnalyze.sql"));
        //运行脚本
        sr.runScript(reader);
    }

}
