package com.yueny.brainstorming.status.hander;

import com.yueny.brainstorming.status.ProcessStatus;

/**
 * 默认决策
 */
public class DefaultHander implements IHander<ProcessStatus> {
    @Override
    public ProcessStatus hander(ProcessStatus target) {
        // 终态， 返回自己
        if(target.nextOptions().isEmpty()){
            return target;
        }
        // 唯一的下一状态
        if(target.nextOptions().size() == 1){
            return target.nextOptions().get(0);
        }

        // 多个下一状态的时候，取值最近的一个进行跃迁。 目前是取绝对值最近的，可以更改为正相关和最近相关
        ProcessStatus min = null;
        for (ProcessStatus statusFactory: target.nextOptions()) {
            if(min == null){
                min = statusFactory;
                continue;
            }

            int val = Math.min(min.getWeight(), statusFactory.getWeight());
            if(min.getWeight() != val){
                min = statusFactory;
            }
        }
        return min;
    }

}
