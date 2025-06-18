import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TerrainPanel extends JPanel {
    TerrainGenerator terrainGenerator;

    public TerrainPanel(TerrainGenerator terrainGenerator) {
        this.terrainGenerator = terrainGenerator;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int x = 0; x < terrainGenerator.getTerrainSize(); x++) {
            for (int y = 0; y < terrainGenerator.getTerrainSize(); y++) {
                double elevation = terrainGenerator.getElevation(x, y);
                Color pixelColor = terrainGenerator.getTerrainColor(elevation);
                g.setColor(pixelColor);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
