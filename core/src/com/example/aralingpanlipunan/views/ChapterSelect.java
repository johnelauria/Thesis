package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;

import java.util.ArrayList;

/**
 * This displays the view for chapter selection. This is a sub view for Student & Teacher View
 */
public class ChapterSelect extends AppView implements Disposable, AppFragment {
    public static final int TEACHER = 1;
    public static final int STUDENT = 0;
    private int userType = STUDENT;
    private int chapterSection, upTimer = 0;
    private float touchX, touchY, movementCursorLimit, movementCursor = 0;
    private boolean isMovingRight, isMovingLeft = false;
    private String loggedInUserName;
    private ArrayList<Sprite> buttonSprites;
    private ArrayList<Integer> chapterScores;
    private Texture chap1Texture, chap2Texture, chap3Texture, chap4Texture,chap5Texture, chap6Texture,chap7Texture, chap8Texture,chap9Texture, chap10Texture,chap11Texture, chap12Texture,chap13Texture, chap14Texture,chap15Texture, chap16Texture,chap17Texture, chap18Texture, background;
    private Sprite chap1, chap2, chap3, chap4,chap5, chap6,chap7, chap8,chap9, chap10,chap11, chap12,chap13, chap14,chap15, chap16,chap17, chap18;
    private AndroidInterface android;

