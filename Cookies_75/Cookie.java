import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Cookie {
    private JButton button1;
    private JPanel passwordPane;
    private JPasswordField passwordField1;
    private String url = "http://problems1.2016q1.sctf.io:25565/?";
    private String charset;

    public Cookie() {
        this.$$$setupUI$$$();
        this.charset = StandardCharsets.UTF_8.name();
        this.button1.addActionListener(actionEvent -> {
            if (this.passwordField1.getPassword().length == 0) {
                JFrame newFrame = new JFrame("Error");
                JLabel label = new JLabel("Please enter a password.");
                label.setHorizontalAlignment(0);
                newFrame.add(label);
                newFrame.setPreferredSize(new Dimension(300, 120));
                newFrame.getContentPane();
                newFrame.pack();
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                newFrame.setLocation(dim.width / 2 - newFrame.getSize().width / 2, dim.height / 2 - newFrame.getSize().height / 2);
                newFrame.setVisible(true);
            } else {
                try {
                    MessageDigest digest = MessageDigest.getInstance("MD5");
                    byte[] arr = digest.digest(new String(this.passwordField1.getPassword()).getBytes("UTF-8"));
                    String md5 = new BigInteger(1, arr).toString(16);
                    System.out.println(md5);
                    String answer = "fdf87a05e2169b88a8db5a1ebc15fa50";
                    if (md5.equals(answer)) {
                        System.out.println("success! it's working!");
                    }
                    URLConnection connection = new URL(this.url + new String(this.passwordField1.getPassword())).openConnection();
                    connection.setRequestProperty("Accept-Charset", this.charset);
                    InputStream response = connection.getInputStream();
                    String flag = Cookie.getStringFromInputStream(response);
                    JFrame newFrame = new JFrame("Server Response");
                    JLabel label = new JLabel(flag);
                    label.setHorizontalAlignment(0);
                    JPanel content = new JPanel();
                    content.setLayout(new BoxLayout(content, 1));
                    label.setAlignmentX(0.5f);
                    label.setAlignmentY(0.5f);
                    if (flag.startsWith("sctf")) {
                        JButton copyButton = new JButton("Copy to Clipboard");
                        copyButton.addActionListener(actionEvent1 -> {
                            StringSelection stringSelection = new StringSelection(flag);
                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clipboard.setContents(stringSelection, null);
                        }
                        );
                        copyButton.setAlignmentX(0.5f);
                        copyButton.setAlignmentY(0.5f);
                        content.add(copyButton);
                    }
                    content.add(label);
                    newFrame.add(content);
                    newFrame.setPreferredSize(new Dimension(300, 100));
                    newFrame.getContentPane();
                    newFrame.pack();
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    newFrame.setLocation(dim.width / 2 - newFrame.getSize().width / 2, dim.height / 2 - newFrame.getSize().height / 2);
                    newFrame.setVisible(true);
                }
                catch (Exception e) {
                    System.err.println("rip");
                }
            }
        }
        );
        this.passwordField1.addActionListener(actionEvent -> {
            this.button1.doClick();
        }
        );
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        JFrame frame = new JFrame("Cookie Jar");
        frame.setPreferredSize(new Dimension(500, 120));
        frame.setContentPane(new Cookie().passwordPane);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    private static String getStringFromInputStream(InputStream is) {
        StringBuilder sb;
        BufferedReader br = null;
        sb = new StringBuilder();
        try {
            String line;
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private /* synthetic */ void $$$setupUI$$$() {
        JPasswordField jPasswordField;
        JPanel jPanel;
        JButton jButton;
        this.passwordPane = jPanel = new JPanel();
        jPanel.setLayout((LayoutManager)new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1, false, false));
        jPanel.setBackground(new Color(-8126477));
        JLabel jLabel = new JLabel();
        jLabel.setText("Enter the password to get a cookie!");
        jPanel.add((Component)jLabel, (Object)new GridConstraints(0, 1, 1, 1, 8, 0, 0, 0, null, null, null));
        this.button1 = jButton = new JButton();
        jButton.setText("Submit");
        jPanel.add((Component)jButton, (Object)new GridConstraints(0, 3, 1, 1, 0, 1, 3, 0, null, null, null));
        this.passwordField1 = jPasswordField = new JPasswordField();
        jPanel.add((Component)jPasswordField, (Object)new GridConstraints(0, 2, 1, 1, 8, 1, 6, 0, null, new Dimension(150, -1), null));
        Spacer spacer = new Spacer();
        jPanel.add((Component)spacer, (Object)new GridConstraints(0, 0, 1, 1, 0, 1, 6, 1, null, null, null));
        Spacer spacer2 = new Spacer();
        jPanel.add((Component)spacer2, (Object)new GridConstraints(0, 4, 1, 1, 0, 1, 6, 1, null, null, null));
    }

    public /* synthetic */ JComponent $$$getRootComponent$$$() {
        return this.passwordPane;
    }
}
