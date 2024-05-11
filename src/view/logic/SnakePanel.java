package view.logic;

import view.async.ExpireFoodTimer;
import view.async.GenerateFoodTimer;
import view.async.SnakeMoveSpeedTimer;
import view.async.SnakeMoveTimer;
import bean.FoodElement;
import bean.SnakeElement;
import config.GameConfig;
import config.GameImgConfig;
import config.MessageConfig;
import enums.FoodConfigEnum;
import enums.MoveDirectionEnum;
import utils.GameUtils;
import view.SnakePanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

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
public class SnakePanel extends SnakePanelView implements KeyListener {

    /**
     * 头结点
     */
    private SnakeElement head;
    /**
     * 尾结点
     */
    private SnakeElement tail;
    /**
     * 食物
     */
    private final FoodElement[] foodArray;
    /**
     * 长度
     */
    private int snakeLength;
    /**
     * 移动方向
     */
    private MoveDirectionEnum direction;
    /**
     * 改变方向后是否已经移动
     */
    private boolean moved = true;
    /**
     * 计分板Title
     */
    private final ExtendedPanel extendedPanel;
    /**
     * 蛇移动定时器
     */
    private final SnakeMoveTimer snakeMoveTimer;
    /**
     * 移动速度定时器
     */
    private final SnakeMoveSpeedTimer snakeMoveSpeedTimer;
    /**
     * 食物生成定时器
     */
    private final GenerateFoodTimer generateFoodTimer;
    /**
     * 食物超时定时器
     */
    private final ExpireFoodTimer expireFoodTimer;
    /**
     * 游戏运行状态
     */
    private boolean gameStarted;
    /**
     * 同步锁
     */
    private final Lock lock;
    /**
     * 方向键按下次数
     */
    private long directionKeyPressedCount;

    public SnakePanel(ExtendedPanel extendedPanel) {
        super();
        // 属性初始化
        this.snakeLength = GameConfig.SNAKE_INIT_LENGTH;
        // 蛇
        this.head = new SnakeElement(GameConfig.FRAME_WIDTH >> 1, GameConfig.FRAME_HEIGHT >> 1);
        if (GameConfig.SNAKE_INIT_LENGTH > 1) {
            SnakeElement tmp = this.head;
            for (int i = 0; i < GameConfig.SNAKE_INIT_LENGTH - 1; i++) {
                SnakeElement element = new SnakeElement(tmp.getX() - GameConfig.SNAKE_UNIT, tmp.getY());
                element.setPrevious(tmp);
                tmp.setNext(element);
                tmp = element;
                tail = element;
            }
        }

        this.lock = new ReentrantLock();
        this.foodArray = new FoodElement[GameConfig.FOOD_NUM_MAX];
        this.direction = MoveDirectionEnum.RIGHT;
        this.extendedPanel = extendedPanel;
        this.extendedPanel.initPanel(this.snakeLength);
        this.addKeyListener(this);

        this.snakeMoveTimer = new SnakeMoveTimer(this, extendedPanel);
        this.snakeMoveSpeedTimer = new SnakeMoveSpeedTimer(this.snakeMoveTimer);
        this.generateFoodTimer = new GenerateFoodTimer(this);
        this.expireFoodTimer = new ExpireFoodTimer(this);
        this.gameStarted = false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!gameStarted) {
            g.setColor(GameConfig.START_GAME_TEXT_COLOR);
            g.setFont(GameConfig.START_GAME_TEXT_FONT);
            g.drawString(MessageConfig.START_GAME, GameConfig.START_GAME_TEXT_POINT.x, GameConfig.START_GAME_TEXT_POINT.y);
            return;
        }

