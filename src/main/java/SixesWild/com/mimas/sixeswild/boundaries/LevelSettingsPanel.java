package SixesWild.com.mimas.sixeswild.boundaries;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class LevelSettingsPanel extends JPanel {
	private JTextField userLevelNameTextField;
	private JTextField movesTextField;
	private JTextField timerTextField;
	private JTextField onesTextField;
	private JTextField foursTextField;
	private JTextField twosTextField;
	private JTextField fivesTextField;
	private JTextField threesTextField;
	private JTextField sixesTextField;
	private JTextField xthreeMultiplierTextField;
	private JTextField xtwoMultiplierTextField;
	private JTextField oneStarScoreTextField;
	private JTextField twoStarScoreTextField;
	private JTextField threeStarScoreTextField;

	/**
	 * Create the panel.
	 */
	public LevelSettingsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 10.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 5.0, 1.0, 5.0, 1.0, 5.0, 1.0, 5.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel levelSettingLabel = new JLabel("Level Settings");
		levelSettingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelSettingLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		levelSettingLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_levelSettingLabel = new GridBagConstraints();
		gbc_levelSettingLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelSettingLabel.insets = new Insets(0, 0, 5, 5);
		gbc_levelSettingLabel.gridx = 1;
		gbc_levelSettingLabel.gridy = 1;
		add(levelSettingLabel, gbc_levelSettingLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameLabel.gridwidth = 4;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		panel.add(nameLabel, gbc_nameLabel);
		
		userLevelNameTextField = new JTextField();
		userLevelNameTextField.setText("UserLvlName");
		GridBagConstraints gbc_userLevelNameTextField = new GridBagConstraints();
		gbc_userLevelNameTextField.gridwidth = 4;
		gbc_userLevelNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_userLevelNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userLevelNameTextField.gridx = 0;
		gbc_userLevelNameTextField.gridy = 1;
		panel.add(userLevelNameTextField, gbc_userLevelNameTextField);
		userLevelNameTextField.setColumns(10);
		
		JLabel levelTypeLabel = new JLabel("Level Type");
		levelTypeLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_levelTypeLabel = new GridBagConstraints();
		gbc_levelTypeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelTypeLabel.gridwidth = 2;
		gbc_levelTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_levelTypeLabel.gridx = 0;
		gbc_levelTypeLabel.gridy = 2;
		panel.add(levelTypeLabel, gbc_levelTypeLabel);
		
		JComboBox levelTypeComboBox = new JComboBox();
		GridBagConstraints gbc_levelTypeComboBox = new GridBagConstraints();
		gbc_levelTypeComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_levelTypeComboBox.gridwidth = 2;
		gbc_levelTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelTypeComboBox.gridx = 2;
		gbc_levelTypeComboBox.gridy = 2;
		panel.add(levelTypeComboBox, gbc_levelTypeComboBox);
		
		JLabel movesLabe = new JLabel("Moves");
		movesLabe.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_movesLabe = new GridBagConstraints();
		gbc_movesLabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_movesLabe.insets = new Insets(0, 0, 0, 5);
		gbc_movesLabe.gridx = 0;
		gbc_movesLabe.gridy = 3;
		panel.add(movesLabe, gbc_movesLabe);
		
		movesTextField = new JTextField();
		GridBagConstraints gbc_movesTextField = new GridBagConstraints();
		gbc_movesTextField.insets = new Insets(0, 0, 0, 5);
		gbc_movesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_movesTextField.gridx = 1;
		gbc_movesTextField.gridy = 3;
		panel.add(movesTextField, gbc_movesTextField);
		movesTextField.setColumns(10);
		
		JLabel timerLabel = new JLabel("Timer");
		timerLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_timerLabel = new GridBagConstraints();
		gbc_timerLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_timerLabel.insets = new Insets(0, 0, 0, 5);
		gbc_timerLabel.gridx = 2;
		gbc_timerLabel.gridy = 3;
		panel.add(timerLabel, gbc_timerLabel);
		
		timerTextField = new JTextField();
		GridBagConstraints gbc_timerTextField = new GridBagConstraints();
		gbc_timerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_timerTextField.gridx = 3;
		gbc_timerTextField.gridy = 3;
		panel.add(timerTextField, gbc_timerTextField);
		timerTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel frequencyLabel = new JLabel("Frequency of Tiles");
		frequencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frequencyLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		frequencyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_frequencyLabel = new GridBagConstraints();
		gbc_frequencyLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_frequencyLabel.gridwidth = 6;
		gbc_frequencyLabel.insets = new Insets(0, 0, 5, 0);
		gbc_frequencyLabel.gridx = 0;
		gbc_frequencyLabel.gridy = 0;
		panel_1.add(frequencyLabel, gbc_frequencyLabel);
		
		JLabel onesLabel = new JLabel("1's");
		onesLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_onesLabel = new GridBagConstraints();
		gbc_onesLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_onesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_onesLabel.gridx = 0;
		gbc_onesLabel.gridy = 1;
		panel_1.add(onesLabel, gbc_onesLabel);
		
		onesTextField = new JTextField();
		GridBagConstraints gbc_onesTextField = new GridBagConstraints();
		gbc_onesTextField.insets = new Insets(0, 0, 5, 5);
		gbc_onesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_onesTextField.gridx = 1;
		gbc_onesTextField.gridy = 1;
		panel_1.add(onesTextField, gbc_onesTextField);
		onesTextField.setColumns(10);
		
		JLabel twosLabel = new JLabel("2's");
		twosLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_twosLabel = new GridBagConstraints();
		gbc_twosLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_twosLabel.insets = new Insets(0, 0, 5, 5);
		gbc_twosLabel.gridx = 2;
		gbc_twosLabel.gridy = 1;
		panel_1.add(twosLabel, gbc_twosLabel);
		
		twosTextField = new JTextField();
		twosTextField.setColumns(10);
		GridBagConstraints gbc_twosTextField = new GridBagConstraints();
		gbc_twosTextField.insets = new Insets(0, 0, 5, 5);
		gbc_twosTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_twosTextField.gridx = 3;
		gbc_twosTextField.gridy = 1;
		panel_1.add(twosTextField, gbc_twosTextField);
		
		JLabel threesLabel = new JLabel("3's");
		threesLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_threesLabel = new GridBagConstraints();
		gbc_threesLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_threesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_threesLabel.gridx = 4;
		gbc_threesLabel.gridy = 1;
		panel_1.add(threesLabel, gbc_threesLabel);
		
		threesTextField = new JTextField();
		threesTextField.setColumns(10);
		GridBagConstraints gbc_threesTextField = new GridBagConstraints();
		gbc_threesTextField.insets = new Insets(0, 0, 5, 0);
		gbc_threesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_threesTextField.gridx = 5;
		gbc_threesTextField.gridy = 1;
		panel_1.add(threesTextField, gbc_threesTextField);
		
		JLabel foursLabel = new JLabel("4's");
		foursLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_foursLabel = new GridBagConstraints();
		gbc_foursLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_foursLabel.insets = new Insets(0, 0, 5, 5);
		gbc_foursLabel.gridx = 0;
		gbc_foursLabel.gridy = 2;
		panel_1.add(foursLabel, gbc_foursLabel);
		
		foursTextField = new JTextField();
		GridBagConstraints gbc_foursTextField = new GridBagConstraints();
		gbc_foursTextField.insets = new Insets(0, 0, 5, 5);
		gbc_foursTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_foursTextField.gridx = 1;
		gbc_foursTextField.gridy = 2;
		panel_1.add(foursTextField, gbc_foursTextField);
		foursTextField.setColumns(10);
		
		JLabel fivesLabel = new JLabel("5's");
		fivesLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_fivesLabel = new GridBagConstraints();
		gbc_fivesLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_fivesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fivesLabel.gridx = 2;
		gbc_fivesLabel.gridy = 2;
		panel_1.add(fivesLabel, gbc_fivesLabel);
		
		fivesTextField = new JTextField();
		fivesTextField.setColumns(10);
		GridBagConstraints gbc_fivesTextField = new GridBagConstraints();
		gbc_fivesTextField.insets = new Insets(0, 0, 5, 5);
		gbc_fivesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fivesTextField.gridx = 3;
		gbc_fivesTextField.gridy = 2;
		panel_1.add(fivesTextField, gbc_fivesTextField);
		
		JLabel sixesLabel = new JLabel("6's");
		sixesLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_sixesLabel = new GridBagConstraints();
		gbc_sixesLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_sixesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sixesLabel.gridx = 4;
		gbc_sixesLabel.gridy = 2;
		panel_1.add(sixesLabel, gbc_sixesLabel);
		
		sixesTextField = new JTextField();
		sixesTextField.setColumns(10);
		GridBagConstraints gbc_sixesTextField = new GridBagConstraints();
		gbc_sixesTextField.insets = new Insets(0, 0, 5, 0);
		gbc_sixesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sixesTextField.gridx = 5;
		gbc_sixesTextField.gridy = 2;
		panel_1.add(sixesTextField, gbc_sixesTextField);
		
		JLabel xtwosMultiplierLabel = new JLabel("x2 Multiplier");
		xtwosMultiplierLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_xtwosMultiplierLabel = new GridBagConstraints();
		gbc_xtwosMultiplierLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_xtwosMultiplierLabel.gridwidth = 2;
		gbc_xtwosMultiplierLabel.insets = new Insets(0, 0, 0, 5);
		gbc_xtwosMultiplierLabel.gridx = 0;
		gbc_xtwosMultiplierLabel.gridy = 3;
		panel_1.add(xtwosMultiplierLabel, gbc_xtwosMultiplierLabel);
		
		xtwoMultiplierTextField = new JTextField();
		xtwoMultiplierTextField.setColumns(10);
		GridBagConstraints gbc_xtwoMultiplierTextField = new GridBagConstraints();
		gbc_xtwoMultiplierTextField.insets = new Insets(0, 0, 0, 5);
		gbc_xtwoMultiplierTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_xtwoMultiplierTextField.gridx = 2;
		gbc_xtwoMultiplierTextField.gridy = 3;
		panel_1.add(xtwoMultiplierTextField, gbc_xtwoMultiplierTextField);
		
		JLabel xthreeMultiplierLabel = new JLabel("x3 Multiplier");
		xthreeMultiplierLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_xthreeMultiplierLabel = new GridBagConstraints();
		gbc_xthreeMultiplierLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_xthreeMultiplierLabel.gridwidth = 2;
		gbc_xthreeMultiplierLabel.insets = new Insets(0, 0, 0, 5);
		gbc_xthreeMultiplierLabel.gridx = 3;
		gbc_xthreeMultiplierLabel.gridy = 3;
		panel_1.add(xthreeMultiplierLabel, gbc_xthreeMultiplierLabel);
		
		xthreeMultiplierTextField = new JTextField();
		xthreeMultiplierTextField.setColumns(10);
		GridBagConstraints gbc_xthreeMultiplierTextField = new GridBagConstraints();
		gbc_xthreeMultiplierTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_xthreeMultiplierTextField.gridx = 5;
		gbc_xthreeMultiplierTextField.gridy = 3;
		panel_1.add(xthreeMultiplierTextField, gbc_xthreeMultiplierTextField);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 7;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel specialMovesLabel = new JLabel("Special Moves");
		specialMovesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		specialMovesLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		specialMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_specialMovesLabel = new GridBagConstraints();
		gbc_specialMovesLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialMovesLabel.gridwidth = 6;
		gbc_specialMovesLabel.insets = new Insets(0, 0, 5, 0);
		gbc_specialMovesLabel.gridx = 0;
		gbc_specialMovesLabel.gridy = 0;
		panel_2.add(specialMovesLabel, gbc_specialMovesLabel);
		
		JPanel specialMoveOnePanel = new JPanel();
		specialMoveOnePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_specialMoveOnePanel = new GridBagConstraints();
		gbc_specialMoveOnePanel.gridheight = 2;
		gbc_specialMoveOnePanel.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveOnePanel.fill = GridBagConstraints.BOTH;
		gbc_specialMoveOnePanel.gridx = 0;
		gbc_specialMoveOnePanel.gridy = 1;
		panel_2.add(specialMoveOnePanel, gbc_specialMoveOnePanel);
		
		JLabel specialMoveOneLabel = new JLabel("###");
		specialMoveOneLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		specialMoveOneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_specialMoveOneLabel = new GridBagConstraints();
		gbc_specialMoveOneLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialMoveOneLabel.gridwidth = 2;
		gbc_specialMoveOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveOneLabel.gridx = 1;
		gbc_specialMoveOneLabel.gridy = 1;
		panel_2.add(specialMoveOneLabel, gbc_specialMoveOneLabel);
		
		JPanel specialMoveThreePanel = new JPanel();
		specialMoveThreePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_specialMoveThreePanel = new GridBagConstraints();
		gbc_specialMoveThreePanel.gridheight = 2;
		gbc_specialMoveThreePanel.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveThreePanel.fill = GridBagConstraints.BOTH;
		gbc_specialMoveThreePanel.gridx = 3;
		gbc_specialMoveThreePanel.gridy = 1;
		panel_2.add(specialMoveThreePanel, gbc_specialMoveThreePanel);
		
		JLabel specialMoveThreeLabel = new JLabel("###");
		specialMoveThreeLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		specialMoveThreeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_specialMoveThreeLabel = new GridBagConstraints();
		gbc_specialMoveThreeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialMoveThreeLabel.gridwidth = 2;
		gbc_specialMoveThreeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveThreeLabel.gridx = 4;
		gbc_specialMoveThreeLabel.gridy = 1;
		panel_2.add(specialMoveThreeLabel, gbc_specialMoveThreeLabel);
		
		JButton specialMoveOneMinusButton = new JButton("-");
		GridBagConstraints gbc_specialMoveOneMinusButton = new GridBagConstraints();
		gbc_specialMoveOneMinusButton.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveOneMinusButton.gridx = 1;
		gbc_specialMoveOneMinusButton.gridy = 2;
		panel_2.add(specialMoveOneMinusButton, gbc_specialMoveOneMinusButton);
		
		JButton specialMoveOnePlusButton = new JButton("+");
		GridBagConstraints gbc_specialMoveOnePlusButton = new GridBagConstraints();
		gbc_specialMoveOnePlusButton.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveOnePlusButton.gridx = 2;
		gbc_specialMoveOnePlusButton.gridy = 2;
		panel_2.add(specialMoveOnePlusButton, gbc_specialMoveOnePlusButton);
		
		JButton specialMoveThreeMinusButton = new JButton("-");
		GridBagConstraints gbc_specialMoveThreeMinusButton = new GridBagConstraints();
		gbc_specialMoveThreeMinusButton.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveThreeMinusButton.gridx = 4;
		gbc_specialMoveThreeMinusButton.gridy = 2;
		panel_2.add(specialMoveThreeMinusButton, gbc_specialMoveThreeMinusButton);
		
		JButton specialMoveThreePlusButton = new JButton("+");
		GridBagConstraints gbc_specialMoveThreePlusButton = new GridBagConstraints();
		gbc_specialMoveThreePlusButton.insets = new Insets(0, 0, 5, 0);
		gbc_specialMoveThreePlusButton.gridx = 5;
		gbc_specialMoveThreePlusButton.gridy = 2;
		panel_2.add(specialMoveThreePlusButton, gbc_specialMoveThreePlusButton);
		
		JPanel specialMoveTwoPanel = new JPanel();
		specialMoveTwoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_specialMoveTwoPanel = new GridBagConstraints();
		gbc_specialMoveTwoPanel.gridheight = 2;
		gbc_specialMoveTwoPanel.insets = new Insets(0, 0, 0, 5);
		gbc_specialMoveTwoPanel.fill = GridBagConstraints.BOTH;
		gbc_specialMoveTwoPanel.gridx = 0;
		gbc_specialMoveTwoPanel.gridy = 3;
		panel_2.add(specialMoveTwoPanel, gbc_specialMoveTwoPanel);
		
		JLabel specialMoveTwoLabel = new JLabel("###");
		specialMoveTwoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		specialMoveTwoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_specialMoveTwoLabel = new GridBagConstraints();
		gbc_specialMoveTwoLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialMoveTwoLabel.gridwidth = 2;
		gbc_specialMoveTwoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveTwoLabel.gridx = 1;
		gbc_specialMoveTwoLabel.gridy = 3;
		panel_2.add(specialMoveTwoLabel, gbc_specialMoveTwoLabel);
		
		JPanel specialMoveFourPanel = new JPanel();
		specialMoveFourPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_specialMoveFourPanel = new GridBagConstraints();
		gbc_specialMoveFourPanel.gridheight = 2;
		gbc_specialMoveFourPanel.insets = new Insets(0, 0, 0, 5);
		gbc_specialMoveFourPanel.fill = GridBagConstraints.BOTH;
		gbc_specialMoveFourPanel.gridx = 3;
		gbc_specialMoveFourPanel.gridy = 3;
		panel_2.add(specialMoveFourPanel, gbc_specialMoveFourPanel);
		
		JLabel specialMoveFourLabel = new JLabel("###");
		specialMoveFourLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		specialMoveFourLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_specialMoveFourLabel = new GridBagConstraints();
		gbc_specialMoveFourLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialMoveFourLabel.gridwidth = 2;
		gbc_specialMoveFourLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveFourLabel.gridx = 4;
		gbc_specialMoveFourLabel.gridy = 3;
		panel_2.add(specialMoveFourLabel, gbc_specialMoveFourLabel);
		
		JButton specialMoveTwoMinusButton = new JButton("-");
		GridBagConstraints gbc_specialMoveTwoMinusButton = new GridBagConstraints();
		gbc_specialMoveTwoMinusButton.insets = new Insets(0, 0, 0, 5);
		gbc_specialMoveTwoMinusButton.gridx = 1;
		gbc_specialMoveTwoMinusButton.gridy = 4;
		panel_2.add(specialMoveTwoMinusButton, gbc_specialMoveTwoMinusButton);
		
		JButton specialMoveTwoPlusButton = new JButton("+");
		GridBagConstraints gbc_specialMoveTwoPlusButton = new GridBagConstraints();
		gbc_specialMoveTwoPlusButton.insets = new Insets(0, 0, 0, 5);
		gbc_specialMoveTwoPlusButton.gridx = 2;
		gbc_specialMoveTwoPlusButton.gridy = 4;
		panel_2.add(specialMoveTwoPlusButton, gbc_specialMoveTwoPlusButton);
		
		JButton specialMoveFourMinusButton = new JButton("-");
		GridBagConstraints gbc_specialMoveFourMinusButton = new GridBagConstraints();
		gbc_specialMoveFourMinusButton.insets = new Insets(0, 0, 0, 5);
		gbc_specialMoveFourMinusButton.gridx = 4;
		gbc_specialMoveFourMinusButton.gridy = 4;
		panel_2.add(specialMoveFourMinusButton, gbc_specialMoveFourMinusButton);
		
		JButton specialMoveFourPlusButton = new JButton("+");
		GridBagConstraints gbc_specialMoveFourPlusButton = new GridBagConstraints();
		gbc_specialMoveFourPlusButton.gridx = 5;
		gbc_specialMoveFourPlusButton.gridy = 4;
		panel_2.add(specialMoveFourPlusButton, gbc_specialMoveFourPlusButton);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 9;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel scoreCutoffsLabel = new JLabel("Score Cutoffs");
		scoreCutoffsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scoreCutoffsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreCutoffsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_scoreCutoffsLabel = new GridBagConstraints();
		gbc_scoreCutoffsLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_scoreCutoffsLabel.gridwidth = 2;
		gbc_scoreCutoffsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_scoreCutoffsLabel.gridx = 0;
		gbc_scoreCutoffsLabel.gridy = 0;
		panel_3.add(scoreCutoffsLabel, gbc_scoreCutoffsLabel);
		
		JLabel oneStarScoreLabel = new JLabel("1 Star Score");
		oneStarScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		oneStarScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_oneStarScoreLabel = new GridBagConstraints();
		gbc_oneStarScoreLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_oneStarScoreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_oneStarScoreLabel.gridx = 0;
		gbc_oneStarScoreLabel.gridy = 1;
		panel_3.add(oneStarScoreLabel, gbc_oneStarScoreLabel);
		
		oneStarScoreTextField = new JTextField();
		GridBagConstraints gbc_oneStarScoreTextField = new GridBagConstraints();
		gbc_oneStarScoreTextField.insets = new Insets(0, 0, 5, 0);
		gbc_oneStarScoreTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_oneStarScoreTextField.gridx = 1;
		gbc_oneStarScoreTextField.gridy = 1;
		panel_3.add(oneStarScoreTextField, gbc_oneStarScoreTextField);
		oneStarScoreTextField.setColumns(10);
		
		JLabel twoStarScoreLabel = new JLabel("2 Star Score");
		twoStarScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		twoStarScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_twoStarScoreLabel = new GridBagConstraints();
		gbc_twoStarScoreLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_twoStarScoreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_twoStarScoreLabel.gridx = 0;
		gbc_twoStarScoreLabel.gridy = 2;
		panel_3.add(twoStarScoreLabel, gbc_twoStarScoreLabel);
		
		twoStarScoreTextField = new JTextField();
		twoStarScoreTextField.setColumns(10);
		GridBagConstraints gbc_twoStarScoreTextField = new GridBagConstraints();
		gbc_twoStarScoreTextField.insets = new Insets(0, 0, 5, 0);
		gbc_twoStarScoreTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_twoStarScoreTextField.gridx = 1;
		gbc_twoStarScoreTextField.gridy = 2;
		panel_3.add(twoStarScoreTextField, gbc_twoStarScoreTextField);
		
		JLabel threeStarScoreLabel = new JLabel("3 Star Score");
		threeStarScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		threeStarScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_threeStarScoreLabel = new GridBagConstraints();
		gbc_threeStarScoreLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_threeStarScoreLabel.insets = new Insets(0, 0, 0, 5);
		gbc_threeStarScoreLabel.gridx = 0;
		gbc_threeStarScoreLabel.gridy = 3;
		panel_3.add(threeStarScoreLabel, gbc_threeStarScoreLabel);
		
		threeStarScoreTextField = new JTextField();
		threeStarScoreTextField.setColumns(10);
		GridBagConstraints gbc_threeStarScoreTextField = new GridBagConstraints();
		gbc_threeStarScoreTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_threeStarScoreTextField.gridx = 1;
		gbc_threeStarScoreTextField.gridy = 3;
		panel_3.add(threeStarScoreTextField, gbc_threeStarScoreTextField);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 11;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel tileSettingsLabel = new JLabel("Tile Settings");
		tileSettingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileSettingsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tileSettingsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_tileSettingsLabel = new GridBagConstraints();
		gbc_tileSettingsLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileSettingsLabel.gridwidth = 2;
		gbc_tileSettingsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_tileSettingsLabel.gridx = 0;
		gbc_tileSettingsLabel.gridy = 0;
		panel_4.add(tileSettingsLabel, gbc_tileSettingsLabel);
		
		JLabel tileTypeLabel = new JLabel("Tile Type");
		tileTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileTypeLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_tileTypeLabel = new GridBagConstraints();
		gbc_tileTypeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileTypeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_tileTypeLabel.gridx = 0;
		gbc_tileTypeLabel.gridy = 1;
		panel_4.add(tileTypeLabel, gbc_tileTypeLabel);
		
		JComboBox tileTypeComboBox = new JComboBox();
		GridBagConstraints gbc_tileTypeComboBox = new GridBagConstraints();
		gbc_tileTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileTypeComboBox.gridx = 1;
		gbc_tileTypeComboBox.gridy = 1;
		panel_4.add(tileTypeComboBox, gbc_tileTypeComboBox);

	}

}
