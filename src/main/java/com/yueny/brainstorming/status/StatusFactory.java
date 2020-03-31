package com.yueny.brainstorming.status;


/**
 * 状态机工厂
 *           CANCEL
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
public enum StatusFactory implements IFactory, IFlower{
    INIT(0),
    HANDER(16),
    SUP(18),
    S(32),
    CANCEL(35),
    FAIL(38);

    StatusFactory(int weight){
        this.weight = weight;
    }

    /**
     * 权重
     */
    int weight;

    @Override
    public IFactory next(IHander hander) {
        return next(this, hander);
    }

    @Override
    public IFactory next(IFactory current, IHander hander) {
        IFactory next = hander.hander(current);

        if(next.getWeight() - current.getWeight() > 8){
            // 不允许跨界
            return null;
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
