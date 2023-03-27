package com.kkb.designpatternprinciple.segregationprinciple;

public class SegregationDemo {
    public static void main(String[] args) {

        //水果店类
        new FruitShop().cutApple(new CookZhang());
        new FruitShop().cutTomato(new CookZhang());

        //蔬菜店类
        new VegetableShop().cutTomato(new CookLi());
        new VegetableShop().cutPotato(new CookLi());
    }
}

//示例接口隔离原则
// 将接口knife拆分为三个独立的接口
interface AppleKnife {
    //切苹果的能力
    void cutApple();

}

interface TomatoKinfe{
    //切番茄的能力
    void cutTomato();
}

interface PotatoKnife{
    //切土豆的能力
    void cutPotato();
}

//张厨师类
class CookZhang implements AppleKnife,TomatoKinfe {

    @Override
    public void cutApple() {
        System.out.println("张厨师正在切苹果");
    }

    @Override
    public void cutTomato() {
        System.out.println("张厨师正在切番茄");
    }


}

//李厨师类
class CookLi implements TomatoKinfe,PotatoKnife {


    @Override
    public void cutTomato() {
        System.out.println("李厨师正在切番茄");
    }

    @Override
    public void cutPotato() {
        System.out.println("李厨师正在切土豆");
    }
}

/*假设有这样一个案例场景，现在有一个接口knife，给定他有三个能力，可以切苹果，切番茄，切土豆，两个类张

厨师，李厨师分别具有这些能力，有一个水果店类，假设是需要张师傅来切苹果和切番茄，而另一个蔬菜店类需要

李师傅来切番茄和切土豆*/


//水果店类
class FruitShop {
    // 将接口类型作为参数传入
    public void cutApple(AppleKnife knife) {
        knife.cutApple();
    }

    public void cutTomato(TomatoKinfe knife) {
        knife.cutTomato();
    }
}

//蔬菜店类
class VegetableShop {

    public void cutTomato(TomatoKinfe knife) {
        knife.cutTomato();
    }

    public void cutPotato(PotatoKnife knife) {
        knife.cutPotato();
    }
}

