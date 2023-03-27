package com.kkb.designpatternprinciple.unifiedmodelinglanguage;


//案例演示 - 依赖关系的形式
/*public class PersonServiceBean {

    private PersonDao personDao; //类的成员属性

    public void save(Person person){  //方法的接收参数类型

    }

    public IDCard getIDCard(){  //方法的返回值类型

        return new IDCard();
    }

    public void modify(){

        //违反了迪米特法则 可以这样写，
        Department department = new Department(); //方法内部使用到
    }



}

class PersonDao{ }

class IDCard{ }

class Person{ }

class Department{ }*/


//案例演示 - 泛化关系
/*class PersonBean{

    public void save(){
        //TODO...
    }

    public void delete(){
        //TODO...
    }
}

public class PersonServiceBean extends PersonBean{


}*/



//案例演示 - 实现关系

/*interface PersonService{
    public void delete() {
        System.out.println("delete");
    }

    void delete();
}

public class PersonServiceBean implements PersonService{

    @Override
}*/


//案例演示 - 关联关系

//双向一对一
/*class Person{

    public IDCard idCard;
}

class IDCard{

    public Person person;

}*/


//案例演示 - 组合关系

class Person{

    public IDCard idCard; //聚合关系

    public Head head = new Head(); //组合关系

}

class IDCard{

}

class Head{

}













