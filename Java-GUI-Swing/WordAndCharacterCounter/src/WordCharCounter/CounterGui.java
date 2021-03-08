package WordCharCounter;

import javax.swing.*;

class CounterGui extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JButton words = new JButton("Words");
    private JButton characters = new JButton("Characters");
    CounterGui(){
        textArea.setBounds(10,10,380,300);
        words.setBounds(90,320,100,20);
        characters.setBounds(200,320,100,20);
        this.add(textArea);
        this.add(words);
        this.add(characters);
        this.setLayout(null);
        this.setTitle("Word Character Counter-String Demo");
        words.addActionListener((e)-> {
                int wordsCount=textArea.getText().split(" |\n").length;
                JOptionPane.showMessageDialog(CounterGui.this,"Total words:"+wordsCount,"message",JOptionPane.INFORMATION_MESSAGE);
        });
        characters.addActionListener((e)-> {
                String text=textArea.getText().replace("\n","");
                int characterCount = text.length();
                JOptionPane.showMessageDialog(CounterGui.this,"Total characters:"+characterCount,"message",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
