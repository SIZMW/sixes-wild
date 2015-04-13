/**
 * 
 */
package SixesWild.com.mimas.sixeswild.boundaries;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * @author Joey Perez
 *
 */
@SuppressWarnings("serial")
public class CreditsView extends JPanel {

	
/*
 * @Constructor
 * Creates a CreditsView Instance
 */
	public CreditsView(){
		setForeground(Color.BLUE);
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("=========CREDITS=========");
		
		JLabel lblNewLabel_1 = new JLabel("Joey Perez\r\n");
		
		JLabel lblNewLabel_2 = new JLabel("Marco Duran");
		
		JLabel lblNewLabel_3 = new JLabel("Cameron Jones");
		
		JLabel lblNewLabel_4 = new JLabel("Aditya Nivarthi");
		
		JLabel lblNewLabel_5 = new JLabel("Yahel Nachum");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addGap(131))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(203)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(21)))
					.addGap(173))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addGap(139))
		);
		setLayout(groupLayout);
		
	}
}
