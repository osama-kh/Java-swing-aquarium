package start;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import q3.Fish;
import q3.Jellyfish;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.JTextField;
/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */

public class AddAnimalDialog extends JDialog {

	/**
	 * add Animal Dialog to add the animals to 
	 * the aquarium by its kind and color ,size ,speed
	 */
	
//Initialization of the variables
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Size_of_animal_input;
	private Fish fish;
	private Jellyfish jellyfish;
	private boolean select_type=true;
	private int size1, x_front1=0, y_front1=0, horspeed, virspeed, col1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddAnimalDialog dialog = new AddAnimalDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog and show it.
	 */
	public AddAnimalDialog() {
		setBounds(100, 100, 806, 484);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JCheckBox Isfish = new JCheckBox("Fish");
		JCheckBox IsJellyFish = new JCheckBox("Jelly Fish");
		
		/*
		 * IsFish check box to choose the fish kind
		 */
		Isfish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IsJellyFish.setSelected(false);
				select_type=true;
			}
		});
		
		
		/*
		 * IsJellyFish check box to choose the Jelly fish kind
		 */
		IsJellyFish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Isfish.setSelected(false);
				select_type=false;
			}
		});
		
		/**
		 * Initialization of the Dialog components and to add it
		 */
		JLabel Dialog_title = new JLabel("Add Animal to the Aquariume");
		Dialog_title.setFont(new Font("Tahoma", Font.BOLD, 20));
		Dialog_title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Choose_animal_type_title = new JLabel("Choose animal type:");
		/**
		 * to sit the Horizontal speed of the animal
		 */
		JSlider Horizontal_speed_slider = new JSlider();
		Horizontal_speed_slider.setValue(1);
		Horizontal_speed_slider.setMajorTickSpacing(1);
		Horizontal_speed_slider.setPaintLabels(true);
		Horizontal_speed_slider.setPaintTicks(true);
		Horizontal_speed_slider.setMinimum(1);
		Horizontal_speed_slider.setMaximum(10);
		/**
		 * to sit the vertical speed of the animal
		 */
		JSlider vertical_speed_slider = new JSlider();
		vertical_speed_slider.setValue(1);
		vertical_speed_slider.setPaintTicks(true);
		vertical_speed_slider.setPaintLabels(true);
		vertical_speed_slider.setMinimum(1);
		vertical_speed_slider.setMaximum(10);
		vertical_speed_slider.setMajorTickSpacing(1);
		/**
		 * to sit the color of the animal
		 */
		JSlider animal_color_slider = new JSlider();
		animal_color_slider.setValue(1);
		animal_color_slider.setPaintTicks(true);
		animal_color_slider.setPaintLabels(true);
		animal_color_slider.setMinimum(1);
		animal_color_slider.setMaximum(9);
		animal_color_slider.setMajorTickSpacing(1);
		/**
		 * to sit Size of the animal
		 */
		JLabel Size_of_animal_title = new JLabel("Size of animal :");
		Size_of_animal_input = new JTextField();
		Size_of_animal_input.setText("20");
		Size_of_animal_input.setColumns(10);
		/**
		 * to direct the user how to use the input components 
		 */
		JLabel Size_of_animal_interval = new JLabel("(20~320)");	
		JLabel Horizontal_speed_x = new JLabel("Horizontal speed :");
		JLabel Vertical_speed_title = new JLabel("Vertical speed :");
		JLabel animal_color_title = new JLabel("animal color :");
		JLabel colors_info = new JLabel("color choices:   1:Black    2:Red    3:Blue    4:Green    5:Cyan    6:Orange    7:Yellow    8:Magenta    9:Pink");
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(Size_of_animal_title, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Size_of_animal_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Size_of_animal_interval, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(Choose_animal_type_title, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(Isfish, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(Dialog_title, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addComponent(IsJellyFish, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addGap(189))
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(Vertical_speed_title, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addComponent(Horizontal_speed_x, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(Horizontal_speed_slider, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addComponent(vertical_speed_slider, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)))
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(animal_color_title, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
					.addComponent(animal_color_slider, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
					.addComponent(colors_info, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))))
					.addGap(55))
		);
		gl_contentPanel.setVerticalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addComponent(Dialog_title)
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(Choose_animal_type_title)
					.addComponent(Isfish)
					.addComponent(IsJellyFish))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(Size_of_animal_title)
					.addComponent(Size_of_animal_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(Size_of_animal_interval))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(51)
					.addComponent(Horizontal_speed_x))
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(Horizontal_speed_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(Vertical_speed_title))
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(vertical_speed_slider, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(animal_color_title))
					.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(animal_color_slider, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(colors_info)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
			/**
			 * to initialize the OK button
			 */
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				/**
				 * to add an action to the OK button that add
				 *  a new animal and but it in start mode
				 */
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						horspeed=Horizontal_speed_slider.getValue();
						virspeed=vertical_speed_slider.getValue();
						col1=animal_color_slider.getValue();
						size1=Integer.parseInt(Size_of_animal_input.getText().toString());
						
						if (select_type) {
							
							fish= new Fish(size1, x_front1, y_front1, horspeed, virspeed, col1);
							AquaFrame.creatures.add(getFish());
							AquaPanel.animals_in_aquarium.add(fish);
							
							fish.start();
						}
						else {
							
							jellyfish= new Jellyfish(size1, x_front1, y_front1, horspeed, virspeed, col1);
							AquaFrame.creatures.add(getJellyfish());
							AquaPanel.animals_in_aquarium.add(jellyfish);

							jellyfish.start(); 
						}
						

						setVisible(false);
						dispose();	
						}
			         });
				
				
			
			{			/**
				 * to initialize the Cancel button
				 */
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				/**
				 * to add an action to the Cancel button that quit 
				 * the adding process and shut down the Dialog 
				 */
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();						
					}
				});
			}
		}
	}
	
	
	

/**
 * 
 * getters and sitters
 */
	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public Jellyfish getJellyfish() {
		return jellyfish;
	}

	public void setJellyfish(Jellyfish jellyfish) {
		this.jellyfish = jellyfish;
	}

	public boolean isSelect_type() {
		return select_type;
	}

	public void setSelect_type(boolean select_type) {
		this.select_type = select_type;
	}


	
	
}
