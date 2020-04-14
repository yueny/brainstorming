package com.yueny.brainstorming.statuscomplex;

import lombok.Getter;

/**
 * 交易动作
 */
public enum TradeActionEnum {

     /** 下单待支付*/
     PAYMENT_PREPARED_V2,

     /** 付款成功 */
     PAYMENT_SUCCESS,

     /** 支付失败 */
     PAYMENT_FAILED,

     /** 退款 */
     REFUND_APPLY,

     /** 可疑中 */
     HANDING,

     /** 可疑变成功 */
     CHARGEBACK,

     /** 可疑变失败 */
     HANDING_FAILED,
    ;

     @Getter
     private String code;

    TradeActionEnum() {
        this.code = this.name();
    }


    //                    new Transition(TradeStatus.INITIAL.getCode(),
//                            TradeActionEnum.PAYMENT_PREPARED_V2.getCode(),
//                                    TradeStatus.WAIT_PAY.getCode()),
//                                    /** 买家付款成功*/
//                                    new Transition(TradeStatus.WAIT_PAY.getCode(),
//                            TradeActionEnum.PAYMENT_PREPARED_V2.getCode(),
//                                    TradeStatusEnum.AUDIT_APPROVE.getCode()),
//
//                                    /** 支付失败 */
//                                    new Transition(TradeStatusEnum.WAIT_PAY.getCode(),
//                            TradeActionEnum.TRADE_CLOSE.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 支付失败 */
//                                    new Transition(TradeStatusEnum.WAIT_PAY.getCode(),
//                            TradeActionEnum..getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售中支付清算 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.PAYMENT_CLEAR_V2.getCode(),
//                                    TradeStatusEnum.AUDIT_APPROVE.getCode()),
//
//                                    /** 放款 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.LOAN_APPLY.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售中退款 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.REFUND_APPLY.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售中拒付 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.CHARGEBACK.getCode(),
//                                    TradeStatusEnum.AUDIT_APPROVE.getCode()),
//
//                                    /** 售中拒付判责通知处理成功 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.CHARGEBACK_JUDGE_V2.getCode(),
//                                    TradeStatusEnum.AUDIT_APPROVE.getCode()),
//
//                                    /** 已审核交易冻结 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.TRADE_FREEZE.getCode(),
//                                    TradeStatusEnum.AUDIT_APPROVE.getCode()),
//
//                                    /** 已审核交易解冻 */
//                                    new Transition(TradeStatusEnum.AUDIT_APPROVE.getCode(),
//                            TradeActionEnum.TRADE_UN_FREEZE.getCode(),
//                                    TradeStatusEnum.AUDIT_APPROVE.getCode()),
//
//                                    /** 售后支付清算 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.PAYMENT_CLEAR_V2.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售后退款资金准备 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.REFUND_PREPARE.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售后退款申请 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.REFUND_APPLY.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 已结束交易冻结 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.TRADE_FREEZE.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 已结束交易解冻 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.TRADE_UN_FREEZE.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售后拒付 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.CHARGEBACK.getCode(),
//                                    TradeStatusEnum.FINISH.getCode()),
//
//                                    /** 售后拒付判责通知处理成功 */
//                                    new Transition(TradeStatusEnum.FINISH.getCode(),
//                            TradeActionEnum.CHARGEBACK_JUDGE_V2.getCode(),
//                                    TradeStatusEnum.FINISH.getCode())}
//     */
}
