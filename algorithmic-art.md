# Algorithmic Art Generator – Extra Credit Assignment

## Overview

In this extra credit project, you'll create a visually compelling piece of algorithmic artwork using Java. You’ll choose one algorithm from the list below or propose your own, and implement it using Java Swing to render the output.

This project is designed to strengthen your understanding of algorithms, creative coding, and graphical UI programming.

---

## Timeline

- **Day 1 (40 minutes)** – Start designing and implementing your chosen algorithm.
- **Day 2 (40 minutes)** – Continue developing and polish your artwork.
- **Day 3 (40 minutes)** – Demo day: You will present your artwork and walk through your code with the teacher.

Note: You may also work on the project outside of class.

---

## Algorithm Choices (Pick One)

### 1. Mandelbrot Set Fractal
- Plot the Mandelbrot set by iterating the function `z = z² + c` over each pixel.
- Use the number of iterations before escaping a threshold (e.g. |z| > 2) to determine pixel color.
- Focus: Complex number logic, coordinate mapping, iteration.

### 2. L-System Tree Generator
- Use an L-System (Lindenmayer System) to recursively generate a branching pattern (like a fractal tree).
- Example rule: `F -> F[+F]F[-F]F`
- Use stack-based drawing (turtle graphics-like logic).
- Focus: Recursion, string rewriting, geometry.

### 3. Perlin Noise Terrain Map
- Simulate 2D Perlin noise (or a simplified noise function) to generate elevation values across a grid.
- Use colors to represent elevation (e.g., blue = water, green = grass, white = snow).
- Focus: Randomness, smoothing/interpolation, procedural generation.

### 4. Student-Designed Algorithmic Art or Animation
- Design your own visual algorithm or animation using Java Swing.
- Ideas could include:
  - Cellular automata (e.g. Conway’s Game of Life)
  - Spiral or geometric pattern generators
  - Noise-based animation
  - Random walk art
  - Animated particle systems
- You must get approval from the teacher before starting.

---

## Requirements

- Java Swing UI that displays the final image or animation in a `JPanel` or custom canvas.
- Code must include at least one custom class.
- Artwork must be algorithmically generated (not just hand-placed shapes).
- The program must compile and run without errors.
- Add your own creative touches – colors, styles, animation (optional).

---

## Optional Enhancements (for bonus creativity)

- Add interactivity (e.g., regenerate with a button or key press).
- Animate growth or drawing over time.
- Allow user input for seed, iterations, or complexity.
- Export the artwork as an image file (PNG or JPG).

---

## Demo & Grading

On the third class period, you will:

- Run the program live and show the final output.
- Give a brief code walkthrough explaining the core logic and class structure.
- Be prepared to answer questions about how your code works.

There is no numeric rubric—extra credit will be based on:

- Completion and functionality
- Code clarity and design
- Creativity and polish
- Engagement and explanation during the demo

---

## Tips

- Use `paintComponent(Graphics g)` in a custom `JPanel` to draw.
- Avoid running heavy calculations directly inside `paintComponent`—precompute if needed.
- Commit your work regularly using Git (if using GitHub or a local repo).
- Test with different sizes, scales, and color schemes to improve visual appeal.

---

## Submission

You’ll demonstrate your project live during class. No formal submission is required unless otherwise requested. Make sure your code is ready to run on demo day.
