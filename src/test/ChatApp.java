package test;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.html.HTMLDocument;

public class ChatApp extends JFrame {
    private JTextPane messagePane;
    private HTMLDocument document;

    public ChatApp() {
        setTitle("Chat App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messagePane = new JTextPane();
        messagePane.setContentType("text/html");
        messagePane.setEditable(false);

        document = new HTMLDocument();
        messagePane.setStyledDocument(document);

        JScrollPane scrollPane = new JScrollPane(messagePane);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Example: Send a message
        sendMessage("User1", "Hello!");
        sendMessage("User2", "Hi there!");

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void sendMessage(String user, String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedTime = now.format(formatter);

        try {
            document.insertString(document.getLength(), "<b>" + user + ":</b> [" + formattedTime + "] " + message + "<br>", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Scroll to the bottom after adding a new message
        messagePane.setCaretPosition(document.getLength());
        
        GridLayout g = new GridLayout();
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatApp::new);
    }
}
