package com.ohgiraffers.crud.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * JDBC 관련 코드들이 반복적으로 호출될 예정이므로 util용으로 JDBCTemplate클래스를 작성한다.
 * */
public class JDBCTemplate {

    public static Connection getConnection(){

        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader(
                    "src/main/java/com/ohgiraffers/crud/config/jdbc-info.properties"
            ));
            String url = prop.getProperty("url");
            con = DriverManager.getConnection(url, prop);

            // 자동 커밋 설정을 수동 커밋 설정으로 변경하여 서비스에서 트랜잭션을 컨트롤 할 수 있도록해준다.
            con.setAutoCommit(false);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    /* Connection을 닫는 개념은 별도의 메소드로 분리하고 실제 담는 시점은 Service 계층에서 진행 */
    public static void close(Connection con){
        try {
            if(con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){
        try {
            if(stmt != null && !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            if(rset != null && !rset.isClosed()) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con){
        try {
            if(con != null && !con.isClosed()) con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con){
        try {
            if(con != null && !con.isClosed()) con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