    /**
     * Specify the user type, either STUDENT or TEACHER.
     * @param user type of user viewing this chapter
     */
    public ChapterSelect(int user, String userName, AndroidInterface androidInterface) {
        android = androidInterface;
        switch (user) {
            case TEACHER:
                userType = TEACHER;
                break;
            case STUDENT:
                loggedInUserName = userName;
                userType = STUDENT;
                break;
        }
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenHeight = screenH;
        screenWidth = screenW;

        chapterScores = android.getScoresByStudent(loggedInUserName);

        background = new Texture("backgrounds/start-background.jpg");
        chap1Texture = new Texture("buttons/chapters/b1-1.png");
        chap2Texture = new Texture("buttons/chapters/b1-2.png");
        chap3Texture = new Texture("buttons/chapters/b1-3.png");
        chap4Texture = new Texture("buttons/chapters/b2-1.png");
        chap5Texture = new Texture("buttons/chapters/b2-2.png");
        chap6Texture = new Texture("buttons/chapters/b2-3.png");
        chap7Texture = new Texture("buttons/chapters/b3-1.png");
        chap8Texture = new Texture("buttons/chapters/b3-2.png");
        chap9Texture = new Texture("buttons/chapters/b3-3.png");
        chap10Texture = new Texture("buttons/chapters/b4-1.png");
        chap11Texture = new Texture("buttons/chapters/b4-2.png");
        chap12Texture = new Texture("buttons/chapters/b4-3.png");
        chap13Texture = new Texture("buttons/chapters/b5-1.png");
        chap14Texture = new Texture("buttons/chapters/b5-2.png");
        chap15Texture = new Texture("buttons/chapters/b5-3.png");
        chap16Texture = new Texture("buttons/chapters/b6-1.png");
        chap17Texture = new Texture("buttons/chapters/b6-2.png");
        chap18Texture = new Texture("buttons/chapters/b6-3.png");

        buttonSprites = new ArrayList<Sprite>();

        chap1 = new Sprite(chap1Texture);
        chap1.setSize(chap1.getWidth() * getButtonScale(), chap1.getHeight() * getButtonScale());
        final float chap1X = (screenW / 3) - (chap1.getWidth() / 2);
        final float chap1Y = screenH - (screenH / 4);
        chap1.setBounds(chap1X, chap1Y, chap1.getWidth(), chap1.getHeight());
        buttonSprites.add(chap1);

        chap2 = new Sprite(chap2Texture);
        chap2.setSize(chap2.getWidth() * getButtonScale(), chap2.getHeight() * getButtonScale());
        if (chapterScores.get(0) == 0) chap2.setAlpha(0.5f);
        final float chap2X = (screenW / 3) - (chap2.getWidth() / 2);
        final float chap2Y = screenH / 2;
        chap2.setBounds(chap2X, chap2Y, chap2.getWidth(), chap2.getHeight());
        buttonSprites.add(chap2);

        chap3 = new Sprite(chap3Texture);
        chap3.setSize(chap3.getWidth() * getButtonScale(), chap3.getHeight() * getButtonScale());
        if (chapterScores.get(1) == 0) chap3.setAlpha(0.5f);
        final float chap3X = (screenW / 3) - (chap3.getWidth() / 2);
        final float chap3Y = screenH / 4;
        chap3.setBounds(chap3X, chap3Y, chap3.getWidth(), chap3.getHeight());
        buttonSprites.add(chap3);

        chap4 = new Sprite(chap4Texture);
        chap4.setSize(chap4.getWidth() * getButtonScale(), chap4.getHeight() * getButtonScale());
        if (chapterScores.get(2) == 0) chap4.setAlpha(0.5f);
        final float chap4X = (screenW / 1.8f);
        chap4.setBounds(chap4X, chap1Y, chap4.getWidth(), chap4.getHeight());
        buttonSprites.add(chap4);

        chap5 = new Sprite(chap5Texture);
        chap5.setSize(chap5.getWidth() * getButtonScale(), chap5.getHeight() * getButtonScale());
        if (chapterScores.get(3) == 0) chap5.setAlpha(0.5f);
        final float chap5X = (screenW / 1.8f);
        chap5.setBounds(chap5X, chap2Y, chap5.getWidth(), chap5.getHeight());
        buttonSprites.add(chap5);

        chap6 = new Sprite(chap6Texture);
        chap6.setSize(chap6.getWidth() * getButtonScale(), chap6.getHeight() * getButtonScale());
        if (chapterScores.get(4) == 0) chap6.setAlpha(0.5f);
        final float chap6X = (screenW / 1.8f);
        chap6.setBounds(chap6X, chap3Y, chap6.getWidth(), chap6.getHeight());
        buttonSprites.add(chap6);

        chap7 = new Sprite(chap7Texture);
        chap7.setSize(chap7.getWidth() * getButtonScale(), chap7.getHeight() * getButtonScale());
        if (chapterScores.get(5) == 0) chap7.setAlpha(0.5f);
        final float chap7X = ((screenW / 3) - (chap7.getWidth() / 2) + screenW);
        final float chap7Y = screenH - (screenH / 4);
        chap7.setBounds(chap7X, chap7Y, chap7.getWidth(), chap7.getHeight());
        buttonSprites.add(chap7);

        chap8 = new Sprite(chap8Texture);
        chap8.setSize(chap8.getWidth() * getButtonScale(), chap8.getHeight() * getButtonScale());
        if (chapterScores.get(6) == 0) chap8.setAlpha(0.5f);
        final float chap8X = ((screenW / 3) - (chap8.getWidth() / 2) + screenW);
        final float chap8Y = screenH / 2;
        chap8.setBounds(chap8X, chap8Y, chap8.getWidth(), chap8.getHeight());
        buttonSprites.add(chap8);

        chap9 = new Sprite(chap9Texture);
        chap9.setSize(chap9.getWidth() * getButtonScale(), chap9.getHeight() * getButtonScale());
        if (chapterScores.get(7) == 0) chap9.setAlpha(0.5f);
        final float chap9X = ((screenW / 3) - (chap9.getWidth() / 2)) + screenW;
        final float chap9Y = screenH / 4;
        chap9.setBounds(chap9X, chap9Y, chap9.getWidth(), chap9.getHeight());
        buttonSprites.add(chap9);

        chap10 = new Sprite(chap10Texture);
        chap10.setSize(chap10.getWidth() * getButtonScale(), chap10.getHeight() * getButtonScale());
        if (chapterScores.get(8) == 0) chap10.setAlpha(0.5f);
        final float chap10X = (screenW / 1.8f) + screenW;
        chap10.setBounds(chap10X, chap1Y, chap10.getWidth(), chap10.getHeight());
        buttonSprites.add(chap10);

        chap11 = new Sprite(chap11Texture);
        chap11.setSize(chap11.getWidth() * getButtonScale(), chap11.getHeight() * getButtonScale());
        if (chapterScores.get(9) == 0) chap11.setAlpha(0.5f);
        final float chap11X = (screenW / 1.8f) + screenW;
        chap11.setBounds(chap11X, chap2Y, chap11.getWidth(), chap11.getHeight());
        buttonSprites.add(chap11);

        chap12 = new Sprite(chap12Texture);
        chap12.setSize(chap12.getWidth() * getButtonScale(), chap12.getHeight() * getButtonScale());
        if (chapterScores.get(10) == 0) chap12.setAlpha(0.5f);
        final float chap12X = (screenW / 1.8f) + screenW;
        chap12.setBounds(chap12X, chap3Y, chap12.getWidth(), chap12.getHeight());
        buttonSprites.add(chap12);

        chap13 = new Sprite(chap13Texture);
        chap13.setSize(chap13.getWidth() * getButtonScale(), chap13.getHeight() * getButtonScale());
        if (chapterScores.get(11) == 0) chap13.setAlpha(0.5f);
        final float chap13X = ((screenW / 3) - (chap13.getWidth() / 2) + (screenW * 2));
        final float chap13Y = screenH - (screenH / 4);
        chap13.setBounds(chap13X, chap13Y, chap13.getWidth(), chap13.getHeight());
        buttonSprites.add(chap13);

        chap14 = new Sprite(chap14Texture);
        chap14.setSize(chap14.getWidth() * getButtonScale(), chap14.getHeight() * getButtonScale());
        if (chapterScores.get(12) == 0) chap14.setAlpha(0.5f);
        final float chap14X = ((screenW / 3) - (chap14.getWidth() / 2) + (screenW * 2));
        final float chap14Y = screenH / 2;
        chap14.setBounds(chap14X, chap14Y, chap14.getWidth(), chap14.getHeight());
        buttonSprites.add(chap14);

        chap15 = new Sprite(chap15Texture);
        chap15.setSize(chap15.getWidth() * getButtonScale(), chap15.getHeight() * getButtonScale());
        if (chapterScores.get(13) == 0) chap15.setAlpha(0.5f);
        final float chap15X = ((screenW / 3) - (chap15.getWidth() / 2)) + (screenW * 2);
        final float chap15Y = screenH / 4;
        chap15.setBounds(chap15X, chap15Y, chap15.getWidth(), chap15.getHeight());
        buttonSprites.add(chap15);

        chap16 = new Sprite(chap16Texture);
        chap16.setSize(chap16.getWidth() * getButtonScale(), chap16.getHeight() * getButtonScale());
        if (chapterScores.get(14) == 0) chap16.setAlpha(0.5f);
        final float chap16X = (screenW / 1.8f) + (screenW * 2);
        chap16.setBounds(chap16X, chap1Y, chap16.getWidth(), chap16.getHeight());
        buttonSprites.add(chap16);

        chap17 = new Sprite(chap17Texture);
        chap17.setSize(chap17.getWidth() * getButtonScale(), chap17.getHeight() * getButtonScale());
        if (chapterScores.get(15) == 0) chap17.setAlpha(0.5f);
        final float chap17X = (screenW / 1.8f) + (screenW * 2);
        chap17.setBounds(chap17X, chap2Y, chap17.getWidth(), chap17.getHeight());
        buttonSprites.add(chap17);

        chap18 = new Sprite(chap18Texture);
        chap18.setSize(chap18.getWidth() * getButtonScale(), chap18.getHeight() * getButtonScale());
        if (chapterScores.get(16) == 0) chap18.setAlpha(0.5f);
        final float chap18X = (screenW / 1.8f) + (screenW * 2);
        chap18.setBounds(chap18X, chap3Y, chap18.getWidth(), chap18.getHeight());
        buttonSprites.add(chap18);
    }

