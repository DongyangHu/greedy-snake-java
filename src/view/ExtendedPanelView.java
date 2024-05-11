package view;

import config.GameConfig;
import config.GameImgConfig;
import config.MessageConfig;

import javax.swing.*;
import java.awt.*;

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
public class ExtendedPanelView extends JPanel {

    public ExtendedPanelView() {
        this.setBackground(GameConfig.EXTENDED_PANEL_BACKGROUND);
        this.setLocation(GameConfig.EXT_PANEL_POINT);
        this.setSize(GameConfig.EXT_PANEL_WIDTH, GameConfig.EXT_PANEL_HEIGHT);
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(MessageConfig.TITLE);
        titleLabel.setFont(GameConfig.GAME_TITLE_TEXT_FONT);
        titleLabel.setForeground(GameConfig.GAME_TITLE_TEXT_COLOR);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel icoPanel = new JPanel();
        icoPanel.setBackground(GameConfig.EXTENDED_PANEL_BACKGROUND);
        JLabel icoLabel = new JLabel();
        icoLabel.setIcon(new ImageIcon(GameImgConfig.TITLE_IMAGE));
        icoPanel.add(icoLabel);
        this.add(icoPanel);
    }

}
