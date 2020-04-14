package com.yueny.brainstorming.statuscomplex;

public class StateMachineMain {
    public static void main(String[] args) {
        Transition transition =
                StateMachine.get(TradeStatus.WAIT_PAY.getCode(), TradeActionEnum.HANDING.getCode());

        System.out.println(transition);
    }
}
