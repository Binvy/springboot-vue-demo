package com.binvi.springboot.demo03.alibaba;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/24 20:51
 */
public class ConfusingName {

    public int age;

    // 非setter/getter的参数名称，不允许与本类成员变量同名
    public void getData(String alibaba) {
        if (true) {
            final int money = 531;
            System.out.println(money);
        }

        for (int i = 0; i < 10; i++) {
            // 在同一方法体中，不允许与其他代码块中的money命名相同
            final int money = 615;
            System.out.println(money);
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.getData("alibaba");
    }

}

class Son extends ConfusingName {
    // 不允许与父类的成员变量名称相同
    public int age;
}
