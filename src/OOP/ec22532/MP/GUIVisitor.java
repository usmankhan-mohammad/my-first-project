package OOP.ec22532.MP;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;



class GUIVisitor implements Visitor {

    JFrame db = new JFrame();
    private JButton YesB;
    private JButton NoB;
    private JTextPane OutputText;
    private JPanel mainPanel;

    JComboBox arrayCB;
    private JButton submitButton;
    private JTextField inputTextField;
    private JButton inputButton;
    private JLabel currentGold;

    private PrintStream out;
    private Scanner in;
    private int purse;
    private Item[] items;
    private int next;

    protected int yesno = 0;
    protected String chosen;
    protected String inputText;
    protected boolean submitIsClicked;

    protected boolean inputIsClicked;




    Color currentCol = new Color(0,0,0);

    public void changeCol(Color color){
        OutputText.setText("");
        currentCol = color;
    }
    public void resetBs(){
        YesB.setEnabled(false);
        NoB.setEnabled(false);
        yesno = 0;
    }

    public void turnOnBs(){
        YesB.setEnabled(true);
        NoB.setEnabled(true);
    }
    public GUIVisitor(PrintStream ps, InputStream is) {
        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        next = 0;

        YesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    NoB.setEnabled(false);
                    yesno = 1;
            }
        });
        NoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    YesB.setEnabled(false);
                    yesno = 2;
            }
        });


        db.getContentPane().add(mainPanel);
        db.setTitle("GUI by ec22532");
        db.setSize(1600,900);
        db.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        db.setVisible(true);
        currentGold.setText("Gold: " + purse);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosen = arrayCB.getSelectedItem().toString();
                submitIsClicked = true;
            }
        });
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputText = inputTextField.getText();
                inputIsClicked = true;
            }
        });
    }


    private static final char[] yOrN = { 'y', 'n'};

    public void tell(String m) {
        final String RED = "\\u001B[31m";
        final String RESET = "\u001B[0m";



        if (m.charAt(0) == '/'){
            String n = m.replaceFirst("/","");
            String msg = (n+"\n");
            appendToPane(OutputText, msg, Color.red);
        }
        else{
            String msg = (m+"\n");
            appendToPane(OutputText, msg, currentCol);
        }
    }

    private void appendToPane(JTextPane tp, String msg, Color c)
    {
        //borrowed from https://stackoverflow.com/questions/9650992/how-to-change-text-color-in-the-jtextarea
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }


    public String getInputText(){
        inputIsClicked = false;
        inputButton.setEnabled(true);
        inputTextField.setEnabled(true);
        while(!inputIsClicked){
            db.repaint();
        }
        String str = inputText;
        tell("/"+str);
        inputText = "";
        inputIsClicked = true;
        inputButton.setEnabled(false);
        inputTextField.setEnabled(false);
        inputTextField.setText("");
        return str;
    }

    public char getChoice(String d, char[] a) {
        tell(d);
        //char[] heroes = {'I','H','T','A','S'}
        if (a[0] == 'y' && a[1] == 'n'){
            while (yesno == 0){
                turnOnBs();
            }
            if (yesno == 1){
                resetBs();
                tell("/y");
                return 'y';
            }
            else if (yesno == 2){
                resetBs();
                tell("/n");
                return 'n';
            }
            else{
                resetBs();
                return '?';
            }

        }
        else if (a.length != 0){
            submitIsClicked = false;
            submitButton.setEnabled(true);
            arrayCB.setEnabled(true);
            arrayCB.removeAllItems();;

            for (int i = 0; i < a.length; i ++){
                arrayCB.addItem(a[i]);
            }
            while(!submitIsClicked){
                db.repaint();
            }
            char chosenChar = chosen.charAt(0);
            arrayCB.setEnabled(false);
            submitButton.setEnabled(false);
            boolean found = false;
            int i = 0;
            do{
                if (chosenChar == a[i]){
                    found = true;
                }
                i ++;
            }while(!found || (i != a.length));

            chosen = null;
            submitIsClicked = false;
            if (found){
                tell("/" + chosenChar);
                return chosenChar;
            }
            else{
                return '?';
            }


        }
        else{
            if (!in.hasNextLine()) {
                tell("'No line' error");
                return '?';
            }
            String t = in.nextLine();
            if (t.length() > 0)
                return t.charAt(0);
            else {
                if (a.length > 0) {
                    tell("Returning "+a[0]);
                    return a[0];
                } else {
                    tell("Returning '?'");
                    return '?';
                }
            }
        }

    }

    public boolean giveItem(Item x) {
        tell("You have: ");
        for (int i=0;i<next;i++) tell(items[i] + ", ");
        tell("You are being offered: "+x.name);
        if (next >= items.length) {
            tell("But you have no space and must decline.");
            return false;
        }
        if (getChoice("Do you accept (y/n)?", yOrN) == 'y') {
            items[next] = x;
            next++;
            return true;
        } else return false;
    }

    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++)
            if (x == items[i])
                return true;
        return false;
    }

    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++)
            if (x.equals(items[i]))
                return true;
        return false;
    }

    public void giveGold(int n) {
        tell("You are given "+n+" gold pieces.");
        purse += n;
        tell("You now have "+purse+" pieces of gold.");
        currentGold.setText("Gold: " + purse);
    }

    public int takeGold(int n) {

        if (n<0) {
            tell("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            tell("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }

        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        tell(t+" pieces of gold are taken from you.");
        purse -= t;
        tell("You now have "+purse+" pieces of gold.");

        return t;
    }
}





