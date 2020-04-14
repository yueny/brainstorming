package com.yueny.brainstorming.status;


import com.yueny.brainstorming.status.hander.DefaultHander;
import com.yueny.brainstorming.status.hander.IHander;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 状态机工厂
 *           CANCEL  ---> OVER
 *             ∧
 *             |
 *             |
 *            SUP -----------
 *             ∧         |  |
 *             |         |  |
 *             ∨         ∨  |
 * INIT ---> HANDER ---> S  |
 *             |            |
 *             |            |
 *             ∨            |
 *            FAIL <---------
 */
public enum ProcessStatus implements IFactory, IFlower<ProcessStatus> {
    INIT(0){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Arrays.asList(HANDER);
        }
    },
    HANDER(16){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Arrays.asList(ProcessStatus.FAIL, ProcessStatus.SUP, ProcessStatus.S);
        }
    },
    SUP(22){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Arrays.asList(ProcessStatus.FAIL, ProcessStatus.HANDER,
                    ProcessStatus.CANCEL, ProcessStatus.S);
        }
    },
    CANCEL(38){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Arrays.asList(ProcessStatus.OVER);
        }
    },

    S(36){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Collections.emptyList();
        }
    },
    FAIL(38){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Collections.emptyList();
        }
    },
    OVER(38){
        @Override
        public final List<ProcessStatus> nextOptions() {
            return Collections.emptyList();
        }
    };

    ProcessStatus(int weight){
        this.weight = weight;
    }

    /**
     * 权重
     */
    int weight;


    @Override
    public final ProcessStatus next() {
        return next(new DefaultHander());
    }

    @Override
    public final ProcessStatus next(IHander<ProcessStatus> hander) {
        return next(this, hander);
    }

    @Override
    public ProcessStatus next(ProcessStatus target, IHander<ProcessStatus> hander) {
        // 终态， 返回自己
        if(target.nextOptions().isEmpty()){
           return target;
        }

        // 唯一的下一状态
        if(target.nextOptions().size() == 1){
            return target.nextOptions().get(0);
        }

        // 决策 TODO
        ProcessStatus next = hander.hander(target);
        if(next.getWeight() - target.getWeight() < 0 && Math.abs(next.getWeight() - target.getWeight()) > 8){
            // 允许跨界升值  next.getWeight() - target.getWeight() > 0
            // 降值跨度不允许大于 8

            // 此处是唯一返回空值的地方
            throw new IllegalArgumentException("不被允许的跃迁决策项：" + next + "， 当前值为：" + target);
        }

        return next;
    }

    /**
     * 取得枚举值
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public int getWeight() {
        return weight;
    }

}
