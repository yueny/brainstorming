package com.yueny.brainstorming.status.stragy;

import com.yueny.brainstorming.status.IFactory;
import com.yueny.brainstorming.status.StatusFactory;
import com.yueny.brainstorming.status.hander.IHander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class InitStragy implements IStragy<StatusFactory> {
//    @Autowired
//    private ASerive  a;

    Random random = new Random();
    @Override
    public IFactory action(StatusFactory target, Object req) {
        IFactory next = null;

        if(random.nextInt()%3 == 0){
            next = target.next();
        }else if(random.nextInt()%3 == 1){
            next = target.next(new IHander<StatusFactory>() {
                @Override
                public StatusFactory hander(StatusFactory target) {
                    return StatusFactory.S.next();
                }
            });
        }else{
            next = target.next(new IHander<StatusFactory>() {
                @Override
                public StatusFactory hander(StatusFactory target) {
                    return StatusFactory.CANCEL.next();
                }
            });
        }

        System.out.println("新决策：" + target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());

        return next;
    }
}
