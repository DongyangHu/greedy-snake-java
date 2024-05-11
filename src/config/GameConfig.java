package config;

import utils.GameUtils;

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
public class GameConfig {

    private GameConfig() {
    }

    /**
     * 画布宽度
     */
    public static final int FRAME_WIDTH = 600;
    /**
     * 画布长度
     */
    public static final int FRAME_HEIGHT = 600;
    /**
     * 初始化画布位置(屏幕居中)
     */
    public static final Point INIT_POINT = GameUtils.calCenterPoint(FRAME_WIDTH, FRAME_HEIGHT);
    /**
     * 蛇像素
     */
    public static final int SNAKE_UNIT = 20;
    /**
     * 蛇初始长度
     */
    public static final int SNAKE_INIT_LENGTH = 2;
    /**
     * 食物生成时间间隔
     */
    public static final int GEN_FOOD_TIMER_UNIT = 3000;
    /**
     * 食物过期时间间隔
     */
    public static final int EXPIRE_FOOD_TIMER_UNIT = 1000;
    /**
     * panel 间距
     */
    public static final int PANEL_GAP = 6;
    /**
     * 提示框宽度
     */
    public static final int EXT_PANEL_WIDTH = FRAME_WIDTH - SNAKE_UNIT;
    /**
     * 提示框高度
     */
    public static final int EXT_PANEL_HEIGHT = 100;
    /**
     * 提示框位置
     */
    public static final Point EXT_PANEL_POINT = new Point(PANEL_GAP, PANEL_GAP);
    /**
     * 游戏主panel宽度
     */
    public static final int PANEL_WIDTH = EXT_PANEL_WIDTH;
    /**
     * 游戏主panel高度
     */
    public static final int PANEL_HEIGHT = FRAME_HEIGHT - EXT_PANEL_HEIGHT - (SNAKE_UNIT << 1);
    /**
     * 游戏主panel上边缘y坐标
     */
    public static final int TOP_BORDER = EXT_PANEL_HEIGHT + (PANEL_GAP << 1) - 4;
    /**
     * 游戏主panel左边缘x坐标
     */
    public static final int LEFT_BORDER = PANEL_GAP;
    /**
     * 游戏主panel位置
     */
    public static final Point PANEL_POINT = new Point(LEFT_BORDER, TOP_BORDER);
    /**
     * 主panel背景色
     */
    public static final Color SNAKE_PANEL_BACKGROUND = new Color(0x000000);
    /**
     * 附近panel背景色
     */
    public static final Color EXTENDED_PANEL_BACKGROUND = new Color(0xC75E5E);
    /**
     * 同时存在的最大食物数量
     */
    public static final int FOOD_NUM_MAX = 3;
    /**
     * 开始提示字体颜色
     */
    public static final Color START_GAME_TEXT_COLOR = new Color(0xB9B9B9);
    /**
     * 计分板字体颜色
     */
    public static final Color GAME_EXT_TEXT_COLOR = new Color(0xD5D5FFFF);
    /**
     * 计分板字体
     */
    public static final Font GAME_EXT_TEXT_FONT = new Font("宋体", Font.BOLD, 16);
    /**
     * 标题字体颜色
     */
    public static final Color GAME_TITLE_TEXT_COLOR = new Color(0xFFFFFF);
    /**
     * 标题字体
     */
    public static final Font GAME_TITLE_TEXT_FONT = new Font("宋体", Font.BOLD, 30);
    /**
     * 分数坐标
     */
    public static final Point GAME_SCORE_TEXT_POINT = new Point(200, 96);
    /**
     * 长度坐标
     */
    public static final Point GAME_LENGTH_TEXT_POINT = new Point(300, 96);
    /**
     * 游戏开始提示字体
     */
    public static final Font START_GAME_TEXT_FONT = new Font("宋体", Font.BOLD, 18);
    /**
     * 游戏开始提示坐标
     */
    public static final Point START_GAME_TEXT_POINT = new Point(50, 240);
}
