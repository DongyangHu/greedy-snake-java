package view.async;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class SnakeMoveSpeedTimer implements ActionListener {

    private final SnakeMoveTimer snakeMoveTimer;
    private final Timer speedTimer;

    public SnakeMoveSpeedTimer(SnakeMoveTimer snakeMoveTimer) {
        this.speedTimer = new Timer(100, this);
        this.snakeMoveTimer = snakeMoveTimer;
    }

    public void start() {
        this.speedTimer.start();

    }

    public void stop() {
        this.speedTimer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.snakeMoveTimer.resetSpeed();
    }
}
