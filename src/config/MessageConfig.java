package config;

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
public class MessageConfig {
    private MessageConfig() {

    }

    public static final String SCORE = "Score:%s";
    public static final String LENGTH = "Length:%s";
    public static final String TITLE = "Greedy Snake";
    public static final String START_GAME = "Please press the `Space` to start/pause the game";

    public static final String GAME_OVER_TITLE = "Message";
    public static final String GAME_OVER_MESSAGE = "Game Over!    Score: %s";
    public static final String GAME_OVER_CONFIRM = "Restart";
    public static final String GAME_OVER_EXIT = "Exit";
}
