package com.yueny.brainstorming.status;

import com.yueny.brainstorming.status.hander.IHander;
import com.yueny.brainstorming.status.stragy.InitStragy;

public class StatusFactoryMain {
    public static void main(String[] args) {
        StatusFactory target = StatusFactory.INIT;
        IFactory next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());

        target = StatusFactory.HANDER;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());


        target = StatusFactory.SUP;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());


        target = StatusFactory.CANCEL;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());
        target = StatusFactory.S;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());
        target = StatusFactory.FAIL;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());

        // 决策
        // 业务意义的字段和数据
        IHander<StatusFactory> hander = new IHander<StatusFactory>() {
            @Override
            public StatusFactory hander(StatusFactory target) {
//                target.nextOptions;
                return StatusFactory.S.next();
            }
        };

        target = StatusFactory.HANDER;
        next = target.next(hander);
        System.out.println("决策：" + target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());


        target = StatusFactory.SUP;
        for(int i=0; i<10; i++){
            InitStragy stragy = new InitStragy();
            stragy.action(target, null);
        }
    }
}
