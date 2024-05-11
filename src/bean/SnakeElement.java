package bean;

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
public class SnakeElement {
    /**
     * 单个元素的x坐标
     */
    private int x;
    /**
     * 单个元素的y坐标
     */
    private int y;

    /**
     * 前置节点
     */
    private SnakeElement previous;
    /**
     * 后置节点
     */
    private SnakeElement next;

    public SnakeElement() {
    }

    public SnakeElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public SnakeElement getPrevious() {
        return previous;
    }

    public void setPrevious(SnakeElement previous) {
        this.previous = previous;
    }

    public SnakeElement getNext() {
        return next;
    }

    public void setNext(SnakeElement next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public boolean hasPrevious() {
        return this.previous != null;
    }
}
