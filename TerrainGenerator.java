import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TerrainGenerator extends JFrame {
    private TerrainPanel terrainPanel;
    private JTextField seedInput;
    private JButton generateButton;
    private JButton randomSeedButton;
    private String currentSeed;
    private static final int SIZE = 400;

    public TerrainGenerator() {
        setupUI();
        generate();
    }

    private void setupUI() {
        setTitle("Terrain Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // learned about layouts from previous project
        terrainPanel = new TerrainPanel();
        terrainPanel.setPreferredSize(new Dimension(SIZE, SIZE)); //searched google how to set size cuz i forgot, also includes pack feature below
        add(terrainPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(new JLabel("Seed:"));

        seedInput = new JTextField(currentSeed, 10);
        controlPanel.add(seedInput);

        generateButton = new JButton("Generate");
        generateButton.addActionListener(e -> {
            currentSeed = seedInput.getText();
            generate();
        });
        controlPanel.add(generateButton);

        randomSeedButton = new JButton("Random Seed");
        randomSeedButton.addActionListener(e -> {
            currentSeed = generateSeed();
            seedInput.setText(currentSeed);
            generate();
        });
        controlPanel.add(randomSeedButton);

        add(controlPanel, BorderLayout.SOUTH);

        pack(); // check setPrefferedSize comment
        setLocationRelativeTo(null); // wanted the window to be created in the middle and google told me this
    }

    private String generateSeed() {
        String potentials = "abcdefghijklmnopqrstuvwxyz0123456789";
        String seed = new String();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(potentials.length()) + 1; i++) {
            seed += (potentials.charAt(random.nextInt(potentials.length())));
        }
        System.out.println(seed);
        return seed;
    }

    private void generate() {

    }
}
