package Electronicequipment;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        electronic electronic = new electronic();
        mysql sq = new mysql();
        sq.getConnection();
        Scanner in = new Scanner(System.in);
        System.out.println("1-插入");
        System.out.println("2-查看所有结果并导出");
        System.out.println("3-修改电子设备信息");
        System.out.println("4-删除电子设备信息");
        System.out.println("5-退出");
//        int choose = Integer.parseInt(in.next());
        int choose = 1;
        while (choose <= 5 && choose > 0) {
            System.out.println("请选择并输入");
            choose = Integer.parseInt(in.next());
            if (choose == 1) {
                System.out.println("请输入要插入的电子设备信息(按照 编号 名称 价格 库存数量 生产地 输入)");
                String id = in.next();
                String name = in.next();
                String price = in.next();
                String number = in.next();
                String proplace = in.next();
                electronic.setId(id);
                electronic.setName(name);
                electronic.setPrice(price);
                electronic.setNumber(number);
                electronic.setProplace(proplace);
                sq.addData(electronic);
            } else if (choose == 2) {
                System.out.println("==================查看插入结果===========");
                sq.qureyData();
            } else if (choose == 3) {
                System.out.println("请输入要修改的电子设备信息(按照名称修改)=====================");
                String id1 = in.next();
                String name1 = in.next();
                String price1 = in.next();
                String number1 = in.next();
                String proplace1 = in.next();
                electronic.setId(id1);
                electronic.setName(name1);
                electronic.setPrice(price1);
                electronic.setNumber(number1);
                electronic.setProplace(proplace1);
                sq.updata(electronic);
            }
//            System.out.println("==================查看更新结果============");
//            sq.qureyData();
            else if(choose == 4){
                System.out.println("请输入要删除的电子设备编号=====================");
                String id2 = in.next();
                sq.delete(id2);
            }
            else {
                System.out.println("欢迎下次使用，程序已退出");
                break;
            }

        }
    }
}