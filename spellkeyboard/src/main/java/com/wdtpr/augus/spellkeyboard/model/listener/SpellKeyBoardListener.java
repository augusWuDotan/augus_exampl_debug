package com.wdtpr.augus.spellkeyboard.model.listener;

/**
 * Created by augus on 2018/1/19.
 */

public interface SpellKeyBoardListener {

    /**
     * 成功建立
     */
    void alreadyEstablished();

    /**
     * 更新中
     */
    void update();

    /**
     * 更新失敗
     */
    void updateError();

    /**
     * 成功 刪除答案
     */
    void alreadyBack();

    /**
     * 成功 加入答案
     */
    void alreadyAdd();

    /**
     * 答題錯誤
     *
     * @param ErrorStr 錯誤答案
     */
    void answerError(String ErrorStr);

    /**
     * 答題正確
     *
     * @param CorrectStr 正確答案
     */
    void answerCorrect(String CorrectStr);

    /**
     * 答題正確 clear內容動畫結束
     */
    void answerCorrectAnimFinish();
}
