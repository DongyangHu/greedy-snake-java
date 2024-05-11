package view.async;

import enums.MoveSpeedEnum;
import view.logic.ExtendedPanel;
import view.logic.SnakePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Copyright 2024 DongyangHu, hudongyang123@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author DongyangHu
 */
public class SnakeMoveTimer implements ActionListener {
    private final Timer moveTimer;
    private final SnakePanel snakePanel;
    private final ExtendedPanel extendedPanel;
    private MoveSpeedEnum curMoveSpeed;

    public SnakeMoveTimer(SnakePanel snakePanel, ExtendedPanel extendedPanel) {
        this.curMoveSpeed = MoveSpeedEnum.LEVEL1;
        this.moveTimer = new Timer(this.curMoveSpeed.getSpeed(), this);
        this.snakePanel = snakePanel;
        this.extendedPanel = extendedPanel;
    }

    public void start() {
        this.moveTimer.start();

    }

    public void stop() {
        this.moveTimer.stop();
    }

    public void resetSpeed() {
        this.resetSpeed4DirectionKey();
        this.resetSpeed4Score();
    }

    private void updateDelay(int delay) {
        if (this.moveTimer.getDelay() != delay) {
            this.moveTimer.setDelay(delay);
        }
    }

    public void resetSpeed4DirectionKey() {
        // 按住方向键时
        long directionKeyPressedCount = this.snakePanel.getDirectionKeyPressedCount();
        if (directionKeyPressedCount <= 0) {
            this.updateDelay(this.curMoveSpeed.getSpeed());
            return;
        }

        if (directionKeyPressedCount > 5) {
            this.updateDelay(MoveSpeedEnum.LEVEL4.getSpeed());
            return;
        }

        if (directionKeyPressedCount > 1) {
            this.updateDelay(MoveSpeedEnum.LEVEL3.getSpeed());
        }
    }

    public void resetSpeed4Score() {
        if (this.extendedPanel.getScore() >= MoveSpeedEnum.LEVEL4.getScore()) {
            this.moveTimer.setDelay(MoveSpeedEnum.LEVEL4.getSpeed());
            return;
        }
        if (this.extendedPanel.getScore() >= MoveSpeedEnum.LEVEL3.getScore()) {
            this.moveTimer.setDelay(MoveSpeedEnum.LEVEL3.getSpeed());
            return;
        }
        if (this.extendedPanel.getScore() >= MoveSpeedEnum.LEVEL2.getScore()) {
            this.moveTimer.setDelay(MoveSpeedEnum.LEVEL2.getSpeed());
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.snakePanel.moveSnake();
    }
}
