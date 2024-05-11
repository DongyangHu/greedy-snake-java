package bean;

import enums.FoodConfigEnum;
import java.util.Objects;

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
public class FoodElement {
    private int x;
    private int y;
    private FoodConfigEnum foodConfig;
    private long genTime;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public FoodConfigEnum getFoodConfig() {
        return foodConfig;
    }

    public void setFoodConfig(FoodConfigEnum foodConfig) {
        this.foodConfig = foodConfig;
    }

    public long getGenTime() {
        return genTime;
    }

    public void setGenTime(long genTime) {
        this.genTime = genTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoodElement that = (FoodElement) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, foodConfig);
    }
}
