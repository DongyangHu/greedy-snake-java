package config;

import enums.MoveDirectionEnum;

import java.awt.*;
import java.net.URL;

/**
 * Copyright 2024 DongyangHu, hudongyang123@gmail.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author DongyangHu
 */
public class GameImgConfig {

    private GameImgConfig() {
    }

    public static final Image HEAD_UP_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_head_up.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image HEAD_DOWN_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_head_down.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image HEAD_LEFT_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_head_left.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image HEAD_RIGHT_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_head_right.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image BODY_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_body.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image FOOD_1_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_food_1.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image FOOD_2_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_food_2.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image FOOD_3_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_food_3.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image FOOD_4_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_food_4.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image FOOD_5_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_food_5.png"))
            .getScaledInstance(GameConfig.SNAKE_UNIT, GameConfig.SNAKE_UNIT, Image.SCALE_DEFAULT);
    public static final Image TITLE_IMAGE = Toolkit.getDefaultToolkit().getImage(getResourceUrl("/snake_title.png"))
            .getScaledInstance(90, 30, Image.SCALE_DEFAULT);

    private static URL getResourceUrl(String path) {
        return GameImgConfig.class.getResource(path);
    }

    public static Image getHeadImgByDirection(MoveDirectionEnum direction) {
        switch (direction) {
            case UP:
                return HEAD_UP_IMAGE;
            case DOWN:
                return HEAD_DOWN_IMAGE;
            case LEFT:
                return HEAD_LEFT_IMAGE;
            case RIGHT:
                return HEAD_RIGHT_IMAGE;
            default:
                throw new NoSuchFieldError("direction=[" + direction + "] not support.");
        }

    }
}
