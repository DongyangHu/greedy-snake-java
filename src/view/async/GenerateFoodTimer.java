package view.async;

import config.GameConfig;
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
public class GenerateFoodTimer implements ActionListener {

    private final Timer foodTimer;
    private final SnakePanel snakePanel;

    public GenerateFoodTimer(SnakePanel snakePanel) {
        this.foodTimer = new Timer(GameConfig.GEN_FOOD_TIMER_UNIT, this);
        this.foodTimer.setInitialDelay(0);
        this.snakePanel = snakePanel;
    }

    public void start() {
        this.foodTimer.start();
    }

    public void stop() {
        this.foodTimer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.snakePanel.genNewFood();
    }
}
