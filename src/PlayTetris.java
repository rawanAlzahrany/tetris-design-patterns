




import javax.swing.*;
import java.awt.*;

public class PlayTetris extends JFrame {

    public PlayTetris() {

        super("Tetris - Design Patterns");

        // OLD VERSION - original window layout
        // getContentPane().setLayout(new FlowLayout());
        // add(new TetrisComponent(10,20));

        // ========== DECORATOR START ==========

        getContentPane().setLayout(new BorderLayout());

        // Store the game so we can change its theme
        TetrisComponent game = new TetrisComponent(10, 20);

        // Theme selection panel
        JPanel themePanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        themePanel.add(new JLabel("Block Theme:"));

        JComboBox<String> themeSelector =
                new JComboBox<>(new String[]{
                    "Original", "Pastel", "Neon"
                });

        themeSelector.addActionListener(event -> {

            // Start with the original block appearance
            BlockDraw blockDraw = new BasicBlockDraw();

            String selected =
                (String) themeSelector.getSelectedItem();

            // Apply the selected decorator
            if ("Pastel".equals(selected)) {

                blockDraw = new PastelThemeDecorator(blockDraw);

            } else if ("Neon".equals(selected)) {

                blockDraw = new NeonThemeDecorator(blockDraw);
            }

            // Update the game appearance
            game.setBlockDraw(blockDraw);
            game.requestFocusInWindow();
        });

        themePanel.add(themeSelector);

        add(themePanel, BorderLayout.NORTH);
        add(game, BorderLayout.CENTER);

        // ========== DECORATOR END ==========

        // Original window setup
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window
        setLocationRelativeTo(null);
        setVisible(true);

        // ========== DECORATOR START ==========
        // Return keyboard focus to the game when it opens
        SwingUtilities.invokeLater(
            () -> game.requestFocusInWindow());
        // ========== DECORATOR END ==========
    }

    public static void main(String[] args) {

        // Original main method - unchanged
        new PlayTetris();
    }
}
