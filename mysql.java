package Electronicequipment;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mysql {
    private static Connection con;// 声明connection连接
    private static PreparedStatement psm;//声明预处理对象
    private static ResultSet res;//声明结果对象

    private static String url = "jdbc:mysql://localhost:3306/01_table?serverTimezone=UTC";//协议
    private static String user = "root";
    private static String password = "123456";

    List<String> content = new ArrayList<String>();//res写入文件


    public Connection getConnection() {
        // 加载数据库驱动 类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 通过url连接访问数据库
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    //查
    public void qureyData() {
        File file = new File("E:\\下载文件\\数据库\\out.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //sq语句
        String sql = "select * from electronic";
        try {
            //得到结果集
            psm = con.prepareStatement(sql);
            res = psm.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("设备编号") + " " + res.getString("名称")
                        + " " + res.getString("价格") + " " + res.getString("库存数量") +
                        " " + res.getString("生产地"));
                String a = res.getString("设备编号") + " " + res.getString("名称")
                        + " " + res.getString("价格") + " " + res.getString("库存数量") +
                        " " + res.getString("生产地") + "\n";
                content.add(a);
            }

            try {
                FileWriter fw = new FileWriter(file, false);
                for (String a : content) {
                    fw.write(a);
                    fw.flush();
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            res.close();
            psm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("每次查询自动写入");

    }

    //增
    public void addData(electronic electronic) {

        //sq语句
        String sql = "insert into electronic(设备编号, 名称, 价格, 库存数量, 生产地)values(?, ?, ?, ?, ?)";
        try {
            psm = con.prepareStatement(sql);
            psm.setString(1, electronic.getId());
            psm.setString(2, electronic.getName());
            psm.setString(3, electronic.getPrice());
            psm.setString(4, electronic.getNumber());
            psm.setString(5, electronic.getProplace());
            psm.executeUpdate();
            psm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    // 改
    public void updata(electronic electronic) {
        //sq语句
        String sql = "update electronic set 设备编号=?, 名称=?, 价格=? , 库存数量=?, 生产地=? where 名称=?";
        try {
            psm = con.prepareStatement(sql);
            psm.setString(1, electronic.getId());
            psm.setString(2, electronic.getName());
            psm.setString(3, electronic.getPrice());
            psm.setString(4, electronic.getNumber());
            psm.setString(5, electronic.getProplace());
            psm.setString(6, electronic.getName());
            psm.executeUpdate();
            psm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //删
    public void delete(String id) {
        //sq语句
        String sql = "delete from electronic where 设备编号=?";
        try {
            psm = con.prepareStatement(sql);
            psm.setString(1, id);
            psm.executeUpdate();
            psm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
