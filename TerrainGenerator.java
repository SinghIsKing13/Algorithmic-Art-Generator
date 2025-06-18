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
    private double[][] elevationMap;

    public TerrainGenerator() {
        setupUI();
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
            try {
                generate();
            } catch(Exception lol) {
                System.out.println("Improper Seed");
            }
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
        elevationMap = new double[SIZE][SIZE];

        // very helpful for understanding a simple implementation: https://rtouti.github.io/graphics/perlin-noise-algorithm
        // I also saw the FBM in the above implementation and really liked the idea so I will be implementing that if I have more time at the end
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                double elevation = 0;
                // with the following simpleNoise method calls, x and y are multiplied by values
                // i wanted changes in elevations for very simple things
                // the numbers came from ai because I genuinely didnt know what numbers would be good.
                elevation += simpleNoise(x * 0.005, y * 0.005) * 0.5; //for big changes like islands or continents
                elevation += simpleNoise(x * 0.05, y * 0.05) * 0.3; // for smaller things like hills and valleys
                elevation += simpleNoise(x * 0.1, y * 0.1) * 0.1; //for smallest things like land imperfections or something
                //basically, 60% of the elevation is island/continent, 30% hills/valleys, and 10% imperfections

                elevationMap[x][y] = elevation;
            }
        }
        terrainPanel.repaint();
    }

private double simpleNoise(double x, double y) {
        int leftX = (int) Math.floor(x); //round down to closest int
        int bottomY = (int) Math.floor(y);
        int rightX = leftX + 1;
        int topY = bottomY + 1;
        
        // this will get values for each of the corners based on the seed
        double bottomLeft = getNoiseValue(leftX, bottomY); //nTR means n Top Right
        double bottomRight = getNoiseValue(rightX, bottomY);
        double topLeft = getNoiseValue(leftX, topY);
        double topRight = getNoiseValue(rightX, topY);
        
        double deltaX = x - leftX; //percentage from left to right
        double deltaY = y - bottomY; //percentage from bottom to top
        
        // see last three lines of code here: https://glusoft.com/sdl3-tutorials/procedural-terrain-perlin-noise/
        double bottomBlend = smoothInterpolation(bottomLeft, bottomRight, deltaX);
        double topBlend = smoothInterpolation(topLeft, topRight, deltaX);
        return smoothInterpolation(bottomBlend, topBlend, deltaY);
    }

    // this method is pretty much ai as i could not find a simple value algorithm anywhere
    private double getNoiseValue(int x, int y) {
        int hash = (x * 374761393 + y * 668265263 + currentSeed.hashCode()) % Integer.MAX_VALUE; //this takes the coordinates and creates a random number that is always the same same for those coordinates and seed.
        if (hash < 0)
            hash = -1 * hash; //makes sure it is positive
        return (hash % 1000) / 1000.0; // makes sure it is between 0 and 1
    }

    // see this article: https://glusoft.com/sdl3-tutorials/procedural-terrain-perlin-noise/
    private double linearInterpolation(double x, double y, double s) {
        return x + s * (y - x);
    }
    
    // see same article: https://glusoft.com/sdl3-tutorials/procedural-terrain-perlin-noise/
    private double smoothInterpolation(double x, double y, double s) {
        return linearInterpolation(x, y, s * s * (3 - 2 * s)); // creates s curve instead of blockyness
    }
}
