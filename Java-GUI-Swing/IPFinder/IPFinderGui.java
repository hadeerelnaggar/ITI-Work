package IPFinder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.*;

public class IPFinderGui extends JFrame {
    JLabel label=new JLabel("Enter URL: ");
    JTextField urlTextField=new JTextField();
    JButton findIP=new JButton("Find IP");
    JOptionPane popup=new JOptionPane();
    public IPFinderGui(){
        this.add(label);
        label.setBounds(100,160,160,20);
        this.add(urlTextField);
        //urlTextField.setSize(150,20);
        urlTextField.setBounds(170,160,150,20);
        this.add(findIP);
        findIP.setBounds(150,190,80,20);
        this.setTitle("IP Finder Tool-Event Handling Demo");
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        findIP.addActionListener(this::onFindIpClick);
        this.getRootPane().setDefaultButton(findIP);
    }
    public void onFindIpClick(ActionEvent e){
        System.out.println(e.paramString());
        String IPAdress;
        String text=urlTextField.getText();
        try {
            URI uri=new URI(urlTextField.getText());
            if(uri.getHost()==null){
                System.out.println("kkk");
                IPAdress = InetAddress.getByName(text).getHostAddress();
            }
            else{
                IPAdress = InetAddress.getByName(uri.getHost()).getHostAddress();
            }

            JOptionPane.showMessageDialog(IPFinderGui.this,"Url: " + urlTextField.getText() + "\nIP adress:" + IPAdress,"Message",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(IPFinderGui.this,"please enter valid host name","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(IPFinderGui.this,"please enter valid host name","Error",JOptionPane.ERROR_MESSAGE);
        }

    }
}
