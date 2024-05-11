package view;

import config.GameConfig;
import config.MessageConfig;
import view.logic.ExtendedPanel;
import view.logic.SnakePanel;

import javax.swing.*;

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
public class SnakeFrame extends JFrame {

    public void launch() {
        this.fillFrame();
        this.addView();
        this.setVisible(true);
    }

    private void fillFrame() {
        this.setTitle(MessageConfig.TITLE);
        this.setSize(GameConfig.FRAME_WIDTH, GameConfig.FRAME_HEIGHT);
        this.setLocation(GameConfig.INIT_POINT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    private void addView() {
        ExtendedPanel extendedPanel = new ExtendedPanel();
        SnakePanel snakePanel = new SnakePanel(extendedPanel);
        this.add(extendedPanel);
        this.add(snakePanel);
    }

}
