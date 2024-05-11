package enums;

import config.GameImgConfig;
import javafx.util.Pair;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public enum FoodConfigEnum {
    LEVEL_1(GameImgConfig.FOOD_1_IMAGE, 1, 1, 20000, 40),
    LEVEL_2(GameImgConfig.FOOD_2_IMAGE, 10, 1, 16000, 20),
    LEVEL_3(GameImgConfig.FOOD_3_IMAGE, 20, 1, 12000, 17),
    LEVEL_4(GameImgConfig.FOOD_4_IMAGE, 50, 1, 8000, 15),
    LEVEL_5(GameImgConfig.FOOD_5_IMAGE, 100, 1, 4000, 8),
    ;

    /**
     * 图片
     */
    private Image img;
    /**
     * 增加分数
     */
    private int score;
    /**
     * 增加长度
     */
    private int length;
    /**
     * 过期时间
     */
    private int expireTime;
    /**
     * 出现的概率n%
     */
    private int probability;

    private static final Map<FoodConfigEnum, Integer> LEVEL_RATIO_RANGE;

    static {
        Integer sum = Arrays.stream(FoodConfigEnum.values())
                .map(FoodConfigEnum::getProbability)
                .reduce(Integer::sum).orElse(0);
        if (!sum.equals(100)) {
            System.exit(-1);
        }

        LEVEL_RATIO_RANGE = new HashMap<>(FoodConfigEnum.values().length << 1);
        LEVEL_RATIO_RANGE.put(LEVEL_1, LEVEL_1.getProbability());
        LEVEL_RATIO_RANGE.put(LEVEL_2, LEVEL_RATIO_RANGE.get(LEVEL_1) + LEVEL_2.getProbability());
        LEVEL_RATIO_RANGE.put(LEVEL_3, LEVEL_RATIO_RANGE.get(LEVEL_2) + LEVEL_3.getProbability());
        LEVEL_RATIO_RANGE.put(LEVEL_4, LEVEL_RATIO_RANGE.get(LEVEL_3) + LEVEL_4.getProbability());
        LEVEL_RATIO_RANGE.put(LEVEL_5, LEVEL_RATIO_RANGE.get(LEVEL_4) + LEVEL_4.getProbability());
    }

    FoodConfigEnum(Image img, int score, int length, int expireTime, int probability) {
        this.img = img;
        this.score = score;
        this.length = length;
        this.expireTime = expireTime;
        this.probability = probability;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public static FoodConfigEnum getByRandom(int value) {
        if (value > 100 || value < 0) {
            return LEVEL_1;
        }
        if (value < LEVEL_RATIO_RANGE.get(LEVEL_1)) {
            return LEVEL_1;
        } else if (value < LEVEL_RATIO_RANGE.get(LEVEL_2)) {
            return LEVEL_2;
        } else if (value < LEVEL_RATIO_RANGE.get(LEVEL_3)) {
            return LEVEL_3;
        } else if (value < LEVEL_RATIO_RANGE.get(LEVEL_4)) {
            return LEVEL_4;
        } else {
            return LEVEL_5;
        }
    }

}