    @Override
    public void display(Batch batch) {
        if (upTimer < 15)
            upTimer++;
        batch.draw(background, 0, 0, screenWidth, screenHeight);
        for(Sprite button : buttonSprites) {
            button.draw(batch);
        }

        buttonMovementManager();
    }

    @Override
    public void dispose() {
        chap1Texture.dispose();
        chap2Texture.dispose();
        chap3Texture.dispose();
        chap4Texture.dispose();
        chap5Texture.dispose();
        chap6Texture.dispose();
        chap7Texture.dispose();
        chap8Texture.dispose();
        chap9Texture.dispose();
        chap10Texture.dispose();
        chap11Texture.dispose();
        chap12Texture.dispose();
        chap13Texture.dispose();
        chap14Texture.dispose();
        chap15Texture.dispose();
        chap16Texture.dispose();
        chap17Texture.dispose();
        chap18Texture.dispose();
    }

    /**
     * Detect Touch listener for Chapter select view. If an accessible chapter is touched, return its number
     * so we open the lecture for that chapter from Students View
     * @param x The x coordinate of touched screen
     * @param y The x coordinate of touched screen
     * @return int
     */
    public int touchDown(float x, float y) {
        touchX = x;
        touchY = y;

        for (int c = 0; c < 19; c++) {
            if ((c == 0 || chapterScores.get(c) > 0) && buttonSprites.get(c).getBoundingRectangle().contains(x, y))
                return c + 1;
        }

        return 0;
    }

    public void touchDragged(int x, int y) {
        float slide = touchX - x;
        if (slide >= screenWidth * 0.20f)
            moveLeft();
        else if (slide <= screenWidth * -0.20f)
            moveRight();
    }

    /**
     * If this is triggered, animates all buttons to move to the right, unless
     * there are no more buttons to move
     */
    private void moveRight() {
        if (!isMovingRight && !isMovingLeft && chapterSection < 0) {
            isMovingRight = true;
            chapterSection++;
        }
    }

    /**
     * If this is triggered, animates all buttons to move to the left, unless
     * there are no more buttons to move
     */
    private void moveLeft() {
        if (!isMovingRight && !isMovingLeft && chapterSection > -2) {
            chapterSection--;
            isMovingLeft = true;
        }
    }

    /**
     * Animates all the buttons either left or right, depending on how
     * user slides the screen horizontally
     */
    private void buttonMovementManager() {
        final float scrollSpeed = 60;
        if (isMovingLeft) {
            movementCursorLimit = screenWidth * chapterSection;
            for (Sprite button : buttonSprites) {
                button.setX(button.getX() - scrollSpeed);
            }
            movementCursor-=scrollSpeed;
            if (movementCursor <= movementCursorLimit) {
                isMovingLeft = false;
            }
        }

        if (isMovingRight) {
            movementCursorLimit = screenWidth * chapterSection;
            for (Sprite button : buttonSprites) {
                button.setX(button.getX() + scrollSpeed);
            }
            movementCursor+=scrollSpeed;
            if (movementCursor >= movementCursorLimit) {
                isMovingRight = false;
            }
        }
    }

    /**
     * Determines if all ChapterSelect view is already setup by giving it 1.5 secs
     * before claiming to be ready / setup
     * @return boolean
     */
    public boolean isSetUp() {
        return upTimer >= 15;
    }
}
