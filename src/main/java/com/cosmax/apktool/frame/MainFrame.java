package com.cosmax.apktool.frame;

import com.cosmax.apktool.biz.ApkBiz;
import com.cosmax.apktool.entity.MessageStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: apktool
 * @description:
 * @author: Cosmax
 * @create: 2020/11/28 20:59
 */
public class MainFrame {
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel buttomPanel;
    private JButton apkButton;
    private JButton luaDecButton;
    private JTextField srcPathText;
    private JButton choserButton;
    private JPanel panel1;
    private JButton decButton;
    private JButton saveButton;
    private JTextField destPathText;

    public MainFrame() {
        choserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int status = jFileChooser.showOpenDialog(null);
                if (status != 1){
                    srcPathText.setText(jFileChooser.getSelectedFile().getAbsolutePath());
                }

            }
        });
        apkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.setVisible(true);

            }
        });
        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApkBiz apkBiz = new ApkBiz();
                MessageStatus messageStatus = apkBiz.apk2Jar(srcPathText.getText(), destPathText.getText());
                messageShow(messageStatus);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int status = jFileChooser.showOpenDialog(null);
                if (status != 1){
                    destPathText.setText(jFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }

    private void messageShow(MessageStatus messageStatus) {
        if (messageStatus.getCode() == 200) {
            JOptionPane.showMessageDialog(null, messageStatus.getMessage());
        }else {
            JOptionPane.showMessageDialog(null, messageStatus.getMessage(), "错误!",JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,200);
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-frame.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-frame.getHeight())/2;
        frame.setLocation(x, y);
    }
}
