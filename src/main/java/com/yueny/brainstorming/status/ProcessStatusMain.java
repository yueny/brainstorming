package com.yueny.brainstorming.status;

import com.yueny.brainstorming.status.hander.IHander;
import com.yueny.brainstorming.status.stragy.InitStragy;

public class ProcessStatusMain {
    public static void main(String[] args) {
        ProcessStatus target = ProcessStatus.INIT;
        IFactory next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());

        target = ProcessStatus.HANDER;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());


        target = ProcessStatus.SUP;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());


        target = ProcessStatus.CANCEL;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());
        target = ProcessStatus.S;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());
        target = ProcessStatus.FAIL;
        next = target.next();
        System.out.println(target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());

        // 决策
        // 业务意义的字段和数据
        IHander<ProcessStatus> hander = new IHander<ProcessStatus>() {
            @Override
            public ProcessStatus hander(ProcessStatus target) {
//                target.nextOptions;
                return ProcessStatus.S.next();
            }
        };

        target = ProcessStatus.HANDER;
        next = target.next(hander);
        System.out.println("决策：" + target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());


        target = ProcessStatus.SUP;
        for(int i=0; i<10; i++){
            InitStragy stragy = new InitStragy();
            stragy.action(target, null);
        }
    }
}
