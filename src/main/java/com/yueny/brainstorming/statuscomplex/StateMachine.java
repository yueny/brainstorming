package com.yueny.brainstorming.statuscomplex;

/**
 * 由状态签转路径组成的状态机模型示例，整体迁移图可以在注释中维护
 */

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 代扣状态模型
 *
 *                            INITIAL
 *                              |
 *                              |
 *                              ∨
 *                  --------WAIT_PAY ---------
 *                  |            |           |
 *                  |            |           |
 *                  |            ∨           |
 *                  |           SUCCESS      |
 *                  |          支付成功       |
 *                  ∨            |  ∧        |
 *                支付失败        |  |        |
 *             -> /交易关闭       |  |        ∨
 *             |   FAILURE       |  |------ HANDING  可疑
 *             |                 ∨            |
 *             |                退款 REFUND    |
 *             |                              |
 *             |                              |
 *             |                              |
 *             |-------------------------------
 *
 */
public class StateMachine {
    private static StateMachine stateMachine;

    private static Transition[] transitions;
    public StateMachine(Transition[] transitions) {
        this.transitions = transitions;
    }

    public static Transition get(String current, String action){
        for (Transition transition : transitions) {
            if(StringUtils.equals(transition.getAction(), action)
                    && StringUtils.equals(transition.getFromStatus(), current)) {
                return transition;
            }
        }

        return null;
    }

    static{
        stateMachine = new StateMachine(
                new Transition[] {
                        /** 下单待支付*/
                        new Transition(TradeStatus.INITIAL.getCode(),
                                TradeActionEnum.PAYMENT_PREPARED_V2.getCode(),
                                TradeStatus.WAIT_PAY.getCode()),

                        /** 买家付款成功*/
                        new Transition(TradeStatus.WAIT_PAY.getCode(),
                                TradeActionEnum.PAYMENT_SUCCESS.getCode(),
                                TradeStatus.SUCCESS.getCode()),

                        /** 支付失败 */
                        new Transition(TradeStatus.WAIT_PAY.getCode(),
                                TradeActionEnum.PAYMENT_FAILED.getCode(),
                                TradeStatus.FAILURE.getCode()),

                        /** 支付可疑 */
                        new Transition(TradeStatus.WAIT_PAY.getCode(),
                                TradeActionEnum.HANDING.getCode(),
                                TradeStatus.HANDING.getCode()),

                        /** 售中退款 */
                        new Transition(TradeStatus.SUCCESS.getCode(),
                                TradeActionEnum.REFUND_APPLY.getCode(),
                                TradeStatus.REFUND.getCode()),

                        /** 可疑成功 */
                        new Transition(TradeStatus.HANDING.getCode(),
                                TradeActionEnum.CHARGEBACK.getCode(),
                                TradeStatus.SUCCESS.getCode()),

                        /** 可疑失败 */
                        new Transition(TradeStatus.HANDING.getCode(),
                                TradeActionEnum.HANDING_FAILED.getCode(),
                                TradeStatus.FAILURE.getCode()),

                        /** 可疑可疑 */
                        new Transition(TradeStatus.HANDING.getCode(),
                                TradeActionEnum.HANDING.getCode(),
                                TradeStatus.HANDING.getCode())
            }
        );
    }

}
