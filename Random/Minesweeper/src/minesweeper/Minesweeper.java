package minesweeper;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Minesweeper extends JFrame {
	private static final long serialVersionUID = -7926222441084157804L;
	int width;
	int height;
	int bombs;
	JFrame frame;
	JPanel gridPanel;
	GridSquare[][] grid;
	private static final ImageIcon BLANK = new ImageIcon("assets/blankSquare.png");
	private static final ImageIcon MARKED = new ImageIcon("assets/markedSquare.png");
	private static final ImageIcon EMPTY = new ImageIcon("assets/noSquare.png");
	private static final ImageIcon MINE_CLICKED = new ImageIcon("assets/mines/clickedSquare.png");
	private static final ImageIcon MINE = new ImageIcon("assets/mines/mineSquare.png");
	private static final ImageIcon ONE = new ImageIcon("assets/numbers/oneSquare.png");
	private static final ImageIcon TWO = new ImageIcon("assets/numbers/twoSquare.png");
	private static final ImageIcon THREE = new ImageIcon("assets/numbers/threeSquare.png");
	private static final ImageIcon FOUR = new ImageIcon("assets/numbers/fourSquare.png");
	private static final ImageIcon FIVE = new ImageIcon("assets/numbers/fiveSquare.png");
	private static final ImageIcon SIX = new ImageIcon("assets/numbers/sixSquare.png");
	private static final ImageIcon SEVEN = new ImageIcon("assets/numbers/sevenSquare.png");
	private static final ImageIcon EIGHT = new ImageIcon("assets/numbers/eightSquare.png");
	private static final ImageIcon[] NUMBER_ICONS = { ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT };
	private static final int TILE_WIDTH = 40;
	private static final int TILE_HEIGHT = 40;
	private boolean gameActive = true;
	private boolean exitWindow = false;
	private SetupWindow setup;

	public Minesweeper(int wide, int high, int bomb, SetupWindow setup) {
		super("Minesweeper");
		width = wide;
		height = high;
		bombs = bomb;
		makeGrid();
		frame = new JFrame("Minesweeper");
		frame.setLayout(new FlowLayout());
		makeGridPanel();
		gridPanel.addMouseListener(new MineListener());
		frame.add(gridPanel);
		refreshBounds();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void awaitCompletion() {
		while (!exitWindow) {
			Thread.onSpinWait();
		}
	}

	private ArrayList<GridSquare> getNearbyTiles(GridSquare[][] grid, GridSquare selected) {
		ArrayList<GridSquare> nearby = new ArrayList<GridSquare>();

		int targetX = 0, targetY = 0;
		for (int i = 0; i < 8; i++) {
			switch (i) {
			case 0:
				targetX = selected.x() + 1;
				targetY = selected.y() + 1;
				break;
			case 1:
				targetX = selected.x() + 1;
				targetY = selected.y() + 0;
				break;
			case 2:
				targetX = selected.x() + 1;
				targetY = selected.y() - 1;
				break;
			case 3:
				targetX = selected.x() + 0;
				targetY = selected.y() - 1;
				break;
			case 4:
				targetX = selected.x() - 1;
				targetY = selected.y() - 1;
				break;
			case 5:
				targetX = selected.x() - 1;
				targetY = selected.y() + 0;
				break;
			case 6:
				targetX = selected.x() - 1;
				targetY = selected.y() + 1;
				break;
			case 7:
				targetX = selected.x() + 0;
				targetY = selected.y() + 1;
				break;
			default:
				throw new IllegalStateException("Unreachable");
			}

			if (targetX < 0 || targetX >= width || targetY < 0 || targetY >= height) {
				continue;
			}

			nearby.add(grid[targetX][targetY]);
		}

		return nearby;
	}

	private class MineListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// Unused
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// Get selected GridSquare
			int x = e.getX() / TILE_WIDTH;
			int y = e.getY() / TILE_HEIGHT;
			System.out.printf("Position for mouse event: x = %d, y = %d\n", x, y);
			GridSquare selected = grid[x][y];

			// Detect button pressed
			if (e.getButton() == MouseEvent.BUTTON1) {
				// Left Click

				// If it's marked as a bomb, don't let the user click it
				if (selected.isMarked()) {
					return;
				}

				// If it's already revealed, try to reveal all nearby tiles if they've already
				// marked the bombs for this tile
				if (selected.isRevealed()) {
					// If the user has already marked all bombs that this tile says there are
					// Start with 0 marked bombs
					int markedBombs = 0;
					// Check all nearby tiles
					for (GridSquare nearbyTile : getNearbyTiles(grid, selected)) {
						// If it's marked
						if (nearbyTile.isMarked())
							// Increment the markedBombs counter
							markedBombs++;
					}
					// If the number of marked bombs equals the number of expected bombs
					if (markedBombs == selected.getBombs()) {
						// Reveal all non-marked tiles around the selected tile
						for (GridSquare nearbyTile : getNearbyTiles(grid, selected)) {
							if (!nearbyTile.isMarked()) {
								reveal(nearbyTile);
							}
						}
					}
					// Otherwise, they're clicking on an unmarked, unrevealed tile.
				} else {
					// Let's reveal it.
					reveal(selected);
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				// Right Click

				// If not already revealed
				if (!selected.isRevealed()) {
					// Toggle marked, then update icon
					selected.toggleMarked();
					selected.setIcon(selected.isMarked() ? MARKED : BLANK);
				}
			}
		}

		private void checkWin() {
			int revealCount = 0;
			for (int x = 0; x < width; ++x) {
				for (int y = 0; y < height; ++y) {
					if (grid[x][y].isRevealed()) {
						revealCount++;
					}
				}
			}
			if (revealCount == width * height - bombs) {

				gameActive = false;

				// Show game over dialogue
				JOptionPane.showMessageDialog(setup,
						"Congratulations, you win!\nClose this window to return to the setup window.", "Victory!",
						JOptionPane.DEFAULT_OPTION);

				// Exit this window
				exit();
			}
		}

		private void doLoss() {
			// Show all other tiles
			for (int x = 0; x < width; ++x) {
				for (int y = 0; y < height; ++y) {
					if (!grid[x][y].isRevealed())
						reveal(grid[x][y]);
				}
			}

			// Show game over dialogue
			JOptionPane.showMessageDialog(setup,
					"Oh no, you've lost!\nClose this window to return to the setup window.", "Failure.",
					JOptionPane.DEFAULT_OPTION);
			
			// Exit this window
			exit();
		}
		
		private void exit() {
			// Signal to return to setup window
			exitWindow = true;
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

		private void reveal(GridSquare selected) {
			// No point in revealing a tile that has already been revealed
			if (selected.isRevealed())
				return;
			// Set this tile to know that it has been revealed
			selected.setRevealed(true);
			// Switch based on whether it holds a bomb or how many bombs are nearby
			switch (selected.getBombs()) {
			case 0:
				// This tile is in an empty space
				selected.setIcon(EMPTY);

				// Reveal all tiles around it, in all 8 directions
				for (GridSquare tileToReveal : getNearbyTiles(grid, selected)) {

					// If tile has already been revealed, skip it. This avoids an infinite loop.
					if (tileToReveal.isRevealed()) {
						continue;
					} else {
						reveal(tileToReveal);
					}
				}

				break;
			case 9:
				// This tile is a bomb
				selected.setIcon(gameActive ? MINE_CLICKED : MINE);

				// If this is the first bomb clicked, start the loss method
				if (gameActive) {
					gameActive = false;
					doLoss();
				}

				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				// This tile does not have a bomb, but knows how many are nearby
				// Access 0-indexed array
				selected.setIcon(NUMBER_ICONS[selected.getBombs() - 1]);
				break;
			default:
				throw new IllegalStateException("GridSquare with bombs not between [0-9]: " + selected.getBombs());
			}

			// After processing the click, check to see if the game has been won.
			if (gameActive) {
				checkWin();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// Possibly shade?
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Unused
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Unused
		}

	};

	public void refreshBounds() {
		frame.setBounds((1820 - (width * TILE_WIDTH)) / 2, (880 - (height * TILE_HEIGHT)) / 2,
				(width * TILE_WIDTH) + 100, (height * TILE_HEIGHT) + 200);
	}

	public void makeGrid() {
		grid = new GridSquare[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				grid[x][y] = new GridSquare(x, y);
				grid[x][y].setSize(TILE_WIDTH, TILE_HEIGHT);
				grid[x][y].setIcon(BLANK);
				if (x == 0 || y == 0) {
					System.out.println("icon width: " + grid[x][y].getIcon().getIconWidth());
					System.out.println("icon height: " + grid[x][y].getIcon().getIconHeight());
				}
			}
		}
		Random rand = new Random();
		for (int bombNum = 0; bombNum < bombs; bombNum++) {
			int xCoord;
			int yCoord;
			do {
				xCoord = rand.nextInt(width);
				yCoord = rand.nextInt(height);
			} while (grid[xCoord][yCoord].getBombs() == 9);
			grid[xCoord][yCoord].setBombs(9);
		}
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (grid[x][y].getBombs() != 9) {
					int bombsNear = 0;
					for (int i = 0; i < 8; i++) {
						switch (i) {
						case 0: {
							if (x + 1 < 0 || x + 1 >= width || y + 1 < 0 || y + 1 >= height) {
								break;
							}
							bombsNear = (grid[x + 1][y + 1].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 1: {
							if (x + 1 < 0 || x + 1 >= width || y < 0 || y >= height) {
								break;
							}
							bombsNear = (grid[x + 1][y].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 2: {
							if (x + 1 < 0 || x + 1 >= width || y - 1 < 0 || y - 1 >= height) {
								break;
							}
							bombsNear = (grid[x + 1][y - 1].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 3: {
							if (x < 0 || x >= width || y - 1 < 0 || y - 1 >= height) {
								break;
							}
							bombsNear = (grid[x][y - 1].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 4: {
							if (x - 1 < 0 || x - 1 >= width || y - 1 < 0 || y - 1 >= height) {
								break;
							}
							bombsNear = (grid[x - 1][y - 1].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 5: {
							if (x - 1 < 0 || x - 1 >= width || y < 0 || y >= height) {
								break;
							}
							bombsNear = (grid[x - 1][y].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 6: {
							if (x - 1 < 0 || x - 1 >= width || y + 1 < 0 || y + 1 >= height) {
								break;
							}
							bombsNear = (grid[x - 1][y + 1].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						case 7: {
							if (x < 0 || x >= width || y + 1 < 0 || y + 1 >= height) {
								break;
							}
							bombsNear = (grid[x][y + 1].getBombs() == 9) ? bombsNear + 1 : bombsNear;
							break;
						}
						}
					}
					grid[x][y].setBombs(bombsNear);
				}
			}
		}

	}

	private void makeGridPanel() {

		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(height, width));
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				gridPanel.add(grid[x][y]);
			}
		}

	}

	public void setWidth(int i) {
		width = i;
	}

	public void setHeight(int i) {
		height = i;
	}

	public void setBombs(int i) {
		bombs = i;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getBombs() {
		return bombs;
	}

}
