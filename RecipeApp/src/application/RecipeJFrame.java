package application;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RecipeJFrame extends JFrame {

	private RecipeSelect rs;
	private CardLayout cl;


	/**
	 * Create the frame
	 */
	private static final long serialVersionUID = 2861580930946856409L;

	public RecipeJFrame() {
		//Frame set up
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(550, 700);
		this.setVisible(true);
		setVisible(true);
		setEnabled(true);		
		getContentPane().setLayout(null);

		//This JPanel is the base for CardLayout for other JPanels
		JPanel cardPanel = new JPanel(); 
		cardPanel.setBounds(10, 57, 518, 608); 
		cl = new CardLayout();
		cardPanel.setLayout(cl);

		/*Creating objects of the Panel series classes to allow
		 * them to be added to the JPanel having CardLayout.
		 */

		// Table view on main page (Card 1)
		JPanel jpT = new JPanel(); 
		cardPanel.add(jpT, CARD_TABLE);
		jpT.setLayout(new GridLayout(0, 1, 0, 0));
		jpT.add(new JScrollPane(tableContents()));

		// Recipe view on card 2
		JPanel jpV = new JPanel(); 
		cardPanel.add(jpV, CARD_VIEW);
		jpV.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane scrollPaneV = new JScrollPane(viewRecipe());
		jpV.add(scrollPaneV);

		// Create Recipe on card 3
		JPanel jpC = new JPanel(); 
		cardPanel.add(jpC, CARD_CREATE);
		jpC.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane scrollPaneC = new JScrollPane(createRecipe());
		jpC.add(scrollPaneC);


		JPanel jpP = new JPanel();
		cardPanel.add(jpP, CARD_PlANNER);
		jpP.setLayout(new GridLayout(0, 1, 0, 0));
		jpP.add(new JScrollPane(tableContents()));

		//Add the JPanel and buttonPanel to JFrame
		getContentPane().add(cardPanel);
		//pack();
		buttonPanel();


	}


	/*
	 * public JPanel viewTable() {
	 * 
	 * tableContents(); table.setBounds(getMaximizedBounds()); return null; }
	 */

	private JTable tableContents() {
		JTable table;
		String[] columnNames = {"Title", "Category"};

		Object[][] data = {
				{"Chicken Curry", "Chicken"},
				{"Beef Stroganoff", "Beef"}
		};

		table = new JTable(data, columnNames);
		return table;

	}

	public Component viewRecipe() {

		this.rs = new RecipeSelect(); 
		return rs;
	}

	private Component createRecipe() {
		this.rs = new RecipeSelect(); 
		return rs;	}


	public void buttonPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 119, 665);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{101, 0};
		gbl_panel.rowHeights = new int[]{23, 23, 23, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JButton btnViewR = new JButton("View Recipe");
		GridBagConstraints gbc_btnViewR = new GridBagConstraints();
		gbc_btnViewR.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnViewR.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewR.gridx = 0;
		gbc_btnViewR.gridy = 0;
		panel.add(btnViewR, gbc_btnViewR);		


		JButton btnCreateR = new JButton("Create Recipe");
		GridBagConstraints gbc_btnCreateR = new GridBagConstraints();
		gbc_btnCreateR.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateR.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateR.gridx = 0;
		gbc_btnCreateR.gridy = 1;
		panel.add(btnCreateR, gbc_btnCreateR);
		//btnCreateR.setSize(new Dimension(110, 30));

		JButton btnMealPlan = new JButton("Meal Planner");
		GridBagConstraints gbc_btnMealPlan = new GridBagConstraints();
		gbc_btnMealPlan.insets = new Insets(0, 0, 5, 0);
		gbc_btnMealPlan.fill = GridBagConstraints.BOTH;
		gbc_btnMealPlan.gridx = 0;
		gbc_btnMealPlan.gridy = 2;
		panel.add(btnMealPlan, gbc_btnMealPlan);
		//btnMealPlan.setPreferredSize(new Dimension(110, 30));

	}
}