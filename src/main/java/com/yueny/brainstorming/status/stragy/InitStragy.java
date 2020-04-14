package com.yueny.brainstorming.status.stragy;

import com.yueny.brainstorming.status.IFactory;
import com.yueny.brainstorming.status.ProcessStatus;
import com.yueny.brainstorming.status.hander.IHander;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class InitStragy implements IStragy<ProcessStatus> {
//    @Autowired
//    private ASerive  a;

    Random random = new Random();
    @Override
    public IFactory action(ProcessStatus target, Object req) {
        IFactory next = null;

        if(random.nextInt()%3 == 0){
            next = target.next();
        }else if(random.nextInt()%3 == 1){
            next = target.next(new IHander<ProcessStatus>() {
                @Override
                public ProcessStatus hander(ProcessStatus target) {
                    return ProcessStatus.S.next();
                }
            });
        }else{
            next = target.next(new IHander<ProcessStatus>() {
                @Override
                public ProcessStatus hander(ProcessStatus target) {
                    return ProcessStatus.CANCEL.next();
                }
            });
        }

        System.out.println("新决策：" + target.getWeight() + "-->" + next.getWeight());
        System.out.println(target.getName() + "-->" + next.getName());

        return next;
    }
}
