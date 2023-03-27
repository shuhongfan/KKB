package com.kkb.designpatternprinciple.opencloseprinciple.next;

//案例改进 - 使用开闭原则
public class OcpDemo {
    public static void main(String[] args) {

        new GraphicEditor().drawShape(new Circle());
        new GraphicEditor().drawShape(new Rectangle());
        new GraphicEditor().drawShape(new Triangle());
    }
}

//调用方
class GraphicEditor{

    public void drawShape(Shape shape){
        shape.draw();
    }
}

//抽象基类
abstract class Shape{

    int m_type;

    //抽象方法
    public abstract void draw();
}

//矩形类
class Rectangle extends Shape{


    @Override
    public void draw() {
        System.out.println("绘制矩形中 --- 绘制成功");
    }
}

//圆形类
class Circle extends Shape{


    @Override
    public void draw() {
        System.out.println("绘制圆形 --- 绘制成功");
    }
}

//三角形类
class Triangle extends Shape{


    @Override
    public void draw() {
        System.out.println("绘制三角形 --- 绘制成功");
    }
}