        // 画蛇头
        g.drawImage(GameImgConfig.getHeadImgByDirection(direction), this.head.getX(), this.head.getY(), this);
        // 画身体
        SnakeElement tmp = this.head.getNext();
        while (Objects.nonNull(tmp)) {
            g.drawImage(GameImgConfig.BODY_IMAGE, tmp.getX(), tmp.getY(), this);
            tmp = tmp.getNext();
        }
        // 食物
        for (FoodElement food : this.foodArray) {
            if (food != null) {
                g.drawImage(food.getFoodConfig().getImg(), food.getX(), food.getY(), this);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (this.direction != MoveDirectionEnum.DOWN && this.moved) {
                    this.direction = MoveDirectionEnum.UP;
                    this.moved = false;
                    this.directionKeyPressedCount++;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.direction != MoveDirectionEnum.UP && this.moved) {
                    this.direction = MoveDirectionEnum.DOWN;
                    this.moved = false;
                    this.directionKeyPressedCount++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (this.direction != MoveDirectionEnum.RIGHT && this.moved) {
                    this.direction = MoveDirectionEnum.LEFT;
                    this.moved = false;
                    this.directionKeyPressedCount++;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.direction != MoveDirectionEnum.LEFT && this.moved) {
                    this.direction = MoveDirectionEnum.RIGHT;
                    this.moved = false;
                    this.directionKeyPressedCount++;
                }
                break;
            case KeyEvent.VK_SPACE:
                if (this.gameStarted) {
                    this.stop();
                } else {
                    this.start();
                }
                this.gameStarted = !this.gameStarted;
                this.repaint();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                this.directionKeyPressedCount = 0L;
            default:
                break;
        }
    }

    /**
     * 蛇移动
     */
    public void moveSnake() {
        // 移动子节点
        SnakeElement tmp = this.tail;
        while (tmp.hasPrevious()) {
            tmp.setX(tmp.getPrevious().getX());
            tmp.setY(tmp.getPrevious().getY());
            tmp = tmp.getPrevious();
        }

        // 移动头节点
        switch (direction) {
            case UP:
                this.head.setY(this.head.getY() - GameConfig.SNAKE_UNIT);
                if (this.head.getY() < 0) {
                    this.head.setY(GameConfig.PANEL_HEIGHT - GameConfig.SNAKE_UNIT);
                }
                this.touchFood(index -> this.eatFood(this.head.getX(), this.head.getY() - GameConfig.SNAKE_UNIT < 0
                        ? GameConfig.PANEL_HEIGHT - GameConfig.SNAKE_UNIT
                        : this.head.getY() - GameConfig.SNAKE_UNIT, index));

                break;
            case DOWN:
                this.head.setY(this.head.getY() + GameConfig.SNAKE_UNIT);
                if (this.head.getY() >= GameConfig.PANEL_HEIGHT) {
                    this.head.setY(0);
                }
                this.touchFood(index -> this.eatFood(this.head.getX(), this.head.getY() + GameConfig.SNAKE_UNIT >= GameConfig.PANEL_HEIGHT
                        ? 0 : this.head.getY() + GameConfig.SNAKE_UNIT, index));

                break;
            case LEFT:
                this.head.setX(this.head.getX() - GameConfig.SNAKE_UNIT);
                if (this.head.getX() < 0) {
                    this.head.setX(GameConfig.PANEL_WIDTH - GameConfig.SNAKE_UNIT);
                }
                this.touchFood(index -> this.eatFood(this.head.getX() - GameConfig.SNAKE_UNIT < 0
                        ? GameConfig.PANEL_WIDTH - GameConfig.SNAKE_UNIT
                        : this.head.getX() - GameConfig.SNAKE_UNIT, this.head.getY(), index));

                break;
            case RIGHT:
                this.head.setX(this.head.getX() + GameConfig.SNAKE_UNIT);
                if (this.head.getX() >= GameConfig.PANEL_WIDTH) {
                    this.head.setX(0);
                }
                this.touchFood(index -> this.eatFood(this.head.getX() + GameConfig.SNAKE_UNIT >= GameConfig.PANEL_WIDTH
                        ? 0 : this.head.getX() + GameConfig.SNAKE_UNIT, this.head.getY(), index));
                break;
            default:
                break;
        }

        // 失败
        this.toFailed();
        this.repaint();
        this.moved = true;
    }

    private void toFailed() {
        SnakeElement tmp1 = this.head;
        while (tmp1.hasNext()) {
            tmp1 = tmp1.getNext();
            if (tmp1.getX() == this.head.getX() && tmp1.getY() == this.head.getY()) {
                this.gameOverLogic();
            }
        }
    }

    private void gameOverLogic() {
        Object[] options = {MessageConfig.GAME_OVER_CONFIRM, MessageConfig.GAME_OVER_EXIT};
        ImageIcon icon = new ImageIcon(GameImgConfig.HEAD_UP_IMAGE);
        int response = JOptionPane.showOptionDialog(this, String.format(MessageConfig.GAME_OVER_MESSAGE, this.extendedPanel.getScore()),
                MessageConfig.GAME_OVER_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
        if (response == 0) {
            this.clear();
        } else {
            System.exit(-1);
        }
    }

    private void clear() {
        try {
            this.lock.lock();
            // 停止定时器
            this.stop();
            // 游戏状态
            this.gameStarted = false;
            // 属性初始化
            this.snakeLength = GameConfig.SNAKE_INIT_LENGTH;
            // 蛇
            this.head = new SnakeElement(GameConfig.FRAME_WIDTH >> 1, GameConfig.FRAME_HEIGHT >> 1);
            if (GameConfig.SNAKE_INIT_LENGTH > 1) {
                SnakeElement tmp = this.head;
                for (int i = 0; i < GameConfig.SNAKE_INIT_LENGTH - 1; i++) {
                    SnakeElement element = new SnakeElement(tmp.getX() - GameConfig.SNAKE_UNIT, tmp.getY());
                    element.setPrevious(tmp);
                    tmp.setNext(element);
                    tmp = element;
                    tail = element;
                }
            }
            // 重置食物
            Arrays.fill(this.foodArray, null);
            // 重置方向
            this.direction = MoveDirectionEnum.RIGHT;
            // 重置计分板
            this.extendedPanel.clear(this.snakeLength);
            this.repaint();
        } finally {
            this.lock.unlock();
        }
    }

    private void eatFood(int newX, int newY, int foodIndex) {
        // 计分
        FoodConfigEnum curFoodConfig = this.foodArray[foodIndex].getFoodConfig();
        this.extendedPanel.eatFood(curFoodConfig.getScore(), curFoodConfig.getLength());
        SnakeElement newHead = new SnakeElement(newX, newY);
        newHead.setNext(this.head);
        this.head.setPrevious(newHead);
        this.head = newHead;
        this.snakeLength++;
    }

    private FoodElement genNewFoodBase() {
        FoodElement food = GameUtils.genFood(GameConfig.PANEL_WIDTH, GameConfig.PANEL_HEIGHT, GameConfig.SNAKE_UNIT);
        for (FoodElement foodElement : this.foodArray) {
            if (food.equals(foodElement)) {
                return genNewFoodBase();
            }
        }
        return food;
    }

    /**
     * 定时生成food
     */
    public void genNewFood() {
        try {
            this.lock.lock();
            for (int i = 0; i < this.foodArray.length; i++) {
                if (this.foodArray[i] == null) {
                    this.foodArray[i] = genNewFoodBase();
                    break;
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void touchFood(Consumer<Integer> foodIndexConsumer) {
        try {
            this.lock.lock();
            for (int i = 0; i < this.foodArray.length; i++) {
                if (this.foodArray[i] == null) {
                    continue;
                }
                if (head.getX() == this.foodArray[i].getX() && head.getY() == this.foodArray[i].getY()) {
                    foodIndexConsumer.accept(i);
                    this.foodArray[i] = null;
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void start() {
        this.snakeMoveTimer.start();
        this.snakeMoveSpeedTimer.start();
        this.generateFoodTimer.start();
        this.expireFoodTimer.start();
    }

    private void stop() {
        this.snakeMoveTimer.stop();
        this.snakeMoveSpeedTimer.stop();
        this.generateFoodTimer.stop();
        this.expireFoodTimer.stop();
    }

    public void expireFood() {
        try {
            this.lock.lock();
            for (int i = 0; i < this.foodArray.length; i++) {
                if (this.foodArray[i] == null) {
                    continue;
                }
                if (this.foodArray[i].getFoodConfig().getExpireTime() + this.foodArray[i].getGenTime() <= System.currentTimeMillis()) {
                    this.foodArray[i] = null;
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public long getDirectionKeyPressedCount() {
        return this.directionKeyPressedCount;
    }
}
