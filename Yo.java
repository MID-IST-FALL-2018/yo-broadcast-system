/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

 /*
  * Updated by Raúl Pardo
  */

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Yo extends JPanel
                        implements ActionListener {
    protected JButton b1, b2;
    protected JLabel l1;

    public Yo() {

        b1 = new JButton("Register in Yo server");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("register");

        b2 = new JButton("Send Yo!");
        b2.setMnemonic(KeyEvent.VK_E);
        b2.setActionCommand("send-yo");
        b2.setEnabled(false);

        l1 = new javax.swing.JLabel();
        l1.setText("Not registered yet!");

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setToolTipText("Click this button to register in the Yo server.");
        b2.setToolTipText("Click this button to send a Yo to everyone.");

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(l1);
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Yo Broadcasting Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Yo newContentPane = new Yo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Simple method to play the Yo! sound.
    // Use it when receiving a notification to play Yo from the server
    private static void playYo() {
      try {
        String soundName = "yo.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      } catch(Exception err) {
        System.out.println("Exception while playing sound: " + err);
      }
    }

    // NOTE: This is the only method you must modify.
    // NOTE: You may use the playYo() method above.
    public void actionPerformed(ActionEvent e) {

      // NOTE: If statement executed when clicking on register
      if ("register".equals(e.getActionCommand())) {
        // TODO: Connect to the Yo server 
        // Your code here...

        b2.setEnabled(true); // Enable sending Yo after registering
        b1.setEnabled(false); // Disable registering Yo after registering
        l1.setText("Registered!"); // Informing that registration was successfull

      // NOTE: If statement executed when clicking on send Yo
      } else if ("send-yo".equals(e.getActionCommand())) {
        // TODO: Send a broadcast Yo request to the server
        // Your code here...

      }
    }
}
