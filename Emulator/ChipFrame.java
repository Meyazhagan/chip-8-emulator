package Emulator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import chip8.*;

public class ChipFrame extends JFrame implements KeyListener {

  private static final long serialVersionUID = 1L;
  private ChipPanel panel;
  private int[] keyBuffer;
  private int[] KeyIDtoKey;

  ChipFrame(Chip c) {
    setPreferredSize(new Dimension(640, 320));
    pack();
    setPreferredSize(
        new Dimension(640 + getInsets().right + getInsets().left, 320 + getInsets().top + getInsets().bottom));
    panel = new ChipPanel(c);
    setLayout(new BorderLayout());
    add(panel, BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Chip 8 Emulator");
    pack();
    setVisible(true);
    addKeyListener(this);

    keyBuffer = new int[16];
    KeyIDtoKey = new int[256];
    fillKeys();
  }

  public void fillKeys() {
    for(int i=0; i< KeyIDtoKey.length; i++){
      KeyIDtoKey[i] = -1;
    }
    KeyIDtoKey['1'] = 1;
    KeyIDtoKey['2'] = 2;
    KeyIDtoKey['3'] = 3;
    KeyIDtoKey['Q'] = 4;
    KeyIDtoKey['W'] = 5;
    KeyIDtoKey['E'] = 6;
    KeyIDtoKey['A'] = 7;
    KeyIDtoKey['S'] = 8;
    KeyIDtoKey['D'] = 9;
    KeyIDtoKey['Z'] = 0XA;
    KeyIDtoKey['X'] = 0;
    KeyIDtoKey['C'] = 0XB;
    KeyIDtoKey['4'] = 0XC;
    KeyIDtoKey['R'] = 0XD;
    KeyIDtoKey['F'] = 0XE;
    KeyIDtoKey['V'] = 0XF;
  }
  @Override
  public void keyPressed(KeyEvent e){
    if(KeyIDtoKey[e.getKeyCode()] != -1){
      keyBuffer[KeyIDtoKey[e.getKeyCode()]] = 1;
    }
  }
  @Override
  public void keyReleased(KeyEvent e){
    if(KeyIDtoKey[e.getKeyCode()] != -1){
      keyBuffer[KeyIDtoKey[e.getKeyCode()]] = 0;
    }
  }
  @Override
  public void keyTyped(KeyEvent e){
  }
  public int[] getkeyBuffer(){
    return keyBuffer;
  }
}