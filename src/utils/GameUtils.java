package utils;

import bean.FoodElement;
import enums.FoodConfigEnum;

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
public class GameUtils {

    /**
     * 游戏初始化,界面居中
     *
     * @return JFrame起始位置
     */
    public static Point calCenterPoint(int gameWidth, int gameHeight) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - gameWidth) >> 1;
        int y = (screenSize.height - gameHeight) >> 1;
        return new Point(x, y);
    }

    public static FoodElement genFood(int xRange, int yRange, int unit) {
        FoodElement food = new FoodElement();
        // 坐标
        int xMax = xRange / unit - 1;
        int yMax = yRange / unit - 1;
        food.setX(unit * (int) (Math.random() * xMax));
        food.setY(unit * (int) (Math.random() * yMax));

        // 属性
        int seed4Level = (int) (Math.random() * 100);
        food.setFoodConfig(FoodConfigEnum.getByRandom(seed4Level));
        food.setGenTime(System.currentTimeMillis());
        return food;
    }
}
