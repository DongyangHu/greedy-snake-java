package view.logic;

import config.GameConfig;
import config.GameImgConfig;
import config.MessageConfig;
import utils.GameUtils;
import view.ExtendedPanelView;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
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
public class ExtendedPanel extends ExtendedPanelView {

    private long score;
    private long length;

    public ExtendedPanel() {
        super();
    }

    public long getScore() {
        return score;
    }

    public long getLength() {
        return length;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(GameConfig.GAME_EXT_TEXT_COLOR);
        g.setFont(GameConfig.GAME_EXT_TEXT_FONT);
        g.drawString(String.format(MessageConfig.SCORE, this.score), GameConfig.GAME_SCORE_TEXT_POINT.x, GameConfig.GAME_SCORE_TEXT_POINT.y);
        g.drawString(String.format(MessageConfig.LENGTH, this.length), GameConfig.GAME_LENGTH_TEXT_POINT.x, GameConfig.GAME_LENGTH_TEXT_POINT.y);
    }

    public void initPanel(int initLength) {
        this.score = 0;
        this.length = initLength;
    }

    public void eatFood(int scoreAdd, int lengthAdd) {
        this.score += scoreAdd;
        this.length += lengthAdd;
        this.repaint();
    }

    public void clear(int initLength) {
        this.score = 0;
        this.length = initLength;
        this.repaint();
    }

}
