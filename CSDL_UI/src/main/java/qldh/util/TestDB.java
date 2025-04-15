package qldh.util;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Kết nối thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
