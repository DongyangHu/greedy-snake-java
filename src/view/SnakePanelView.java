package view;

import config.GameConfig;

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
public class SnakePanelView extends JPanel {

    public SnakePanelView() {
        this.setBackground(GameConfig.SNAKE_PANEL_BACKGROUND);
        this.setLocation(GameConfig.PANEL_POINT);
        this.setSize(GameConfig.PANEL_WIDTH, GameConfig.PANEL_HEIGHT);
        this.setFocusable(true);
    }
}
