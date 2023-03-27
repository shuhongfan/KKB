//package com.kkb.designpatternprinciple.dependenceinversionprinciple;
//
//public class InversionDemo {
//
//    public static void main(String[] args) {
//
//        new Worker().getMessage(new WeChat());
//        new Worker().getMessage(new Message());
//        new Worker().getMessage(new DingDing());
//    }
//}
//
////案例演示 - 依赖倒转原则
//
////假设有这样一个场景 现在有一个工作人员，收发钉钉消息
//
////引入接口，制定消息的规范
//interface IMessage{
//
//    void SendMessage();
//}
//
//class Worker{
//
//    //公共的接收消息方法
//    public void getMessage(IMessage iMessage){
//
//        iMessage.SendMessage();
//
//    }
//}
//
////钉钉类
//class DingDing implements IMessage{
//
//    /*//发送消息
//    public void sendMessage(){
//        System.out.println("钉钉上，老板找你加班啦");
//    }
//*/
//    @Override
//    public void SendMessage() {
//        System.out.println("钉钉上，老板找你加班啦");
//    }
//}
//
////微信类
//class WeChat implements IMessage{
//
//    @Override
//    public void SendMessage() {
//        System.out.println("钉钉不会，老板给你打微信电话了");
//    }
//}
//
////短信类
//class Message implements IMessage{
//
//    @Override
//    public void SendMessage() {
//        //TODO...
//    }
//}