import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

public class AIChatbotNLP extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    AIChatbotNLP() {

        // Window title
        setTitle("Artificial Intelligence NLP Chatbot");

        // Window size
        setSize(600, 600);

        // Close program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main layout
        setLayout(new BorderLayout());

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input Text Field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 18));

        // Send Button
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 16));
        sendButton.addActionListener(this);

        // Bottom Panel for textbox + button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Add Components Properly
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome Message
        chatArea.append("====================================\n");
        chatArea.append("       AI NLP CHATBOT STARTED\n");
        chatArea.append("====================================\n\n");

        chatArea.append("Bot: Hello! I am your AI NLP Chatbot.\n");
        chatArea.append("Bot: Type your message below.\n\n");

        // Visible
        setVisible(true);
    }

    // NLP Response Method
    public String getBotResponse(String input) {

        input = input.toLowerCase();

        input = input.replaceAll("[^a-zA-Z0-9 ]", "");

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        else if (input.contains("how are you")) {
            return "I am fine and working properly.";
        }

        else if (input.contains("your name")) {
            return "I am an Artificial Intelligence NLP Chatbot.";
        }

        else if (input.contains("java")) {
            return "Java is an object-oriented programming language.";
        }

        else if (input.contains("ai")) {
            return "Artificial Intelligence helps machines think intelligently.";
        }

        else if (input.contains("machine learning")) {
            return "Machine Learning is a subset of Artificial Intelligence.";
        }

        else if (input.contains("nlp")) {
            return "NLP stands for Natural Language Processing.";
        }

        else if (input.contains("time")) {
            return "Current Time: " + LocalTime.now();
        }

        else if (input.contains("thank")) {
            return "You are welcome!";
        }

        else if (input.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else {
            return "Sorry, I could not understand.";
        }
    }

    // Button Click
    @Override
    public void actionPerformed(ActionEvent e) {

        String userInput = inputField.getText();

        if (userInput.trim().equals("")) {
            return;
        }

        // Show User Message
        chatArea.append("You: " + userInput + "\n");

        // Bot Response
        String response = getBotResponse(userInput);

        chatArea.append("Bot: " + response + "\n\n");

        // Clear textbox
        inputField.setText("");

        // Auto scroll down
        chatArea.setCaretPosition(chatArea.getDocument().getLength());

        // Exit
        if (userInput.equalsIgnoreCase("bye")) {
            JOptionPane.showMessageDialog(this, "Chatbot Closed");
            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {

        new AIChatbotNLP();
    }
}