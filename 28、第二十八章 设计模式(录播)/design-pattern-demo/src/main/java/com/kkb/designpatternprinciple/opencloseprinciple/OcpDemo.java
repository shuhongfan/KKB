package com.kkb.designpatternprinciple.opencloseprinciple;

//案例演示 - 开闭原则
public class OcpDemo {
    public static void main(String[] args) {

        new GraphicEditor().drawShape(new Rectangle());
        new GraphicEditor().drawShape(new Circle());
        new GraphicEditor().drawShape(new Triangle());

    }
}

//需求：绘制三角形
// 用于绘图的类 [调用方]
class GraphicEditor {

    //按类型绘制图形
    public void drawShape(Shape s) {
        if (s.m_type == 1) {
            drawRectangle(s);
        } else if (s.m_type == 2) {
            drawCircle(s);
        } else if (s.m_type == 3){
            //绘制三角形
            drawTriangle(s);
        }
    }

    public void drawRectangle(Shape r) {

        System.out.println(" 正在绘制矩形中---绘制成功 ");

    }

    public void drawCircle(Shape r) {

        System.out.println(" 正在绘制圆形中---绘制成功");

    }

    public void drawTriangle(Shape r) {

        System.out.println(" 正在绘制三角形中---绘制成功");

    }
}

//形状基类
class Shape {

    int m_type;
}

class Rectangle extends Shape {

    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {

    Circle() {
        super.m_type = 2;
    }

}

//三角形类
class Triangle extends Shape{

    Triangle(){
        super.m_type = 3;
    }

}