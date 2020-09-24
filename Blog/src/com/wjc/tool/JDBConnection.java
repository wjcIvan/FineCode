package com.wjc.tool;

import java.sql.*;

public class JDBConnection {
    private final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_BlodMay";
    private final String userName = "sa";
    private final String password = "123456";
    private Connection con = null;
//ͨ�����췽���������ݿ�����
    static {
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance(); 
        } catch (Exception ex) {
            System.out.println("���ݿ����ʧ��");
        }
    }
//�������ݿ����� 
    public boolean creatConnection() {
        try {
            con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("creatConnectionError!");
        }
        return true;
    }
//�����ݿ�����ӡ��޸ĺ�ɾ���Ĳ���
    public boolean executeUpdate(String sql) {
         if (con == null) {
            creatConnection();
        }
        try {
            Statement stmt = con.createStatement();
            int iCount = stmt.executeUpdate(sql);
            System.out.println("�����ɹ�����Ӱ��ļ�¼��Ϊ" + String.valueOf(iCount));
		    return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
		    return false;
        }   
    }
//�����ݿ�Ĳ�ѯ����
    public ResultSet executeQuery(String sql) {
        ResultSet rs;
        try {
            if (con == null) {
                creatConnection();
            }
            Statement stmt = con.createStatement();
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("executeQueryError!");
            return null;
        }
        return rs;
    }


}
